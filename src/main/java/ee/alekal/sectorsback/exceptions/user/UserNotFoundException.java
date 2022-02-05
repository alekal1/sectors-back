package ee.alekal.sectorsback.exceptions.user;

import static ee.alekal.sectorsback.util.AppConstants.USER_NOT_FOUND_EXCEPTION_MSG;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super(USER_NOT_FOUND_EXCEPTION_MSG);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
