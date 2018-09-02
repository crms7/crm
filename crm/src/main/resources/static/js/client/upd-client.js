$(function(){
    $('#clientForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            'cr_ClientCode': {
                validators: {
                    notEmpty: {
                        message: '输入的用户编码不能为空!'
                    }
                }
            }, 'cr_Phone': {
                validators: {
                    notEmpty: {
                        message: '输入的手机号不能为空!'
                    } , /*正则表达式*/
                    regexp: {
                        regexp: /^1[358]\d{9}$/,
                        message: '手机号格式不正确！ 如：以13、15、18开头 的11位号码'
                    }
                }
            }, 'cr_Email': {
                validators: {
                    notEmpty: {
                        message: '输入的邮箱不能为空!'
                    },
                    /*正则表达式*/
                    regexp: {
                        regexp: /^\w+@+\w+(\.[a-zA-Z]{2,3}){1,2}$/,
                        message: '邮箱格式不正确！如：web@SINA.com.cn或web@SINA.com'
                    }
                }
            }, 'cr_ClientName': {
                validators: {
                    notEmpty: {
                        message: '输入的客户姓名不能为空!'
                    }
                }
            }, 'cr_ClientCode': {
                validators: {
                    notEmpty: {
                        message: '输入的用户编码不能为空!'
                    }
                }
            }, 'cr_Status':  {
                validators: {
                    notEmpty: {
                        message: '请选择！'
                    }
                }
            },
            'cr_Type':  {
                validators: {
                    notEmpty: {
                        message: '请选择！'
                    }
                }
            } ,
            'cr_Birthday':  {
                validators: {
                    notEmpty: {
                        message: '请选择！'
                    }
                }
            },'cr_Remark': {
                validators: {
                    /*正则表达式*/
                    regexp: {
                        regexp: /^.{0,200}$/,
                        message: '最多输入200字！'
                    }
                }
            } ,'cr_Address': {
                validators: {
                    /*正则表达式*/
                    regexp: {
                        regexp: /^.{0,50}$/,
                        message: '最多输入50字！'
                    }
                }
            },'cr_WorkTelephone':  {
                validators: {
                    /*正则表达式*/
                    regexp: {
                        regexp: /\d{3}-\d{8}|\d{4}-\d{7}/,
                        message: '格式不正确！如：0511-4405222、021-87888822'
                    }
                }
            },'cr_HomeTelephone':  {
                validators: {
                    /*正则表达式*/
                    regexp: {
                        regexp: /\d{3}-\d{8}|\d{4}-\d{7}/,
                        message: '格式不正确！如：0511-4405222、021-87888822'
                    }
                }
            }
        }
    }).on('success.form.bv',function(e) {
        e.preventDefault();
        updClient();
    })
});

function updClient(){
    $.ajax({
        url:"/client/changeClient",
        data:$("#clientForm").serialize(),
        type:"post",
        dataType:"json",
        success:function(data){
            if(data>0){
                $("#sub").attr("disabled","disabled");
                $("#back").attr("disabled","disabled");
                $.notify({
                    offset: "200",
                    message: "修改成功"
                },{
                    type:"success"
                })
                window.setTimeout("window.location.href='/jumps/client-resource'",2000);
            }else{
                $.notify({
                    offset: "200",
                    message: "修改失败"
                },{
                    type:"danger"
                })
            }
        }
    })
    return false;
}
