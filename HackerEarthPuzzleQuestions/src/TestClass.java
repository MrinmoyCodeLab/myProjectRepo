/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

//int put : "(())(()" -->  how many deletion required to make it equal:  
//question:
//https://www.geeksforgeeks.org/dbs-hack2hire-interview-experience-tech-associate/
class TestClass {
	
	
    public static void main(String args[] ) throws Exception {
       
    	String input = "()((())";
    	char leftChar ='(';
    	char rightChar =')';
    	int left=0;
    	int right=0;
    	int count =0;
    	for(int i=0; i<input.length();i++){  
            char c = input.charAt(i);
            if(c == leftChar) {
            	left= left+1;
            }
            if(c == rightChar) {
            	right= right+1;
            }
    	} 
    	
    	System.out.println(" Total leftChar "+ left);  
    	System.out.println(" Total rightChar "+ right);  
    	
    	if(left == right) {
    		System.out.println(" Both left and right same  ");
    		count=(left-right);
    		System.out.println(count);
    	}    	
    	if(left > right) {
    		count=(left-right);
    		System.out.println("Total deletion: " +  count);
    	}else {
    		count=(right-left);
    		System.out.println("Total deletion: " +  count);
    	}
    }
    
}
