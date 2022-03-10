package dr.app.backend.attendance.domain.repository;

import dr.app.backend.attendance.domain.entity.BeaconLog;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class BeaconLogRepositoryImpl implements CustomBeaconLogRepository{

    private final MongoTemplate mongoTemplate;
    private static final String OFFICE_ID = "officeId";
    private static final String USER_NUMBER = "userNumber";
    private static final String EVENT_TIMESTAMP = "eventTimestamp";
    private static final String BEACON_NAME = "beaconName";
    private static final String RSSI = "rssi";
    private static final String BEACON_LOGS_COLLECTION = "beacon_logs";
    private static final String BEACON_LOG_HISTORIES_COLLECTION = "beacon_log_histories";

    @Override
    public List<BeaconLog> findByOfficeIdAndUserNumberBetweenDate(String officeId, String userNumber, Date start, Date end) {
        Query query = new Query();
        query.addCriteria(Criteria.where(OFFICE_ID).is(officeId));
        query.addCriteria(Criteria.where(USER_NUMBER).is(userNumber.toUpperCase()));
        query.addCriteria(Criteria.where(EVENT_TIMESTAMP).gte(start).lte(end));
        query.with(Sort.by(Sort.Direction.ASC, EVENT_TIMESTAMP));
        return mongoTemplate.find(query, BeaconLog.class);
    }
}
