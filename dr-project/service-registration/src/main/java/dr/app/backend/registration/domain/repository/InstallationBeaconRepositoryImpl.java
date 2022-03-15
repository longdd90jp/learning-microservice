package dr.app.backend.registration.domain.repository;

import dr.app.backend.registration.domain.entity.InstallationBeacon;
import dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.MongoRegexCreator;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@RequiredArgsConstructor
public class InstallationBeaconRepositoryImpl implements CustomInstallationBeaconRepository {
    private final MongoTemplate mongoTemplate;
    private static final String NAME = "name";
    private static final String OFFICE_ID = "officeId";
    private static final String BEACON_ATTENDANCE_AREA_ID = "beaconAttendanceAreaId";
    private static final String BEACON_MR_MANAGEMENT_AREA_ID = "beaconMrManagementAreaId";
    private static final String DELETED = "deleted";
    private static final String MAC = "mac";
    private static final String UPDATED = "updated";

    @Override
    public List<InstallationBeacon> findAllByMacAndDeletedNotOrderByUpdated(String mac,
                                                                            boolean deleted) {
        final Query query = new Query()
                .addCriteria(Criteria.where(MAC).in(mac.toLowerCase(), mac.toUpperCase()))
                .addCriteria(Criteria.where(DELETED).ne(deleted))
                .with(Sort.by(Sort.Direction.ASC, UPDATED));
        return mongoTemplate.find(query, InstallationBeacon.class);
    }

    @Override
    public List<InstallationBeacon> findByKeywordAndOfficeIdAndStatusesWithinLimit(String keyword, String officeId,
                                                                                   REListInstallationBeaconRequest.LinkStatus linkStatusForAttendanceArea,
                                                                                   REListInstallationBeaconRequest.LinkStatus linkStatusForMrManagementArea,
                                                                                   int offset, int limit) {
        final Query query = new Query();
        final String regexKeyWord = MongoRegexCreator.INSTANCE.toRegularExpression(keyword, MongoRegexCreator.MatchMode.CONTAINING);
        query.addCriteria(Criteria.where(NAME).regex(regexKeyWord));
        query.addCriteria(Criteria.where(OFFICE_ID).is(officeId));
        query.addCriteria(Criteria.where(DELETED).ne(true));

        addQueryForLinkStatus(linkStatusForAttendanceArea, query, BEACON_ATTENDANCE_AREA_ID);
        addQueryForLinkStatus(linkStatusForMrManagementArea, query, BEACON_MR_MANAGEMENT_AREA_ID);

        query.limit(limit);
        query.skip(offset);
        query.with(Sort.by(Sort.Direction.ASC, NAME));
        return mongoTemplate.find(query, InstallationBeacon.class);
    }

    /**
     * 作成中のクエリに、エリアとの結びつき状況に関する条件を追加する。
     *
     * @param status    検索ステータス
     * @param query     作成中のクエリ
     * @param fieldName InstallationBeaconのフィールド名
     */
    private void addQueryForLinkStatus(REListInstallationBeaconRequest.LinkStatus status, Query query, String fieldName) {
        switch (status) {
            case ONLY_LINKED:
                query.addCriteria(Criteria.where(fieldName).nin(null, ""));
                break;
            case ONLY_NOT_LINKED:
                query.addCriteria(Criteria.where(fieldName).in(null, ""));
                break;
        }
    }

    @Override
    public long countByKeywordAndOfficeId(String keyword, String officeId) {
        final Query query = new Query();
        final String regexKeyWord = MongoRegexCreator.INSTANCE.toRegularExpression(keyword, MongoRegexCreator.MatchMode.CONTAINING);
        query.addCriteria(Criteria.where(NAME).regex(regexKeyWord));
        query.addCriteria(Criteria.where(OFFICE_ID).is(officeId));
        query.addCriteria(Criteria.where(DELETED).ne(true));
        return mongoTemplate.count(query, InstallationBeacon.class);
    }
}
