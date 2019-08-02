package tensor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Factory {
	private Factory() {}
	//Scalar ���� - ������ �Űܺ��� Double,double - �����ڽ����� ����
	public static Scalar makeScalar(Double e) {
		Scalar s = new ScalarImpl(e);
		return s;
	}
	public static Scalar makeScalar(Double i, Double j) {
		Scalar s = new ScalarImpl(i, j);
		return s;
	}
	public static Scalar copyScalar(Scalar org) {//17�� ���ι� �� ���� ���ϱ� ���� clone���
		try {
			Scalar copy = (Scalar)org.clone();
			return copy;
		}
		catch(CloneNotSupportedException e) {
			System.out.println("��Į�� ���� ����");
		}
		return null;
	}
	
	//Vector ���� - double�� ���
	public static Vector makeVector(Double e, int n) {
		Vector v = new VectorImpl(e, n);
		return v;
	}
	public static Vector makeVector(Double i, Double j, int n) {
		Vector v = new VectorImpl(i, j, n);
		return v;
	}
	public static Vector makeVector(double[] arr) {//1���� �迭�� Vector�� �����
		Vector v = new VectorImpl(0.0, arr.length);
		for(int i = 0;i<arr.length;i++) {
			Scalar s = new ScalarImpl(arr[i]);
			v.set(s, i);
		}
		return v;
	}
	public static Vector copyVector(Vector org) {//17�� ���� ���� ���� clone ���
		try {
			Vector copy = (Vector)org.clone();
			return copy;
		}
		catch(CloneNotSupportedException e) {
			System.out.println("���� ���� ����");
		}
		return null;
	}
	
	//Matrix ���� 
	public static Matrix makeMatrix(Double d,int m, int n) {
		Matrix mat = new MatrixImpl(d, m, n);
		return mat;
	}
	public static Matrix makeMatrix(Double i, Double j, int m, int n) {
		Matrix mat = new MatrixImpl(i, j, m, n);
		return mat;
	}
	public static Matrix makeMatrix(double[][] arr) {
		Matrix m = new MatrixImpl(0.0, arr.length, arr[0].length);
		for(int i = 0;i<arr.length;i++)
			for(int j = 0 ; j <arr[i].length;j++){
				Scalar s = new ScalarImpl(arr[i][j]);
				m.set(s, i, j);
			}
		return m;
	}
	public static Matrix makeMatrix(String adr) {//8��
		try(BufferedReader br = new BufferedReader(new FileReader(adr))){
			String line = "";
			List<String> list = new LinkedList<String>();
			int row = 0;
			int col = 0;
			while((line = br.readLine()) != null) {
				String[] token = line.split(",");
				for(int i = 0 ;i<token.length;i++)
					list.add(token[i]);
				row++;
				col = token.length;
			}
			double[][] arr = new double[row][col];
			int idx=0;
			for(int i =0;i<row;i++)
				for(int j = 0 ; j<col;j++) {
					arr[i][j] = Double.parseDouble(list.get(idx));
					idx++;
				}
			return makeMatrix(arr);
		}
		catch(FileNotFoundException e) {
			e.getStackTrace();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("csv���Ϸ� ���� ���� ����");
		return null;
	}
	
	public static Matrix makeIdentityMatrix(int n) { //���� ��� ����
		Matrix mat = new MatrixImpl(0.0, n, n);
		for(int i = 0 ; i < n;i++) {
			Scalar s = new ScalarImpl(1.0);
			mat.set(s, i, i);
		}
		return mat;
	}
	public static Matrix copyMatrix(Matrix org) {
		try {
			Matrix copy = (Matrix)org.clone();
			return copy;
		}
		catch(CloneNotSupportedException e) {
			System.out.println("��� ���� ����");
		}
		return null;
	}
}
