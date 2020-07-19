<%@page import="com.shop.dao.ProductDb"%>
<%@page import="com.shop.dao.SalesDao"%>
<%@page import="com.shop.model.Sales"%>
<%@page import="com.shop.model.User"%>


<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="${pageContext.request.contextPath}/assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
  <style>
 

</style>
<script>
//js for dropdown functionality
function myFunction() {
	  document.getElementById("myDropdown").classList.toggle("show");
	}

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
						//Authenticating the user session
			User user = (User)session.getAttribute("user");
		  if (user != null ){
		  
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
                  		<form action="AddSalesForm.jsp" method="POST"><input type="submit" value="Add Sales" class="btn btn-primary btn-block" >
                     	</form>         
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
      </nav>      <!-- End Navbar -->
      
      <%
      SalesDao salesDao = new SalesDao();
      ArrayList<Sales> salesList = salesDao.getSalesRecords();
      %>
       <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title ">Sales</h4>
                  <p class="card-category"> Sales Overview</p>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table">
                      <thead class=" text-primary">
                        <th>:</th>
                        <th>
                          Sales Id
                        </th>
                        <th>
                          Product Id
                        </th>
                        <th>
                          Customer Id
                        </th>
                        <th>
                          Quantity
                        </th>
                        <th>
                          Date
                        </th>
                        <th>
                          Total
                        </th>
                      </thead>
                      <tbody>
                      <%
                      for (Sales sales : salesList){
                      %>
                        <tr>
                        <td>
						 <li class="nav-item dropdown">
			                <a class="nav-link" href="javascript:;" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			                  <i class="material-icons">menu</i>
			                  <p class="d-lg-none d-md-block">
			                    Account
			                  </p>
			                </a>
			                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
								<form action="${pageContext.request.contextPath}/DeleteSalesServlet?salesid='<%=sales.getSalesId() %>'" method="post">
											                <button> DELETE</button> 
								
								</form>
							<form action="${pageContext.request.contextPath}/page/UpdateSalesForm.jsp?salesId='<%=sales.getSalesId()%>'" method="post">
											                <button> Update</button> 
								
								</form>
			                </div>
			              </li>
                        </td>
                    	<td><%=sales.getSalesId()%></td>
                    	<td><%=sales.getProductId() %></td>
                    	<td><%=sales.getCustomerId() %></td>
                    	<td><%=sales.getQuantity() %></td>
                    	<td><%=sales.getDate() %></td>
                    	<td><%=sales.getTotal() %></td>
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
    <script src="../assets/js/core/jquery.min.js"></script>
  <script src="../assets/js/core/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
</body>
  <script src="${pageContext.request.contextPath}/assets/js/core/bootstrap-material-design.min.js"></script>

<%}
 else {
		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("/page/login.jsp");
		requestDispatcher.forward(request, response);
 }%>
</html>