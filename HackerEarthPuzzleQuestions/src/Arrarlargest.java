import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class Arrarlargest {

	public static void main (String[] args) { 
	      
	  /*  Vector<String> arr; 
	    arr = new Vector<>(); 	      
	    //output should be 6054854654 
	    arr.add("54"); 
	    arr.add("546"); 
	    arr.add("548"); 
	    arr.add("60"); 
	    printLargest(arr); */
	    
	    //new 1, 34, 3, 98, 9, 76, 45, 4 : output:998764543431 
	    
	    Vector<String> arr2 = new Vector<>(); 
	    arr2.add("1");
	    arr2.add("34");
	    arr2.add("3");
	    arr2.add("98");
	    arr2.add("9");
	    arr2.add("76");
	    arr2.add("45");
	    arr2.add("4");
	    printLargest(arr2); 
	    
	    
	} 
	
	static void printLargest(Vector<String> arr){ 
		  
	    Collections.sort(arr, new Comparator<String>(){ 

	    // A comparison function which is used by  
	    // sort() in printLargest() 
	    @Override
	    public int compare(String X, String Y) { 
	      
	    // first append Y at the end of X 
	    String XY=X + Y; 
	      
	    // then append X at the end of Y 
	    String YX=Y + X; 
	      
	    // Now see which of the two formed numbers  
	    // is greater 
	    return XY.compareTo(YX) > 0 ? -1:1; 
	} 
	}); 
	      
	Iterator it = arr.iterator(); 

	while(it.hasNext()) 
	    System.out.print(it.next()); 
	  
	} 

}

 

  