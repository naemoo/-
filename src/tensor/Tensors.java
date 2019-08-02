package tensor;

public class Tensors {
	private Tensors() {}
	//����ó���� �� Ŭ���� �޼ҵ� �ȿ��� ���� ��.
	public static Scalar addTwoScalar(Scalar s1,Scalar s2) {//24��
		return ScalarImpl.addTwoScalar(s1, s2);
	}
	public static Scalar mulTwoScalar(Scalar s1,Scalar s2) {//25��
		return ScalarImpl.mulTwoScalar(s1, s2);
	}
	public static Vector addTwoVector(Vector v1,Vector v2) {//26��
		return VectorImpl.addTwoVector(v1, v2);
	}
	public static Vector mulScalarAndVector(Scalar s,Vector v) {//27��
		return VectorImpl.mulScalarAndVector(s, v);
	}
	public static Matrix addTwoMatrix
	(Matrix m1, Matrix m2) {//28��
		return MatrixImpl.addTwoMatrix(m1, m2);
	}
	public static Matrix mulTwoMatrix(Matrix m1, Matrix m2) {//29��
		return MatrixImpl.mulTwoMatrix(m1, m2);
	}
	public static Matrix combineMatrixWithRow(Matrix m1,Matrix m2) {//32��
		return MatrixImpl.combineMatrixWithRow(m1, m2);
	}
	public static Matrix combineMatrixWithCol(Matrix m1,Matrix m2) {//33��
		return MatrixImpl.combineMatrixWithCol(m1, m2);
	}
}
