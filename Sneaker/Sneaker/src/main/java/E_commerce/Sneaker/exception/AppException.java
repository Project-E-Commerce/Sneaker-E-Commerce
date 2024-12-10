package E_commerce.Sneaker.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is for
 *
 */

@Getter
@Setter
public class AppException extends RuntimeException {

    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
