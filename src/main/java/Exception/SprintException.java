package Exception;

import org.springframework.http.HttpStatus;

public class SprintException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Long resourceId;
    private String errorCode;
    private HttpStatus status;



    public SprintException(String errorCode, String message, HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }


}
