package tensor;

//�ڹ� �Լ��� �ֱ�
public interface Scalar extends Comparable<Scalar>,Cloneable{
	public Double get();
	public void set(Double input);
	public void addToMine(Scalar anotherScalar);//18��
	public void mulToMine(Scalar anotherScalar);//19��
	Object clone() throws CloneNotSupportedException;//17��
}
