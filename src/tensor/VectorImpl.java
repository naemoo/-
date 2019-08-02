package tensor;

import java.util.List;
import java.util.LinkedList;

class VectorImpl implements Vector {
	int length =0;
	List<Scalar> vlist= new LinkedList<Scalar>();
	//�����ڵ�
	VectorImpl(Double element, int n) {
		for(int i = 0 ; i < n ; i ++) {
			Scalar s = new ScalarImpl(element);
			vlist.add(s);
			length++;
		}
	}
	VectorImpl(Double i, Double j , int n) {
		for(int idx = 0 ; idx < n;idx++) {
			Scalar s = new ScalarImpl(i, j);
			vlist.add(s);
			length++;
		}
	}
	//�޼ҵ�
	@Override//������ ������ ȣ��
	public int length() {
		return length;
	}
	@Override//13��
	public void showSize() {
		System.out.println("Vector Size : " + length); 
	}
	@Override//11��
	public Scalar get(int idx) {
		return vlist.get(idx); //���� ó���ϱ� -> idx�ʰ� ��
	}
	@Override//11��
	public void set(Scalar elements,int idx) {
		Scalar ns = new ScalarImpl(elements.get());
		vlist.set(idx, ns);
	}
	@Override//13��
	public String toString() {
		return vlist.toString();
	}
	
	@Override//15��
	public boolean equals(Object obj){
		Vector v = (Vector)obj;
		Scalar s = null;
		try {
			if(length != v.length()) {
				throw new VectorLengthNotMatchException();
			}
			else {
				for(int i = 0;i <length;i++)
					if(!(v.get(i).equals(vlist.get(i))))
						return false;
				return true;
			}
		}
		catch(VectorLengthNotMatchException e) {
			System.out.print("������ ũ�Ⱑ �ٸ��ϴ�.");
		}
		return false;//���� �� ��ȯ ��
	}
	@Override//17��
	public Object clone() throws CloneNotSupportedException{//���� ����Ʈ�� ���纻�� ���� ���纻 ����Ʈ�� ������ ����
		Vector copy = (Vector)super.clone();
		List<Scalar> deepcopy = new LinkedList<Scalar>();
		for(int i = 0 ; i < length;i++)
			deepcopy.add((Scalar)vlist.get(i).clone());
		vlist = deepcopy;
		return copy;
	}
	@Override//20��
	public void addToMine(Vector v){
		try {
			if(length != v.length())
				throw new VectorLengthNotMatchException();
		
			for(int i = 0 ; i <length;i++) {
				vlist.get(i).addToMine(v.get(i));
			}
		}
		catch(VectorLengthNotMatchException e){
			System.out.println(e.getMessage());
		}
	}
	@Override//21��
	public void multToMine(Scalar s) {
		for(int i = 0 ; i <length;i++)
			vlist.get(i).mulToMine(s);
	}
	static Vector addTwoVector(Vector v1,Vector v2) {//26��
		try {
			if(v1.length() != v2.length())
				throw new VectorLengthNotMatchException();
			Vector nv = new VectorImpl(0.0, v1.length());
			for(int i = 0 ; i < v1.length();i++)
				nv.set(ScalarImpl.addTwoScalar(v1.get(i),v2.get(i)), i);
			return nv;
		}
		catch(VectorLengthNotMatchException e) {
			System.out.println(e.getMessage());
			System.out.println("������ ������ ������ �� �����ϴ�.");
		}
		return null;
	}
	static Vector mulScalarAndVector(Scalar s,Vector v) {//27��
		Vector nv = new VectorImpl(0.0, v.length());
		for(int i = 0; i < v.length();i++)
			nv.set(ScalarImpl.mulTwoScalar(s, v.get(i)),i);
		return nv;		
	}
	@Override//30��
	public Matrix makeVectorToMatrixAsCol() {
		Matrix m = new MatrixImpl(0.0, length, 1);
		for(int i = 0 ; i < length;i++)
			m.set(vlist.get(i), i, 0);
		return m;
	}
	@Override//31��
	public Matrix makeVectorToMatrixAsRow() {
		Matrix m = new MatrixImpl(0.0, 1, length);
		for(int i = 0 ; i <length;i++)
			m.set(vlist.get(i), 0, i);
		return m;
	}
}
