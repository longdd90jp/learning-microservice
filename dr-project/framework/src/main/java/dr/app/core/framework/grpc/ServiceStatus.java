package dr.app.core.framework.grpc;

import dr.app.core.autogen.grpc.common.ErrorList;
import dr.app.core.autogen.grpc.common.Error;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.lite.ProtoLiteUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;

public class ServiceStatus {
    public static final Metadata.Key<ErrorList> GRPC_ERRORS_KEY = Metadata.Key.of(
            "grpc-errors-key-bin", ProtoLiteUtils.metadataMarshaller(ErrorList.getDefaultInstance()));

    public static final ServiceStatus OK = new ServiceStatus(Status.OK);
    public static final ServiceStatus CANCELLED = new ServiceStatus(Status.CANCELLED);
    public static final ServiceStatus UNKNOWN = new ServiceStatus(Status.UNKNOWN);
    public static final ServiceStatus INVALID_ARGUMENT = new ServiceStatus(Status.INVALID_ARGUMENT);
    public static final ServiceStatus DEADLINE_EXCEEDED = new ServiceStatus(Status.DEADLINE_EXCEEDED);
    public static final ServiceStatus NOT_FOUND = new ServiceStatus(Status.NOT_FOUND);
    public static final ServiceStatus ALREADY_EXISTS = new ServiceStatus(Status.ALREADY_EXISTS);
    public static final ServiceStatus PERMISSION_DENIED = new ServiceStatus(Status.PERMISSION_DENIED);
    public static final ServiceStatus RESOURCE_EXHAUSTED = new ServiceStatus(Status.RESOURCE_EXHAUSTED);
    public static final ServiceStatus FAILED_PRECONDITION = new ServiceStatus(Status.FAILED_PRECONDITION);
    public static final ServiceStatus ABORTED = new ServiceStatus(Status.ABORTED);
    public static final ServiceStatus OUT_OF_RANGE = new ServiceStatus(Status.OUT_OF_RANGE);
    public static final ServiceStatus UNIMPLEMENTED = new ServiceStatus(Status.UNIMPLEMENTED);
    public static final ServiceStatus INTERNAL = new ServiceStatus(Status.INTERNAL);
    public static final ServiceStatus UNAVAILABLE = new ServiceStatus(Status.UNAVAILABLE);
    public static final ServiceStatus DATA_LOSS = new ServiceStatus(Status.DATA_LOSS);
    public static final ServiceStatus UNAUTHENTICATED = new ServiceStatus(Status.UNAUTHENTICATED);

    private final Status status;
    private final String message;
    private final List<String> errors;

    private ServiceStatus(Status status) {
        this(status, null, newArrayList());
    }

    private ServiceStatus(Status status, String message) {
        this(status, message, newArrayList());
    }

    private ServiceStatus(Status status, String message, List<String> errors) {
        this.status = checkNotNull(status);
        this.message = message;
        this.errors = errors;
    }

    public ServiceStatus withMessage(String message) {
        checkArgument(!isNullOrEmpty(message));
        return new ServiceStatus(this.status, message);
    }

    public ServiceStatus addError(String error) {
        List<String> newList = newArrayList(this.errors);
        newList.add(checkNotNull(error));
        return new ServiceStatus(this.status, this.message, newList);
    }

    public StatusRuntimeException asStatusRuntimeException() {
        return status.withDescription(message).asRuntimeException(toMetadata(errors));
    }

    private static Metadata toMetadata(List<String> details) {
        if (details.isEmpty()) {
            return new Metadata();
        }
        Metadata metadata = new Metadata();
        metadata.put(GRPC_ERRORS_KEY, toErrors(details));
        return metadata;
    }

    private static ErrorList toErrors(List<String> errors) {
        List<Error> list = errors.stream().
                map(s -> Error.newBuilder().setCode(s).build())
                .collect(Collectors.toList());

        return ErrorList.newBuilder().addAllErrors(list).build();
    }
}
