package tensor;

public class VectorLengthNotMatchException extends Exception{
	public VectorLengthNotMatchException() {
		super("벡터길이가 맞지 않습니다.");
	}
}
