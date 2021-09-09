package executorServiceExample;

import java.io.*;
import java.util.*;

class Employee
{
    //Create the Constructor here     
    String  name;
    int id;
    int age;
    Employee(String name , int id, int age){
        this.name = name;
        this.age =age;
        this.id = id; 
    }
}

class SortEmployees 
{
    void sortEmployees(ArrayList<Employee> empList) 
    {

        //Enter your Code here
        
        empList.sort(new Comparator<Employee>() {
    @Override
    public int compare(Employee m1, Employee m2) {
        if(m1.name == m2.name){
            return 0;
        }if(m1.name.equalsIgnoreCase(m2.name)){
            return 0;
        }
        return  ? -1 : 1;
     }
});
        
    }
}

public class SortEmployeesMain
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Employee> empList=new ArrayList<>();
		
		 int n=Integer.parseInt(br.readLine().trim());
		 for(int i=0;i<n;i++)
		 {
			 String inp=br.readLine();
	         String inparr[]=inp.split(" ");
			 
			 Employee ws=new Employee(inparr[0],Integer.parseInt(inparr[1]), Integer.parseInt(inparr[2]));
			 empList.add(ws);
		 }
		
		SortEmployees s1=new SortEmployees();
		s1.sortEmployees(empList);
    }
}
