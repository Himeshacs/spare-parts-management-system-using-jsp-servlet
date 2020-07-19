<%@page import="java.util.ArrayList"%>
<%@page import="com.shop.dao.ProductDb"%>
<%@page import="com.shop.model.Product"%>
<%@page import="com.shop.model.User"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="${pageContext.request.contextPath}/assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
  <style>
  
  .col-md-4 {
    flex: 0 0 33%;
    max-width: 33%;
}

</style>
</head>
			<%
						//Authenticating the user session
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
          <li class="nav-item   ">
            <a class="nav-link" href="./dashboard.html">
              <i class="material-icons">dashboard</i>
              <p>Dashboard</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./user.html">
              <i class="material-icons">person</i>
              <p>User Profile</p>
            </a>
          </li>
          <li class="nav-item active">
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
              <p>Users</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="">
              <i class="material-icons">location_ons</i>
              <p>Maps</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="">
              <i class="material-icons">notifications</i>
              <p>Notifications</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="">
              <i class="material-icons">language</i>
              <p>RTL Support</p>
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
            <a class="navbar-brand" href="javascript:;">Update Product</a>
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
                  <h4 class="card-title">Enter Product Details</h4>
                  <p class="card-category">Please fill all details</p>
                </div>
                <div class="card-body">
                <%  Product product = new Product();               
                ProductDb productDb = new ProductDb();
                	product = productDb.getProduct(request.getParameter("productId")); 
                %>
				<form action="PostUpdateServlet" method="POST" enctype="multipart/form-data">
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Product Id</label>
					<input class="form-control" type="text" name="productId" value="<%= product.getProductId() %>" readonly>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Product Name</label>
					<input class="form-control" type="text" name="productName" value="<%=product.getProductName() %>" required>
                        </div>
                      </div>

                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Product Type</label>
						<select class="form-control" name="type" value="<%=product.getType()  %>" required>
							<option><%=product.getType()  %></option>
							<option>External Part</option>
							<option>Internal Part</option>
						</select>                        </div>
                      </div>
                      
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Grade</label>
						<select class="form-control" name="grade" value="<%= product.getGrade() %>" required>
							<option><%= product.getGrade() %></option>
							<option>A</option>
							<option>B</option>
							<option>C</option>
						</select>                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Brand</label>
						  <input class="form-control" type="text" name="brand" value="<%= product.getBrand() %>" required>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Modal</label>
						  <input class="form-control" type="text" name="modal" value="<%= product.getModal() %>"required>
                        </div>
                      </div>
                    </div>
                    <div class="row">

                      <div class="col-md-6">
                          <label class="bmd-label-floating">Image</label>
							<input type="file" name="imagePath" value="<%= product.getImagePath() %>" >
                      </div>
                      

                    </div>
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <div class="form-group">
                            <label class="bmd-label-floating">Price</label>
							<input type="number" name="Price" value="<%= product.getPrice() %>">
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <label>Product details</label>
                          <div class="form-group">
                            <label class="bmd-label-floating"> Please make sure all the fields are filled</label>
                          </div>
                        </div>
                      </div>
                    </div>
                    <input class="btn btn-primary btn-block" type="submit" name="submit" value="Submit Details">
                    <div class="clearfix"></div>
                  </form>
                </div>
              </div>
            </div>

          </div>
        </div>
      </div>

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
<%}
 else {
		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("/page/login.jsp");
		requestDispatcher.forward(request, response);
 }%>
</html>