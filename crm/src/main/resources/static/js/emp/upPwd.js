$(function(){
    $('#upForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            "newPwd": {
                validators: {
                    notEmpty: {
                        message: '新密码不能为空!'
                    },
                    regexp: {
                        regexp: /^[0-9a-zA-z.-]{2,8}$/,
                        message: '新密码只能是0-9,a-z,.,-组成的2-8位'
                    },
                },
            },
                "newPwd1": {
                    validators: {
                        notEmpty: {
                            message: '新密码不能为空!'
                        },
                        regexp: {
                            regexp: /^[0-9a-zA-z.-]{2,8}$/,
                            message: '确认密码只能是0-9,a-z,.,-组成的2-8位'
                        },
                    },
                },
                'e_Pwd': {
                    validators: {
                        notEmpty: {
                            message: '旧密码不能为空!'
                        },
                        regexp: {
                            regexp: /^[0-9a-zA-z.-]{2,8}$/,
                            message: '旧密码只能是0-9,a-z,.,-组成的2-8位'
                        },
                        remote: {
                            message: '旧密码不正确',
                            url: '/uppwdyz',
                            type: "post",
                            dataType: "json",
                            data: {
                                "e_Id": $("#upPwd_eId").val(),
                                "e_Pwd": $("#e_Pwd").val()
                            }, //这里默认会传递该验证字段的值到后端
                            delay: 2000 //这里特别要说明，必须要加此属性，否则用户输入一个字就会访问后台一次，会消耗大量的系统资源，
                        },
                    },
                },
        },
    }).on('success.form.bv',function(e) {
        e.preventDefault();
        // pwd();
            uppwd();
    })
});


// function pwd(){
//     $("#newPwd1").blur(function(){
//         var newPwd1 = $("#newPwd").val();
//         var newPwd2=$("#newPwd1").val();
//         if(newPwd2.trim()!=newPwd1.trim()){
//             console.log("两次密码不一样");
//             return false;
//         }else{
//             return true;
//         }
//     })
// }

function uppwd(){
    $.ajax({
        url:"/uppwd",
        type:"post",
        data:{
            "e_Id": $("#upPwd_eId").val(),
            "e_Pwd": $("#newPwd").val()
        },
        dataType:"json",
        success:function(data){
                if(data>0){
                    $.notify({
                        offset: "50",
                        message: "修改成功,请重新登录"
                    },{
                        type:"success"
                    });
                    window.setTimeout("window.location.href='/exit'",2000);
                }else{
                    $.notify({
                        offset: "50",
                        message: "修改失败"
                    },{
                        type:"danger"
                    });
                }
        }
    })
    return false;
}



// function oldPwd(){
//     $.ajax({
//         url:"/uppwd",
//         type:"post",
//         dataType:"json",
//         async:true,
//         data:{
//             "e_Id":$("#upPwd_eId").val(),
//             "e_Pwd":$("#oldPwd").val()
//         },
//         success:function(data){
//             if(data>0){
//                 console.log("旧密码正确");
//             }else{
//                 console.log("旧密码错误");
//             }
//         }
//     })
// }





