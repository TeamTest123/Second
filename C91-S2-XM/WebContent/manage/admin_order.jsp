<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
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
function fmtcz(value,row,index){
	//函数的值会被解析成html元素
	return "<button onclick='del("+index+")'>删除</button>";
}
function del(index){
	$.messager.confirm('系统提示','您想要删除该用户信息吗？',function(r){
		if(r){
			//根据Index删除记录
			//根据index获取当前行的uid
			var rows=$("#table").datagrid('getRows');
			var uid=rows[index].uid;
			//发起Ajax删除数据的记录
			//调用ajax请求方法删除歌手信息
			//JQuery的post方法3个参数url，params,回调函数
			var url="../DeleteUser.s";
			var params={uid:uid};
			
			function callback(data){ //data:Servlet返回的数据
				//刷新表格数据
				$("#table").datagrid('reload');
				$.messager.show({
					title:'系统提示',
					msg:data,
					timeout:5000,//5秒
					showType:'slide'
				});
			
		}
			$.post(url,params,callback);
		}
	});
}

function save(){
	$('#ff').form('submit',{
		url:"../CreateUser.s",
		success:function(data){
			$("#table").datagrid('reload');
			$.messager.show({
				title:'系统提示',
				msg:data,
				timeout:5000,//5秒
				showType:'slide'
			});
		}
		
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
                <li><a href="../index.html" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="../account.html">退出</a></li>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="../index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
        </div>
        <div class="result-wrap">
            
                
               
		<iframe src="../后台管理/orders.html" width="100%" height="600px"></iframe>
	
	</div>
            </form>
        </div>
    
    
    </div>
    <!--/main-->
</div>
</body>
</html>