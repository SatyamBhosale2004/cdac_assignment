
public class forLoop {
	//Q1 for loop disp odd from 1 to 1k 
	public static void q1(){
		for(int iTemp =1 ; iTemp <= 1000 ; iTemp++) {
			if(iTemp % 2 != 0)
				System.out.println(iTemp);
		}
	}
	
	//Q2 for loop al even  1 to 500
	public static void q2(){
		for(int iTemp =1 ; iTemp <= 500 ; iTemp++) {
			if(iTemp % 2 == 0)
				System.out.println(iTemp);
		}
	}
	//Q3 every 7th 1 - 200
	public static void q3(){
		for(int iTemp =1 ; iTemp <= 200 ; iTemp++) {
			if(iTemp % 7 == 0)
				System.out.println(iTemp);
		}
	}
	//Q4 start pattern
//	*
//	**
//	***
//	****
//	*****
	public static void q4(){
		for(int iTemp = 1; iTemp <=5 ; iTemp++) {
			for(int jTemp = 1 ; jTemp <=iTemp ; jTemp ++) {
				System.out.print("*");
			}
			System.out.println();		}
	}
	//Q5
//	*****
//	****
//	***
//	**
//	*
	public static void q5() {
		for(int iTemp = 1; iTemp <= 5 ;iTemp++ ) {
			for(int jTemp = iTemp;jTemp<=5;jTemp++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
//	Q6
//	1
//	2 3
//	4 5 6
//	7 8 9 10
	public static void q6(){
		int value = 1;
		for(int iTemp = 1 ; iTemp <=4 ; iTemp++) {
			for(int jTemp = 1; jTemp <= iTemp ; jTemp++) {
				System.out.print(value + " ");
				value++;
			}
			System.out.println();
		}
	}
//	Q7
//	1
//	1 2
//	1 2 3
//	1 2 3 4
//	1 2 3 4 5
//	1 2 3 4 5 6
	public static void q7() {
		int value = 1;
		for(int iTemp = 1 ; iTemp <=6 ; iTemp++) {
			for(int jTemp = 1; jTemp <= iTemp ; jTemp++) {
				System.out.print(value + " ");
				value++;
			}
			value = 1;
			System.out.println();
		}
	}
//	Q8
//	1 2 3 4 5 6
//	1 2 3 4 5
//	1 2 3 4
//	1 2 3
//	1 2
//	1
	public static void q8() {
		int value = 1;
		for(int iTemp = 1 ; iTemp <=6 ; iTemp++) {
			for(int jTemp = iTemp; jTemp <= 6 ; jTemp++) {
				System.out.print(value + " ");
				value++;
			}
			value = 1;
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		q1();
//		q2();
//		q3();
//		q4();
//		q5();
//		q6();
//		q7();
		q8();
	}

}
