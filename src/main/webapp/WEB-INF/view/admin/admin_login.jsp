<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width"/>
    <title>管理员登录</title>
    <script src="~/Plugins/easyui-1.4.4/jquery.min.js"></script>
    <script src="~/Plugins/easyui-1.4.4/jquery.easyui.min.js"></script>
    <link href="~/Plugins/easyui-1.4.4/themes/gray/easyui.css" rel="stylesheet"/>
    <link href="~/Plugins/easyui-1.4.4/themes/icon.css" rel="stylesheet"/>
    <script type="text/javascript">
        document.onkeydown = function (e) {
            var event = e || window.event;
            var code = event.keyCode || event.which || event.charCode;
            if (code == 13) {
                login();
            }
        }
        $(function () {
            $("input[name='login']").focus();
        });
        function cleardata() {
            $('#loginForm').form('clear');
        }
        function login() {
            if ($("input[name='login']").val() == "" || $("input[name='password']").val() == "") {
                $("#showMsg").html("用户名或密码为空，请输入");
                $("input[name='login']").focus();
            } else {
                //ajax异步提交
                $.ajax({
                    type: "POST",   //post提交方式默认是get
                    url: "login.action",
                    data: $("#loginForm").serialize(),   //序列化
                    error: function (request) {      // 设置表单提交出错
                        $("#showMsg").html(request);  //登录错误提示信息
                    },
                    success: function (data) {
                        document.location = "index.action";
                    }
                });
            }
        }
    </script>
</head>
<body>
<div id="loginWin" class="easyui-window" title="登录" style="width:350px;height:188px;padding:5px;"
     minimizable="false" maximizable="false" resizable="false" collapsible="false">
    <div class="easyui-layout" fit="true">
        <div region="center" border="false" style="padding:5px;background:#fff;border:1px solid #ccc;">
            <form id="loginForm" method="post">
                <div style="padding:5px 0;">
                    <label for="login">帐号:</label>
                    <input type="text" name="login" style="width:260px;"/>
                </div>
                <div style="padding:5px 0;">
                    <label for="password">密码:</label>
                    <input type="password" name="password" style="width:260px;"/>
                </div>
                <div style="padding:5px 0;text-align: center;color: red;" id="showMsg"></div>
            </form>
        </div>
        <div region="south" border="false" style="text-align:right;padding:5px 0;">
            <a class="easyui-linkbutton" iconcls="icon-ok" href="javascript:void(0)" onclick="login()">登录</a>
        </div>
    </div>
</div>
</body>
</html>


