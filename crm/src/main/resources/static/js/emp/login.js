$(function(){
    $('#loginform').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            'e_LoginId': {
                validators: {
                    notEmpty: {
                        message: '账号不能为空'
                    },
                },
            }, 'e_Pwd': {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    } ,
                }
            }
        }
    }).on('success.form.bv',function(e) {
        e.preventDefault();
        login();
    })
});

function login(){
    $.ajax({
        url:"/loginTo",
        type:"post",
        dataType:"json",
        data: $("#loginform").serialize(),
        success:function(data){
            if(data>0){
                $("#login").attr("disabled","disabled");
                $.notify({
                    offset: "50",
                    message: "登录成功"
                },{
                    type:"success"
                });
                window.setTimeout("window.location.href='/jumps/index'",2000);
            }else{
                $.notify({
                    offset: "50",
                    message: "账号或密码错误"
                },{
                    type:"danger"
                });
            }
        }
    })
}

