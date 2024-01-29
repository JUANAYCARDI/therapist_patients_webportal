package com.psi.satrello.user.util;

import com.psi.satrello.user.entity.Account;
import com.psi.satrello.user.exception.InactiveUserException;
import com.psi.satrello.user.exception.InvalidPersonalIdException;
import com.psi.satrello.user.exception.NotATherapistException;
import org.springframework.stereotype.Component;

@Component
public class TherapistValidator {

    private static final int THERAPIST_ROLE_ID = 2;
    private static final int ACTIVE_STATE_ID = 1;

    /* Validate the therapist information */
    public void validate(Account therapist) {
        if (therapist == null) {
            throw new InvalidPersonalIdException("Invalid personal id", 400);
        }
        // This microservice only handles therapist data, any other role will throw an exception
        else if (therapist.getRoleId() != THERAPIST_ROLE_ID) {
            throw new NotATherapistException("The provided personal id does not correspond to a Therapist", 400);
        }
        // The therapist account must be active
        else if (therapist.getStateId() != ACTIVE_STATE_ID) {
            throw new InactiveUserException("The user account must be active", 401);
        }
    }
}
