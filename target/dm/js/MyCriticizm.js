$(document).ready(function () {
    $("#login_btn").click(function () {
        if ($('#username').val() == '' || $('#username').val() == 'null') {
            alert('请填写用户名');
            return false;
        }
        if ($('#password').val() == '' || $('#password').val() == 'null') {
            alert('密码不能为空');
            return false;
        }
        if ($('#password').val() != '' && $('#username').val() != '') {
            $.ajax({
                url: "/login.action",
                data: {
                    "username": $('#username').val(),
                    "password": $('#password').val()
                },
                //回调函数编写业务逻辑
                success: function (data) {
                    //接收后台返回的结果
                    $("modal-dialog").html(data);
                    console.log(data);
                    if (data == "true") {
                        // alert('username : '+data.username+'\n password : '+data.password);
                        $('#welcomeSpan').text("欢迎 " + $('#username').val() + " 登录答辩评分系统！");
                        $('#loginDialog').modal('hide');
                    } else {
                        alert("对不起，用户名或密码错误!");
                    }
                },

            });
        }
    });
    //
    // $.get('/datadictionaries/items/department', function(data) {
    //     $.each(data, function (i, v) {
    //         $('#departmentSelect').append('<option value=' + v.value + '>' + v.text + "</option>");
    //     });
    // });
});