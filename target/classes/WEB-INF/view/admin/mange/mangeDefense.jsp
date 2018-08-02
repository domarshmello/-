<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>答辩评分项细则</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="admin/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- font Awesome -->
    <link href="admin/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Ionicons -->
    <link href="admin/css/ionicons.min.css" rel="stylesheet" type="text/css"/>
    <!-- Morris chart -->
    <link href="/admin/css/morris/morris.css" rel="stylesheet" type="text/css"/>
    <!-- jvectormap -->
    <link href="admin/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css"/>
    <!-- Date Picker -->
    <link href="admin/css/datepicker/datepicker3.css" rel="stylesheet" type="text/css"/>
    <!-- fullCalendar -->
    <!-- <link href="css/fullcalendar/fullcalendar.css" rel="stylesheet" tytexttext/css" /> -->
    <!-- Daterange picker -->
    <link href="admin/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
    <!-- iCheck for checkboxes and radio inputs -->
    <link href="admin/css/iCheck/all.css" rel="stylesheet" type="text/css"/>
    <!-- bootstrap wysihtmltexttext editor -->
    <!-- <link href="css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" tytexttext/css" /> -->
    <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <!-- Theme style -->
    <link href="admin/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>


    <style type="text/css">

    </style>
</head>

<body class="skin-black">
<sec:authentication property="principal" var="principal"/>
<!-- header logo: style can be found in header.less -->
<header class="header">
    <a href="${pageContext.request.contextPath}/" class="logo">
        答辩评分管理系统
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">导航栏</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <div class="navbar-right">
            <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->
                <li class="dropdown messages-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-envelope"></i>
                        <span class="label label-success">3</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">You have 3 messages</li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li><!-- start message -->
                                    <a href="#">
                                        <div class="pull-left">
                                            <img src="admin/img/26115.jpg" class="img-circle" alt="User Image"/>
                                        </div>
                                        <h4>
                                            Support Team
                                        </h4>
                                        <p>Why not buy a new awesome theme?</p>
                                        <small class="pull-right"><i class="fa fa-clock-o"></i> 5 mins</small>
                                    </a>
                                </li><!-- end message -->
                                <li>
                                    <a href="#">
                                        <div class="pull-left">
                                            <img src="admin/img/26115.jpg" class="img-circle" alt="user image"/>
                                        </div>
                                        <h4>
                                            Sales Department

                                        </h4>
                                        <p>Why not buy a new awesome theme?</p>
                                        <small class="pull-right"><i class="fa fa-clock-o"></i> Yesterday</small>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <div class="pull-left">
                                            <img src="admin/img/avatar.png" class="img-circle" alt="user image"/>
                                        </div>
                                        <h4>
                                            Reviewers

                                        </h4>
                                        <p>Why not buy a new awesome theme?</p>
                                        <small class="pull-right"><i class="fa fa-clock-o"></i> 2 days</small>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="footer"><a href="#">See All Messages</a></li>
                    </ul>
                </li>
                <li class="dropdown tasks-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-tasks"></i>
                        <span class="label label-danger">2</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">You have 2 tasks</li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li><!-- Task item -->
                                    <a href="#">
                                        <h3>
                                            Design some buttons
                                            <small class="pull-right">20%</small>
                                        </h3>
                                        <div class="progress progress-striped xs">
                                            <div class="progress-bar progress-bar-success" style="width: 20%"
                                                 role="progressbar" aria-valuenow="20" aria-valuemin="0"
                                                 aria-valuemax="100">
                                                <span class="sr-only">20% Complete</span>
                                            </div>
                                        </div>
                                    </a>
                                </li><!-- end task item -->
                                <li><!-- Task item -->
                                    <a href="#">
                                        <h3>
                                            Create a nice theme
                                            <small class="pull-right">40%</small>
                                        </h3>
                                        <div class="progress progress-striped xs">
                                            <div class="progress-bar progress-bar-danger" style="width: 40%"
                                                 role="progressbar" aria-valuenow="20" aria-valuemin="0"
                                                 aria-valuemax="100">
                                                <span class="sr-only">40% Complete</span>
                                            </div>
                                        </div>
                                    </a>
                                </li><!-- end task item -->


                            </ul>
                        </li>
                        <li class="footer">
                            <a href="#">View all tasks</a>
                        </li>
                    </ul>
                </li>
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-user"></i>
                        <span>用户名：${principal.username}<i class="caret"></i></span>
                    </a>
                    <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
                        <li class="dropdown-header text-center">账号中心</li>
                        <%--账号中心下拉菜单--%>
                        <li>
                            <a href="${pageContext.request.contextPath}/login.action"><i
                                    class="fa fa-magnet fa-fw pull-right"></i>
                                <span class="badge badge-info pull-right">1</span> 登录</a>

                            <a href="${pageContext.request.contextPath}/">
                                <i class="fa fa-user fa-fw pull-right"></i>
                                首页
                            </a>
                        </li>
                        <li class="divider"></li>

                        <li>
                            <a href="javascript:document:logoutForm.submit();"><i
                                    class="fa fa-ban fa-fw pull-right"></i>退出登录</a>
                        </li>
                        <li class="divider"></li>

                        <li>
                            <a href="#">
                                <i class="fa fa-clock-o fa-fw pull-right"></i>
                                <span class="badge badge-success pull-right">10</span> 提醒 </a>

                            <a data-toggle="modal" href="#modal-user-settings">
                                <i class="fa fa-cog fa-fw pull-right"></i>
                                设置
                            </a>
                        </li>

                    </ul>
                </li>
            </ul>

            <form id="logoutForm" action="/logout" method="post">
            </form>
        </div>
    </nav>
