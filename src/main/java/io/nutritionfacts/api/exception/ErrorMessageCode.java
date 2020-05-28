package io.nutritionfacts.api.exception;

/*
 * This is an important enum class for custom error message handling.
 * Custom thrown exceptions are found under /exception/*
 * They accept a custom errorCode parameter, which maps to a custom response message.
 * If you are modifying this class, you must add your message in messages.properties.
 */
public enum ErrorMessageCode {
    GENERAL_EXCEPTION("exception.general"),
    VALIDATION_EXCEPTION("exception.validation"),
    FOOD_NOT_FOUND("exception.foodNotFound"),
    INVALID_SERVING_SIZE("exception.invalidServingSize");

    private String messageCode;

    ErrorMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getValue() {
        return this.messageCode;
    }
}
