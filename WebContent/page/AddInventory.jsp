<!-- Import ArrayList -->
<%@page import="java.util.ArrayList"%>

<!-- Importing Class and DAO of Inventory -->
<%@page import="com.shop.dao.InventoryDAO"%>
<%@page import="com.shop.model.Inventory"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
 		<!-- External CSS Files-->
 		<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  		<link href="${pageContext.request.contextPath}/assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />

		<!-- Calculation and Pop-Function -->
 		<script type='text/javascript' >
			function startCalc(){
	  		interval = setInterval("calc()",1);
			}
			
			function calc(){
	  		x = document.inventory.instoreInventory.value;
	 		y = document.inventory.unitsPurchased.value;
	 		z = document.inventory.unitsSold.value;
	 		document.inventory.closingInventory.value = ((x * 1) + (y * 1)) - (z * 1);
			}
			
			function stopCalc(){
	  		clearInterval(interval);
			}
			
			function popFunction() {
				  alert("New Inventory is Added to the System");
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
          
           		<li class="nav-item">
            		<a class="nav-link" href="${pageContext.request.contextPath}/Pages/ViewSupplier.jsp">
              		<i class="material-icons">person</i>
              		<p> Suppliers </p>
            		</a>
          		</li>
          
          		<li class="nav-item">
            		<a class="nav-link" href="${pageContext.request.contextPath}/Pages/ViewPurchase.jsp">
              		<i class="material-icons">library_books</i>
              		<p> Purchases </p>
            		</a>
          		</li>
          
          		<li class="nav-item active">
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
            <img src="../Images/inventory.png" alt="supplier" height="0100" width="0100"/>
            <a class="navbar-brand" href="javascript:;"> Inventory Management </a>
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
                  <h4 class="card-title"> Add New Inventory </h4>
                  <p class="card-category"> Please Fill All the Fields </p>
                </div>
                <div class="card-body">
				<form name="inventory" action="../AddInventoryServlet" method="POST" >
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> Inventory ID :</label> <br>
							<input type ="text" name="inventoryID" placeholder="format is Ixxxx" maxlength="5" class ="form-control" required>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> Product ID :</label> <br>
							<input type ="text" name="productID"  maxlength="5" class ="form-control" required> 
                        </div>
                      </div>

                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> In-store Inventory :</label> <br>
							<input type ="number" name="instoreInventory"  onFocus="startCalc();" onBlur="stopCalc();" maxlength="5" class ="form-control" required>  <br>
						</div>
                      </div>
                      
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> Units Purchased :</label> <br>
							<input type ="number" name="unitsPurchased"  onFocus="startCalc();" onBlur="stopCalc();" maxlength="20" class ="form-control" required>
                    	</div>
                      </div>
                    </div>

                    <div class="row">

                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> Units Sold :</label> <br>
							<input type ="number" name="unitsSold" onFocus="startCalc();" onBlur="stopCalc();" maxlength="10" class ="form-control" required>
                    	</div>
                      </div>
                    </div>
                    
                     <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> Closing Inventory :</label> <br>
							<input type ="number" name="closingInventory"  maxlength="10" readonly class ="form-control">
                    	</div>
                      </div>
                                 
                       <div class="col-md-6">
                        <div class="form-group">
                          <label> Update Date : </label> <br>
							<input type ="date" name="updateDate"  maxlength="12" class ="form-control" required> 
                    	</div>
                      </div>
                      
                      <div class="col-md-6">
                        <div class="form-group">
                          	<label> Update Time : </label> <br>
							<input type ="time" name="updateTime"  maxlength="8" class ="form-control" required> 
                    	</div>
                      </div>
                      
                    
                    </div>
                    
                    <input type="submit" value="Add Inventory" onclick="popFunction()" class="btn btn-primary btn-block" >
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
</body>
<%
}
 else {
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/page/login.jsp");
	requestDispatcher.forward(request, response);
 }%>
</html>