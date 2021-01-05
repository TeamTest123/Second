<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title> 后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	function openTab(){
		$('#tt').tabs(
				'add',
				{
					title : "用户信息管理",
					//href : 'Singer.html',//href引入子页面存在Bug，设计有缺陷
					//子框架，用于在框架中打开另一个页面
					content : "<iframe src='User.html' style='border:0px' "
							+ "width='100%' height='100%'> </iframe>",
					closable : true
				});
	}
	function openTab1() {
		$('#tt').tabs(
				'add',
				{
					title : "商品信息查询",
					//子框架，用于在框架中打开另一个页面
					content : "<iframe src='product.html' style='border:0px' "
							+ "width='100%' height='100%'> </iframe>",
					closable : true
				});
	}
	
	function openTab2() {
		$('#tt').tabs(
				'add',
				{
					title : "商品信息添加",
					//子框架，用于在框架中打开另一个页面
					content : "<iframe src='addProduct.html' style='border:0px' "
							+ "width='100%' height='100%'> </iframe>",
					closable : true
				});
	}
	
	function openTab4() {
		$('#tt').tabs(
				'add',
				{
					title : "管理管理员",
					//子框架，用于在框架中打开另一个页面
					content : "<iframe src='admin.html' style='border:0px' "
							+ "width='100%' height='100%'> </iframe>",
					closable : true
				});
	}
	


</script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="#" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="#">首页</a></li>
                <li><a href="../index.html" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="../account.html">管理员</a></li>
                <li><a href="../index.html">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="admin_user.jsp"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                        <li><a href="admin_product.jsp"><i class="icon-font">&#xe005;</i>商品管理</a></li>
                        <li><a href="admin_adproduct.jsp"><i class="icon-font">&#xe0012;</i>商品添加</a></li>
                        <li><a href="admin_admin.jsp"><i class="icon-font">&#xe006;</i>管理员管理</a></li>
                        <li><a href="admin_order.jsp"><i class="icon-font">&#xe004;</i>订单管理</a></li>
                    </ul>
                </li>
               
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎来到商城管理后台。</span></div>
        </div>
        
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">操作系统</label><span class="res-info">WINNT</span>
                    </li>
                    <li>
                        <label class="res-lab">运行环境</label><span class="res-info">Apache/2.2.21 (Win64) PHP/7.3.10</span>
                    </li>
                    <li>
                        <label class="res-lab">PHP运行方式</label><span class="res-info">apache2handler</span>
                    </li>
                    <li>
                        <label class="res-lab">静静设计-版本</label><span class="res-info">v-0.1</span>
                    </li>
                    <li>
                        <label class="res-lab">上传附件限制</label><span class="res-info">2M</span>
                    </li>
                    <li>
                        <label class="res-lab">北京时间</label><span class="res-info">2019年3月18日 21:08:24</span>
                    </li>
                    <li>
                        <label class="res-lab">服务器域名/IP</label><span class="res-info">localhost [ 127.0.0.1 ]</span>
                    </li>
                    <li>
                        <label class="res-lab">Host</label><span class="res-info">127.0.0.1</span>
                    </li>
                </ul>
            </div>
        </div>
        
    </div>
    <!--/main-->
</div>
</body>
</html>