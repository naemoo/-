package tensor;

public class MatrixMulSizeNotMatchException extends Exception{
	public MatrixMulSizeNotMatchException() {
		super("행렬의 곱 오류 : 좌측 행렬의 열과 우측 행렬의 행이 맞지 않습니다.");
	}
}
