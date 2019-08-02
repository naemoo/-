package tensor;

class ScalarImpl implements Scalar{	
	Double s;
	//생성자
	ScalarImpl(Double d) {
		s = d;
	}
	ScalarImpl(Double i , Double j) {
		double rand = (Math.random()*(j.doubleValue()-i.doubleValue())) + i.doubleValue();
		s = new Double(rand);
	}
	//메소드 -기능 들
	@Override//13번
	public String toString() {
		return s.toString();
	}
	@Override//15번
	public boolean equals(Object obj) {
		return (s.doubleValue() == ((Scalar)obj).get().doubleValue());
	}
	@Override//12번
	public Double get() {
		return s;
	}
	@Override//12번
	public void set(Double input) {
		s = input;
	}
	@Override//16번
	public int compareTo(Scalar anotherScalar) {
		return s.compareTo(anotherScalar.get());
	}
	@Override//18번 
	public void addToMine(Scalar anotherScalar) {
		s = s.doubleValue() + anotherScalar.get().doubleValue();
	}
	@Override//19번
	public void mulToMine(Scalar anotherScalar) {
		double result = s.doubleValue() * anotherScalar.get().doubleValue();
		s = new Double(result);
	}
	@Override//17번
	public Object clone() throws CloneNotSupportedException{
		Scalar copy = (Scalar)super.clone();
		copy.set(new Double(s.doubleValue()));
		return copy;
	}
	static Scalar addTwoScalar(Scalar s1,Scalar s2) {//24번
		Scalar ns = new ScalarImpl(s1.get().doubleValue()+s2.get().doubleValue());
		return ns;
	}
	static Scalar mulTwoScalar(Scalar s1,Scalar s2) {//25번
		Scalar ns = new ScalarImpl(s1.get().doubleValue() * s2.get().doubleValue());
		return ns;
	}
}


