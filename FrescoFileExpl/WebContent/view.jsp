<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.regex.*" %>
<%@ page import="java.util.*,java.net.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--WRITE YOUR CODE HERE-->

<head>
	<h1>View Jsp</h1>
	
<style type="text/css">

#file-Name{
	display: block;
}
.code-editor-link{
	cursor: pointer;
}
.code-editor{
	box-shadow: 0px 0px 28px #888888;
    background: #eeeeee;
    border: 2px solid lightgray;
    padding-right: 3px;
	position:fixed;
	width:90%;
	height:90%;
	top:5%;
	left:5%;
	display:none;
	text-align:right;
}
.code-editor span{
	position:absolute;
	left:0;
	font-size:14px;
	font-weight:bold;
}
.code-editor form{
	width:100%;
	height:100%;
}
.code-editor textarea{
	width:50%;
	height:45%;
	padding:0px;
	margin:0px;
}
.code-editor  button{
	width:70px;
	height:5%;
}

</style>
	
	
</head>

<body>
	<div class="container">
		<div id="repo_code_div">		
			<c:forEach  var="folders" items="${folderMap}" >			
				<div class="code-editor-link">						
						<div id = "folder-Name">
							<c:set var = "data" value="${folders.key}"> </c:set>
							<span onclick="javascript:submitfolderName('${folders.value}')">${folders.key}</span>													
						</div>
						<div id = "file-Name"> 
									<span id ="fileName-span" onclick="javascript:openEditor(this)"></span>						
									
											<div>
												<!-- <form id="editFileID">
													<input type=hidden name="reponame" id="fileId" >
													<input type=hidden name="fetchFile" value="fetchFile">							
												</form>	 -->	
												<div class="code-editor">				
												 	<form id="saveFileID" action="./SaveFile"  method="POST">	
												 		<textarea name="editor" id="editor">${fileDataText}</textarea>	
												 		<input type=hidden name="reponame" id="fileId" >
														<input type=hidden name="fetchFile" value="fetchFile">		
												 		<%-- onclick="javascript:callsave('${folders.value}')" --%>					
														 <button type="submit" id="save" >Save</button> 
														<!-- <button type="submit" id="save" >Save</button> -->
														<button type="reset" onclick="closeEditor()">Cancel</button>
													</form>	
												</div>
											 </div>
									
								
						</div>
						
				</div>				
			</c:forEach>
			
		<div>
	</div>
	
			
	
	<script>
	
	
	function submitfolderName(param){
		alert(param);
		var update =  document.getElementById('fileName-span');
		document.getElementById('file-Name').style.display = "block";
		update.innerHTML = param
		
	}
	
	
	function submitfileName(param){
		alert(param);

		document.getElementsByClassName('code-editor').style.display = "block";
	/* 	document.getElementById("fileId").value = param
		document.getElementById("editFileID").action="./EditFile";
		document.getElementById("editFileID").method = "GET";
		document.getElementById("editFileID").submit(); */
		//document.getElementsByClassName('code-editor').style.display = "block";
		
		//callsave(ffname);
		
	}
	
	
	
	function callsave(param){
		document.getElementById("fileId").value = param
		document.getElementById("saveFileID").action="./SaveFile";
		document.getElementById("saveFileID").method = "POST";
		document.getElementById("saveFileID").submit(); 
		
		
	}
	
	function openEditor(element){
		element.parentElement.getElementsByClassName('code-editor')[0].style.display = "block";
		//document.getElementsByClassName('code-editor').style.display = "block";
	}

	function closeEditor(){	
		document.getElementsByClassName('code-editor').style.display = "none";
	}
	
	</script>
	
	
</body>

</html>