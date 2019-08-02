package tensor;

import java.util.List;
import java.util.LinkedList;

class VectorImpl implements Vector {
	int length =0;
	List<Scalar> vlist= new LinkedList<Scalar>();
	//생성자들
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
	//메소드
	@Override//벡터의 차원을 호출
	public int length() {
		return length;
	}
	@Override//13번
	public void showSize() {
		System.out.println("Vector Size : " + length); 
	}
	@Override//11번
	public Scalar get(int idx) {
		return vlist.get(idx); //오류 처리하기 -> idx초과 시
	}
	@Override//11번
	public void set(Scalar elements,int idx) {
		Scalar ns = new ScalarImpl(elements.get());
		vlist.set(idx, ns);
	}
	@Override//13번
	public String toString() {
		return vlist.toString();
	}
	
	@Override//15번
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
			System.out.print("벡터의 크기가 다릅니다.");
		}
		return false;//오류 시 반환 값
	}
	@Override//17번
	public Object clone() throws CloneNotSupportedException{//원본 리스트를 복사본이 갖고 복사본 리스트를 원본이 갖기
		Vector copy = (Vector)super.clone();
		List<Scalar> deepcopy = new LinkedList<Scalar>();
		for(int i = 0 ; i < length;i++)
			deepcopy.add((Scalar)vlist.get(i).clone());
		vlist = deepcopy;
		return copy;
	}
	@Override//20번
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
	@Override//21번
	public void multToMine(Scalar s) {
		for(int i = 0 ; i <length;i++)
			vlist.get(i).mulToMine(s);
	}
	static Vector addTwoVector(Vector v1,Vector v2) {//26번
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
			System.out.println("벡터의 덧셈을 진행할 수 없습니다.");
		}
		return null;
	}
	static Vector mulScalarAndVector(Scalar s,Vector v) {//27번
		Vector nv = new VectorImpl(0.0, v.length());
		for(int i = 0; i < v.length();i++)
			nv.set(ScalarImpl.mulTwoScalar(s, v.get(i)),i);
		return nv;		
	}
	@Override//30번
	public Matrix makeVectorToMatrixAsCol() {
		Matrix m = new MatrixImpl(0.0, length, 1);
		for(int i = 0 ; i < length;i++)
			m.set(vlist.get(i), i, 0);
		return m;
	}
	@Override//31번
	public Matrix makeVectorToMatrixAsRow() {
		Matrix m = new MatrixImpl(0.0, 1, length);
		for(int i = 0 ; i <length;i++)
			m.set(vlist.get(i), 0, i);
		return m;
	}
}
