// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: registration.proto

package dr.app.core.autogen.grpc.registration;

/**
 * Protobuf enum {@code registration.REBeaconType}
 */
public enum REBeaconType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>DRJOY = 0;</code>
   */
  DRJOY(0),
  /**
   * <code>BEACAPP = 1;</code>
   */
  BEACAPP(1),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>DRJOY = 0;</code>
   */
  public static final int DRJOY_VALUE = 0;
  /**
   * <code>BEACAPP = 1;</code>
   */
  public static final int BEACAPP_VALUE = 1;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static REBeaconType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static REBeaconType forNumber(int value) {
    switch (value) {
      case 0: return DRJOY;
      case 1: return BEACAPP;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<REBeaconType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      REBeaconType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<REBeaconType>() {
          public REBeaconType findValueByNumber(int number) {
            return REBeaconType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return dr.app.core.autogen.grpc.registration.RegistrationOuterClass.getDescriptor().getEnumTypes().get(1);
  }

  private static final REBeaconType[] VALUES = values();

  public static REBeaconType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private REBeaconType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:registration.REBeaconType)
}

