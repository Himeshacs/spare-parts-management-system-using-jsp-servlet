<!-- Import ArrayList -->
<%@page import="java.util.ArrayList"%>

<!-- Importing Class and DAO of Supplier -->
<%@page import="com.shop.dao.SupplierDAO"%>
<%@page import="com.shop.model.Supplier"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
 		<!-- External CSS Files-->
 		<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  		<link href="${pageContext.request.contextPath}/assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />

		<!-- Pop-Function -->
		<script type='text/javascript'>
  			function popFunction() {
				  alert("New Supplier is Added to the System");
				}
  		</script>
  		
	</head>
	
		<%
					User user = (User)session.getAttribute("user");
			  		if (user != null){  
		%>
		 
		<body class="">
  			<div class="wrapper ">
    		<div class="sidebar" data-color="purple" data-background-color="white" data-image="../assets/img/sidebar-1.jpg">

      		<div class="logo"><a href="" class="simple-text logo-normal">
          	TREGAKIHE
        	</a>
        	</div>
        	
      		<div class="sidebar-wrapper">
        	<ul class="nav">
          		<li class="nav-item">
            		<a class="nav-link" href="./dashboard.html">
              		<i class="material-icons">dashboard</i>
              		<p>Dashboard</p>
            		</a>
          		</li>
          
          		<li class="nav-item ">
            		<a class="nav-link" href="./user.html">
              		<i class="material-icons">person</i>
              		<p>Users</p>
            		</a>
          		</li>
          
          		<li class="nav-item ">
            		<a class="nav-link" href="${pageContext.request.contextPath}/page/products.jsp">
              		<i class="material-icons">content_paste</i>
              		<p>Products</p>
            		</a>
          		</li>
          
          		<li class="nav-item ">
            		<a class="nav-link" href="${pageContext.request.contextPath}/page/Sales.jsp">
              		<i class="material-icons">library_books</i>
              		<p>Sales</p>
            		</a>
          		</li>
          
          		<li class="nav-item ">
            		<a class="nav-link" href="">
              		<i class="material-icons">bubble_chart</i>
              		<p>Customers</p>
            		</a>
          		</li>
          
           		<li class="nav-item active">
            		<a class="nav-link" href="${pageContext.request.contextPath}/Pages/ViewSupplier.jsp">
              		<i class="material-icons">person</i>
              		<p> Suppliers </p>
            		</a>
          		</li>
          
          		<li class="nav-item ">
            		<a class="nav-link" href="${pageContext.request.contextPath}/Pages/ViewPurchase.jsp">
              		<i class="material-icons">library_books</i>
              		<p> Purchases </p>
            		</a>
          		</li>
          
          		<li class="nav-item ">
            		<a class="nav-link" href="${pageContext.request.contextPath}/Pages/ViewInventory.jsp">
              		<i class="material-icons">content_paste</i>
              		<p> Inventory </p>
            		</a>
          		</li>
          
          		<li class="nav-item active-pro ">
          		</li>
          
        </ul>
      	</div>
    	</div>
    	
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <img src="../Images/supplier.png" alt="supplier" height="0100" width="0100"/>
            <a class="navbar-brand" href="javascript:;"> Supplier Management </a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end">
            <form class="navbar-form">
              <div class="input-group no-border">
                <input type="text" value="" class="form-control" placeholder="Search...">
                <button type="submit" class="btn btn-white btn-round btn-just-icon">
                  <i class="material-icons">search</i>
                  <div class="ripple-container"></div>
                </button>
              </div>
            </form>
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="javascript:;">
                  <i class="material-icons">dashboard</i>
                  <p class="d-lg-none d-md-block">
                    Stats
                  </p>
                </a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link" href="javascript:;" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">person</i>

                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      
      <!-- End Navbar -->

      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title"> Add New Supplier</h4>
                  <p class="card-category"> Please Fill All the Fields </p>
                </div>
                <div class="card-body">
				<form action="../AddSupplierServlet" method="POST" >
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> Supplier ID :</label> <br>
							<input class ="form-control" type ="text" name="supplierID" placeholder="format is Sxxxx" maxlength="5" required>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> Company Name :</label> <br>
							<input class ="form-control" type ="text" name="companyName"  maxlength="20" required> 
                        </div>
                      </div>

                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> Contact Person :</label> <br>
							<input class ="form-control" type ="text" name="contactPerson"  maxlength="20" required>
						</div>
                      </div>
                      
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> Email :</label> <br>
							<input class ="form-control" type ="text" name="email"  maxlength="20" required>
                    	</div>
                      </div>
                    </div>

                    <div class="row">

                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> Contact Number :</label> <br>
							<input class ="form-control" type ="text" name="contactNumber"  maxlength="10" required>
                    	</div>
                      </div>
                    </div>
                    
                     <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> Company Address :</label> <br>
							<input class ="form-control" type ="text" name="companyAddress"  maxlength="30" required> 
                    	</div>
                      </div>
                    </div>
                    
                    <input type="submit" value="Add Supplier" onclick="popFunction()" class="btn btn-primary btn-block" >
                    <div class="clearfix"></div>
                  </form>
                </div>
              </div>
            </div>

          </div>
        </div>
      </div>
      
 -----------------------------------------------------------------
      <footer class="footer">
        <div class="container-fluid">
          <nav class="float-left">
            <ul>
              <li>
                <a href="">
					TREGAKIHE
                </a>
              </li>
              <li>
                <a href="">
                  About Us
                </a>
              </li>
              <li>
                <a href="">
                  Blog
                </a>
              </li>
              <li>
                <a href="">
                  Licenses
                </a>
              </li>
            </ul>
          </nav>
        </div>
      </footer>
    </div>
  </div>
</body><%
}
 else {
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/page/login.jsp");
	requestDispatcher.forward(request, response);
 }%>
</html>