package test;

import tensor.Scalar;
import tensor.Vector;
import tensor.Matrix;
import tensor.Tensors;
import tensor.Factory;


public class Test {
	public static void main(String[] args) {
		//1,2번 시작 -phase 1
		System.out.println("1번>> 값을 지정하여 스칼라 생성 후 출력(1.0으로 지정)");
		Scalar p1_s1 = Factory.makeScalar(1.0);//오토 박싱 진행
		System.out.println(p1_s1);
		System.out.println();
		System.out.println("2번>> 0.0이상 2.0미만의 무작위 값을 요소로 하는 스칼라 값 생성");
		Scalar p1_s2 = Factory.makeScalar(0.0, 2.0);//오토 박싱 진행
		System.out.println(p1_s2);
		p1_s1=p1_s2=null;//메모리 위해
		System.out.println();
		
		//3,4,5번 시작 - phase 2
		System.out.println("3번>> 1.0 스칼라 값을 갖는 3차원 벡터 생성");
		Vector p2_v1 = Factory.makeVector(1.0, 3);//오토 박식 진행
		System.out.println(p2_v1);
		System.out.println();
		System.out.println("4번>> 0.0 이상 2.0미만의 무작위 값을 요소로 하는 3차원 벡터 생성");
		Vector p2_v2 = Factory.makeVector(0.0, 2.0, 3);
		System.out.println(p2_v2);
		System.out.println();
		System.out.println("5번>> 1차원 배열로 부터 n차원 벡터 생성");
		double[] p2_arr = {0.0,0.1,0.3};
		Vector p2_v3 = Factory.makeVector(p2_arr);
		System.out.println(p2_v3);
		p2_v1=p2_v2=p2_v3=null;
		p2_arr = null;
		
		//6~10번 시작 - phase 3
		System.out.println("6번>>  하나의 값을 모든 요소의 값으로 하는 m x n 행렬을 생성(0.0으로 지정)");
		Matrix p3_m1 = Factory.makeMatrix(0.0, 2, 2);//오토 박싱 진행
		System.out.println(p3_m1);
		System.out.println();
		System.out.println("7번>> 0.0 이상 2.0 미만의 무작위 값을 요소로 하는 mxn 행렬을 생성");
		Matrix p3_m2 = Factory.makeMatrix(0.0, 2.0, 2, 2);
		System.out.println(p3_m2);
		System.out.println();
		System.out.println("8번>> csv파일로 부터 mxn 행렬을  생성");
		System.out.print("파일이 존재 하지 않을 때>>");
		Matrix p3_m3 = Factory.makeMatrix("");
		System.out.println("Matrix :"+p3_m3);
		System.out.print("파일이 존재 할 때>>");
		p3_m3 = Factory.makeMatrix("D:\\연습장\\prc.csv");
		System.out.println("Matrix :"+p3_m3);
		System.out.println();
		System.out.println("9번>>2차원 배열로 부터 mxn 행렬을 생성");
		double[][] p3_arr = {{0.0,0.1},{0.2,0.3}};
		Matrix p3_m4 = Factory.makeMatrix(p3_arr);
		System.out.println(p3_m4);
		System.out.println();
		System.out.println("10번>>단위 행렬 생성");
		Matrix p3_m5 = Factory.makeIdentityMatrix(2);
		System.out.println(p3_m5);
		p3_m1=p3_m2=p3_m3=p3_m4=p3_m5=null;p3_arr = null;
		
		//11번 ~ 17번 시작 - phase 4
		System.out.println();
		System.out.println("11번>>벡터,행렬 특정 위치의 요소를 지정/조회");
		System.out.println("벡터, 행렬 변경 전 출력");
		Vector p4_v1 = Factory.makeVector(0.1, 3);
		Matrix p4_m1 = Factory.makeMatrix(0.1, 2, 2);
		System.out.print("Vector 1: "+p4_v1+"\t");
		System.out.println("Matrix 1 : "+p4_m1);
		System.out.println("벡터 특정 위치의 요소 지정(Vector1 : 두 번째 , Matrix : (1,1) IDX 변경) 100.0 넣기");
		Scalar p4_s1 = Factory.makeScalar(100.0);//오토박싱 진행
		p4_v1.set(p4_s1, 1);
		p4_m1.set(p4_s1, 1, 1);
		System.out.print(p4_v1+"\t");
		System.out.println(p4_m1);
		System.out.println("벡터, 행렬 특정 위치의 조회(Vector : 1 IDX, Matrix : (1,1) IDX)");
		System.out.print(p4_v1.get(1)+"\t");
		System.out.println(p4_m1.get(1, 1));
		System.out.println();
		
		System.out.println("12번>> 스칼라 값 지정/조회");
		System.out.print("스칼라 값 조회 : ");
		System.out.println(p4_s1);
		System.out.print("스칼라 값 지정 (10.0 넣기) : ");
		p4_s1.set(10.0);//오토방식 진행
		System.out.println(p4_s1);
		System.out.println();
		
		System.out.println("13번>> 벡터,행렬 크기 정보를 조회(11번 벡터,행렬 사용)");
		System.out.println("벡터의 크기 : "+p4_v1.length());
		System.out.println("행 : "+p4_m1.rows()+" 열 :"+p4_m1.cols());
		System.out.println();
		
		System.out.println("14번>>스칼라 값, 벡터 값, 행렬 값 콘솔 출력");
		Scalar p4_s2 = Factory.makeScalar(1.0);
		Vector p4_v2 = Factory.makeVector(1.0, 4);
		Matrix p4_m2 = Factory.makeMatrix(1.0, 2, 3);
		System.out.println("1)스칼라 값 출력 : "+p4_s2);
		System.out.println("2)벡터 값 출력 : " + p4_v2);
		System.out.println("3)행렬 값 출력 : " + p4_m2);
		System.out.println();
		System.out.println("15번>>객체의 동등성 판단 (값이 같다면 true,다르면 false)");
		System.out.println("1)스칼라 비교");
		p4_s1.set(1.0); p4_s2.set(1.0);
		System.out.print("Sclar 1 : " + p4_s1 + "\t");
		System.out.println("Sclar 2 : " + p4_s2);
		System.out.println("두 스칼라 값이 같다면 true, 그렇지 않다면 false : "+p4_s1.equals(p4_s2));
		System.out.println("2)벡터 비교");
		Vector p4_v3 = Factory.makeVector(1.0, 4);
		Vector p4_v4 = Factory.makeVector(2.0, 4);
		System.out.print("Vector 1 : " + p4_v1 + "\t");
		System.out.print("Vector 2 : " + p4_v2 + "\t");
		System.out.print("Vector 3 : " + p4_v3 + "\t");
		System.out.println("Vector 4 : " + p4_v4);
		System.out.print("Vector1, Vector2 비교(크기가 다른 벡터 비교): ");
		System.out.println(p4_v1.equals(p4_v2));
		System.out.println("Vector2, Vector 3 비교 : "+p4_v2.equals(p4_v3));
		System.out.println("Vector 2, Vector 4 비교 : "+p4_v2.equals(p4_v4));
		System.out.println("3)행렬 비교");
		p4_m1 = Factory.makeMatrix(1.0, 2, 2);
		p4_m2 = Factory.makeMatrix(1.0, 2, 2);
		Matrix p4_m3 = Factory.makeMatrix(2.0, 2, 2);
		Matrix p4_m4 = Factory.makeMatrix(1.0, 3, 3);
		System.out.println("Matrix 1 : " + p4_m1 + "\t"+"Matrix 2 : " + p4_m2 + "\t"+"Matrix 3 : " + p4_m3 + "\t"+"Matrix 4 : " + p4_m4);
		System.out.println("Matrix 1, Matrix2 비교 : "+p4_m1.equals(p4_m2));
		System.out.println("Matrix 1, Matrix3 비교 : "+p4_m1.equals(p4_m3));
		System.out.print("Matrix 1, Matrix4 비교(크기가 다른 행렬 비교) : ");
		System.out.println(p4_m1.equals(p4_m4));
		System.out.println();
		System.out.println("16번>>");
		p4_s1 = Factory.makeScalar(1.0); p4_s2 = Factory.makeScalar(2.0); Scalar p4_s3 = Factory.makeScalar(1.0);
		System.out.println("Scalar 1 : "+ p4_s1 +"\t"+"Scalar 2 : "+ p4_s2+"\t"+"Scalar 3 : "+ p4_s3);
		System.out.println("스칼라 대소 비교(앞에 있는 스칼라가 크면 1, 같으면 0, 작으면 -1) : ");
		System.out.println("Scalar 1, Scalar 2 비교 : "+p4_s1.compareTo(p4_s2));
		System.out.println("Scalar 1, Scalar 3 비교  : "+p4_s1.compareTo(p4_s3));
		System.out.println("Scalar 2, Scalar 3 비교 : "+p4_s2.compareTo(p4_s3));
		System.out.println();
		System.out.println("17번>>");
		try {
		System.out.println("Scalar 원본 : "+p4_s1);
		System.out.println("Scalar 사본 : " + p4_s1.clone());
		System.out.println("Vector 원본 : " + p4_v2);
		System.out.println("Vector 사본 : " + p4_v2.clone());
		System.out.println("Matrix 원본 : " + p4_m1);
		System.out.println("Matrix 사본 : " + p4_m1.clone());
		System.out.println();
		}
		catch(CloneNotSupportedException e) {
			System.out.println("복사 실패");
		}
		System.out.println();
		p4_s1= p4_s2=p4_s3=null;p4_v1=p4_v2=p4_v3=p4_v4=null;p4_m1=p4_m2=p4_m3=p4_m4=null;
		
		//18~23번 - phase5
		System.out.println("18번>>");
		Scalar p5_s1 = Factory.makeScalar(1.0);
		Scalar p5_s2 = Factory.makeScalar(2.0);
		System.out.println("Scalar1 : "+p5_s1);
		System.out.println("Scalar2 : "+p5_s2);
		p5_s1.addToMine(p5_s2);
		System.out.println("Scalar1.add(Scalar2) = " + p5_s1);
		System.out.println();
		System.out.println("19번>>");
		System.out.println("Scalar1 : "+p5_s1);
		System.out.println("Scalar 2 : "+p5_s2);
		p5_s1.mulToMine(p5_s2);
		System.out.println("Scalar1.mul(Scalar2) = " + p5_s1);
		System.out.println();
		System.out.println("20번>>");
		Vector p5_v1 = Factory.makeVector(1.0,3);
		Vector p5_v2 = Factory.makeVector(2.0,3);
		Vector p5_v3 = Factory.makeVector(1.0,4);
		System.out.println("Vector 1 : "+p5_v1);
		System.out.println("Vector 2 : "+p5_v2);
		System.out.println("Vector 3 : "+p5_v3);
		System.out.print("Vector1.add(Vector3) - 길이가 다른 벡터 덧셈 : ");
		p5_v1.addToMine(p5_v3);
		System.out.println("Vector1 : " + p5_v1+" -> 벡터 값 변화 x");
		p5_v1.addToMine(p5_v2);
		System.out.println("Vector1.add(Vector2) - 길이가 같은 벡터 덧셈 : "+p5_v1);
		System.out.println();
		System.out.println("21번>>");
		System.out.println("Scalar1 : "+p5_s1);
		System.out.println("Vector1 : "+p5_v1);
		p5_v1.multToMine(p5_s1);
		System.out.println("Vector1.mul(Scalar1) : "+p5_v1);
		System.out.println();
		System.out.println("22번>>");
		Matrix p5_m1 = Factory.makeMatrix(1.0, 2, 2);
		Matrix p5_m2 = Factory.makeMatrix(2.0, 2, 2);
		Matrix p5_m3 = Factory.makeMatrix(2.0, 2, 3);
		System.out.println("Matrix1 : "+p5_m1);
		System.out.println("Matrix2 : "+p5_m2);
		System.out.println("Matrix3 : "+p5_m3);
		System.out.print("Matrix1.add(Matrix 3) - 크기가 다른 행렬 덧셈 : ");
		p5_m1.addToMine(p5_m3);
		System.out.println("Matrix1 : " + p5_m1+" -> 행렬 값 변화 x");
		p5_m1.addToMine(p5_m2);
		System.out.println("Matrix1.add(Matrix2) - 크기가 같은 행렬 덧셈 : "+p5_m1);
		System.out.println();
		System.out.println("23번>>");
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
		System.out.println("Matrix1.mul(Matrix2) 왼쪽 행렬로서 : "+ p5_m1);
		p5_m2.multToMineAsRight(p5_m3);
		System.out.println("Matrix2.mul(Matrix2) 오른쪽 행렬로서 :"+ p5_m2);
		p5_arr1=p5_arr2=p5_arr3 =null;
		p5_m1=p5_m2=p5_m3 = null;p5_v1=p5_v2=p5_v3=null;p5_s1=p5_s2=null;
		System.out.println();
		
		//24~29번 phase6
		System.out.println("24, 25번>>");
		Scalar p6_s1 = Factory.makeScalar(2.0);
		Scalar p6_s2 = Factory.makeScalar(3.0);
		Scalar p6_s3 = Tensors.addTwoScalar(p6_s1,p6_s2);
		Scalar p6_s4 = Tensors.mulTwoScalar(p6_s1, p6_s2);
		System.out.println("Scalar 1 : "+p6_s1);
		System.out.println("Scalar 2 : "+p6_s2);
		System.out.println("Scalar 1 + Scalar 2 = "+p6_s3);
		System.out.println("Scalar 1 x Scalar 2 = "+p6_s4);
		System.out.println();
		System.out.println("26, 27번>>");
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
		System.out.print("Vector1 + Vector3(길이가 다른 벡터의 덧셈) : ");
		p6_v4 = Tensors.addTwoVector(p6_v1, p6_v3);
		System.out.println();
		
		System.out.println("28, 29번>>");
		Matrix p6_m1 = Factory.makeMatrix(1.0, 2, 2);
		Matrix p6_m2 = Factory.makeMatrix(2.0,2,2);
		Matrix p6_m3 = Factory.makeMatrix(3.0, 2, 3);
		Matrix p6_m4 = Tensors.addTwoMatrix(p6_m1, p6_m2);
		Matrix p6_m5 = Tensors.mulTwoMatrix(p6_m1, p6_m3);
		System.out.println("Matrix1 : "+p6_m1);
		System.out.println("Matrix2 : "+p6_m2);
		System.out.println("Matrix3 : "+p6_m3);
		System.out.println("Matrix 1 + Matrix 2 = "+p6_m4);
		System.out.print("Matrix 1 + Matrix 3 (크기 다른 행렬의 덧셈) = ");
		p6_m4 = Tensors.addTwoMatrix(p6_m1, p6_m3);
		System.out.println("Matrix 1 x Matrix 3 = "+p6_m5);
		System.out.print("Matrix 3 x Matrix 1 = ");
		p6_m5 = Tensors.mulTwoMatrix(p6_m3, p6_m1);
		System.out.println();
		p6_m1=p6_m2=p6_m3=p6_m4=p6_m5=null;
		p6_v1=p6_v2=p6_v3=p6_v4=p6_v5=null;
		p6_s1=p6_s2=p6_s3=p6_s4=null;
		
		//30~31번 phase7
		System.out.println("30번,31번>>");
		Vector p7_v1 = Factory.makeVector(1.0, 3);
		Matrix p7_m1 = p7_v1.makeVectorToMatrixAsCol();
		Matrix p7_m2 = p7_v1.makeVectorToMatrixAsRow();
		System.out.println("Vector 1 : " + p7_v1);
		System.out.println("Vector 1으로부터  3x1 행렬 생성 : "+ p7_m1);
		System.out.println("Vector 1으로부터 1x3 행렬 생성"+p7_m2);
		System.out.println();
		p7_v1=null;p7_m1=p7_m2=null;
		
		//32~36번phase8
		System.out.println("32번,33번>>");
		Matrix p8_m1 = Factory.makeMatrix(2.0, 2, 2);
		Matrix p8_m2 = Factory.makeIdentityMatrix(2);
		Matrix p8_m3 = Tensors.combineMatrixWithRow(p8_m1, p8_m2);
		Matrix p8_m4 = Tensors.combineMatrixWithCol(p8_m1, p8_m2);
		System.out.println("Matrix 1 : " + p8_m1);
		System.out.println("Matrix 2 : " + p8_m2);
		System.out.println("Matrix 1, Matrix 2 가로로 합치기 : "+p8_m3);
		System.out.println("Matrix 1, Matrix 2 세로로 합치기 : "+p8_m4);
		System.out.println();
		
		System.out.println("34번,35번>>");
		double[][] p8_arr = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0},{10.0,11.0,12.0}};
		p8_m3 = Factory.makeMatrix(p8_arr);
		p8_arr = null;
		System.out.println("Matrix 1 : " + p8_m3);
		Vector p8_v1 = p8_m3.getRowVector(1);
		Vector p8_v2 = p8_m3.getColVector(1);
		System.out.println("특정 행을 벡터 형태로 추출(두 번째 행) : "+p8_v1);
		System.out.println("특정 열을 벡터 형태로 추출(두 번쨰 열) : "+p8_v2);
		System.out.println();
		
		System.out.println("36번>>");
		p8_m1 = p8_m3.subtractMatrixPart(0, 2, 0, 1);
		System.out.println("Matrix : " + p8_m3);
		System.out.println("Matrix의 0행부터 2행, 0열부터 1열 추출 : "+p8_m1);
		p8_m1=p8_m2=p8_m3=p8_m4=null;
		p8_v1=p8_v2=null;
		System.out.println();
		
		//37번~39번 phase9
		System.out.println("37번>>");
		double[][] p9_arr = {{1,2,3,4},{5,6,7,8},{9,3,4,1}};
		Matrix p9_m1 = Factory.makeMatrix(p9_arr);
		System.out.println("Matrix1 : "+p9_m1);
		Matrix p9_m2 = p9_m1.makeMinor(1, 1);
		System.out.println("Matrix1의 Minor(1행 1열 제외)(0행,0열 부터 있다고 할 때) : "+ p9_m2);
		System.out.println();
		System.out.println("38번>>");
		System.out.println("Matrix1 :"+p9_m1);
		p9_m2 = p9_m1.transpose();
		System.out.println("Matrix1 의 Transpose() : " + p9_m2);
		System.out.println();
		System.out.println("39번>>");
		p9_m2 = Factory.makeIdentityMatrix(3);
		System.out.println("Matrix1 :"+p9_m1);
		System.out.println("Matrix2 : " + p9_m2);
		System.out.print("Matrix1 의 대각 요소의 합(nxn행렬이 아닌 경우) : ");
		Scalar p9_s1 = p9_m1.trace();
		System.out.print("Matrix2 의 대각 요소의 합 : ");
		p9_s1 = p9_m2.trace();
		System.out.println(p9_s1);
		p9_arr = null;
		p9_s1 = null; p9_m1=p9_m2=null;
		System.out.println();
		
		//40~44번 phase10
		double[][] p0_arr1 = {{1.0,1.0,1.0},{0.0,1.0,1.0},{0.0,0.0,1.0}};
		double[][] p0_arr2 = {{1.0,0.0,0.0},{1.0,1.0,0.0},{1.0,1.0,1.0}};
		double[][] p0_arr3 = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0},{3.0,1.0,2.0}};
		Matrix p0_m1 = Factory.makeMatrix(p0_arr1);
		Matrix p0_m2 = Factory.makeMatrix(p0_arr2);
		Matrix p0_m3 = Factory.makeMatrix(p0_arr3);
		System.out.println("40번>>");
		System.out.println("Matrix1 : "+ p0_m1);
		System.out.println("Matrix3 : "+ p0_m3);
		System.out.println("Matrix1 정사각 행렬인지 여부 판별(맞다면 true) : "+p0_m1.distinguishSquareMatrix());
		System.out.println("Matrix3 정사각 행렬인지 여부 판별(맞다면 true) : "+p0_m3.distinguishSquareMatrix());
		System.out.println();
		System.out.println("41번>>");
		System.out.println("Matrix1 : "+ p0_m1);
		System.out.println("Matrix2 : "+ p0_m2);
		System.out.println("Matrix3 : "+ p0_m3);
		System.out.println("Matrix1 상삼각 행렬인지 여부를 판별 (맞다면 true) : "+ p0_m1.distinguishUpperTriangularMatrix());
		System.out.println("Matrix2 상삼각 행렬인지 여부를 판별 (맞다면 true) : "+ p0_m2.distinguishUpperTriangularMatrix());
		System.out.print("Matrix3 상삼각 행렬인지 여부를 판별(nxn이 아닌경우) :");
		p0_m3.distinguishUpperTriangularMatrix();
		System.out.println();
		System.out.println("42번>>");
		System.out.println("Matrix1 : "+ p0_m1);
		System.out.println("Matrix2 : "+ p0_m2);
		System.out.println("Matrix3 : "+ p0_m3);
		System.out.println("Matrix1 하삼각 행렬인지 여부를 판별 (맞다면 true) : "+ p0_m1.distinguishLowerTriangularMatrix());
		System.out.println("Matrix2 하삼각 행렬인지 여부를 판별 (맞다면 true) : "+ p0_m2.distinguishLowerTriangularMatrix());
		System.out.print("Matrix3 하삼각 행렬인지 여부를 판별(nxn이 아닌경우) :");
		p0_m3.distinguishLowerTriangularMatrix();
		System.out.println();
		System.out.println("43번>>");
		p0_m1 = Factory.makeIdentityMatrix(3);
		p0_m2 = Factory.makeMatrix(0.0, 3, 3);
		System.out.println("Matrix1 : "+ p0_m1);
		System.out.println("Matrix2 : "+ p0_m2);
		System.out.println("Matrix3 : "+ p0_m3);
		System.out.println("Matrix1 단위 행렬인지 여부를 판별 (맞다면 true) : "+ p0_m1.distinguishIdentityMatrix());
		System.out.println("Matrix2 단위 행렬인지 여부를 판별 (맞다면 true) : "+ p0_m2.distinguishIdentityMatrix());
		System.out.print("Matrix3 단위 행렬인지 여부를 판별(nxn이 아닌경우) :");
		p0_m3.distinguishIdentityMatrix();
		System.out.println();
		System.out.println("44번>>");
		System.out.println("Matrix1 : "+ p0_m1);
		System.out.println("Matrix2 : "+ p0_m2);
		System.out.println("Matrix3 : "+ p0_m3);
		System.out.println("Matrix1 영 행렬인지 여부를 판별 (맞다면 true) : "+ p0_m1.distinguishNullMatrix());
		System.out.println("Matrix2 단위 행렬인지 여부를 판별 (맞다면 true) : "+ p0_m2.distinguishNullMatrix());
		System.out.print("Matrix3 단위 행렬인지 여부를 판별(맞다면 true) :" + p0_m3.distinguishNullMatrix());
		System.out.println();
		System.out.println();
		p0_m1 = p0_m2 = p0_m3 = null;
		p0_arr1=p0_arr2=p0_arr3=null;
		
		//45번 ~ 50번 phase11
		double[][] p11_arr1 = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0}};
		Matrix p11_m1 = Factory.makeMatrix(p11_arr1);
		System.out.println("45번>>");
		System.out.println("Matrix1 : " + p11_m1);
		p11_m1.changeRow(0, 1);
		System.out.println("Matrix1 0행과 1행 위치 맞교환 : "+ p11_m1);
		System.out.println();
		System.out.println("46번>>");
		System.out.println("Matrix1 : " + p11_m1);
		p11_m1.changeCol(0, 1);
		System.out.println("Matrix1 0열과 1열 위치 맞교환 : "+ p11_m1);
		System.out.println();
		System.out.println("47번>>");
		Matrix p11_m2 = Factory.makeMatrix(1.0, 3, 3);
		System.out.println("Matrix1 : " + p11_m2);
		Scalar p11_s1 = Factory.makeScalar(2.0);
		p11_m2.mulScalarToRow(0, p11_s1);
		System.out.println("Matrix1 0행에 2배 : " + p11_m2);
		System.out.println();
		System.out.println("48번>>");
		p11_m2 = Factory.makeMatrix(1.0, 3, 3);
		System.out.println("Matrix1 : " + p11_m2);
		p11_s1 = Factory.makeScalar(2.0);
		p11_m2.mulScalarToCol(0, p11_s1);
		System.out.println("Matrix1 0열에 2배 : " + p11_m2);
		System.out.println();
		System.out.println("49번>>");
		p11_m1 = Factory.makeMatrix(p11_arr1);
		p11_m2 = Factory.makeMatrix(0.0, 3, 3);
		System.out.println("Matrix1 : "+ p11_m1);
		System.out.println("Matrix2 : "+ p11_m2);
		p11_m2.addCertainRowToMine(0, 0, p11_m1, p11_s1);
		System.out.println("Matrix2에 Matrix1의 0행 2배한 것 더하기 : "+p11_m2);
		System.out.println();
		System.out.println("50번>>");
		p11_m2 = Factory.makeMatrix(0.0, 3, 3);
		System.out.println("Matrix1 : "+ p11_m1);
		System.out.println("Matrix2 : "+ p11_m2);
		p11_m2.addCertainColToMine(0, 0, p11_m1, p11_s1);
		System.out.println("Matrix2에 Matrix1의 0열 2배한 것 더하기 : "+p11_m2);
		System.out.println();
		p11_m1=p11_m2=null;p11_arr1=null;p11_s1=null;		
		
		//51번 ~ 54번 phase12
		double[][] p12_arr1 = {{2.0,1.0,1.0,7.0},{1.0,-2.0,-7.0,-4.0},{4.0,3.0,5.0,17.0}};
		double[][] p12_arr2 = {{1.0,2.0,3.0},{4.0,5.0,6.0},{3.0,2.0,4.0}};
		double[][] p12_arr5 = {{1.0,0.0,1.0},{3.0,1.0,2.0},{3.0,1.0,2.0},{2.0,0.0,1.0}};
		double[][] p12_arr6 = {{0.0,0.0,0.0,1.0},{0.0,0.0,1.0,1.0},{0.0,1.0,1.0,1.0},{1.0,1.0,1.0,1.0}};
		Matrix p12_m1 = Factory.makeMatrix(p12_arr1);
		Matrix p12_m2 = Factory.makeMatrix(p12_arr2);
		Matrix p12_m3 = Factory.makeMatrix(p12_arr5);
		Matrix p12_m4 = Factory.makeMatrix(p12_arr6);
		System.out.println("51번>>");
		System.out.println("Matrix1 : "+ p12_m1);
		System.out.println("Matrix1의 RREF구하기 : " + p12_m1.makeRREFMatrix());
		System.out.println("Matrix2 : " + p12_m2);
		System.out.println("Matrix2의 RREF구하기 : " + p12_m2.makeRREFMatrix());
		System.out.println("Matrix3 : " + p12_m3);
		System.out.println("Matrix3의 RREF구하기 : " + p12_m3.makeRREFMatrix());
		System.out.println("Matrix4 : " + p12_m4);
		System.out.println("Matrix4의 RREF구하기 : " + p12_m4.makeRREFMatrix());
		System.out.println();
		
		System.out.println("52번>>");
		System.out.println("Matrix1 : " + p12_m2);
		System.out.println("Matrix1 RREF 행렬인지 여부를 판별 : " + p12_m2.distinguishRREF());
		p12_m3 = p12_m2.makeRREFMatrix();
		System.out.println("Matrix1의 RREF구하기 : " + p12_m3);
		System.out.println("Matrix1의 RREF가 RREF행렬인지 여부를 판별  : "+ p12_m3.distinguishRREF());
		System.out.println();
		
		System.out.println("53번>>");
		double[][] p12_arr3 = {{-2.0,-3.0,2.0},{3.0,5.0,-4.0},{1.0,2.0,-1.0}};
		double[][] p12_arr4 = {{1.0,2.0,3.0},{1.0,2.0,3.0},{1.0,2.0,-1.0}};
		p12_m2 = Factory.makeMatrix(p12_arr3);
		p12_m3 = Factory.makeMatrix(p12_arr4);
		System.out.println("Matrix1 : " + p12_m2);
		System.out.println("Matrix2 : " + p12_m3);
		System.out.println("Matrix3 : " + p12_m1);
		System.out.println("Matrix1의 행렬식 구하기 : "+ p12_m2.determinant());
		System.out.println("Matrix2의 행렬식 구하기 : " +p12_m3.determinant());
		System.out.print("Matrix3의 행렬식 구하기 : ");
		p12_m1.determinant();
		System.out.println();
		
		System.out.println("54번>>");
		System.out.println("Matrix1 : " + p12_m2);
		System.out.println("Matrix2 : " + p12_m3);
		System.out.println("Matrix3 : " + p12_m1);
		p12_m4 = p12_m2.makeInverse();
		System.out.println("Matrix1의 역행렬 구하기 : "+ p12_m4);
		System.out.println("Matrix1과 역행렬의 곱 " + Tensors.mulTwoMatrix(p12_m2, p12_m4));
		System.out.print("Matrix2의 역행렬 구하기(역행렬이 존재하지 않을경우) : ");
		p12_m3.makeInverse();
		System.out.print("Matrix3의 역행렬 구하기(정방행렬이 아닌 경우) : ");
		p12_m1.makeInverse();
	}
}