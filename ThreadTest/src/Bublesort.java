
public class Bublesort {

	public static void main(String[] args) {


		
		int[] abe = {1,5,3,4,6,2};
		
		for(int i=0; i<abe.length ;i++) {
			System.out.println("WIthout sort -- " + abe[i]);

		}
		
		
		int temp =0;
		
		for(int i=0; i<abe.length ;i++) {
			
			for(int j=1; j<(abe.length - i) ;j++) {
				
				 if(abe[j-1] > abe[j]){  
                     //swap elements  
                     temp = abe[j-1];  
                     abe[j-1] = abe[j];  
                     abe[j] = temp;  
             }  
			}
		}
		
		for(int i=0; i<abe.length ;i++) {
			System.out.println("with sort -- " + abe[i]);

		}
	}

}
