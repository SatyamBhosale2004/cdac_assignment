package A7th;
import common.ConsoleInput;


import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
public class LambdaCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		q1();
//		q2();
//		q3();
//		q4();
//		q5();
//		q6();
//		q7();
//		q8();
//		exer2();
		exer3();
	}

	
	
	public static void q1() {
		String arr[] = new String[] {"Satyam","Ankit","Mitesh"};
		Comparator<String> sortArr = (first,second) -> first.compareTo(second);
		for(String s : arr)
			System.out.println("Before sorting : " + s);
		Arrays.sort(arr,sortArr);
		for(String s : arr)
			System.out.println("After sorting : " + s);
	}
	
	public static void q2() {
		Integer arr[] = new Integer[] {10,2,22,1,-1,0,47};
		Function<Integer[],Integer> largest = array -> {
			int max = array[0];
			for(int iTmp = 0 ; iTmp < array.length; iTmp++) {
				if(max < array[iTmp])
					max = array[iTmp];
			}
			return max;
		};
		System.out.println("Largest element " + largest.apply(arr));
	}
	
	public static void q3() {
		Integer arr[] = new Integer[] {10,2,22,1,-1,0,47,-10};
		Function<Integer[],Integer> smallest = array -> {
			int min = array[0];
			for(int iTmp = 0 ; iTmp < array.length; iTmp++) {
				if(min > array[iTmp])
					min = array[iTmp];
			}
			return min;
		};
		System.out.println("Smallest element " + smallest.apply(arr));
	}
	
	
	public static void q4() {
		Supplier<String> random = () -> "Random No " + (int)(Math.random() * 300);
		System.out.println(random.get());
	}
	
	public static void q5() {
		Integer array[] = new Integer[] {1,2,3,4,5};
		Function<Integer[], Integer[]> revarr = arr -> {
			int left = 0;
			int right = arr.length-1;
			for(int iTmp = 0 ; iTmp < arr.length ; iTmp++ ) {
				if(left < right) {
					int temp = arr[left];
					arr[left] = arr[right];
					arr[right] = temp;
					left++;
					right--;
				}
			}
			return arr;
		};
		Integer reversed[] = revarr.apply(array);
		System.out.println("Reverse array " + Arrays.toString(reversed));
	}
	
	public static void q6() {
		Supplier<String> date = () -> LocalDate.now().toString();
		System.out.println("Curr date " +date.get());
	}
	
	public static void q7() {
		Predicate<Integer> prime = num -> {
			if(num <=1)
				return false;
			for(int iTmp = 2; iTmp < num;iTmp++) {
				if(num % iTmp==0)
					return false;
			}
			return true;
		};
		System.out.println("ENter num to check if prime");
		int num = ConsoleInput.getInt();
		System.out.println(prime.test(num));
		
	}
	
	public static void q8() {
		Function<String[],String> concat = arr -> arr[0]+arr[1];
		System.out.println(concat.apply(new String[] {"Hello","Bhai"}));
	}
	
	public static void exer2() {
		char vowel[] = new char[] {'A','E','I','O','U'};
		
		Supplier<String> otp = () -> {
			int index = (int)(Math.random() * vowel.length);
			return "OTP is " + vowel[index] + (int)(Math.random() * 9000+1000); 
		};
		System.out.println(otp.get());
		System.out.println(otp.get());
	}
	
	public static void exer3() {
		
		ArrayList<Transaction> transacDetails = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for(int iTmp = 0;iTmp<5;iTmp++) {
			System.out.println("Enter transaction id for " +(iTmp+1));
			int txId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter transaction date (YYYY-MM-DD) for " +(iTmp+1));
			String date = sc.nextLine();
			LocalDate txDate = LocalDate.parse(date);
			System.out.println("Enter transaction amount for " +(iTmp+1));
			float txAmt = sc.nextFloat();
			System.out.println("Enter transaction status for " +(iTmp+1));
			boolean txStatus = sc.nextBoolean();
			System.out.println("Enter transaction arrears for " +(iTmp+1));
			boolean txArrears = sc.nextBoolean();
			
			Transaction obj = new Transaction(txId, txDate , txAmt, txStatus,txArrears);
			
			transacDetails.add(obj);
		}
		System.out.println("All transactions");
		for(Transaction t : transacDetails)
			System.out.println(t);
		System.out.println();
		System.out.println("Amount > 5000");
		System.out.println();
		Predicate<Transaction> amt = tx -> tx.txAmount() > 5000;
		for(Transaction t : transacDetails) {
			if(amt.test(t))
				System.out.println(t);
		}
		System.out.println();
		System.out.println("status is false");
		System.out.println();
		Predicate<Transaction> pending = tx -> !tx.txStatus();
		for(Transaction t : transacDetails) {
			if(pending.test(t))
				System.out.println(t);				
		}
		System.out.println();
		System.out.println("amount due");
		System.out.println();
		Function<Transaction, Float> amtDue = tx -> {
			if(!tx.txArrears())
				return tx.txAmount();
			else
				return (float)(tx.txAmount()+500+(0.18*tx.txAmount()));
		};
		for(Transaction t : transacDetails) {
			System.out.println("Amount due is " +amtDue.apply(t));
		}
			
		sc.close();
	}
}
@FunctionalInterface
interface concat{
	String join(String s1, String s2);
}


record Transaction(int txId, LocalDate txDate, float txAmount, boolean txStatus, boolean txArrears ) {}

