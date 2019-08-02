package tensor;

public interface Vector extends Cloneable {
	public Scalar get(int idx);//11��
	public void set(Scalar elements,int idx);//11��
	public int length(); //�������
	public void showSize();//13��
	public void addToMine(Vector v);//20�� ����ó�� �޼ҵ� �� �ذ�
	public void multToMine(Scalar s);//21�� ����ó�� �޼ҵ� �� �ذ�
	public Object clone() throws CloneNotSupportedException;
	public Matrix makeVectorToMatrixAsCol();//30��
	public Matrix makeVectorToMatrixAsRow();//31��
}
