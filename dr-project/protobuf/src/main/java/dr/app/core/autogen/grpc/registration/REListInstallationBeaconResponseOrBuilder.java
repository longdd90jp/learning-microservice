// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: registration.proto

package dr.app.core.autogen.grpc.registration;

public interface REListInstallationBeaconResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:registration.REListInstallationBeaconResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *&#47; 全件数
   * </pre>
   *
   * <code>int64 allCount = 1;</code>
   * @return The allCount.
   */
  long getAllCount();

  /**
   * <pre>
   *&#47; 設置用ビーコン情報のリスト
   * </pre>
   *
   * <code>repeated .registration.REInstallationBeacon installationBeacons = 2;</code>
   */
  java.util.List<dr.app.core.autogen.grpc.registration.REInstallationBeacon> 
      getInstallationBeaconsList();
  /**
   * <pre>
   *&#47; 設置用ビーコン情報のリスト
   * </pre>
   *
   * <code>repeated .registration.REInstallationBeacon installationBeacons = 2;</code>
   */
  dr.app.core.autogen.grpc.registration.REInstallationBeacon getInstallationBeacons(int index);
  /**
   * <pre>
   *&#47; 設置用ビーコン情報のリスト
   * </pre>
   *
   * <code>repeated .registration.REInstallationBeacon installationBeacons = 2;</code>
   */
  int getInstallationBeaconsCount();
  /**
   * <pre>
   *&#47; 設置用ビーコン情報のリスト
   * </pre>
   *
   * <code>repeated .registration.REInstallationBeacon installationBeacons = 2;</code>
   */
  java.util.List<? extends dr.app.core.autogen.grpc.registration.REInstallationBeaconOrBuilder> 
      getInstallationBeaconsOrBuilderList();
  /**
   * <pre>
   *&#47; 設置用ビーコン情報のリスト
   * </pre>
   *
   * <code>repeated .registration.REInstallationBeacon installationBeacons = 2;</code>
   */
  dr.app.core.autogen.grpc.registration.REInstallationBeaconOrBuilder getInstallationBeaconsOrBuilder(
      int index);
}
