package tensor;

public class MatrixSizeNotMatchException extends Exception{
	public MatrixSizeNotMatchException() {
		super("행렬 크기가 맞지 않습니다.");
	}
}
