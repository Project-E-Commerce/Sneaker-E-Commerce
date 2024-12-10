package E_commerce.Sneaker.exception;

import lombok.Getter;

/**
 * This class contains the exceptions with declared code and message
 *
 */

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(1999, "Uncategorized error."),
    INVALID_MESSAGE_KEY(1998, "Uncategorized error."),
    USERNAME_EXISTED(101, "This username has been used."),
    USER_NOT_FOUND(102, "User not found."),
    INVALID_USERNAME(103, "Username must be at least 6 characters"),
    INVALID_PASSWORD(104,
            "Password must be from 6 to 50 characters, contains at least 1 digit and 1 uppercase letter"),
    UNAUTHENTICATED(105, "Unauthenticated password.")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;


}
