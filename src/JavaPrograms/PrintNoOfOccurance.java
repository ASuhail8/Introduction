package JavaPrograms;

import java.util.ArrayList;

public class PrintNoOfOccurance {

	public static void main(String[] args) {

		Integer[] arr = { 9, 3, 3, 4, 5, 4, 6, 7, 8, 4, 12, 9, 5, 6, 7, 8 , 5,5};

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			int k = 0;
			if (!al.contains(arr[i])) {
				al.add(arr[i]);
				k++;
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] == arr[j]) {
						k++;
					}

				}
				System.out.println(arr[i] + " is repeated " + k + " times");
			}

		}
	}

}
