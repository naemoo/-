package tensor;

import java.util.List;
import java.util.LinkedList;

class MatrixImpl implements Matrix {
	List<Vector> mlist = new LinkedList<Vector>();
	int rows = 0;
	int cols = 0;
		
	MatrixImpl(Double d, int m, int n) {//6번
		for(int i = 0 ; i <m;i++) {
			Vector v = new VectorImpl(d, n);
			mlist.add(v);
		}
		rows = m;
		cols = n;
	}

	MatrixImpl(Double i, Double j, int m, int n) {//7번
		for(int idx = 0 ; idx < m;idx++) {
			Vector v= new VectorImpl(i, j, n);
			mlist.add(v);
		}
		rows = m;
		cols = n;
	}
	
	@Override//열 개수 출력
	public int cols() {
		return cols;
	}
	@Override//행 개수 출력
	public int rows() {
		return rows;
	}
	@Override//11번
	public Scalar get(int m, int n) {
		return mlist.get(m).get(n);
	}
	@Override//11번
	public void set(Scalar elements, int m, int n) {
		mlist.get(m).set(elements, n);
	}
	@Override//13번
	public void showSize() {
		System.out.println("Matrix Size : " + rows +" x "+cols); 
	}
	@Override//13번
	public String toString() {
		return mlist.toString();
	}
	@Override//15번
	public boolean equals(Object obj) {
		Matrix m = (Matrix)obj;
		
		if(cols != m.cols() || rows != m.rows()) {
			System.out.print("행렬크기가 맞지 않습니다.");
			return false;
		}
		else
			for(int i= 0 ;i<rows;i++)
				for(int j = 0 ; j<cols;j++)
					if(!(mlist.get(i).get(j).equals(m.get(i, j))))
						return false;
		return true;
	}
	@Override 
	public Object clone() throws CloneNotSupportedException{
		Matrix copy = (Matrix)super.clone();
		List<Vector> deepcopy = new LinkedList<Vector>();
		for(int i = 0 ; i < rows;i++)
			deepcopy.add((Vector)mlist.get(i).clone());
		mlist = deepcopy;
		return copy;
	}
	
	@Override
	public Vector getRowVector(int idx) {
		Vector row_vector = new VectorImpl(0.0, cols);
		for(int i = 0 ; i < cols;i++) {
			row_vector.set(mlist.get(idx).get(i), i);
		}
		return row_vector;
	}
	@Override
	public Vector getColVector(int idx) {
		Vector col_vector = new VectorImpl(0.0, rows);
		for(int i = 0 ; i <rows;i++) {
			col_vector.set(mlist.get(i).get(idx), i);
		}
		return col_vector;
	}
	@Override//22번
	public void addToMine(Matrix m) {
		try {
			if(rows != m.rows() || cols!=m.cols())
				throw new MatrixSizeNotMatchException();
			for(int i =0;i<rows;i++)
				mlist.get(i).addToMine(m.getRowVector(i));
		}
		catch(MatrixSizeNotMatchException e){
			System.out.println(e.getMessage());
		}
	}
	@Override//23번
	public void multToMineAsLeft(Matrix m) {
		try {
		if(cols!=m.rows())
			throw new MatrixMulSizeNotMatchException();
			List<Vector> tmplist = new LinkedList<Vector>();
			for(int i = 0 ; i < rows;i++) {
				Vector nv = new VectorImpl(0.0, m.cols());
				for(int j = 0 ; j<m.cols();j++) {
					Scalar ns = new ScalarImpl(0.0);
					for(int k = 0 ; k<cols;k++) {
						ns.addToMine(ScalarImpl.mulTwoScalar(mlist.get(i).get(k), m.get(k,j)));
					}
					nv.set(ns, j);
				}
				tmplist.add(nv);
			}
			mlist = tmplist;
			cols = m.cols();
		}
		catch(MatrixMulSizeNotMatchException e) {
			System.out.println(e.getMessage()); 
			System.out.println("곱셈 진행 불가.");
		}
	}
	