</header>

<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="left-side sidebar-offcanvas">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <%--管理员头像--%>
                    <img src="admin/img/26115.jpg" class="img-circle" alt="User Image"/>
                </div>
                <div class="pull-left info">
                    <p> hello , ${principal.username}</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <%--搜索框--%>

            <%--<!-- search form -->--%>
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search..."/>
                    <span class="input-group-btn">
                                        <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i
                                                class="fa fa-search"></i></button>
                    </span>
                </div>
            </form>
            <%--<!-- /.search form -->--%>

            <!-- sidebar menu: : style can be foundsear in sidebar.less -->
            <ul class="sidebar-menu">
                <%--booststrap手风琴效果下拉菜单--%>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel-group" id="panel-1">
                                <%--学生管理目录导航栏--%>

                                <sec:authorize access="hasAuthority('ADMIN')">
                                    <%--学生管理模块--%>
                                    <div class="panel panel-default">
                                        <div class="panel-heading">

                                            <a class="panel-title collapsed" data-toggle="collapse"
                                               data-parent="#panel-1"
                                               href="#panel-element-1" style="color: black">
                                                <i class="fa fa-dashboard"></i> <span>学生管理</span>
                                            </a>

                                        </div>
                                        <div id="panel-element-1" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <a href="${pageContext.request.contextPath}/queryStudent.do"
                                                   style="color:black">学生列表</a>
                                            </div>
                                            <div class="panel-body">
                                                <a href="${pageContext.request.contextPath}/studentAddView.do"
                                                   style="color:black">添加学生</a>
                                            </div>
                                        </div>
                                    </div>
                                </sec:authorize>
                                <%--答辩主题管理目录导航栏--%>
                                <sec:authorize access="hasAuthority('TEACHER')">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">

                                            <a class="panel-title collapsed" data-toggle="collapse"
                                               data-parent="#panel-1"
                                               href="#panel-element-2" style="color: black">
                                                <i class="fa fa-gavel"></i> <span>辩题管理</span>
                                            </a>

                                        </div>
                                        <div id="panel-element-2" class="panel-collapse collapse">
                                                <%--<div class="panel-body">--%>
                                                <%--<a href="${pageContext.request.contextPath}/SubjectAdd" style="color:black">添加主题</a>--%>
                                                <%--</div>--%>
                                            <div class="panel-body">
                                                <a href="${pageContext.request.contextPath}/SubjectList.action"
                                                   style="color:black">答辩主题列表</a>
                                            </div>
                                            <div class="panel-body">
                                                <a href="${pageContext.request.contextPath}/setDefense.action"
                                                   style="color:black"> 发布答辩</a>

                                            </div>
                                        </div>
                                    </div>
                                </sec:authorize>

                                <sec:authorize access="hasAuthority('ADMIN')">
                                    <%--教师管理目录导航栏--%>
                                    <div class="panel panel-default">
                                        <div class="panel-heading">

                                            <a class="panel-title collapsed" data-toggle="collapse"
                                               data-parent="#panel-1"
                                               href="#panel-element-3" style="color: black">
                                                <i class="fa fa-globe"></i> <span>任课教师管理</span>
                                            </a>

                                        </div>
                                        <div id="panel-element-3" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <a href="${pageContext.request.contextPath}/teacherList.do"
                                                   style="color:black">教师列表</a>
                                            </div>
                                            <div class="panel-body">
                                                <a href="${pageContext.request.contextPath}/teacherAddView.do"
                                                   style="color:black">添加教师</a>
                                            </div>

                                        </div>
                                    </div>
                                </sec:authorize>
                                <sec:authorize access="hasAuthority('TEACHER')">
                                    <%--答辩状态管理目录导航栏--%>
                                    <div class="panel panel-default">
                                        <div class="panel-heading">

                                            <a class="panel-title collapsed" data-toggle="collapse"
                                               data-parent="#panel-1"
                                               href="#panel-element-5" style="color: black">
                                                <i class="fa fa-gavel"></i> <span>答辩管理</span>
                                            </a>

                                        </div>
                                        <div id="panel-element-5" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <a href="${pageContext.request.contextPath}/setDefense.action"
                                                   style="color:black">创建答辩</a>
                                            </div>
                                            <div class="panel-body">
                                                <a href="${pageContext.request.contextPath}/defenseList.do"
                                                   style="color:black">管理答辩</a>
                                            </div>
                                        </div>
                                    </div>
                                </sec:authorize>
                                <sec:authorize access="hasAuthority('STUDENT')">
                                    <%--学生查看答辩--%>
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <a class="panel-title collapsed" data-toggle="collapse"
                                               data-parent="#panel-1"
                                               href="#panel-element-6" style="color: black">
                                                <i class="fa fa-gavel"></i> <span>学生查看答辩</span>
                                            </a>
                                        </div>
                                        <div id="panel-element-6" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <a href="${pageContext.request.contextPath}/defenseList.do"
                                                   style="color:black">查看答辩分数</a>
                                            </div>
                                        </div>
                                    </div>
                                </sec:authorize>
                            </div>

                        </div>
                    </div>
                </div>


            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <div class="copyrights"><a href="#">dodo studio</a></div>

    <aside class="right-side">

        <!-- Main content -->
        <section class="content">

            <div class="row" style="margin-bottom:5px;">
                <div class="col-md-3">
                    <div class="sm-st clearfix">
                        <span class="sm-st-icon st-red"><i class="fa fa-check-square-o"></i></span>
                        <div class="sm-st-info">

                            <span>32</span>
                            <a href="${pageContext.request.contextPath}/setDefense.action">发布答辩</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="sm-st clearfix">
                        <span class="sm-st-icon st-violet"><i class="fa fa-envelope-o"></i></span>
                        <div class="sm-st-info">
                            <span>22</span>
                            <a href="${pageContext.request.contextPath}/mangeDefenseView.action"> 评分项管理</a>

                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="sm-st clearfix">
                        <span class="sm-st-icon st-blue"><i class="fa fa-dollar"></i></span>
                        <div class="sm-st-info">
                            <span>100</span>
                            <a href="${pageContext.request.contextPath}/mangeMembersScoreView.action">评分委员管理</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="sm-st clearfix">
                        <span class="sm-st-icon st-green"><i class="fa fa-paperclip"></i></span>
                        <div class="sm-st-info">
                            <span>456</span>
                            <a href="${pageContext.request.contextPath}/defenseList.do">成绩管理</a>
                        </div>
                    </div>
                </div>
            </div>


            <!-- Main content -->
            <section class="content">

                <div class="row" style="margin-bottom:5px;">
                    <div class="col-md-12">
                        <!--breadcrumbs start -->
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i>主页 </a></li>
                            <%--<li><a href="#">答辩管理</a></li>--%>
                            <li class="active">评分项目管理</li>
                        </ul>
                        <!--breadcrumbs end -->
                        <div class="panel">

                            <header class="panel-heading">
                                答辩评分项
                            </header>

                            <div class="panel-body">
                                <form class="form-horizontal" role="form" id="setDefen" method="post"
                                      action="${pageContext.request.contextPath}/setDefense..action">
                                    <div class="form-group">

                                        <div class="col-lg-offset-2 col-lg-10">
                                            <table align="center">
                                                <label>答辩评分项:</br> </br>
                                                    <input class="btn btn-danger" value="评委提问"></br></br>
                                                    <input class="btn btn-danger" value="临场反应"></br></br>
                                                    <input class="btn btn-danger" value="精神面貌"></br></br>
                                                    <input class="btn btn-danger" value="答辩内容"></br></br>
                                                    <input class="btn btn-danger" value="论文质量"></br></br>
                                                    <input class="btn btn-danger" value="综合印象"></br></br>
                                                    <input class="btn btn-danger" value="答辩能力水平"></br></br>
                                                    <input class="btn btn-danger" value="答辩仪表"></br></br>
                                                </label>

                                            </table>

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-10">
                                            <button type="submit" class="btn btn-danger">请 注 意 查 看 答 辩 评 分 的 得 分 点 哦 ！ ！
                                                ！
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </section>
            <!-- row end -->
        </section><!-- /.content -->
        <div class="footer-main">
    <a href="#" target="_blank"> 答辩评分系统管理中心 -- domian studio</a>
        </div>
