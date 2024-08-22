<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Accueil</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	</head>
	<body>
	
		<div class="container d-flex justify-content-center flex-direction-column">
			
			<div style="height: 400px; width: 700px; display: flex ; flex-direction: column; justify-content: center; align-items: center; ">
			   <form action="login" method="post">
			   		<div class="mb-3 row">
					    <label for="inputPassword" class="col-sm-2 col-form-label">Email</label>
					    <div class="col-sm-10">
					      <input type="email" name="email" class="form-control" id="inputPassword">
					    </div>
		  			 </div>
					 <div class="mb-3 row">
					    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
					    <div class="col-sm-10">
					      <input type="password" name="password" class="form-control" id="inputPassword">
					    </div>
		  			 </div>
		  			 
		  			 <div class="mb-3 row">
					    <button type="submit" class="btn btn-sm btn-primary">Login</button>
		  			 </div>
			   </form>
			</div>
			  
		</div>
	</body>
</html>