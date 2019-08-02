package tensor;

public interface Matrix extends Cloneable{
	public Scalar get(int m, int n);
	public void set(Scalar elements,int m,int n);
	public void showSize();//13�� ��� ũ�� ���
	public int cols();//��� �� ����
	public int rows();//��� �� ����
	public Vector getRowVector(int idx);//����� idx��° �� ���
	public Vector getColVector(int idx);//����� idx��° �� ���
	public Object clone() throws CloneNotSupportedException;
	public void addToMine(Matrix m);//22��
	public void multToMineAsLeft(Matrix m);//23��
	public void multToMineAsRight(Matrix m);//23��
	public Matrix subtractMatrixPart(int start_row_idx,int end_row_idx,int strat_col_idx,int end_col_idx);//36��
	public Matrix makeMinor(int rowIdx,int colIdx);//37��
	public Matrix transpose();//38��
	public Scalar trace();//39��
	public boolean distinguishSquareMatrix();//40��
	public boolean distinguishUpperTriangularMatrix();//41��
	public boolean distinguishLowerTriangularMatrix();//42��
	public boolean distinguishIdentityMatrix();//43��
	public boolean distinguishNullMatrix();//44��
	public void changeRow(int row1,int row2);//45��
	public void changeCol(int col1,int col2);//46��
	public void mulScalarToRow(int rowIdx,Scalar s);//47��
	public void mulScalarToCol(int colIdx,Scalar s);//48��
	public void addCertainRowToMine(int my_row_idx,int other_row_idx,Matrix m,Scalar s);//49��
	public void addCertainColToMine(int my_col_idx,int other_col_idx,Matrix m,Scalar s);//50��
	public Matrix makeRREFMatrix();//51��
	public boolean distinguishRREF();//52��
	public Double determinant();//53��
	public Matrix makeInverse();//54��
}
