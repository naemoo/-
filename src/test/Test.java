package test;

import tensor.Scalar;
import tensor.Vector;
import tensor.Matrix;
import tensor.Tensors;
import tensor.Factory;


public class Test {
	public static void main(String[] args) {
		//1,2�� ���� -phase 1
		System.out.println("1��>> ���� �����Ͽ� ��Į�� ���� �� ���(1.0���� ����)");
		Scalar p1_s1 = Factory.makeScalar(1.0);//���� �ڽ� ����
		System.out.println(p1_s1);
		System.out.println();
		System.out.println("2��>> 0.0�̻� 2.0�̸��� ������ ���� ��ҷ� �ϴ� ��Į�� �� ����");
		Scalar p1_s2 = Factory.makeScalar(0.0, 2.0);//���� �ڽ� ����
		System.out.println(p1_s2);
		p1_s1=p1_s2=null;//�޸� ����
		System.out.println();
		
		//3,4,5�� ���� - phase 2
		System.out.println("3��>> 1.0 ��Į�� ���� ���� 3���� ���� ����");
		Vector p2_v1 = Factory.makeVector(1.0, 3);//���� �ڽ� ����
		System.out.println(p2_v1);
		System.out.println();
		System.out.println("4��>> 0.0 �̻� 2.0�̸��� ������ ���� ��ҷ� �ϴ� 3���� ���� ����");
		Vector p2_v2 = Factory.makeVector(0.0, 2.0, 3);
		System.out.println(p2_v2);
		System.out.println();
		System.out.println("5��>> 1���� �迭�� ���� n���� ���� ����");
		double[] p2_arr = {0.0,0.1,0.3};
		Vector p2_v3 = Factory.makeVector(p2_arr);
		System.out.println(p2_v3);
		p2_v1=p2_v2=p2_v3=null;
		p2_arr = null;
		
		//6~10�� ���� - phase 3
		System.out.println("6��>>  �ϳ��� ���� ��� ����� ������ �ϴ� m x n ����� ����(0.0���� ����)");
		Matrix p3_m1 = Factory.makeMatrix(0.0, 2, 2);//���� �ڽ� ����
		System.out.println(p3_m1);
		System.out.println();
		System.out.println("7��>> 0.0 �̻� 2.0 �̸��� ������ ���� ��ҷ� �ϴ� mxn ����� ����");
		Matrix p3_m2 = Factory.makeMatrix(0.0, 2.0, 2, 2);
		System.out.println(p3_m2);
		System.out.println();
		System.out.println("8��>> csv���Ϸ� ���� mxn �����  ����");
		System.out.print("������ ���� ���� ���� ��>>");
		Matrix p3_m3 = Factory.makeMatrix("");
		System.out.println("Matrix :"+p3_m3);
		System.out.print("������ ���� �� ��>>");
		p3_m3 = Factory.makeMatrix("D:\\������\\prc.csv");
		System.out.println("Matrix :"+p3_m3);
		System.out.println();
		System.out.println("9��>>2���� �迭�� ���� mxn ����� ����");
		double[][] p3_arr = {{0.0,0.1},{0.2,0.3}};
		Matrix p3_m4 = Factory.makeMatrix(p3_arr);
		System.out.println(p3_m4);
		System.out.println();
		System.out.println("10��>>���� ��� ����");
		Matrix p3_m5 = Factory.makeIdentityMatrix(2);
		System.out.println(p3_m5);
		p3_m1=p3_m2=p3_m3=p3_m4=p3_m5=null;p3_arr = null;
		
		//11�� ~ 17�� ���� - phase 4
		System.out.println();
		System.out.println("11��>>����,��� Ư�� ��ġ�� ��Ҹ� ����/��ȸ");
		System.out.println("����, ��� ���� �� ���");
		Vector p4_v1 = Factory.makeVector(0.1, 3);
		Matrix p4_m1 = Factory.makeMatrix(0.1, 2, 2);
		System.out.print("Vector 1: "+p4_v1+"\t");
		System.out.println("Matrix 1 : "+p4_m1);
		System.out.println("���� Ư�� ��ġ�� ��� ����(Vector1 : �� ��° , Matrix : (1,1) IDX ����) 100.0 �ֱ�");
		Scalar p4_s1 = Factory.makeScalar(100.0);//����ڽ� ����
		p4_v1.set(p4_s1, 1);
		p4_m1.set(p4_s1, 1, 1);
		System.out.print(p4_v1+"\t");
		System.out.println(p4_m1);
		System.out.println("����, ��� Ư�� ��ġ�� ��ȸ(Vector : 1 IDX, Matrix : (1,1) IDX)");
		System.out.print(p4_v1.get(1)+"\t");
		System.out.println(p4_m1.get(1, 1));
		System.out.println();
		
		System.out.println("12��>> ��Į�� �� ����/��ȸ");
		System.out.print("��Į�� �� ��ȸ : ");
		System.out.println(p4_s1);
		System.out.print("��Į�� �� ���� (10.0 �ֱ�) : ");
		p4_s1.set(10.0);//������ ����
		System.out.println(p4_s1);
		System.out.println();
		
		System.out.println("13��>> ����,��� ũ�� ������ ��ȸ(11�� ����,��� ���)");
		System.out.println("������ ũ�� : "+p4_v1.length());
		System.out.println("�� : "+p4_m1.rows()+" �� :"+p4_m1.cols());
		System.out.println();
		
		System.out.println("14��>>��Į�� ��, ���� ��, ��� �� �ܼ� ���");
		Scalar p4_s2 = Factory.makeScalar(1.0);
		Vector p4_v2 = Factory.makeVector(1.0, 4);
		Matrix p4_m2 = Factory.makeMatrix(1.0, 2, 3);
		System.out.println("1)��Į�� �� ��� : "+p4_s2);
		System.out.println("2)���� �� ��� : " + p4_v2);
		System.out.println("3)��� �� ��� : " + p4_m2);
		System.out.println();
		System.out.println("15��>>��ü�� ��� �Ǵ� (���� ���ٸ� true,�ٸ��� false)");
		System.out.println("1)��Į�� ��");
		p4_s1.set(1.0); p4_s2.set(1.0);
		System.out.print("Sclar 1 : " + p4_s1 + "\t");
		System.out.println("Sclar 2 : " + p4_s2);
		System.out.println("�� ��Į�� ���� ���ٸ� true, �׷��� �ʴٸ� false : "+p4_s1.equals(p4_s2));
		System.out.println("2)���� ��");
		Vector p4_v3 = Factory.makeVector(1.0, 4);
		Vector p4_v4 = Factory.makeVector(2.0, 4);
		System.out.print("Vector 1 : " + p4_v1 + "\t");
		System.out.print("Vector 2 : " + p4_v2 + "\t");
		System.out.print("Vector 3 : " + p4_v3 + "\t");
		System.out.println("Vector 4 : " + p4_v4);
		System.out.print("Vector1, Vector2 ��(ũ�Ⱑ �ٸ� ���� ��): ");
		System.out.println(p4_v1.equals(p4_v2));
		System.out.println("Vector2, Vector 3 �� : "+p4_v2.equals(p4_v3));
		System.out.println("Vector 2, Vector 4 �� : "+p4_v2.equals(p4_v4));
		System.out.println("3)��� ��");
		p4_m1 = Factory.makeMatrix(1.0, 2, 2);
		p4_m2 = Factory.makeMatrix(1.0, 2, 2);
		Matrix p4_m3 = Factory.makeMatrix(2.0, 2, 2);
		Matrix p4_m4 = Factory.makeMatrix(1.0, 3, 3);
		System.out.println("Matrix 1 : " + p4_m1 + "\t"+"Matrix 2 : " + p4_m2 + "\t"+"Matrix 3 : " + p4_m3 + "\t"+"Matrix 4 : " + p4_m4);
		System.out.println("Matrix 1, Matrix2 �� : "+p4_m1.equals(p4_m2));
		System.out.println("Matrix 1, Matrix3 �� : "+p4_m1.equals(p4_m3));
		System.out.print("Matrix 1, Matrix4 ��(ũ�Ⱑ �ٸ� ��� ��) : ");
		System.out.println(p4_m1.equals(p4_m4));
		System.out.println();
		System.out.println("16��>>");
		p4_s1 = Factory.makeScalar(1.0); p4_s2 = Factory.makeScalar(2.0); Scalar p4_s3 = Factory.makeScalar(1.0);
		System.out.println("Scalar 1 : "+ p4_s1 +"\t"+"Scalar 2 : "+ p4_s2+"\t"+"Scalar 3 : "+ p4_s3);
		System.out.println("��Į�� ��� ��(�տ� �ִ� ��Į�� ũ�� 1, ������ 0, ������ -1) : ");
		System.out.println("Scalar 1, Scalar 2 �� : "+p4_s1.compareTo(p4_s2));
		System.out.println("Scalar 1, Scalar 3 ��  : "+p4_s1.compareTo(p4_s3));
		System.out.println("Scalar 2, Scalar 3 �� : "+p4_s2.compareTo(p4_s3));
		System.out.println();
		System.out.println("17��>>");
		try {
		System.out.println("Scalar ���� : "+p4_s1);
		System.out.println("Scalar �纻 : " + p4_s1.clone());
		System.out.println("Vector ���� : " + p4_v2);
		System.out.println("Vector �纻 : " + p4_v2.clone());
		System.out.println("Matrix ���� : " + p4_m1);
		System.out.println("Matrix �纻 : " + p4_m1.clone());
		System.out.println();
		}
		catch(CloneNotSupportedException e) {
			System.out.println("���� ����");
		}
		System.out.println();
		p4_s1= p4_s2=p4_s3=null;p4_v1=p4_v2=p4_v3=p4_v4=null;p4_m1=p4_m2=p4_m3=p4_m4=null;
		
		//18~23�� - phase5
		System.out.println("18��>>");
		Scalar p5_s1 = Factory.makeScalar(1.0);
		Scalar p5_s2 = Factory.makeScalar(2.0);
		System.out.println("Scalar1 : "+p5_s1);
		System.out.println("Scalar2 : "+p5_s2);
		p5_s1.addToMine(p5_s2);
		System.out.println("Scalar1.add(Scalar2) = " + p5_s1);
		System.out.println();
		System.out.println("19��>>");
		System.out.println("Scalar1 : "+p5_s1);
		System.out.println("Scalar 2 : "+p5_s2);
		p5_s1.mulToMine(p5_s2);
		System.out.println("Scalar1.mul(Scalar2) = " + p5_s1);
		System.out.println();
		System.out.println("20��>>");
		Vector p5_v1 = Factory.makeVector(1.0,3);
		Vector p5_v2 = Factory.makeVector(2.0,3);
		Vector p5_v3 = Factory.makeVector(1.0,4);
		System.out.println("Vector 1 : "+p5_v1);
		System.out.println("Vector 2 : "+p5_v2);
		System.out.println("Vector 3 : "+p5_v3);
		System.out.print("Vector1.add(Vector3) - ���̰� �ٸ� ���� ���� : ");
		p5_v1.addToMine(p5_v3);
		System.out.println("Vector1 : " + p5_v1+" -> ���� �� ��ȭ x");
		p5_v1.addToMine(p5_v2);
		System.out.println("Vector1.add(Vector2) - ���̰� ���� ���� ���� : "+p5_v1);
		System.out.println();
		System.out.println("21��>>");
		System.out.println("Scalar1 : "+p5_s1);
		System.out.println("Vector1 : "+p5_v1);
		p5_v1.multToMine(p5_s1);
		System.out.println("Vector1.mul(Scalar1) : "+p5_v1);
		System.out.println();
		System.out.println("22��>>");
		Matrix p5_m1 = Factory.makeMatrix(1.0, 2, 2);
		Matrix p5_m2 = Factory.makeMatrix(2.0, 2, 2);
		Matrix p5_m3 = Factory.makeMatrix(2.0, 2, 3);
		System.out.println("Matrix1 : "+p5_m1);
		System.out.println("Matrix2 : "+p5_m2);
		System.out.println("Matrix3 : "+p5_m3);
		System.out.print("Matrix1.add(Matrix 3) - ũ�Ⱑ �ٸ� ��� ���� : ");
		p5_m1.addToMine(p5_m3);
		System.out.println("Matrix1 : " + p5_m1+" -> ��� �� ��ȭ x");
		p5_m1.addToMine(p5_m2);
		System.out.println("Matrix1.add(Matrix2) - ũ�Ⱑ ���� ��� ���� : "+p5_m1);
		System.out.println();
		System.out.println("23��>>");
		double[][] p5_arr1 = {{2.0,4.0},{-1.0,5.0},{7.0,3.0}};
		p5_m1 = Factory.makeMatrix(p5_arr1);
		double[][] p5_arr2 = {{1.0,2.0,-3.0},{0.0,-1.0,-2.0}};
		double[][] p5_arr3 = {{2.0,0.0},{0.0,2.0}};
		p5_m2 = Factory.makeMatrix(p5_arr2);
		p5_m3 =Factory.makeMatrix(p5_arr3);
		System.out.println("Matrix1(3x2) :" +p5_m1);
		System.out.println("Matrix2(2x3) :" +p5_m2);
		System.out.println("Matrix3(2x2) :"+p5_m3);
		p5_m1.multToMineAsLeft(p5_m2);
		System.out.println("Matrix1.mul(Matrix2) ���� ��ķμ� : "+ p5_m1);
		p5_m2.multToMineAsRight(p5_m3);
		System.out.println("Matrix2.mul(Matrix2) ������ ��ķμ� :"+ p5_m2);
		p5_arr1=p5_arr2=p5_arr3 =null;
		p5_m1=p5_m2=p5_m3 = null;p5_v1=p5_v2=p5_v3=null;p5_s1=p5_s2=null;
		System.out.println();
		
		//24~29�� phase6
		System.out.println("24, 25��>>");
		Scalar p6_s1 = Factory.makeScalar(2.0);
		Scalar p6_s2 = Factory.makeScalar(3.0);
		Scalar p6_s3 = Tensors.addTwoScalar(p6_s1,p6_s2);
		Scalar p6_s4 = Tensors.mulTwoScalar(p6_s1, p6_s2);
		System.out.println("Scalar 1 : "+p6_s1);
		System.out.println("Scalar 2 : "+p6_s2);
		System.out.println("Scalar 1 + Scalar 2 = "+p6_s3);
		System.out.println("Scalar 1 x Scalar 2 = "+p6_s4);
		System.out.println();
		System.out.println("26, 27��>>");
		Vector p6_v1 = Factory.makeVector(2.0, 3);
		Vector p6_v2 = Factory.makeVector(3.0, 3);
		Vector p6_v3 = Factory.makeVector(1.0, 4);
		Vector p6_v4 = Tensors.addTwoVector(p6_v1, p6_v2);
		Vector p6_v5 = Tensors.mulScalarAndVector(p6_s1, p6_v1);
		System.out.println("Scalar 1 : "+p6_s1);
		System.out.print("Vector 1 : " + p6_v1 + "\t");
		System.out.print("Vector 2 : " + p6_v2 + "\t");
		System.out.println("Vector 3 : " + p6_v3 + "\t");
		System.out.println("Vector 1 + Vector 2 : "+ p6_v4);
		System.out.println("Scalar 1 x Vector 1 : "+ p6_v5);
		System.out.print("Vector1 + Vector3(���̰� �ٸ� ������ ����) : ");
		p6_v4 = Tensors.addTwoVector(p6_v1, p6_v3);
		System.out.println();
		
		System.out.println("28, 29��>>");
		Matrix p6_m1 = Factory.makeMatrix(1.0, 2, 2);
		Matrix p6_m2 = Factory.makeMatrix(2.0,2,2);
		Matrix p6_m3 = Factory.makeMatrix(3.0, 2, 3);
		Matrix p6_m4 = Tensors.addTwoMatrix(p6_m1, p6_m2);
		Matrix p6_m5 = Tensors.mulTwoMatrix(p6_m1, p6_m3);
		System.out.println("Matrix1 : "+p6_m1);
		System.out.println("Matrix2 : "+p6_m2);
		System.out.println("Matrix3 : "+p6_m3);
		System.out.println("Matrix 1 + Matrix 2 = "+p6_m4);
		System.out.print("Matrix 1 + Matrix 3 (ũ�� �ٸ� ����� ����) = ");
		p6_m4 = Tensors.addTwoMatrix(p6_m1, p6_m3);
		System.out.println("Matrix 1 x Matrix 3 = "+p6_m5);
		System.out.print("Matrix 3 x Matrix 1 = ");
		p6_m5 = Tensors.mulTwoMatrix(p6_m3, p6_m1);
		System.out.println();
		p6_m1=p6_m2=p6_m3=p6_m4=p6_m5=null;
		p6_v1=p6_v2=p6_v3=p6_v4=p6_v5=null;
		p6_s1=p6_s2=p6_s3=p6_s4=null;
		
		//30~31�� phase7
		System.out.println("30��,31��>>");
		Vector p7_v1 = Factory.makeVector(1.0, 3);
		Matrix p7_m1 = p7_v1.makeVectorToMatrixAsCol();
		Matrix p7_m2 = p7_v1.makeVectorToMatrixAsRow();
		System.out.println("Vector 1 : " + p7_v1);
		System.out.println("Vector 1���κ���  3x1 ��� ���� : "+ p7_m1);
		System.out.println("Vector 1���κ��� 1x3 ��� ����"+p7_m2);
		System.out.println();
		p7_v1=null;p7_m1=p7_m2=null;
		
		//32~36��phase8
		System.out.println("32��,33��>>");
		Matrix p8_m1 = Factory.makeMatrix(2.0, 2, 2);
		Matrix p8_m2 = Factory.makeIdentityMatrix(2);
		Matrix p8_m3 = Tensors.combineMatrixWithRow(p8_m1, p8_m2);
		Matrix p8_m4 = Tensors.combineMatrixWithCol(p8_m1, p8_m2);
		System.out.println("Matrix 1 : " + p8_m1);
		System.out.println("Matrix 2 : " + p8_m2);
		System.out.println("Matrix 1, Matrix 2 ���η� ��ġ�� : "+p8_m3);
		System.out.println("Matrix 1, Matrix 2 ���η� ��ġ�� : "+p8_m4);
		System.out.println();
		
		System.out.println("34��,35��>>");
		double[][] p8_arr = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0},{10.0,11.0,12.0}};
		p8_m3 = Factory.makeMatrix(p8_arr);
		p8_arr = null;
		System.out.println("Matrix 1 : " + p8_m3);
		Vector p8_v1 = p8_m3.getRowVector(1);
		Vector p8_v2 = p8_m3.getColVector(1);
		System.out.println("Ư�� ���� ���� ���·� ����(�� ��° ��) : "+p8_v1);
		System.out.println("Ư�� ���� ���� ���·� ����(�� ���� ��) : "+p8_v2);
		System.out.println();
		
		System.out.println("36��>>");
		p8_m1 = p8_m3.subtractMatrixPart(0, 2, 0, 1);
		System.out.println("Matrix : " + p8_m3);
		System.out.println("Matrix�� 0����� 2��, 0������ 1�� ���� : "+p8_m1);
		p8_m1=p8_m2=p8_m3=p8_m4=null;
		p8_v1=p8_v2=null;
		System.out.println();
		
		//37��~39�� phase9
		System.out.println("37��>>");
		double[][] p9_arr = {{1,2,3,4},{5,6,7,8},{9,3,4,1}};
		Matrix p9_m1 = Factory.makeMatrix(p9_arr);
		System.out.println("Matrix1 : "+p9_m1);
		Matrix p9_m2 = p9_m1.makeMinor(1, 1);
		System.out.println("Matrix1�� Minor(1�� 1�� ����)(0��,0�� ���� �ִٰ� �� ��) : "+ p9_m2);
		System.out.println();
		System.out.println("38��>>");
		System.out.println("Matrix1 :"+p9_m1);
		p9_m2 = p9_m1.transpose();
		System.out.println("Matrix1 �� Transpose() : " + p9_m2);
		System.out.println();
		System.out.println("39��>>");
		p9_m2 = Factory.makeIdentityMatrix(3);
		System.out.println("Matrix1 :"+p9_m1);
		System.out.println("Matrix2 : " + p9_m2);
		System.out.print("Matrix1 �� �밢 ����� ��(nxn����� �ƴ� ���) : ");
		Scalar p9_s1 = p9_m1.trace();
		System.out.print("Matrix2 �� �밢 ����� �� : ");
		p9_s1 = p9_m2.trace();
		System.out.println(p9_s1);
		p9_arr = null;
		p9_s1 = null; p9_m1=p9_m2=null;
		System.out.println();
		
		//40~44�� phase10
		double[][] p0_arr1 = {{1.0,1.0,1.0},{0.0,1.0,1.0},{0.0,0.0,1.0}};
		double[][] p0_arr2 = {{1.0,0.0,0.0},{1.0,1.0,0.0},{1.0,1.0,1.0}};
		double[][] p0_arr3 = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0},{3.0,1.0,2.0}};
		Matrix p0_m1 = Factory.makeMatrix(p0_arr1);
		Matrix p0_m2 = Factory.makeMatrix(p0_arr2);
		Matrix p0_m3 = Factory.makeMatrix(p0_arr3);
		System.out.println("40��>>");
		System.out.println("Matrix1 : "+ p0_m1);
		System.out.println("Matrix3 : "+ p0_m3);
		System.out.println("Matrix1 ���簢 ������� ���� �Ǻ�(�´ٸ� true) : "+p0_m1.distinguishSquareMatrix());
		System.out.println("Matrix3 ���簢 ������� ���� �Ǻ�(�´ٸ� true) : "+p0_m3.distinguishSquareMatrix());
		System.out.println();
		System.out.println("41��>>");
		System.out.println("Matrix1 : "+ p0_m1);
		System.out.println("Matrix2 : "+ p0_m2);
		System.out.println("Matrix3 : "+ p0_m3);
		System.out.println("Matrix1 ��ﰢ ������� ���θ� �Ǻ� (�´ٸ� true) : "+ p0_m1.distinguishUpperTriangularMatrix());
		System.out.println("Matrix2 ��ﰢ ������� ���θ� �Ǻ� (�´ٸ� true) : "+ p0_m2.distinguishUpperTriangularMatrix());
		System.out.print("Matrix3 ��ﰢ ������� ���θ� �Ǻ�(nxn�� �ƴѰ��) :");
		p0_m3.distinguishUpperTriangularMatrix();
		System.out.println();
		System.out.println("42��>>");
		System.out.println("Matrix1 : "+ p0_m1);
		System.out.println("Matrix2 : "+ p0_m2);
		System.out.println("Matrix3 : "+ p0_m3);
		System.out.println("Matrix1 �ϻﰢ ������� ���θ� �Ǻ� (�´ٸ� true) : "+ p0_m1.distinguishLowerTriangularMatrix());
		System.out.println("Matrix2 �ϻﰢ ������� ���θ� �Ǻ� (�´ٸ� true) : "+ p0_m2.distinguishLowerTriangularMatrix());
		System.out.print("Matrix3 �ϻﰢ ������� ���θ� �Ǻ�(nxn�� �ƴѰ��) :");
		p0_m3.distinguishLowerTriangularMatrix();
		System.out.println();
		System.out.println("43��>>");
		p0_m1 = Factory.makeIdentityMatrix(3);
		p0_m2 = Factory.makeMatrix(0.0, 3, 3);
		System.out.println("Matrix1 : "+ p0_m1);
		System.out.println("Matrix2 : "+ p0_m2);
		System.out.println("Matrix3 : "+ p0_m3);
		System.out.println("Matrix1 ���� ������� ���θ� �Ǻ� (�´ٸ� true) : "+ p0_m1.distinguishIdentityMatrix());
		System.out.println("Matrix2 ���� ������� ���θ� �Ǻ� (�´ٸ� true) : "+ p0_m2.distinguishIdentityMatrix());
		System.out.print("Matrix3 ���� ������� ���θ� �Ǻ�(nxn�� �ƴѰ��) :");
		p0_m3.distinguishIdentityMatrix();
		System.out.println();
		System.out.println("44��>>");
		System.out.println("Matrix1 : "+ p0_m1);
		System.out.println("Matrix2 : "+ p0_m2);
		System.out.println("Matrix3 : "+ p0_m3);
		System.out.println("Matrix1 �� ������� ���θ� �Ǻ� (�´ٸ� true) : "+ p0_m1.distinguishNullMatrix());
		System.out.println("Matrix2 ���� ������� ���θ� �Ǻ� (�´ٸ� true) : "+ p0_m2.distinguishNullMatrix());
		System.out.print("Matrix3 ���� ������� ���θ� �Ǻ�(�´ٸ� true) :" + p0_m3.distinguishNullMatrix());
		System.out.println();
		System.out.println();
		p0_m1 = p0_m2 = p0_m3 = null;
		p0_arr1=p0_arr2=p0_arr3=null;
		
		//45�� ~ 50�� phase11
		double[][] p11_arr1 = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0}};
		Matrix p11_m1 = Factory.makeMatrix(p11_arr1);
		System.out.println("45��>>");
		System.out.println("Matrix1 : " + p11_m1);
		p11_m1.changeRow(0, 1);
		System.out.println("Matrix1 0��� 1�� ��ġ �±�ȯ : "+ p11_m1);
		System.out.println();
		System.out.println("46��>>");
		System.out.println("Matrix1 : " + p11_m1);
		p11_m1.changeCol(0, 1);
		System.out.println("Matrix1 0���� 1�� ��ġ �±�ȯ : "+ p11_m1);
		System.out.println();
		System.out.println("47��>>");
		Matrix p11_m2 = Factory.makeMatrix(1.0, 3, 3);
		System.out.println("Matrix1 : " + p11_m2);
		Scalar p11_s1 = Factory.makeScalar(2.0);
		p11_m2.mulScalarToRow(0, p11_s1);
		System.out.println("Matrix1 0�࿡ 2�� : " + p11_m2);
		System.out.println();
		System.out.println("48��>>");
		p11_m2 = Factory.makeMatrix(1.0, 3, 3);
		System.out.println("Matrix1 : " + p11_m2);
		p11_s1 = Factory.makeScalar(2.0);
		p11_m2.mulScalarToCol(0, p11_s1);
		System.out.println("Matrix1 0���� 2�� : " + p11_m2);
		System.out.println();
		System.out.println("49��>>");
		p11_m1 = Factory.makeMatrix(p11_arr1);
		p11_m2 = Factory.makeMatrix(0.0, 3, 3);
		System.out.println("Matrix1 : "+ p11_m1);
		System.out.println("Matrix2 : "+ p11_m2);
		p11_m2.addCertainRowToMine(0, 0, p11_m1, p11_s1);
		System.out.println("Matrix2�� Matrix1�� 0�� 2���� �� ���ϱ� : "+p11_m2);
		System.out.println();
		System.out.println("50��>>");
		p11_m2 = Factory.makeMatrix(0.0, 3, 3);
		System.out.println("Matrix1 : "+ p11_m1);
		System.out.println("Matrix2 : "+ p11_m2);
		p11_m2.addCertainColToMine(0, 0, p11_m1, p11_s1);
		System.out.println("Matrix2�� Matrix1�� 0�� 2���� �� ���ϱ� : "+p11_m2);
		System.out.println();
		p11_m1=p11_m2=null;p11_arr1=null;p11_s1=null;		
		
		//51�� ~ 54�� phase12
		double[][] p12_arr1 = {{2.0,1.0,1.0,7.0},{1.0,-2.0,-7.0,-4.0},{4.0,3.0,5.0,17.0}};
		double[][] p12_arr2 = {{1.0,2.0,3.0},{4.0,5.0,6.0},{3.0,2.0,4.0}};
		double[][] p12_arr5 = {{1.0,0.0,1.0},{3.0,1.0,2.0},{3.0,1.0,2.0},{2.0,0.0,1.0}};
		double[][] p12_arr6 = {{0.0,0.0,0.0,1.0},{0.0,0.0,1.0,1.0},{0.0,1.0,1.0,1.0},{1.0,1.0,1.0,1.0}};
		Matrix p12_m1 = Factory.makeMatrix(p12_arr1);
		Matrix p12_m2 = Factory.makeMatrix(p12_arr2);
		Matrix p12_m3 = Factory.makeMatrix(p12_arr5);
		Matrix p12_m4 = Factory.makeMatrix(p12_arr6);
		System.out.println("51��>>");
		System.out.println("Matrix1 : "+ p12_m1);
		System.out.println("Matrix1�� RREF���ϱ� : " + p12_m1.makeRREFMatrix());
		System.out.println("Matrix2 : " + p12_m2);
		System.out.println("Matrix2�� RREF���ϱ� : " + p12_m2.makeRREFMatrix());
		System.out.println("Matrix3 : " + p12_m3);
		System.out.println("Matrix3�� RREF���ϱ� : " + p12_m3.makeRREFMatrix());
		System.out.println("Matrix4 : " + p12_m4);
		System.out.println("Matrix4�� RREF���ϱ� : " + p12_m4.makeRREFMatrix());
		System.out.println();
		
		System.out.println("52��>>");
		System.out.println("Matrix1 : " + p12_m2);
		System.out.println("Matrix1 RREF ������� ���θ� �Ǻ� : " + p12_m2.distinguishRREF());
		p12_m3 = p12_m2.makeRREFMatrix();
		System.out.println("Matrix1�� RREF���ϱ� : " + p12_m3);
		System.out.println("Matrix1�� RREF�� RREF������� ���θ� �Ǻ�  : "+ p12_m3.distinguishRREF());
		System.out.println();
		
		System.out.println("53��>>");
		double[][] p12_arr3 = {{-2.0,-3.0,2.0},{3.0,5.0,-4.0},{1.0,2.0,-1.0}};
		double[][] p12_arr4 = {{1.0,2.0,3.0},{1.0,2.0,3.0},{1.0,2.0,-1.0}};
		p12_m2 = Factory.makeMatrix(p12_arr3);
		p12_m3 = Factory.makeMatrix(p12_arr4);
		System.out.println("Matrix1 : " + p12_m2);
		System.out.println("Matrix2 : " + p12_m3);
		System.out.println("Matrix3 : " + p12_m1);
		System.out.println("Matrix1�� ��Ľ� ���ϱ� : "+ p12_m2.determinant());
		System.out.println("Matrix2�� ��Ľ� ���ϱ� : " +p12_m3.determinant());
		System.out.print("Matrix3�� ��Ľ� ���ϱ� : ");
		p12_m1.determinant();
		System.out.println();
		
		System.out.println("54��>>");
		System.out.println("Matrix1 : " + p12_m2);
		System.out.println("Matrix2 : " + p12_m3);
		System.out.println("Matrix3 : " + p12_m1);
		p12_m4 = p12_m2.makeInverse();
		System.out.println("Matrix1�� ����� ���ϱ� : "+ p12_m4);
		System.out.println("Matrix1�� ������� �� " + Tensors.mulTwoMatrix(p12_m2, p12_m4));
		System.out.print("Matrix2�� ����� ���ϱ�(������� �������� �������) : ");
		p12_m3.makeInverse();
		System.out.print("Matrix3�� ����� ���ϱ�(��������� �ƴ� ���) : ");
		p12_m1.makeInverse();
	}
}