package dr.app.backend.uaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    // Instance variables
    // ------------------------------------------------------------------------
    private RegistrationService registrationService;

    // Constructors
    // ------------------------------------------------------------------------
    @Autowired
    public LoginService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    // Methods
    // ------------------------------------------------------------------------
}
