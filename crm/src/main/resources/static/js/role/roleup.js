$(function(){
    $('#formId').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            'rm_Code': {
                validators: {
                    notEmpty: {
                        message: '输入的角色编码不能为空!'
                    },
                    regexp: {
                        regexp:  /^[A-Za-z]{2,18}$/,
                        message: '角色编码只能是2-18位字母'
                    },
                    remote: {
                                message: '编码已存在',
                                url: '/roleExits',
                                type:"post",
                                dataType:"json",
                                data:{
                                    "id":$("#roleId").val(),
                                    },  //这里默认会传递该验证字段的值到后端
                                delay:2000 //这里特别要说明，必须要加此属性，否则用户输入一个字就会访问后台一次，会消耗大量的系统资源，
                             },
                },
            }, 'rm_Name': {
                validators: {
                    notEmpty: {
                        message: '输入的角色名称不能为空!'
                    } ,
                    /*正则表达式*/
                    regexp: {
                        regexp:  /^[\u4e00-\u9fa5]{2,8}$/,
                        message: '角色名称只能是2-8位的中文字符,'
                    },
                    remote: {
                        message: '名称已存在',
                        url: '/roleExits',
                        type:"post",
                        dataType:"json",
                        data:{
                            "id":$("#roleId").val(),
                        },  //这里默认会传递该验证字段的值到后端
                        delay:2000 //这里特别要说明，必须要加此属性，否则用户输入一个字就会访问后台一次，会消耗大量的系统资源，
                    },
                }
            }
        }
    }).on('success.form.bv',function(e) {
        e.preventDefault();
        upRoleInfo();
    })
});



function  upRoleInfo(){
        $.ajax({
            url:"/updateRole",
            data:$("#formId").serialize(),
            type:"post",
            dataType:"json",
            success:function(data){
                if(data){
                    $("#sub").attr("disabled","disabled");
                    $.notify({
                        offset: "50",
                        message: "修改成功"
                    },{
                        type:"success"
                    });
                    window.setTimeout("window.location.href='/jumps/role-manage'",2000);
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
