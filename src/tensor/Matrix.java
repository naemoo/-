package tensor;

public interface Matrix extends Cloneable{
	public Scalar get(int m, int n);
	public void set(Scalar elements,int m,int n);
	public void showSize();//13번 행렬 크기 출력
	public int cols();//행렬 열 개수
	public int rows();//행렬 행 개수
	public Vector getRowVector(int idx);//행렬의 idx번째 행 출력
	public Vector getColVector(int idx);//행렬의 idx번째 열 출력
	public Object clone() throws CloneNotSupportedException;
	public void addToMine(Matrix m);//22번
	public void multToMineAsLeft(Matrix m);//23번
	public void multToMineAsRight(Matrix m);//23번
	public Matrix subtractMatrixPart(int start_row_idx,int end_row_idx,int strat_col_idx,int end_col_idx);//36번
	public Matrix makeMinor(int rowIdx,int colIdx);//37번
	public Matrix transpose();//38번
	public Scalar trace();//39번
	public boolean distinguishSquareMatrix();//40번
	public boolean distinguishUpperTriangularMatrix();//41번
	public boolean distinguishLowerTriangularMatrix();//42번
	public boolean distinguishIdentityMatrix();//43번
	public boolean distinguishNullMatrix();//44번
	public void changeRow(int row1,int row2);//45번
	public void changeCol(int col1,int col2);//46번
	public void mulScalarToRow(int rowIdx,Scalar s);//47번
	public void mulScalarToCol(int colIdx,Scalar s);//48번
	public void addCertainRowToMine(int my_row_idx,int other_row_idx,Matrix m,Scalar s);//49번
	public void addCertainColToMine(int my_col_idx,int other_col_idx,Matrix m,Scalar s);//50번
	public Matrix makeRREFMatrix();//51번
	public boolean distinguishRREF();//52번
	public Double determinant();//53번
	public Matrix makeInverse();//54번
}
