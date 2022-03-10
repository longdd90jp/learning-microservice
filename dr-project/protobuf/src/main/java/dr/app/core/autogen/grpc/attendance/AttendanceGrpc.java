package dr.app.core.autogen.grpc.attendance;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.1)",
    comments = "Source: attendance.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AttendanceGrpc {

  private AttendanceGrpc() {}

  public static final String SERVICE_NAME = "attendance.Attendance";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.attendance.ATInputLog,
      dr.app.core.autogen.grpc.attendance.ATInputLogResponse> getPutCheckingLogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putCheckingLog",
      requestType = dr.app.core.autogen.grpc.attendance.ATInputLog.class,
      responseType = dr.app.core.autogen.grpc.attendance.ATInputLogResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.attendance.ATInputLog,
      dr.app.core.autogen.grpc.attendance.ATInputLogResponse> getPutCheckingLogMethod() {
    io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.attendance.ATInputLog, dr.app.core.autogen.grpc.attendance.ATInputLogResponse> getPutCheckingLogMethod;
    if ((getPutCheckingLogMethod = AttendanceGrpc.getPutCheckingLogMethod) == null) {
      synchronized (AttendanceGrpc.class) {
        if ((getPutCheckingLogMethod = AttendanceGrpc.getPutCheckingLogMethod) == null) {
          AttendanceGrpc.getPutCheckingLogMethod = getPutCheckingLogMethod =
              io.grpc.MethodDescriptor.<dr.app.core.autogen.grpc.attendance.ATInputLog, dr.app.core.autogen.grpc.attendance.ATInputLogResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "putCheckingLog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dr.app.core.autogen.grpc.attendance.ATInputLog.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dr.app.core.autogen.grpc.attendance.ATInputLogResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AttendanceMethodDescriptorSupplier("putCheckingLog"))
              .build();
        }
      }
    }
    return getPutCheckingLogMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AttendanceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttendanceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AttendanceStub>() {
        @java.lang.Override
        public AttendanceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AttendanceStub(channel, callOptions);
        }
      };
    return AttendanceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AttendanceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttendanceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AttendanceBlockingStub>() {
        @java.lang.Override
        public AttendanceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AttendanceBlockingStub(channel, callOptions);
        }
      };
    return AttendanceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AttendanceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttendanceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AttendanceFutureStub>() {
        @java.lang.Override
        public AttendanceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AttendanceFutureStub(channel, callOptions);
        }
      };
    return AttendanceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AttendanceImplBase implements io.grpc.BindableService {

    /**
     */
    public void putCheckingLog(dr.app.core.autogen.grpc.attendance.ATInputLog request,
        io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.attendance.ATInputLogResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPutCheckingLogMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPutCheckingLogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                dr.app.core.autogen.grpc.attendance.ATInputLog,
                dr.app.core.autogen.grpc.attendance.ATInputLogResponse>(
                  this, METHODID_PUT_CHECKING_LOG)))
          .build();
    }
  }

  /**
   */
  public static final class AttendanceStub extends io.grpc.stub.AbstractAsyncStub<AttendanceStub> {
    private AttendanceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttendanceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttendanceStub(channel, callOptions);
    }

    /**
     */
    public void putCheckingLog(dr.app.core.autogen.grpc.attendance.ATInputLog request,
        io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.attendance.ATInputLogResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPutCheckingLogMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AttendanceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AttendanceBlockingStub> {
    private AttendanceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttendanceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttendanceBlockingStub(channel, callOptions);
    }

    /**
     */
    public dr.app.core.autogen.grpc.attendance.ATInputLogResponse putCheckingLog(dr.app.core.autogen.grpc.attendance.ATInputLog request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPutCheckingLogMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AttendanceFutureStub extends io.grpc.stub.AbstractFutureStub<AttendanceFutureStub> {
    private AttendanceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttendanceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttendanceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dr.app.core.autogen.grpc.attendance.ATInputLogResponse> putCheckingLog(
        dr.app.core.autogen.grpc.attendance.ATInputLog request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPutCheckingLogMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PUT_CHECKING_LOG = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AttendanceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AttendanceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUT_CHECKING_LOG:
          serviceImpl.putCheckingLog((dr.app.core.autogen.grpc.attendance.ATInputLog) request,
              (io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.attendance.ATInputLogResponse>) responseObserver);
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

  private static abstract class AttendanceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AttendanceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dr.app.core.autogen.grpc.attendance.AttendanceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Attendance");
    }
  }

  private static final class AttendanceFileDescriptorSupplier
      extends AttendanceBaseDescriptorSupplier {
    AttendanceFileDescriptorSupplier() {}
  }

  private static final class AttendanceMethodDescriptorSupplier
      extends AttendanceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AttendanceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AttendanceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AttendanceFileDescriptorSupplier())
              .addMethod(getPutCheckingLogMethod())
              .build();
        }
      }
    }
    return result;
  }
}
