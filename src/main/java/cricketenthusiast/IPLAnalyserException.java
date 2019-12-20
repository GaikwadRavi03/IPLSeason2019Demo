package cricketenthusiast;

public class IPLAnalyserException extends Exception {
    enum ExceptionType {
        FILE_PROBLEM, INCORRECT_DELIMITER, NOT_SUFFICIENT_FILES, UNKNOWN_PLAYER, CSV_BUILDER_ERROR
    }

    ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
