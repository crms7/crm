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
/**
 * 获取客户编号
 */
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
                $("#back").attr("disabled","disabled");
                $(".app-menu").attr("disabled","disabled");
                $.notify({
                    offset: "200",
                    message: "添加成功"
                },{
                    type:"success"
                })
                window.setTimeout("window.location.href='/jumps/client-resource'",2000);
            }else{
                $.notify({
                    offset: "200",
                    message: "添加失败"
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
                    },
                    regexp: {
                        regexp: /^[\u4e00-\u9fa5]{2,4}$/,
                            message: '只能2-4个是汉字组成！'
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
            ,'cr_Remark': {
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
            }
        }
    }).on('success.form.bv',function(e) {
        e.preventDefault();
        addClient();
    })
});

/*获取分配状态下拉框的值*/
$(document).ready(function (){
    $.ajax({
        url:"/dataDict/getAllocaionState",
        type:"post",
        dataType:"json",
        success:function(data){
            if(null!=data){
                for(var i = 0; i < data.length; i++){
                    if(data[i].typeName=='客户类型'){
                        $("#clientType").append("<option name='dataDictName'  value='"+data[i].valueId+"'>"+data[i].valueName+"</option>");
                    }else if(data[i].typeName=='客户状态'){
                        $("#clientStatus").append("<option name='dataDictName' value='"+data[i].valueId+"'>"+data[i].valueName+"</option>");
                    }
                }
            }
        }
    });
});