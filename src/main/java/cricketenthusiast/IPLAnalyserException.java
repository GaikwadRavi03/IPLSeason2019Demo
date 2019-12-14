package cricketenthusiast;

public class IPLAnalyserException extends Exception {
    enum ExceptionType {
        FILE_PROBLEM, INCORRECT_DELIMITER, NOT_SUFFICIENT_FILES,INPUT_OUTPUT_ISSUE
    }

    ExceptionType type;

    public IPLAnalyserException(ExceptionType type) {
    }

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
