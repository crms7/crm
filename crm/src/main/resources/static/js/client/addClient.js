$("#pickdate").change(function(e) {
    /**
     * bootstrapValidator 与日期控件混合使用验证不了表单的解决方法：
     * 在日期表单触发change方法时，执行刷新校验
     * clientForm ：Form表单
     * cr_Birthday：时间name属性
     */
    $('#clientForm').data('bootstrapValidator')
        .updateStatus('cr_Birthday','NOT_VALIDATED',null)
        .validateField('cr_Birthday');
});
$(function(){
    $.ajax({
        url:"/client/getCode",
        type:"post",
        dataType:"json",
        success:function(data){
           $("input[name='cr_ClientCode']").val(data);
        }
        });
});
/**
 * 添加用户
 * @returns {boolean}
 */
function addClient(){
    $.ajax({
        url:"/client/addClient",
        data:$("#clientForm").serialize(),
        type:"post",
        dataType:"json",
        success:function(data){
            if(data>0){
                $("#sub").attr("disabled","disabled");
                $.notify({
                    offset: "200",
                    message: "添加成功"
                },{
                    type:"success"
                })
                window.setTimeout("window.location.href='/jumps/client-resource'",2000);
            }else{
                $("#back").attr("disabled","disabled");
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

<!--表单验证-->

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
            }
        }
    }).on('success.form.bv',function(e) {
        e.preventDefault();
        addClient();
    })
});