	@Override//23번
	public void multToMineAsRight(Matrix m) {
		try {
			if(m.cols()!=rows)
				throw new MatrixMulSizeNotMatchException();
			List<Vector> tmplist = new LinkedList<Vector>();
			for(int i = 0 ; i < m.rows();i++) {
				Vector nv = new VectorImpl(0.0, cols);
				for(int j = 0 ; j < cols;j++) {
					Scalar ns = new ScalarImpl(0.0);
					for(int k=0;k<m.cols();k++) {
						ns.addToMine(ScalarImpl.mulTwoScalar(m.get(i, k), mlist.get(k).get(j)));
					}
					nv.set(ns, j);
				}
				tmplist.add(nv);
			}
			mlist = tmplist;
			rows = m.rows();
		}
		catch(MatrixMulSizeNotMatchException e) {
			System.out.println(e.getMessage());
			System.out.println("곱셈 진행 불가.");
		}
	}
	static Matrix addTwoMatrix(Matrix m1,Matrix m2) {//28번
		try {
			if((m1.rows()!=m2.rows()) || (m1.cols() !=m2.cols()))
				throw new MatrixSizeNotMatchException();
			Matrix newMatrix = new MatrixImpl(0.0, m1.rows(), m1.cols());
			for(int i = 0 ; i < m1.rows();i++)
				for(int j = 0 ; j < m1.cols() ; j++) {
					Scalar s = ScalarImpl.addTwoScalar(m1.get(i,j), m2.get(i, j));
					newMatrix.set(s, i, j);
				}
			return newMatrix;
		}
		catch(MatrixSizeNotMatchException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	static Matrix mulTwoMatrix(Matrix m1,Matrix m2) {//29번
		try {
			if(m1.cols()!=m2.rows())
				throw new MatrixMulSizeNotMatchException();
			Matrix newMatrix = (Matrix)m1.clone();
			newMatrix.multToMineAsLeft(m2);
			return newMatrix;
		}
		catch(MatrixMulSizeNotMatchException e) {
			System.out.println(e.getMessage());
		}
		catch(CloneNotSupportedException e) {
			System.out.println("행렬 복사 실패");
		}
		return null;
	}
	static Matrix combineMatrixWithRow(Matrix m1, Matrix m2) {//32번 Tensor에 이용
		try {
			if(m1.rows()!=m2.rows())
				throw new MatrixSizeNotMatchException();
			Matrix newMatrix = new MatrixImpl(0.0, m1.rows(), m1.cols()+m2.cols());
			for(int i = 0; i< m1.rows();i++)
				for(int j = 0 ; j<m1.cols();j++)
					newMatrix.set(m1.get(i, j), i, j);
			for(int i = 0;i<m1.rows();i++)
				for(int j = m1.cols();j<m1.cols()+m2.cols();j++)
					newMatrix.set(m2.get(i, j-m1.cols()), i, j);
			return newMatrix;
		}
		catch(MatrixSizeNotMatchException e){
			System.out.println("두 행렬의 행 수가 다릅니다.");
		}
		return null;
	}
	static Matrix combineMatrixWithCol(Matrix m1, Matrix m2) {//33번 Tensor에 이용
		try {
			if(m1.cols() != m2.cols())
				throw new MatrixSizeNotMatchException();
			Matrix newMatrix = new MatrixImpl(0.0, m1.rows()+m2.rows(), m1.cols());
			for(int i = 0;i<m1.rows();i++)
				for(int j=0;j<m1.cols();j++)
					newMatrix.set(m1.get(i, j), i, j);
			for(int i = m1.rows();i<m1.rows()+m1.cols();i++)
				for(int j = 0 ; j<m2.rows();j++)
					newMatrix.set(m2.get(i-m1.rows(), j), i, j);
			return newMatrix;
		}
		catch(MatrixSizeNotMatchException e) {
			System.out.println("두 행렬의 열 수가 다릅니다.");
		}
		return null;
	}
	@Override//36번
	public Matrix subtractMatrixPart(int sri, int eri, int sci, int eci) {
		int prow = eri - sri+1;
		int pcol = eci - sci+1;
		try {
			if(eri>=rows||eci>=cols)
				throw new MatrixSizeNotMatchException();
			Matrix part_matrix = new MatrixImpl(0.0,prow,pcol);
			for(int i =0; i<prow;i++)
				for(int j=0;j<pcol;j++)
					part_matrix.set(mlist.get(sri + i).get(sci + j), i, j);
			return part_matrix;
		}
		catch(MatrixSizeNotMatchException e) {
			System.out.println("입력한 인덱스 값이 행렬 크기를 초과합니다.");
		}
		return null;
	}
	@Override//37번
	public Matrix makeMinor(int rowIdx, int colIdx) {
		Matrix minor = new MatrixImpl(0.0, rows-1, cols-1);
		int minor_rowidx = 0;
		for(int i = 0;i<rows;i++) {
			int minor_colidx = 0;
			if(i == rowIdx)
				continue;
			for(int j = 0 ; j<cols;j++) {
				if(j==colIdx)
					continue;
				minor.set(mlist.get(i).get(j), minor_rowidx,minor_colidx);
				minor_colidx++;
			}
			minor_rowidx++;
		}
		return minor;
	}
	@Override//38번
	public Matrix transpose() {
		Matrix tm = new MatrixImpl(0.0, cols, rows);
		for(int i = 0 ; i < cols;i++)
			for(int j = 0 ; j < rows;j++)
				tm.set(mlist.get(j).get(i), i, j);
		return tm;
	}
	@Override//39번
	public Scalar trace() {
		try {
			if(rows != cols)
				throw new SquareMatrixException();
			Scalar s = new ScalarImpl(0.0);
			for(int i = 0;i<rows;i++)
				s.addToMine(mlist.get(i).get(i));
			return s;
		}
		catch(SquareMatrixException e) {
			System.out.println(e.getMessage());
			System.out.println("trace()메소드 실행 불가합니다.");
		}
		return null;
	}
	@Override//40번
	public boolean distinguishSquareMatrix() {
		if(rows == cols)
			return true;
		return false;
	}
	@Override//41번
	public boolean distinguishUpperTriangularMatrix() {
		try {
			if(!distinguishSquareMatrix())
				throw new SquareMatrixException();
			Scalar cmp = new ScalarImpl(0.0);
			for(int i = 0 ; i < rows; i++)
				for(int j = 0;j<i;j++)
					if(!(mlist.get(i).get(j).equals(cmp)))
						return false;
			return true;
		}
		catch(SquareMatrixException e) {
			System.out.println(e.getMessage());
			System.out.println("distinguishUpperTriangularMatrix 진행 불가.");
		}
		return false;
	}
	@Override//42번
	public boolean distinguishLowerTriangularMatrix() {
		try {
			if(!distinguishSquareMatrix())
				throw new SquareMatrixException();
			Scalar cmp = new ScalarImpl(0.0);
			for(int i = 0 ; i<rows;i++)
				for(int j = i+1 ; j<cols;j++)
					if(!(mlist.get(i).get(j).equals(cmp)))
						return false;
			return true;
		}
		catch(SquareMatrixException e) {
			System.out.println(e.getMessage());
			System.out.println("distinguishLowerTriangularMatrix 진행 불가.");
		}
		return false;
	}
	@Override//43번
	public boolean distinguishIdentityMatrix() {
		try {
			if(!distinguishSquareMatrix())
				throw new SquareMatrixException();
			Scalar cmp1 = new ScalarImpl(1.0);
			Scalar cmp2 = new ScalarImpl(0.0);
			for(int i = 0 ; i <rows;i++) 
				if(!(mlist.get(i).get(i).equals(cmp1)))
					return false;
			for(int i = 0; i < rows;i++)
				for(int j = 0 ; j <cols;j++) {
					if(i == j)
						continue;
					if(!(mlist.get(i).get(j).equals(cmp2)))
						return false;
				}
			return true;
		}
		catch(SquareMatrixException e) {
			System.out.println(e.getMessage());
			System.out.println("distinguishIdentityTriangularMatrix 진행 불가.");
		}
		return false;
	}
	@Override//44번
	public boolean distinguishNullMatrix() {
		Scalar cmp = new ScalarImpl(0.0);
		for(int i=0;i<rows;i++)
			for(int j = 0 ; j<cols;j++)
				if(!(mlist.get(i).get(j).equals(cmp)))
					return false;
		return true;
	}
	@Override//45번
	public void changeRow(int row1,int row2) {
		Vector tmp = mlist.get(row1);
		mlist.set(row1, mlist.get(row2));
		mlist.set(row2, tmp);
	}
	@Override//46번
	public void changeCol(int col1, int col2) {
		for(int i = 0 ; i<rows;i++) {
			Scalar tmp = mlist.get(i).get(col1);
			mlist.get(i).set(mlist.get(i).get(col2), col1);
			mlist.get(i).set(tmp, col2);
		}		
	}
	@Override//47번
	public void mulScalarToRow(int rowIdx, Scalar s) {
		mlist.get(rowIdx).multToMine(s);
	}
	@Override//48번
	public void mulScalarToCol(int colIdx, Scalar s) {
		for(int i = 0;i<rows;i++)
			mlist.get(i).get(colIdx).mulToMine(s);
	}
	@Override//49번
	public void addCertainRowToMine(int mri,int ori ,Matrix m, Scalar s) {
		try {
			Vector v = (Vector)m.getRowVector(ori).clone();//클론없이 가능?
			v.multToMine(s);
			mlist.get(mri).addToMine(v);
		}
		catch(CloneNotSupportedException e) {
			System.out.println("addCertainRowtoMine 메소드 호출 실패");
		}
	}
	@Override//50번
	public void addCertainColToMine(int my_col_idx, int other_col_idx, Matrix m, Scalar s) {
		
		for(int i = 0; i<rows;i++) {
			Scalar operand = (Scalar)m.get(i, other_col_idx);
			operand.mulToMine(s);
			mlist.get(i).get(my_col_idx).addToMine(operand);
		}
	}
	private Matrix gaussElimination(Matrix m) {
		try {
			Matrix gm = (Matrix)m.clone();
			Scalar zero = new ScalarImpl(0.0);
			Scalar div = new ScalarImpl(1.0);
			Scalar minus = new ScalarImpl(-1.0);
			Vector nullvector = gm.getRowVector(0);
			nullvector.multToMine(zero);
			for(int n = 0 ; n < gm.rows();n++) {
				if(gm.cols() <= n)//열이 길 경우
					break;
				if(gm.get(n, n).equals(zero)) {//0일 경우
					for(int a = n + 1; a<gm.rows();a++) {//같은 열 0 아닌 수 찾기 - for문
						if(!gm.get(a, n).equals(zero)) {
							gm.changeRow(n, a);
							break;
						}
					}
					if(gm.get(n, n).equals(zero)) {//같은 열에 0 만 있다면
						for(int j = n+1;j<gm.cols();j++) {//다음 열로 이동
							escape:
							if(gm.get(n, j).equals(zero)) {//다음 열에 첫 숫자가 0이라면
								for(int a = n+1;a<gm.rows();a++)//같은 열 0 아닌 수 찾기
									if(!gm.get(a, j).equals(zero)) {
										gm.changeCol(n, a);
										break escape;
									}
							}
							else {//다음 열에 첫 숫자가 있다면 나가기
								break;
							}
						}
					}
				}
			}//정렬
			for(int n = 0 ; n<gm.rows();n++) {
				if(gm.cols() <=n)//행이 길 경우
					break;
				if(nullvector.equals(gm.getRowVector(n))&& n != gm.rows()-1) {//0벡터일 경우 행 바꾸기
					for(int i = n+1;i<gm.rows();i++) {
						if(!nullvector.equals(gm.getRowVector(i))) {
							gm.changeRow(n, i);
							break;
						}
					}
				}
				
				if(gm.get(n,n).equals(zero)) {
					for(int i = n+1;i<gm.rows();i++) {
						if(!gm.get(i, n).equals(zero)&&n!=gm.rows()-1) {
							gm.changeRow(i, n);
							break;
						}
					}
					
					for(int j = n;j<gm.cols();j++) {
						if(!gm.get(n, j).equals(zero)) {
							div.set(gm.get(n, j).get());//div에 pivot 값 저장
							div.set(1/div.get());
							break;
						}
					}
				}
				else {
					div.set(gm.get(n, n).get());
					div.set(1/div.get());
				}
				gm.mulScalarToRow(n, div);//pivot값으로 나누기
				for(int a = n+1;a<gm.rows();a++) {
					if(gm.get(a, n).equals(zero))
						continue;
					div.set(gm.get(a, n).get());
					div.mulToMine(minus);
					gm.addCertainRowToMine(a, n, gm, div);
				}
			}
			return gm;
		}
		catch(CloneNotSupportedException e) {
			System.out.println("복사 실패");
		}
		return null;
	}
	@Override//51번
	public Matrix makeRREFMatrix() {
		Matrix m = new MatrixImpl(0.0, rows, cols);
		Scalar con = new ScalarImpl(1.0);
		Scalar zero = new ScalarImpl(0.0);
		Scalar minus = new ScalarImpl(-1.0);
		for(int i= 0;i<rows;i++)
			for(int j= 0 ; j<cols;j++)
				m.set(mlist.get(i).get(j), i, j);
		m = gaussElimination(m);//ref형태로 만들기
		for(int n = m.rows()-1; n >=0; n--) {
			for(int j = 0;j<m.cols();j++) {
				if(!m.get(n,j).equals(zero)) {
					for(int r = n-1;r>=0;r--) {
						con.set(m.get(r, j).get());
						con.mulToMine(minus);
						m.addCertainRowToMine(r, n, m, con);
					}
					break;
				}
			}
		}
		return m;
	}
	@Override
	public boolean distinguishRREF() {//52번
		Matrix m = new MatrixImpl(0.0,rows,cols);
		for(int i = 0 ; i < rows();i++)
			for(int j =0 ; j <cols();j++)
				m.set(mlist.get(i).get(j), i, j);
		 Matrix decision =m.makeRREFMatrix();
		 if(m.equals(decision))
			 return true;
		 else
			 return false;
	}
	@Override
	public Double determinant() {
		try {
			if(rows!=cols)
				throw new SquareMatrixException();
			Scalar det = new ScalarImpl(0.0);
			Scalar minus = new ScalarImpl(-1.0);
			if(rows == 2) {
				Scalar s1 = new ScalarImpl(0.0);
				Scalar s2 = new ScalarImpl(0.0);
				s1.addToMine(mlist.get(0).get(0));
				s2.addToMine(mlist.get(0).get(1));
				s1.mulToMine(mlist.get(1).get(1));
				s2.mulToMine(mlist.get(1).get(0));
				s2.mulToMine(minus);
				det.addToMine(s1);
				det.addToMine(s2);
				return det.get();
			}
			else {
				Matrix m = new MatrixImpl(0.0, rows, cols);
				Matrix minor;
				for(int i = 0 ; i < rows;i++)
					for(int j = 0 ; j<cols;j++)
						m.set(mlist.get(i).get(j),i,j);
				for(int i = 0 ; i<rows;i++) {
					Scalar tmp = new ScalarImpl(0.0);
					minor = m.makeMinor(i, 0);
					tmp.set(minor.determinant());
					tmp.mulToMine(mlist.get(i).get(0));
					if(i%2 ==1)
						tmp.mulToMine(minus);
					det.addToMine(tmp);
				}
				return det.get();
			}
		}
		catch(SquareMatrixException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	@Override
	public Matrix makeInverse() {//54번 확장 행렬 이용
		try {
			if(rows!=cols)
				throw new SquareMatrixException();
			Matrix m = new MatrixImpl(0.0, rows, cols);
			for(int i = 0 ; i < rows;i++)
				for(int j = 0 ; j<cols;j++)
					m.set(mlist.get(i).get(j), i, j);
			if(m.determinant().equals(0.0)) {
				throw new NotExistInveseException();
			}
			Matrix im = Factory.makeIdentityMatrix(rows);
			Matrix mm = Tensors.combineMatrixWithRow(m, im);
			mm = mm.makeRREFMatrix();
			Matrix inverse = mm.subtractMatrixPart(0, rows-1, cols,cols+cols-1);
			return inverse;
		}
		catch(SquareMatrixException e) {
			System.out.println(e.getMessage());
		}
		catch(NotExistInveseException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}


