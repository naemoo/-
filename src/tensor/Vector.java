package tensor;

public interface Vector extends Cloneable {
	public Scalar get(int idx);//11번
	public void set(Scalar elements,int idx);//11번
	public int length(); //길이출력
	public void showSize();//13번
	public void addToMine(Vector v);//20번 예외처리 메소드 내 해결
	public void multToMine(Scalar s);//21번 예외처리 메소드 내 해결
	public Object clone() throws CloneNotSupportedException;
	public Matrix makeVectorToMatrixAsCol();//30번
	public Matrix makeVectorToMatrixAsRow();//31번
}
