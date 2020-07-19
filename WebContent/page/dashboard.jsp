<%@page import="java.util.HashMap"%>
<%@page import="com.shop.dao.ProductDb"%>
<%@page import="com.shop.util.DashUtill"%>
<%@page import="com.shop.model.User"%>

<%@page import="java.util.ArrayList"%>

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
            <a class="nav-link" href="${pageContext.request.contextPath}/page/Customers.jsp">
              <i class="material-icons">bubble_chart</i>
              <p>Customers</p>
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
          </div>
        </div>
      </nav>
      
      <!-- End Navbar -->
      <div class="content">
        <div class="container-fluid">
                  <%
              	  HashMap<String,String> dashboardData ;
                  DashUtill dashUtill = new DashUtill();
                  dashboardData = dashUtill.getDashBoardData();
                  %>
          <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-success card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">store</i>
                  </div>                 
                  <p class="card-category">Daily Sales</p>
                  <h3 class="card-title">$<%=dashboardData.get("dailySales") %>
                  </h3>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">date_range</i> Last 7 days
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-success card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">store</i>
                  </div>
                  <p class="card-category">Weekly Sales</p>
                  <h3 class="card-title">$<%=dashboardData.get("weeklySales") %></h3>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">date_range</i> Last 7 days
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-success card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">store</i>
                  </div>                 
                  <p class="card-category">Monthly Sales</p>
                  <h3 class="card-title">$<%=dashboardData.get("monthlySales") %>
                  </h3>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">date_range</i> Last Month
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row" style="background-color:white">
            <div class="col-md-4">
              <div class="card card-chart" style="height: 500px">
                <div class="card-header card-header-success" style="margin-top: 0px;background: linear-gradient(60deg,white ,white )" b>
					<div id="chartContainer" style="height: 300px; width: 100%;"></div>
					
                </div>
                <div class="card-body">
                  <h4 class="card-title">Product Grades</h4>
                  <p class="card-category">
                    <span class="text-success"><i class="fa fa-long-arrow-up"></i>  </span> Types Of Products</p>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">access_time</i> updated 4 minutes ago
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card card-chart" >
          <div id="columnchart_material" style="width: 800px; height: 500px;"></div>

                </div>
              </div>
            </div>

            <div class="col-md-4">
              <div class="card card-chart">
                <div class="card-header card-header-warning">
                  <div class="ct-chart" id="websiteViewsChart"></div>
                </div>
                <div class="card-body">
                  <h4 class="card-title">Email Subscriptions</h4>
                  <p class="card-category">Last Campaign Performance</p>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">access_time</i> campaign sent 2 days ago
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card card-chart">
                <div class="card-header card-header-danger">
                  <div class="ct-chart" id="completedTasksChart"></div>
                </div>
                <div class="card-body">
                  <h4 class="card-title">Completed Tasks</h4>
                  <p class="card-category">Last Campaign Performance</p>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">access_time</i> campaign sent 2 days ago
                  </div>
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

  <!--   Core JS Files   -->
-----------deleted-------

---------------------deleted----------
  <script src="${pageContext.request.contextPath}/assets/js/material-dashboard.js?v=2.1.2" type="text/javascript"></script>
  <%
  ProductDb productDb = new ProductDb();
  ArrayList<Integer> list = new ArrayList<Integer>();
  list = productDb.getGradeForChart();
  %>
  <script type="text/javascript">
window.onload = function () {
	var chart = new CanvasJS.Chart("chartContainer",
	{

		legend: {
			maxWidth: 350,
			itemWidth: 120
		},
		data: [
		{
			type: "pie",
			showInLegend: true,
			legendText: "{indexLabel}",
			dataPoints: [
				{ y: <%=list.get(0)%>, indexLabel: "Grade A" },
				{ y: <%=list.get(1)%>, indexLabel: "Grade B" },
				{ y: <%=list.get(2)%>, indexLabel: "Grade C" },

			]
		}
		]
	});
	chart.render();
}
</script>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Day', 'Sales'],
          ['Monday', <%=dashboardData.get("MondaySales") %> ],
          ['Tuesday',  <%=dashboardData.get("TuesdaySales") %>],
          ['Wednesday', <%=dashboardData.get("WednesdaySales") %>],
          ['Thursday',  <%=dashboardData.get("ThursdaySales") %>],
          ['Friday',  <%=dashboardData.get("FridaySales") %>],
          ['Saturday', <%=dashboardData.get("SaturdaySales") %>],
          ['Sunday',  <%=dashboardData.get("SundaySales") %>]
        ]);

        var options = {
          chart: {
            title: 'Company Performance',
            subtitle: 'Week\'s Sales',
          }
        };

        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
    </script>



<script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
  
  
</body>
<%}
 else {
		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("/page/login.jsp");
		requestDispatcher.forward(request, response);
 }%>
</html>