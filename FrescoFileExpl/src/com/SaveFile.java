package com;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveFile
 */
public class SaveFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String content = request.getParameter("editor");
		String fileId = request.getParameter("fileId"); 
		
		String path = request.getParameter("path");
		if(path == null) {
			path = "C:/Users/Home/Desktop/Java8_Sample_question/10994/JAP-Code-File-Explorer/usr/repos/repo1/text1.txt" ;
		}
		
		
		String data = "" ;
		try {
			
			 FileWriter myWriter = new FileWriter(path);	
		      myWriter.write(content);
		      myWriter.close();
			     
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }	
		
		File directoryPath = new File("C:\\Users\\Home\\Desktop\\Java8_Sample_question\\10994\\JAP-Code-File-Explorer\\usr\\repos\\");
		Map<String, String> fileMap = new HashMap<String, String>(); 
		listFilesForFolder(directoryPath , fileMap);		
		List<String> folderPath = new ArrayList<String>();			
		if(fileMap!= null) {
			fileMap.forEach((key , value)->{
				System.out.println((key + ":" + value));
				folderPath.add(key);
			});
		}
		request.setAttribute("folderPathName", folderPath);
		request.setAttribute("folderMap", fileMap);
		
		this.getServletContext().getRequestDispatcher("/view.jsp").include(request, response);
		
	}
	
	public void listFilesForFolder(File folder , Map name) {
		String folderName = ""; 
		String fileName = ""; 
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	 System.out.println (fileEntry.getName());
	        	 folderName = fileEntry.getName();
	        	 for (final File files : fileEntry.listFiles()) { 
	        		 fileName =  files.getName() ;
	        		 break;
	        	 }
	        	 name.put(folderName, fileName); 
	        } 
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("SaveFile servlet");
		doGet(request, response);
	}

}
