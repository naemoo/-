package tensor;

public class NotExistInveseException extends Exception{
	public NotExistInveseException() {
		super("역행렬이 존재하지 않습니다.");
	}
}
