
public class arrays {

	public static void q2() {

		System.out.println("Enter size of array");

		int size = ConsoleInput.getInt();

		int arr[] = new int[size];

		System.out.println("Enter array elements");

		for(int iTemp = 0; iTemp < size; iTemp++) {
			arr[iTemp] = ConsoleInput.getInt();
		}
		for(int iTemp=0;iTemp < size;iTemp++) {
			for(int jTemp=0;jTemp < size;jTemp++) {
				if(arr[iTemp] < arr[jTemp]) {
					int temp = arr[iTemp];
					arr[iTemp] = arr[jTemp];
					arr[jTemp] = temp;
				}
			}
		}
		System.out.println("Sorted Array: ");
		for(int iTemp=0;iTemp<size;iTemp++) {
			System.out.println(arr[iTemp]);
		}
	}
	
	
	public static void q4() {
		System.out.println("Enter size of array");

		int size = ConsoleInput.getInt();

		int arr[] = new int[size];

		System.out.println("Enter array elements");
		int sum =0;
		for(int iTemp = 0; iTemp < size; iTemp++) {
			arr[iTemp] = ConsoleInput.getInt();
			sum += arr[iTemp];
		}

		System.out.println("Avg of all elements of array is:" +sum/size);
	}
	
	public static void q3() {
		System.out.println("Enter size of array");

		int size = ConsoleInput.getInt();

		int arr[] = new int[size];

		System.out.println("Enter array elements");
		int sum =0;
		for(int iTemp = 0; iTemp < size; iTemp++) {
			arr[iTemp] = ConsoleInput.getInt();
			sum += arr[iTemp];
		}

		System.out.println("Sum of all elements of array is:" +sum);
	}
	public static void q5() {
		System.out.println("Enter size of array");

		int size = ConsoleInput.getInt();

		int arr[] = new int[size];
		int arrCopy[] = new int[size];
		System.out.println("Enter array elements");
		
		for(int iTemp = 0; iTemp < size; iTemp++) {
			arr[iTemp] = ConsoleInput.getInt();
			arrCopy[iTemp] = arr[iTemp];
		}

		System.out.println("Original Array elements:");
		for(int iTemp=0;iTemp<size;iTemp++) {
			System.out.print(arr[iTemp] + " ");
		}
		System.out.println();
		System.out.println("Copied Array elements:");
		for(int iTemp=0;iTemp<size;iTemp++) {
			System.out.print(arrCopy[iTemp] + " ");
		}
	}
	public static void q6() {
		System.out.println("Enter size of array");

		int size = ConsoleInput.getInt();

		int arr[] = new int[size];

		System.out.println("Enter array elements");
		
		for(int iTemp = 0; iTemp < size; iTemp++) {
			arr[iTemp] = ConsoleInput.getInt();
		}
        int minValue =arr[0] , maxValue = arr[0];
		for(int iTemp=0;iTemp<size;iTemp++) {
			if(minValue > arr[iTemp])
				minValue = arr[iTemp];
			
			if(maxValue < arr[iTemp])
				maxValue = arr[iTemp];
		}
		System.out.println("Min value of Array is: " + minValue);
		System.out.println("Max value of Array is: " + maxValue);
		
	}

	public static void q7() {
		System.out.println("Enter size of array");

		int size = ConsoleInput.getInt();

		int arr[] = new int[size];
		

		System.out.println("Enter array elements");
		for(int iTemp = 0; iTemp < size; iTemp++) {
			arr[iTemp] = ConsoleInput.getInt();
		}
		for(int iTemp=size-1;iTemp>-1;iTemp--) {
			System.out.println(arr[iTemp]);
		}
		
	}
	public static void q8() {
		System.out.println("Enter size of array");

		int size = ConsoleInput.getInt();

		int arr[] = new int[size];
		

		System.out.println("Enter array elements");
		for(int iTemp = 0; iTemp < size; iTemp++) {
			arr[iTemp] = ConsoleInput.getInt();
		}
		System.out.println("Duplicate Elements : ");
		for(int iTemp = 0; iTemp < size; iTemp++) {
			for(int jTemp = iTemp + 1 ; jTemp < size ; jTemp++) {
				if(arr[iTemp] == arr[jTemp]) {
					System.out.print(arr[iTemp] + " ");
					break;
				}
			}
		}
	}
	//9 SAME AS 8
	public static void q10() {
		System.out.println("Enter size of first array");

		int size = ConsoleInput.getInt();

		int arr[] = new int[size];
		

		System.out.println("Enter array elements of first array");
		for(int iTemp = 0; iTemp < size; iTemp++) {
			arr[iTemp] = ConsoleInput.getInt();
		}
		System.out.println("Enter size of second array");

		int size2 = ConsoleInput.getInt();

		int arr2[] = new int[size2];
		

		System.out.println("Enter array elements of second array");
		for(int iTemp = 0; iTemp < size2; iTemp++) {
			arr2[iTemp] = ConsoleInput.getInt();
		}
		System.out.println("Duplicate Elements : ");
		for(int iTemp = 0; iTemp < size; iTemp++) {
			for(int jTemp = 0  ; jTemp < size2 ; jTemp++) {
				if(arr[iTemp] == arr2[jTemp]) {
					System.out.print(arr[iTemp] + " ");
					break;
				}
			}
		}
	}
	public static void main(String[] args) {

//		q2();
//		q3();
//		q4();
//		q5();
//		q6();
//		q7();
//		q8();
		q10();
	}
}