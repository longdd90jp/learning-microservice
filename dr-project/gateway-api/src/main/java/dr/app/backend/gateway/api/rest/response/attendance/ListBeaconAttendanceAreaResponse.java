package dr.app.backend.gateway.api.rest.response.attendance;

import dr.app.backend.gateway.model.DefaultStayReason;
import dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea;
import dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ListBeaconAttendanceAreaResponse extends BaseATResponse {
    @ApiModelProperty(value = "BeaconAreaのリスト")
    private List<BeaconArea> beaconAreas;

    @Data
    @NoArgsConstructor
    private static class BeaconArea {

        @ApiModelProperty(value = "BeaconAreaのオブジェクトID")
        private String id;

        @ApiModelProperty(value = "表示名")
        private String name;

        @ApiModelProperty(value = "デフォルトの滞在理由")
        private DefaultStayReason defaultStayReason;

        @ApiModelProperty(value = "表示色（10進数表示）")
        private int color;
    }

    public ListBeaconAttendanceAreaResponse(final REListBeaconAttendanceAreaResponse response) {
        this.beaconAreas = new ArrayList<>();
        for (REBeaconAttendanceArea reBeaconArea : response.getBeaconAttendanceAreaList()) {
            final BeaconArea beaconArea = new BeaconArea();
            beaconArea.setId(reBeaconArea.getId());
            beaconArea.setName(reBeaconArea.getName());
            beaconArea.setDefaultStayReason(DefaultStayReason.toDefaultStayReason(reBeaconArea.getDefaultStayReason()));
            beaconArea.setColor(reBeaconArea.getColor());
            this.beaconAreas.add(beaconArea);
        }
    }
}