</aside><!-- /.right-side -->

</div><!-- ./wrapper -->


<!-- jQuery 2.0.2 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="admin/js/jquery.min.js" type="text/javascript"></script>

<!-- jQuery UI 1.10.3 -->
<script src="admin/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
<!-- Bootstrap -->
<script src="admin/js/bootstrap.min.js" type="text/javascript"></script>
<!-- daterangepicker -->
<script src="admin/js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>

<script src="admin/js/plugins/chart.js" type="text/javascript"></script>

<!-- datepicker
<script src="js/plugins/datepicker/bootstrap-datepicker.js" tytexttext/javascript"></script>-->
<!-- Bootstrap WYSIHTML5
<script src="js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" tytexttext/javascript"></script>-->
<!-- iCheck -->
<script src="admin/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
<!-- calendar -->
<script src="admin/js/plugins/fullcalendar/fullcalendar.js" type="text/javascript"></script>

<!-- Director App -->
<script src="admin/js/Director/app.js" type="text/javascript"></script>

<!-- Director dashboard demo (This is only for demo purposes) -->
<script src="admin/js/Director/dashboard.js" type="text/javascript"></script>

<!-- Director for demo purposes -->
<script type="text/javascript">
    $('input').on('ifChecked', function (event) {
        // var element = $(this).parent().find('input:checkbox:first');
        // element.parent().parent().parent().addClass('highlight');
        $(this).parents('li').addClass("task-done");
        console.log('ok');
    });
    $('input').on('ifUnchecked', function (event) {
        // var element = $(this).parent().find('input:checkbox:first');
        // element.parent().parent().parent().removeClass('highlight');
        $(this).parents('li').removeClass("task-done");
        console.log('not');
    });

</script>
<script>
    $('#noti-box').slimScroll({
        height: '400px',
        size: '5px',
        BorderRadius: '5px'
    });

    $('input[type="checkbox"].flat-grey, input[type="radio"].flat-grey').iCheck({
        checkboxClass: 'icheckbox_flat-grey',
        radioClass: 'iradio_flat-grey'
    });
</script>
<script type="text/javascript">
    $(function () {
        "use strict";
        //BAR CHART
        var data = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    label: "My First dataset",
                    fillColor: "rgba(220,220,220,0.2)",
                    strokeColor: "rgba(220,220,220,1)",
                    pointColor: "rgba(220,220,220,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(220,220,220,1)",
                    data: [65, 59, 80, 81, 56, 55, 40]
                },
                {
                    label: "My Second dataset",
                    fillColor: "rgba(151,187,205,0.2)",
                    strokeColor: "rgba(151,187,205,1)",
                    pointColor: "rgba(151,187,205,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(151,187,205,1)",
                    data: [28, 48, 40, 19, 86, 27, 90]
                }
            ]
        };
        new Chart(document.getElementById("linechart").getContext("2d")).Line(data, {
            responsive: true,
            maintainAspectRatio: false,
        });

    });

</script>
</body>
</html>