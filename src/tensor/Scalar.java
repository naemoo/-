package tensor;

//자바 함수들 넣기
public interface Scalar extends Comparable<Scalar>,Cloneable{
	public Double get();
	public void set(Double input);
	public void addToMine(Scalar anotherScalar);//18번
	public void mulToMine(Scalar anotherScalar);//19번
	Object clone() throws CloneNotSupportedException;//17번
}
