<!-- Importing Class and DAO of Supplier -->
<%@page import="com.shop.dao.SupplierDAO"%>
<%@page import="com.shop.model.Supplier"%>

<!-- Import ArrayList -->
<%@page import="java.util.ArrayList"%>

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
	  			alert("Deleted Succesfully");
			}
		</script>
  		
 
		</style>
		
		<!-- JavaScript for drop down -->
		<script>
			function myFunction() {
	  			document.getElementById("myDropdown").classList.toggle("show");
			}

			// Close the dropdown menu if the user clicks outside of it
			window.onclick = function(event) {
	  			if (!event.target.matches('.dropbtn')) {
	    			var dropdowns = document.getElementsByClassName("dropdown-content");
	    			var i;
	    			for (i = 0; i < dropdowns.length; i++) {
	      			var openDropdown = dropdowns[i];
	      				if (openDropdown.classList.contains('show')) {
	        			openDropdown.classList.remove('show');
	      				}
	    			}
	  			}
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
        	</a></div>
      		
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
                <div class="col-md-btn">
          			<form action="AddSupplier.jsp" method="POST"><input type="submit" value="Add New Supplier" class="btn btn-primary btn-block" > </form>         
                </div>
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
          		</div>
        		</div>
      			</nav>      
      		<!-- End Navbar -->
      
		<!-- Creating DAO object & Array to Display Supplier Data -->
      	<%
      		SupplierDAO supplierdao = new SupplierDAO();
			ArrayList<Supplier> suppliers = supplierdao.getSupplier();
      	%>
      	
       	<div class="content">
        <div class="container-fluid">
          	<div class="row">
			<div class="col-md-12">
              	<div class="card">
				<div class="card-header card-header-primary">
                	<h4 class="card-title "> Suppliers </h4>
                  	<p class="card-category"> Total Supplier List </p>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table">
                      <thead class=" text-primary">
                        <th>:</th>
                        <th>
               				Supplier ID
                        </th>
                        <th>
                          Company Name
                        </th>
                        <th>
                          Contact Person
                        </th>
                        <th>
                          Email
                        </th>
                        <th>
                          Contact Number
                        </th>
                        <th>
                          Company Address
                        </th>
                      </thead>
                      <tbody>
                      
                      <% for (Supplier supplier : suppliers){ %>
                        <tr>
                        	<td>
						 		<li class="nav-item dropdown">
			                	<a class="nav-link" href="javascript:;" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			                  	<i class="material-icons">menu</i>
			                  	<p class="d-lg-none d-md-block"> Account </p>
			                	</a>
			                	
			                	<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
			                	<!-- Delete Supplier -->
			                	<form action="${pageContext.request.contextPath}/DeleteSupplierServlet?supplierID='<%=supplier.getSupplierID() %>'" method="post">
										<input type="submit" onclick="popFunction()" value="Delete Supplier" class="button" >
								</form>
								
								<!-- Update SUpplier -->
								<form action="${pageContext.request.contextPath}/PreUpdateSupplierServlet?supplierID=<%=supplier.getSupplierID() %>" method="post">
										<input type="submit" value="Update Supplier" class="button" >
								</form>
			                	</div>
			              		</li>
                        	</td>
                        	
                        	<td><%= supplier.getSupplierID() %></td>
                    		<td><%= supplier.getCompanyName() %></td>
                    		<td><%= supplier.getContactPerson() %></td>
                    		<td><%= supplier.getEmail() %></td>
                    		<td><%= supplier.getContactNumber() %></td>
                    		<td><%= supplier.getCompanyAddress() %></td>
                        </tr>
                        <%} %>
                      </tbody>
                    </table>
                  </div>
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
  <%
}
 else {
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/page/login.jsp");
	requestDispatcher.forward(request, response);
 }%>
    <script src="../assets/js/core/jquery.min.js"></script>
  <script src="../assets/js/core/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
</body>
  <script src="${pageContext.request.contextPath}/assets/js/core/bootstrap-material-design.min.js"></script>


</html>