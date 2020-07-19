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
  
    .product-img{
	height: 200px;
    position: relative;
    padding: 10px 40px;
	
}
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
          <li class="nav-item active  ">
            <a class="nav-link" href="./dashboard.jsp">
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
              <p>Icons</p>
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
            <a class="navbar-brand" href="javascript:;">Dashboard</a>
                                  <div class="col-md-btn">
                  		<form action="addProductForm.jsp" method="POST"><input type="submit" value="Add Products" class="btn btn-primary btn-block" >
                     	</form>         
                      </div>
          </div>
        </div>
      </nav>


      <div class="content">
        <div class="container-fluid">
        	<% ProductDb productDb 			= new ProductDb();
	   		   ArrayList<Product> products  = productDb.getProducts();
	   		   int count = 0;
	   		   for(Product product : products){
	   			   if(count % 4 == 0){
	   		          out.write("<div class='row'>");

	   			   }
	   			   count++;
	   		   
			%>
            <div class="col-md-4" style="    flex: 0 0 25%; max-width: 25%;">
              <div class="card card-chart">
         
                   <img class="product-img" src="<%=product.getImagePath()%>"/>
                <div class="card-body">
                  <h4 class="card-title">Product Id <%=product.getProductId() %></h4>
                  <p class="card-category">Product Name : <%=product.getProductName() %></p>
                  <p class="card-category">Grade : <%=product.getGrade() %></p>
                  <p class="card-category">Type : <%=product.getType() %></p>
                  <p class="card-category">Modal : <%=product.getModal() %></p>
                  <p class="card-category">Brand : <%=product.getBrand() %></p>
                  <p class="card-category">Price : <%=product.getPrice() %></p>
                  
                </div>
                <div class="card-footer">
                      <div class="col-md-btn">
                  		<form action="UpdateProductForm?productId='<%= product.getProductId() %>'" method="POST"><input type="submit" value="update" class="btn btn-primary btn-block" >
                     	</form>         
                      </div>
                      <div class="col-md-btn">      	
                     	<form action="..\DeleteProductServlet?productId='<%= product.getProductId() %>'" method="POST"><input type="submit" value="Delete" class="btn btn-primary btn-block" >
                     	</form>
                      </div>
                </div>
              </div>
            </div>
			<%
			if (count % 4 == 0){
		          out.write("</div>");	
			}
			}
			%>

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