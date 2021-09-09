import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort bubblesort = new BubbleSort();
		int[] a = {200,10, 9, 7, 101, 23, 44, 12, 78, 34, 23}; 
		int[] arrs = bubblesort.getMaxDataAtLast(a);		
		for (int i = 0; i < arrs.length; i++) {
			System.out.println(arrs[i]);
		}
	}
	
	
	/**
	 * This method will return max element in last and return
	 * @param arrs
	 * @return
	 */
	public int[] getMaxDataAtLast(int[] arrs){
		
		for (int i = 0; i < arrs.length; i++) {
			for (int j = 0; j < arrs.length -1; j++) {
				if(arrs[j] > arrs[j+1]) {
					int swap = arrs[j];
					arrs[j] = arrs[j+1];
					arrs[j+1] =swap;
				}
			}	
		}
		return arrs;
	}
	
}
