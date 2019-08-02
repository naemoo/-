package tensor;

public class Tensors {
	private Tensors() {}
	//예외처리는 각 클레스 메소드 안에서 실현 함.
	public static Scalar addTwoScalar(Scalar s1,Scalar s2) {//24번
		return ScalarImpl.addTwoScalar(s1, s2);
	}
	public static Scalar mulTwoScalar(Scalar s1,Scalar s2) {//25번
		return ScalarImpl.mulTwoScalar(s1, s2);
	}
	public static Vector addTwoVector(Vector v1,Vector v2) {//26번
		return VectorImpl.addTwoVector(v1, v2);
	}
	public static Vector mulScalarAndVector(Scalar s,Vector v) {//27번
		return VectorImpl.mulScalarAndVector(s, v);
	}
	public static Matrix addTwoMatrix
	(Matrix m1, Matrix m2) {//28번
		return MatrixImpl.addTwoMatrix(m1, m2);
	}
	public static Matrix mulTwoMatrix(Matrix m1, Matrix m2) {//29번
		return MatrixImpl.mulTwoMatrix(m1, m2);
	}
	public static Matrix combineMatrixWithRow(Matrix m1,Matrix m2) {//32번
		return MatrixImpl.combineMatrixWithRow(m1, m2);
	}
	public static Matrix combineMatrixWithCol(Matrix m1,Matrix m2) {//33번
		return MatrixImpl.combineMatrixWithCol(m1, m2);
	}
}
