import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastIteraror {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Map<String,String> map = new HashMap<String,String>();
		
		//HashSet<E> 
		
		Collection 
		Map<String, String> map = new ConcurrentHashMap<String,String>();
		map.put("1", "Mrinmoy");
		map.put("2", "Mrinmoy");
		map.put("3", "Mrinmoy");
		
		Iterator<Entry<String, String>> itr =  map.entrySet().iterator();
		
		
		for(Map.Entry<String, String> key :  map.entrySet()) {
			
			System.out.println(key.getKey());
			map.put("4", "Mrinmoy");
			
		}		
	}

}
