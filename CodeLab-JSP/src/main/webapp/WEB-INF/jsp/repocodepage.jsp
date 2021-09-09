<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>


<style type="text/css">

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
	width:100%;
	height:95%;
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
	<div class="header">
		<span id="repo-name">"${repo.repoName}"</span>
		<span id="repo-version">"${version}"</span>
	</div>
	<div class="container">
		<div id="repo_code_div">
			<c:forEach items="${repoCode}" var="code">
				<div>
					<div class="code-editor-link" onclick="javascript:openEditor(this)">
						 ${code.key.substring(code.key.indexOf('/') + 1)}
						 <span>${code.value.get(0)} bytes</span>
					</div>
					<div class="code-editor">
						<form action="/dashboard/savecode/${repo.repoAutoGenId}/${version}" method=POST>
							<span>${code.key.substring(code.key.indexOf('/') + 1)}</span>
							<input type=hidden name="reponame" value="${code.key}">							
							<label for="submit"><b>Save</b></label>
							<input type="submit" name="submit"> <br>
							<!-- <button type="submit">Save</button> -->
							<button type="reset" onclick="closeEditor(this)">Cancel</button>
							<textarea name="code">${code.value.get(1)}</textarea>
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<script>
	
	function openEditor(element){
		element.parentElement.getElementsByClassName('code-editor')[0].style.display = "block";
	}

	function closeEditor(element){
		element.parentElement.parentElement.style.display = "none";
	}
	
	</script>
	
</body>
</html>