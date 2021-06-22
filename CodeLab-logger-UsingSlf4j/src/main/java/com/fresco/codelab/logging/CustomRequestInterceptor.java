package com.fresco.codelab.logging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import net.minidev.json.JSONObject;

@Component
public class CustomRequestInterceptor extends HandlerInterceptorAdapter{
	
	   private static final Logger logger = LoggerFactory.getLogger(CustomRequestInterceptor.class);
	   
	   @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		   
		   
		   String scheme = request.getScheme();             // http
		    String serverName = request.getServerName();     // hostname.com
		    int serverPort = request.getServerPort();        // 80
		    String contextPath = request.getContextPath();   // /mywebapp
		    String servletPath = request.getServletPath();   // /servlet/MyServlet
		    String pathInfo = request.getPathInfo();         // /a/b;c=123
		    String queryString = request.getQueryString();          // d=789
		    String address = request.getRemoteAddr() ; 
		    Map<String, String[]> param = request.getParameterMap();
		    Enumeration<String> ee = request.getParameterNames();
		  
		    StringBuilder url = new StringBuilder();
		    url.append(scheme).append("://").append(serverName);
		    StringBuffer sb = new StringBuffer();
		   
		    param.forEach(
		    	(key,value) -> {
		    				sb.append(key).
		    				append(":")
		    				.append(value[0]).append(",").append(" ");
		    			}	
		    		
		    		);
		    	       
		   if ("POST".equalsIgnoreCase(request.getMethod())) {
			   System.out.println(sb.toString());
			   logger.info(request.getMethod() + "::" + url.toString()+request.getRequestURI() + "::" + "Body" + "::{ " + sb.toString() + " }clientIpAddr/" + request.getRemoteAddr());   
		   }else if("GET".equalsIgnoreCase(request.getMethod())) {
			   logger.info(request.getMethod() + "::" + url.toString()+request.getRequestURI() + "::" + "clientIpAddr/" + request.getRemoteAddr());
		   }
		   return true;
	 	}

	    @Override
	    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler, Exception ex) {
	       
	    	FileInputStream instream = null;
		      FileOutputStream outstream = null;
	 
	    	try{
	    	    File infile =new File("application.log");
	    	    File outfile =new File("test.log");
	 
	    	    instream = new FileInputStream(infile);
	    	    outstream = new FileOutputStream(outfile);
	 
	    	    byte[] buffer = new byte[1024];
	 
	    	    int length;
	    	    /*copying the contents from input stream to
	    	     * output stream using read and write methods
	    	     */
	    	    while ((length = instream.read(buffer)) > 0){
	    	    	outstream.write(buffer, 0, length);
	    	    }

	    	    //Closing the input/output file streams
	    	    instream.close();
	    	    outstream.close();

	    	    System.out.println("File copied successfully!!");
	 
	    	}catch(IOException ioe){
	    		ioe.printStackTrace();
	    	 }
		    	
		    
	    	
	    }
	
	
}
