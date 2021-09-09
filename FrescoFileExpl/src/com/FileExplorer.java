package com;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileExplorer
 */

@WebServlet("/FileExplorer")
public class FileExplorer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileExplorer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*WRITE YOUR CODE HERE*/
		System.out.println("FileExplorer servlet");
		Map<String, String> fileMap = new HashMap<String, String>(); 
		File directoryPath = new File("C:\\Users\\Home\\Desktop\\Java8_Sample_question\\10994\\JAP-Code-File-Explorer\\usr\\repos\\");
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
		doGet(request, response);
	}

}
