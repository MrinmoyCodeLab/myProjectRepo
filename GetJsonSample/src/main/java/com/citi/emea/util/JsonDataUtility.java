package com.citi.emea.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

@Component
public class JsonDataUtility {

	
	public JSONObject getJsonFile(String country , String filePath, String fileName) throws FileNotFoundException {
		
		JSONObject jsonFile = new JSONObject();
		String countryfolder=filePath+country;
		String fileSourcePath = filePath+country+"/"+fileName;
		System.out.println("File name to search ---> " + fileName);
		System.out.println("Country File path ---> " + fileSourcePath);
		
		File file = new File(countryfolder);
		if(isFileDirectoryExists(file)) {
			jsonFile = readJsonFile(fileSourcePath);
		}else {
			fileSourcePath = filePath+"Common"+"/"+fileName;
			jsonFile = readJsonFile(fileSourcePath);			
		}		
		return jsonFile;
	}
	
	
	public static boolean isFileDirectoryExists(File file)
	{
	    if (file.exists())
	    {
	      return true;
	    }
	    return false;
	}
	
	
	public JSONObject readJsonFile(String fileName) {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();
		try {
			System.out.println(fileName);			
			Object obj = parser.parse(new FileReader(fileName)); 
			jsonObject = (JSONObject) obj;
 
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("Error", "Invalid country code . Please verify country entry in property file");
		}
		return jsonObject;
	}
	
	
	
	  public static void main(String[] args) throws Exception 
	  { 
	    // pass the path to the file as a parameter 	   
	    File file = new File("C:/EmeaJsonFile/POLAND/employeeJsp.txt"); 	    
	    BufferedReader br = new BufferedReader(new FileReader(file)); 	  
	    String st; 
	    while ((st = br.readLine()) != null) 
	      System.out.println(st); 
	   } 
	  
	
	
	
}
