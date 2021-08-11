
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin page</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
 <style>
.column {
  float: left;
  width: 40%;
  padding: 5px;
}
</style>
</head>
<body>
<center><h2>Admin panel</h2>
Hi you have successfully logged in as admin.</center>
<div class="row">
<div class="container  col-md-4" >
<h4>Add Employee</h4>
<form action="addemp" method="post">
   <div class="form-group">
    <label for="uname">Name:</label> <input type="text"
     class="form-control" id="username" placeholder="Name"
     name="username" required>
  
    <label for="uname">Lastname:</label> <input type="text"
     class="form-control" id="Lastname" placeholder="Lastname"
     name="Lastname" required>

    <label for="uname">Password:</label> <input type="password"
     class="form-control" id="password" placeholder="Password"
     name="password" required>

    <label for="uname">Type:</label> 
    <select for="uname" id="type" name="type"required>
  <option value="2">Employee</option>
  <option value="1">Admin</option>
</select>
<br>


    <label for="uname">Dept :</label> <select for="uname" id="dept" name="dept"required>
##replace with options##
</select>
<br>
    <label for="uname">DOB:</label> <input type="date"
     class="form-control" id="DOB" placeholder="dd/mm/yyyy"
     name="DOB" max="#maxdate#" required>
     </div>
   <button type="submit" class="btn btn-primary">Submit</button>
  </form>
 </div>
 


<div class=" container col-md-4" >
<h4>Add Department</h4>
<form action="adddept" method="post">
   <div class="form-group">
    <label for="uname"> Department Name:</label> <input type="text"
     class="form-control" id="username" placeholder="Name" name="username" required>

     </div>
   <button type="submit" class="btn btn-primary">Submit</button>
  </form>
 </div>
 
 
 
 
 <div class="container  col-md-4" >
<h4>Add Rl</h4>
<form action="addrl" method="post">
   <div class="form-group">
  
    <label for="uname">RL type:</label> <input type="text"
     class="form-control" id="type" placeholder="type"
     name="type" required>

    <label for="uname">Description:</label> <input type="text"
     class="form-control" id="desc" placeholder="Description"
     name="desc" required>


    <label for="uname">Dept :</label> <select for="uname" id="dept" name="dept"required>
##replace with options##
</select>
<br>
    <label for="uname">creation date:</label> <input type="date"
     class="form-control" id="date" placeholder="dd/mm/yyyy"
     name="date"  required>
     </div>
   <button type="submit" class="btn btn-primary">Submit</button>
  </form>
 </div>
 
 
 
 
 </div>
 
<br><br><br>
<div class="row">
<div class="container">
<div class="column">


####replace admin here####

</div>
<div class="column">


####replace dept here####
</div>
</div>
</div>
<div class="row">
<div class="container">

####replace here####
</div>
</div>

<div class="row">
<div class="container">

####replace rl here####
</div>
</div>
<footer><center>

<br>

<a href ="logout.jsp">logout </a></center></footer>
</body>
</html>