package dr.app.backend.gateway.api.rest.controller.attendance;

import dr.app.backend.gateway.api.rest.request.attendance.BaseATRequest;
import dr.app.backend.gateway.api.rest.response.attendance.BaseATResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractATBaseController {

    /**
     * Validator to be applied, and adds binding-specific analysis and model building.
     *
     * @param result  {@link BindingResult}
     * @param request Request API parameters
     * @param method  service method
     * @param <T>     instance of class extends BaseATResponse
     * @return ResponseEntity<T extends BaseATResponse> response data
     */
    <T extends BaseATResponse, R extends BaseATRequest> ResponseEntity<T> bindingResult(BindingResult result,
                                                                                        R request,
                                                                                        Function<R, T> method) {
        if (result.hasErrors()) {
            return new ResponseEntity(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(method.apply(request), HttpStatus.OK);
    }

    /**
     * Validator to be applied, and adds binding-specific analysis and model building.
     *
     * @param result  {@link BindingResult}
     * @param request Request API parameters
     * @param method  service method
     * @return ResponseEntity<Void> response status
     */
    <R extends BaseATRequest> ResponseEntity<Void> bindingResult(BindingResult result, R request, Consumer<R> method) {
        if (result.hasErrors()) {
            return new ResponseEntity(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        method.accept(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
