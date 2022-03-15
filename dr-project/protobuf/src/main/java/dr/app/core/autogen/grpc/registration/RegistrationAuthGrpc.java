package dr.app.core.autogen.grpc.registration;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.1)",
    comments = "Source: registration_auth.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RegistrationAuthGrpc {

  private RegistrationAuthGrpc() {}

  public static final String SERVICE_NAME = "registration.RegistrationAuth";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.registration.RELoginRequest,
      dr.app.core.autogen.grpc.registration.RELoginUserResponse> getGetLoginInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLoginInfo",
      requestType = dr.app.core.autogen.grpc.registration.RELoginRequest.class,
      responseType = dr.app.core.autogen.grpc.registration.RELoginUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.registration.RELoginRequest,
      dr.app.core.autogen.grpc.registration.RELoginUserResponse> getGetLoginInfoMethod() {
    io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.registration.RELoginRequest, dr.app.core.autogen.grpc.registration.RELoginUserResponse> getGetLoginInfoMethod;
    if ((getGetLoginInfoMethod = RegistrationAuthGrpc.getGetLoginInfoMethod) == null) {
      synchronized (RegistrationAuthGrpc.class) {
        if ((getGetLoginInfoMethod = RegistrationAuthGrpc.getGetLoginInfoMethod) == null) {
          RegistrationAuthGrpc.getGetLoginInfoMethod = getGetLoginInfoMethod =
              io.grpc.MethodDescriptor.<dr.app.core.autogen.grpc.registration.RELoginRequest, dr.app.core.autogen.grpc.registration.RELoginUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLoginInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dr.app.core.autogen.grpc.registration.RELoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dr.app.core.autogen.grpc.registration.RELoginUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RegistrationAuthMethodDescriptorSupplier("GetLoginInfo"))
              .build();
        }
      }
    }
    return getGetLoginInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.registration.REGetLoginUserInfoRequest,
      dr.app.core.autogen.grpc.registration.REGetLoginUserInfoResponse> getGetLoginUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLoginUserInfo",
      requestType = dr.app.core.autogen.grpc.registration.REGetLoginUserInfoRequest.class,
      responseType = dr.app.core.autogen.grpc.registration.REGetLoginUserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.registration.REGetLoginUserInfoRequest,
      dr.app.core.autogen.grpc.registration.REGetLoginUserInfoResponse> getGetLoginUserInfoMethod() {
    io.grpc.MethodDescriptor<dr.app.core.autogen.grpc.registration.REGetLoginUserInfoRequest, dr.app.core.autogen.grpc.registration.REGetLoginUserInfoResponse> getGetLoginUserInfoMethod;
    if ((getGetLoginUserInfoMethod = RegistrationAuthGrpc.getGetLoginUserInfoMethod) == null) {
      synchronized (RegistrationAuthGrpc.class) {
        if ((getGetLoginUserInfoMethod = RegistrationAuthGrpc.getGetLoginUserInfoMethod) == null) {
          RegistrationAuthGrpc.getGetLoginUserInfoMethod = getGetLoginUserInfoMethod =
              io.grpc.MethodDescriptor.<dr.app.core.autogen.grpc.registration.REGetLoginUserInfoRequest, dr.app.core.autogen.grpc.registration.REGetLoginUserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLoginUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dr.app.core.autogen.grpc.registration.REGetLoginUserInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dr.app.core.autogen.grpc.registration.REGetLoginUserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RegistrationAuthMethodDescriptorSupplier("GetLoginUserInfo"))
              .build();
        }
      }
    }
    return getGetLoginUserInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegistrationAuthStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistrationAuthStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistrationAuthStub>() {
        @java.lang.Override
        public RegistrationAuthStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistrationAuthStub(channel, callOptions);
        }
      };
    return RegistrationAuthStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegistrationAuthBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistrationAuthBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistrationAuthBlockingStub>() {
        @java.lang.Override
        public RegistrationAuthBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistrationAuthBlockingStub(channel, callOptions);
        }
      };
    return RegistrationAuthBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegistrationAuthFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistrationAuthFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistrationAuthFutureStub>() {
        @java.lang.Override
        public RegistrationAuthFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistrationAuthFutureStub(channel, callOptions);
        }
      };
    return RegistrationAuthFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RegistrationAuthImplBase implements io.grpc.BindableService {

    /**
     */
    public void getLoginInfo(dr.app.core.autogen.grpc.registration.RELoginRequest request,
        io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.registration.RELoginUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLoginInfoMethod(), responseObserver);
    }

    /**
     */
    public void getLoginUserInfo(dr.app.core.autogen.grpc.registration.REGetLoginUserInfoRequest request,
        io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.registration.REGetLoginUserInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLoginUserInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetLoginInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                dr.app.core.autogen.grpc.registration.RELoginRequest,
                dr.app.core.autogen.grpc.registration.RELoginUserResponse>(
                  this, METHODID_GET_LOGIN_INFO)))
          .addMethod(
            getGetLoginUserInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                dr.app.core.autogen.grpc.registration.REGetLoginUserInfoRequest,
                dr.app.core.autogen.grpc.registration.REGetLoginUserInfoResponse>(
                  this, METHODID_GET_LOGIN_USER_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class RegistrationAuthStub extends io.grpc.stub.AbstractAsyncStub<RegistrationAuthStub> {
    private RegistrationAuthStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistrationAuthStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistrationAuthStub(channel, callOptions);
    }

    /**
     */
    public void getLoginInfo(dr.app.core.autogen.grpc.registration.RELoginRequest request,
        io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.registration.RELoginUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLoginInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLoginUserInfo(dr.app.core.autogen.grpc.registration.REGetLoginUserInfoRequest request,
        io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.registration.REGetLoginUserInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLoginUserInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RegistrationAuthBlockingStub extends io.grpc.stub.AbstractBlockingStub<RegistrationAuthBlockingStub> {
    private RegistrationAuthBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistrationAuthBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistrationAuthBlockingStub(channel, callOptions);
    }

    /**
     */
    public dr.app.core.autogen.grpc.registration.RELoginUserResponse getLoginInfo(dr.app.core.autogen.grpc.registration.RELoginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLoginInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public dr.app.core.autogen.grpc.registration.REGetLoginUserInfoResponse getLoginUserInfo(dr.app.core.autogen.grpc.registration.REGetLoginUserInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLoginUserInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RegistrationAuthFutureStub extends io.grpc.stub.AbstractFutureStub<RegistrationAuthFutureStub> {
    private RegistrationAuthFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistrationAuthFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistrationAuthFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dr.app.core.autogen.grpc.registration.RELoginUserResponse> getLoginInfo(
        dr.app.core.autogen.grpc.registration.RELoginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLoginInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dr.app.core.autogen.grpc.registration.REGetLoginUserInfoResponse> getLoginUserInfo(
        dr.app.core.autogen.grpc.registration.REGetLoginUserInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLoginUserInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LOGIN_INFO = 0;
  private static final int METHODID_GET_LOGIN_USER_INFO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegistrationAuthImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegistrationAuthImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LOGIN_INFO:
          serviceImpl.getLoginInfo((dr.app.core.autogen.grpc.registration.RELoginRequest) request,
              (io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.registration.RELoginUserResponse>) responseObserver);
          break;
        case METHODID_GET_LOGIN_USER_INFO:
          serviceImpl.getLoginUserInfo((dr.app.core.autogen.grpc.registration.REGetLoginUserInfoRequest) request,
              (io.grpc.stub.StreamObserver<dr.app.core.autogen.grpc.registration.REGetLoginUserInfoResponse>) responseObserver);
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

  private static abstract class RegistrationAuthBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegistrationAuthBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dr.app.core.autogen.grpc.registration.RegistrationAuthOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegistrationAuth");
    }
  }

  private static final class RegistrationAuthFileDescriptorSupplier
      extends RegistrationAuthBaseDescriptorSupplier {
    RegistrationAuthFileDescriptorSupplier() {}
  }

  private static final class RegistrationAuthMethodDescriptorSupplier
      extends RegistrationAuthBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegistrationAuthMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegistrationAuthGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegistrationAuthFileDescriptorSupplier())
              .addMethod(getGetLoginInfoMethod())
              .addMethod(getGetLoginUserInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
