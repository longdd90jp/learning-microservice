// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: registration.proto

package dr.app.core.autogen.grpc.registration;

/**
 * Protobuf type {@code registration.REListBeaconAttendanceAreaResponse}
 */
public final class REListBeaconAttendanceAreaResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:registration.REListBeaconAttendanceAreaResponse)
    REListBeaconAttendanceAreaResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use REListBeaconAttendanceAreaResponse.newBuilder() to construct.
  private REListBeaconAttendanceAreaResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private REListBeaconAttendanceAreaResponse() {
    beaconAttendanceArea_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new REListBeaconAttendanceAreaResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private REListBeaconAttendanceAreaResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            allCount_ = input.readInt64();
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              beaconAttendanceArea_ = new java.util.ArrayList<dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea>();
              mutable_bitField0_ |= 0x00000001;
            }
            beaconAttendanceArea_.add(
                input.readMessage(dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.parser(), extensionRegistry));
            break;
          }
          case 24: {

            notLinkedBeaconCount_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        beaconAttendanceArea_ = java.util.Collections.unmodifiableList(beaconAttendanceArea_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return dr.app.core.autogen.grpc.registration.RegistrationOuterClass.internal_static_registration_REListBeaconAttendanceAreaResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return dr.app.core.autogen.grpc.registration.RegistrationOuterClass.internal_static_registration_REListBeaconAttendanceAreaResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse.class, dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse.Builder.class);
  }

  public static final int ALLCOUNT_FIELD_NUMBER = 1;
  private long allCount_;
  /**
   * <pre>
   *&#47; 全件数
   * </pre>
   *
   * <code>int64 allCount = 1;</code>
   * @return The allCount.
   */
  @java.lang.Override
  public long getAllCount() {
    return allCount_;
  }

  public static final int BEACONATTENDANCEAREA_FIELD_NUMBER = 2;
  private java.util.List<dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea> beaconAttendanceArea_;
  /**
   * <pre>
   *&#47; REBeaconAttendanceAreaのリスト
   * </pre>
   *
   * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
   */
  @java.lang.Override
  public java.util.List<dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea> getBeaconAttendanceAreaList() {
    return beaconAttendanceArea_;
  }
  /**
   * <pre>
   *&#47; REBeaconAttendanceAreaのリスト
   * </pre>
   *
   * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends dr.app.core.autogen.grpc.registration.REBeaconAttendanceAreaOrBuilder> 
      getBeaconAttendanceAreaOrBuilderList() {
    return beaconAttendanceArea_;
  }
  /**
   * <pre>
   *&#47; REBeaconAttendanceAreaのリスト
   * </pre>
   *
   * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
   */
  @java.lang.Override
  public int getBeaconAttendanceAreaCount() {
    return beaconAttendanceArea_.size();
  }
  /**
   * <pre>
   *&#47; REBeaconAttendanceAreaのリスト
   * </pre>
   *
   * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
   */
  @java.lang.Override
  public dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea getBeaconAttendanceArea(int index) {
    return beaconAttendanceArea_.get(index);
  }
  /**
   * <pre>
   *&#47; REBeaconAttendanceAreaのリスト
   * </pre>
   *
   * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
   */
  @java.lang.Override
  public dr.app.core.autogen.grpc.registration.REBeaconAttendanceAreaOrBuilder getBeaconAttendanceAreaOrBuilder(
      int index) {
    return beaconAttendanceArea_.get(index);
  }

  public static final int NOTLINKEDBEACONCOUNT_FIELD_NUMBER = 3;
  private int notLinkedBeaconCount_;
  /**
   * <pre>
   *&#47; どのエリアにも紐づいていないビーコンの数
   * </pre>
   *
   * <code>int32 notLinkedBeaconCount = 3;</code>
   * @return The notLinkedBeaconCount.
   */
  @java.lang.Override
  public int getNotLinkedBeaconCount() {
    return notLinkedBeaconCount_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (allCount_ != 0L) {
      output.writeInt64(1, allCount_);
    }
    for (int i = 0; i < beaconAttendanceArea_.size(); i++) {
      output.writeMessage(2, beaconAttendanceArea_.get(i));
    }
    if (notLinkedBeaconCount_ != 0) {
      output.writeInt32(3, notLinkedBeaconCount_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (allCount_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, allCount_);
    }
    for (int i = 0; i < beaconAttendanceArea_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, beaconAttendanceArea_.get(i));
    }
    if (notLinkedBeaconCount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, notLinkedBeaconCount_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse)) {
      return super.equals(obj);
    }
    dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse other = (dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse) obj;

    if (getAllCount()
        != other.getAllCount()) return false;
    if (!getBeaconAttendanceAreaList()
        .equals(other.getBeaconAttendanceAreaList())) return false;
    if (getNotLinkedBeaconCount()
        != other.getNotLinkedBeaconCount()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ALLCOUNT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getAllCount());
    if (getBeaconAttendanceAreaCount() > 0) {
      hash = (37 * hash) + BEACONATTENDANCEAREA_FIELD_NUMBER;
      hash = (53 * hash) + getBeaconAttendanceAreaList().hashCode();
    }
    hash = (37 * hash) + NOTLINKEDBEACONCOUNT_FIELD_NUMBER;
    hash = (53 * hash) + getNotLinkedBeaconCount();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code registration.REListBeaconAttendanceAreaResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:registration.REListBeaconAttendanceAreaResponse)
      dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return dr.app.core.autogen.grpc.registration.RegistrationOuterClass.internal_static_registration_REListBeaconAttendanceAreaResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return dr.app.core.autogen.grpc.registration.RegistrationOuterClass.internal_static_registration_REListBeaconAttendanceAreaResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse.class, dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse.Builder.class);
    }

    // Construct using dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getBeaconAttendanceAreaFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      allCount_ = 0L;

      if (beaconAttendanceAreaBuilder_ == null) {
        beaconAttendanceArea_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        beaconAttendanceAreaBuilder_.clear();
      }
      notLinkedBeaconCount_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return dr.app.core.autogen.grpc.registration.RegistrationOuterClass.internal_static_registration_REListBeaconAttendanceAreaResponse_descriptor;
    }

    @java.lang.Override
    public dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse getDefaultInstanceForType() {
      return dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse.getDefaultInstance();
    }

    @java.lang.Override
    public dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse build() {
      dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse buildPartial() {
      dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse result = new dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse(this);
      int from_bitField0_ = bitField0_;
      result.allCount_ = allCount_;
      if (beaconAttendanceAreaBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          beaconAttendanceArea_ = java.util.Collections.unmodifiableList(beaconAttendanceArea_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.beaconAttendanceArea_ = beaconAttendanceArea_;
      } else {
        result.beaconAttendanceArea_ = beaconAttendanceAreaBuilder_.build();
      }
      result.notLinkedBeaconCount_ = notLinkedBeaconCount_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse) {
        return mergeFrom((dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse other) {
      if (other == dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse.getDefaultInstance()) return this;
      if (other.getAllCount() != 0L) {
        setAllCount(other.getAllCount());
      }
      if (beaconAttendanceAreaBuilder_ == null) {
        if (!other.beaconAttendanceArea_.isEmpty()) {
          if (beaconAttendanceArea_.isEmpty()) {
            beaconAttendanceArea_ = other.beaconAttendanceArea_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureBeaconAttendanceAreaIsMutable();
            beaconAttendanceArea_.addAll(other.beaconAttendanceArea_);
          }
          onChanged();
        }
      } else {
        if (!other.beaconAttendanceArea_.isEmpty()) {
          if (beaconAttendanceAreaBuilder_.isEmpty()) {
            beaconAttendanceAreaBuilder_.dispose();
            beaconAttendanceAreaBuilder_ = null;
            beaconAttendanceArea_ = other.beaconAttendanceArea_;
            bitField0_ = (bitField0_ & ~0x00000001);
            beaconAttendanceAreaBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getBeaconAttendanceAreaFieldBuilder() : null;
          } else {
            beaconAttendanceAreaBuilder_.addAllMessages(other.beaconAttendanceArea_);
          }
        }
      }
      if (other.getNotLinkedBeaconCount() != 0) {
        setNotLinkedBeaconCount(other.getNotLinkedBeaconCount());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long allCount_ ;
    /**
     * <pre>
     *&#47; 全件数
     * </pre>
     *
     * <code>int64 allCount = 1;</code>
     * @return The allCount.
     */
    @java.lang.Override
    public long getAllCount() {
      return allCount_;
    }
    /**
     * <pre>
     *&#47; 全件数
     * </pre>
     *
     * <code>int64 allCount = 1;</code>
     * @param value The allCount to set.
     * @return This builder for chaining.
     */
    public Builder setAllCount(long value) {
      
      allCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; 全件数
     * </pre>
     *
     * <code>int64 allCount = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearAllCount() {
      
      allCount_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea> beaconAttendanceArea_ =
      java.util.Collections.emptyList();
    private void ensureBeaconAttendanceAreaIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        beaconAttendanceArea_ = new java.util.ArrayList<dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea>(beaconAttendanceArea_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea, dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.Builder, dr.app.core.autogen.grpc.registration.REBeaconAttendanceAreaOrBuilder> beaconAttendanceAreaBuilder_;

    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public java.util.List<dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea> getBeaconAttendanceAreaList() {
      if (beaconAttendanceAreaBuilder_ == null) {
        return java.util.Collections.unmodifiableList(beaconAttendanceArea_);
      } else {
        return beaconAttendanceAreaBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public int getBeaconAttendanceAreaCount() {
      if (beaconAttendanceAreaBuilder_ == null) {
        return beaconAttendanceArea_.size();
      } else {
        return beaconAttendanceAreaBuilder_.getCount();
      }
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea getBeaconAttendanceArea(int index) {
      if (beaconAttendanceAreaBuilder_ == null) {
        return beaconAttendanceArea_.get(index);
      } else {
        return beaconAttendanceAreaBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public Builder setBeaconAttendanceArea(
        int index, dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea value) {
      if (beaconAttendanceAreaBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBeaconAttendanceAreaIsMutable();
        beaconAttendanceArea_.set(index, value);
        onChanged();
      } else {
        beaconAttendanceAreaBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public Builder setBeaconAttendanceArea(
        int index, dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.Builder builderForValue) {
      if (beaconAttendanceAreaBuilder_ == null) {
        ensureBeaconAttendanceAreaIsMutable();
        beaconAttendanceArea_.set(index, builderForValue.build());
        onChanged();
      } else {
        beaconAttendanceAreaBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public Builder addBeaconAttendanceArea(dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea value) {
      if (beaconAttendanceAreaBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBeaconAttendanceAreaIsMutable();
        beaconAttendanceArea_.add(value);
        onChanged();
      } else {
        beaconAttendanceAreaBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public Builder addBeaconAttendanceArea(
        int index, dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea value) {
      if (beaconAttendanceAreaBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBeaconAttendanceAreaIsMutable();
        beaconAttendanceArea_.add(index, value);
        onChanged();
      } else {
        beaconAttendanceAreaBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public Builder addBeaconAttendanceArea(
        dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.Builder builderForValue) {
      if (beaconAttendanceAreaBuilder_ == null) {
        ensureBeaconAttendanceAreaIsMutable();
        beaconAttendanceArea_.add(builderForValue.build());
        onChanged();
      } else {
        beaconAttendanceAreaBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public Builder addBeaconAttendanceArea(
        int index, dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.Builder builderForValue) {
      if (beaconAttendanceAreaBuilder_ == null) {
        ensureBeaconAttendanceAreaIsMutable();
        beaconAttendanceArea_.add(index, builderForValue.build());
        onChanged();
      } else {
        beaconAttendanceAreaBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public Builder addAllBeaconAttendanceArea(
        java.lang.Iterable<? extends dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea> values) {
      if (beaconAttendanceAreaBuilder_ == null) {
        ensureBeaconAttendanceAreaIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, beaconAttendanceArea_);
        onChanged();
      } else {
        beaconAttendanceAreaBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public Builder clearBeaconAttendanceArea() {
      if (beaconAttendanceAreaBuilder_ == null) {
        beaconAttendanceArea_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        beaconAttendanceAreaBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public Builder removeBeaconAttendanceArea(int index) {
      if (beaconAttendanceAreaBuilder_ == null) {
        ensureBeaconAttendanceAreaIsMutable();
        beaconAttendanceArea_.remove(index);
        onChanged();
      } else {
        beaconAttendanceAreaBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.Builder getBeaconAttendanceAreaBuilder(
        int index) {
      return getBeaconAttendanceAreaFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public dr.app.core.autogen.grpc.registration.REBeaconAttendanceAreaOrBuilder getBeaconAttendanceAreaOrBuilder(
        int index) {
      if (beaconAttendanceAreaBuilder_ == null) {
        return beaconAttendanceArea_.get(index);  } else {
        return beaconAttendanceAreaBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public java.util.List<? extends dr.app.core.autogen.grpc.registration.REBeaconAttendanceAreaOrBuilder> 
         getBeaconAttendanceAreaOrBuilderList() {
      if (beaconAttendanceAreaBuilder_ != null) {
        return beaconAttendanceAreaBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(beaconAttendanceArea_);
      }
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.Builder addBeaconAttendanceAreaBuilder() {
      return getBeaconAttendanceAreaFieldBuilder().addBuilder(
          dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.getDefaultInstance());
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.Builder addBeaconAttendanceAreaBuilder(
        int index) {
      return getBeaconAttendanceAreaFieldBuilder().addBuilder(
          index, dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.getDefaultInstance());
    }
    /**
     * <pre>
     *&#47; REBeaconAttendanceAreaのリスト
     * </pre>
     *
     * <code>repeated .registration.REBeaconAttendanceArea beaconAttendanceArea = 2;</code>
     */
    public java.util.List<dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.Builder> 
         getBeaconAttendanceAreaBuilderList() {
      return getBeaconAttendanceAreaFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea, dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.Builder, dr.app.core.autogen.grpc.registration.REBeaconAttendanceAreaOrBuilder> 
        getBeaconAttendanceAreaFieldBuilder() {
      if (beaconAttendanceAreaBuilder_ == null) {
        beaconAttendanceAreaBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea, dr.app.core.autogen.grpc.registration.REBeaconAttendanceArea.Builder, dr.app.core.autogen.grpc.registration.REBeaconAttendanceAreaOrBuilder>(
                beaconAttendanceArea_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        beaconAttendanceArea_ = null;
      }
      return beaconAttendanceAreaBuilder_;
    }

    private int notLinkedBeaconCount_ ;
    /**
     * <pre>
     *&#47; どのエリアにも紐づいていないビーコンの数
     * </pre>
     *
     * <code>int32 notLinkedBeaconCount = 3;</code>
     * @return The notLinkedBeaconCount.
     */
    @java.lang.Override
    public int getNotLinkedBeaconCount() {
      return notLinkedBeaconCount_;
    }
    /**
     * <pre>
     *&#47; どのエリアにも紐づいていないビーコンの数
     * </pre>
     *
     * <code>int32 notLinkedBeaconCount = 3;</code>
     * @param value The notLinkedBeaconCount to set.
     * @return This builder for chaining.
     */
    public Builder setNotLinkedBeaconCount(int value) {
      
      notLinkedBeaconCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *&#47; どのエリアにも紐づいていないビーコンの数
     * </pre>
     *
     * <code>int32 notLinkedBeaconCount = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearNotLinkedBeaconCount() {
      
      notLinkedBeaconCount_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:registration.REListBeaconAttendanceAreaResponse)
  }

  // @@protoc_insertion_point(class_scope:registration.REListBeaconAttendanceAreaResponse)
  private static final dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse();
  }

  public static dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<REListBeaconAttendanceAreaResponse>
      PARSER = new com.google.protobuf.AbstractParser<REListBeaconAttendanceAreaResponse>() {
    @java.lang.Override
    public REListBeaconAttendanceAreaResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new REListBeaconAttendanceAreaResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<REListBeaconAttendanceAreaResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<REListBeaconAttendanceAreaResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

