package core.web;

public class Result {
	private boolean status;
	private String errorMessage;

	private Result(boolean status) {
		this(status, "");
	}
	
	private Result(boolean status, String errorMessage) {
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public static Result ok() {
		return new Result(true);
	}

	public static Result fail(String errorMessage) {
		return new Result(false, errorMessage);
	}

	public boolean isStatus() {
		return status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public String toString() {
		return "Result [status=" + status + ", errorMessage=" + errorMessage + "]";
	}
}
