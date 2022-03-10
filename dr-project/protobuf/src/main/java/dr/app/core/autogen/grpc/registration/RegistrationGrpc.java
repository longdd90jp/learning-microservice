package dr.app.core.autogen.grpc.registration;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.1)",
    comments = "Source: registration.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RegistrationGrpc {

  private RegistrationGrpc() {}

  public static final String SERVICE_NAME = "registration.Registration";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest,
      dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse> getListInstallationBeaconMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listInstallationBeacon",
      requestType = dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest.class,
      responseType = dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest,
      dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse> getListInstallationBeaconMethod() {
    io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest, dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse> getListInstallationBeaconMethod;
    if ((getListInstallationBeaconMethod = RegistrationGrpc.getListInstallationBeaconMethod) == null) {
      synchronized (RegistrationGrpc.class) {
        if ((getListInstallationBeaconMethod = RegistrationGrpc.getListInstallationBeaconMethod) == null) {
          RegistrationGrpc.getListInstallationBeaconMethod = getListInstallationBeaconMethod =
              io.grpc.MethodDescriptor.<dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest, dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listInstallationBeacon"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RegistrationMethodDescriptorSupplier("listInstallationBeacon"))
              .build();
        }
      }
    }
    return getListInstallationBeaconMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest,
      dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse> getListBeaconAttendanceAreaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listBeaconAttendanceArea",
      requestType = dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest.class,
      responseType = dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest,
      dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse> getListBeaconAttendanceAreaMethod() {
    io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest, dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse> getListBeaconAttendanceAreaMethod;
    if ((getListBeaconAttendanceAreaMethod = RegistrationGrpc.getListBeaconAttendanceAreaMethod) == null) {
      synchronized (RegistrationGrpc.class) {
        if ((getListBeaconAttendanceAreaMethod = RegistrationGrpc.getListBeaconAttendanceAreaMethod) == null) {
          RegistrationGrpc.getListBeaconAttendanceAreaMethod = getListBeaconAttendanceAreaMethod =
              io.grpc.MethodDescriptor.<dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest, dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listBeaconAttendanceArea"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RegistrationMethodDescriptorSupplier("listBeaconAttendanceArea"))
              .build();
        }
      }
    }
    return getListBeaconAttendanceAreaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegistrationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistrationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistrationStub>() {
        @java.lang.Override
        public RegistrationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistrationStub(channel, callOptions);
        }
      };
    return RegistrationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegistrationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistrationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistrationBlockingStub>() {
        @java.lang.Override
        public RegistrationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistrationBlockingStub(channel, callOptions);
        }
      };
    return RegistrationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegistrationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistrationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistrationFutureStub>() {
        @java.lang.Override
        public RegistrationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistrationFutureStub(channel, callOptions);
        }
      };
    return RegistrationFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RegistrationImplBase implements io.grpc.BindableService {

    /**
     */
    public void listInstallationBeacon(dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest request,
        io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListInstallationBeaconMethod(), responseObserver);
    }

    /**
     */
    public void listBeaconAttendanceArea(dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest request,
        io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListBeaconAttendanceAreaMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListInstallationBeaconMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest,
                dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse>(
                  this, METHODID_LIST_INSTALLATION_BEACON)))
          .addMethod(
            getListBeaconAttendanceAreaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest,
                dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse>(
                  this, METHODID_LIST_BEACON_ATTENDANCE_AREA)))
          .build();
    }
  }

  /**
   */
  public static final class RegistrationStub extends io.grpc.stub.AbstractAsyncStub<RegistrationStub> {
    private RegistrationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistrationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistrationStub(channel, callOptions);
    }

    /**
     */
    public void listInstallationBeacon(dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest request,
        io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstallationBeaconMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listBeaconAttendanceArea(dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest request,
        io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBeaconAttendanceAreaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RegistrationBlockingStub extends io.grpc.stub.AbstractBlockingStub<RegistrationBlockingStub> {
    private RegistrationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistrationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistrationBlockingStub(channel, callOptions);
    }

    /**
     */
    public dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse listInstallationBeacon(dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstallationBeaconMethod(), getCallOptions(), request);
    }

    /**
     */
    public dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse listBeaconAttendanceArea(dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBeaconAttendanceAreaMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RegistrationFutureStub extends io.grpc.stub.AbstractFutureStub<RegistrationFutureStub> {
    private RegistrationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistrationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistrationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse> listInstallationBeacon(
        dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstallationBeaconMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse> listBeaconAttendanceArea(
        dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBeaconAttendanceAreaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTALLATION_BEACON = 0;
  private static final int METHODID_LIST_BEACON_ATTENDANCE_AREA = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegistrationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegistrationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_INSTALLATION_BEACON:
          serviceImpl.listInstallationBeacon((dr.app.core.autogen.grpc.registration.REListInstallationBeaconRequest) request,
              (io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.registration.REListInstallationBeaconResponse>) responseObserver);
          break;
        case METHODID_LIST_BEACON_ATTENDANCE_AREA:
          serviceImpl.listBeaconAttendanceArea((dr.app.core.autogen.grpc.registration.REListBeaconAreaRequest) request,
              (io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.registration.REListBeaconAttendanceAreaResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RegistrationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegistrationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dr.app.core.autogen.grpc.registration.RegistrationOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Registration");
    }
  }

  private static final class RegistrationFileDescriptorSupplier
      extends RegistrationBaseDescriptorSupplier {
    RegistrationFileDescriptorSupplier() {}
  }

  private static final class RegistrationMethodDescriptorSupplier
      extends RegistrationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegistrationMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RegistrationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegistrationFileDescriptorSupplier())
              .addMethod(getListInstallationBeaconMethod())
              .addMethod(getListBeaconAttendanceAreaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
