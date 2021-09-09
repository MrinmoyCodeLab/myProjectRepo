<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<style type="text/css">

.menu{
	height:20%;
	padding: 0 20%;
}
.menu button{
	width:150px;
	height:50px;
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	opacity: 0.9;
	font-size:14px;
	font-weight:600;
}
.container{
	height:70%;
	padding: 10% 20% 0 20%;
}

#create_new_repo_div{
	display:none;
}

#view_all_repos_div{
	display:none;
}

#view_my_repos_div{
	
}

.repo-td{
	padding:10px 0px;
	background: lightgray;
	width: 100vw;
}
.repo-link{
	color:black;
	text-decoration:none;
	font-weight:bold;
	padding:0px 10px;
}

</style>
</head>
<body>
		
		<div class="header">
		<span id="repoName">"${repoOwner.username}"</span>
		<span id="repoName">"${repo.repoName}"</span>
		
		<button id="view_code_btn" onclick="viewCode()" style="display:none">View Code</button>
		<button id="upload_code_btn" onclick="uploadCode()">Upload Code</button>
		<c:if test = "${repo.repoOwnerId == loggedInUser}">
			<button id="add_developer_btn" onclick="addDeveloper()">Add Developer</button>
		</c:if>
	</div>
	
	
	<div class="container">
		<div id="view_code_div">
			<c:forEach items="${repo.versions}" var="version">
				<a class="repo-version-link" href="/dashboard/openrepo/${repo.repoAutoGenId}/version/${version.version}">
					<div class="repo-version-div">
						<c:out value="> ${repo.repoName} - version ${version.version} " />
					</div>
				</a>
				<c:if test = "${version.isMaster}">
					<div>Master</div>
				</c:if>
				
			</c:forEach>
		</div>
		<div id="upload_code_div" style="display:none">
			<form method="POST" action="/dashboard/uploadcode/${repo.repoAutoGenId}" enctype="multipart/form-data">
    			<input type="file" name="file" accept=".zip"/><br/><br/>
    			<input type="submit" name="file_submit_btn" value="Upload" />
			</form>
		</div>
		<c:if test = "${repo.repoOwnerId == loggedInUser}">
			<div id="add_developer_div" style="display:none">
				<form method="POST" action="/dashboard/adddeveloper/${repo.repoAutoGenId}">
    				<input  name="developer" list="developers" >
  					<datalist id="developers">
    					<c:forEach items="${developers}" var="dev">
    						<option value="${dev.username}">
						</c:forEach>
					</datalist>
    				<input type="submit" name="add_developer_btn" value="Add Developer" />
				</form>
			</div>
		</c:if>
	</div>
	
	
	<script>	
		function uploadCode(){
			document.getElementById('upload_code_btn').style.display = "none";
			document.getElementById('view_code_div').style.display = "none";
			document.getElementById('view_code_btn').style.display = "block";
			document.getElementById('upload_code_div').style.display = "block";
			document.getElementById('add_developer_btn').style.display = "block";
			document.getElementById('add_developer_div').style.display = "none";
		}
	
		function viewCode(){
			document.getElementById('view_code_btn').style.display = "none";
			document.getElementById('upload_code_btn').style.display = "block";
			document.getElementById('upload_code_div').style.display = "none";
			document.getElementById('view_code_div').style.display = "block";
			document.getElementById('add_developer_btn').style.display = "block";
			document.getElementById('add_developer_div').style.display = "none";
		}
	
		function addDeveloper(){
			document.getElementById('view_code_btn').style.display = "block";
			document.getElementById('upload_code_btn').style.display = "block";
			document.getElementById('upload_code_div').style.display = "none";
			document.getElementById('view_code_div').style.display = "none";
			document.getElementById('add_developer_btn').style.display = "none";
			document.getElementById('add_developer_div').style.display = "block";
		}
	</script>
		



</body>
</html>