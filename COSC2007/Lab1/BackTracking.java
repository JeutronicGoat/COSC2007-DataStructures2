import java.util.Arrays;

public class BackTracking {

	public static void main(String[] args) {
		int[] list0 = new int[3];
		int[] list1 = new int[] {1,2,3};
		System.out.println(partionable(list1, list0, 0));
		System.out.println(Arrays.toString(list1) + "     " + Arrays.toString(list0));
		
		System.out.println();
		
		int[] list2 = new int[7];
		int[] list3 = new int[] {4,7,3,2,8,1,5};
		System.out.println(partionable(list3, list2, 0));
		System.out.println(Arrays.toString(list3) + "     " + Arrays.toString(list2));
		
		System.out.println();
		
		int[] list5 = new int[3];
		int[] list6 = new int[] {1,2,3};
		System.out.println(partionable2(list6, list5, 0));
		System.out.println(Arrays.toString(list6) + "     " + Arrays.toString(list5));
		
		System.out.println();
		
		int[] list7 = new int[7];
		int[] list8 = new int[] {4,7,3,2,8,1,5};
		System.out.println(partionable2(list8, list7, 0));
		System.out.println(Arrays.toString(list8) + "     " + Arrays.toString(list7));
		
		System.out.println();
		
		int[] list9 = new int[7];
		int[] list10 = new int[] {4,7,3,2,8,1,7};
		System.out.println(partionable(list10, list9, 0));
		System.out.println(Arrays.toString(list10) + "     " + Arrays.toString(list9));
		
		System.out.println();
		
		int[] list11 = new int[7];
		int[] list12 = new int[] {4,7,3,2,8,1,7};
		System.out.println(partionable2(list12, list11, 0));
		System.out.println(Arrays.toString(list12) + "     " + Arrays.toString(list11));
		
		
	}
	
	public static boolean partionable(int[] list1, int[] list2, int start) {
		
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0; i < list1.length; i++) {
			sum1 += list1[i];
			sum2 += list2[i];
		}
		
		if(sum1 == sum2) return true;
		if(sum1 < sum2) return false;	//Pruning
		
		for(int i = start; i < list1.length; i++) {
			list2[i] = list1[i];
			list1[i] = 0;
			
			if(partionable(list1, list2, i + 1)) return true;
			
			list1[i] = list2[i];
			list2[i] = 0;
		}
		
		return false;
	}
	
	public static boolean partionable2(int[] list1, int[] list2, int start) {
		
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0; i < list1.length; i++) {
			sum1 += list1[i];
			sum2 += list2[i];
		}
		
		if(sum1 == 2 * sum2 || sum2 == 2 * sum1) return true;
		
		for(int i = start; i < list1.length; i++) {
			list2[i] = list1[i];
			list1[i] = 0;
			
			if(partionable2(list1, list2, i + 1)) return true;
			
			list1[i] = list2[i];
			list2[i] = 0;
		}
		
		return false;
	}
}
