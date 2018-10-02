package in.co.test.excptionhandler;
public final class ErrorConstants {
	
	public static final int ERR_STATUS =  500;
	public static final int ERR_RESOURCE_NOT_FOUND_STATUS =  404;
	public static final int ERR_VALIDATION_STATUS =  400;
	public static final int ERR_ACCESS_DENIED_STATUS =  403;
	public static final int ERR_CONCURRENCY_FAILURE_STATUS =  500;
	public static final int ERR_METHOD_NOT_SUPPORTED_STATUS =  500;
	
	public static final String ERR_VALIDATION = "error.validation";
	public static final String ERR_ACCESS_DENIED = "error.accessDenied";
    public static final String ERR_CONCURRENCY_FAILURE = "error.concurrencyFailure";
    public static final String ERR_METHOD_NOT_SUPPORTED = "error.methodNotSupported";

    private ErrorConstants() {
    }

}

