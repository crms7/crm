$("#pickdate").change(function(e) {
    /**
     * bootstrapValidator 与日期控件混合使用验证不了表单的解决方法：
     * 在日期表单触发change方法时，执行刷新校验
     * clientForm ：Form表单
     * cr_Birthday：时间name属性
     */
    $('#progressForm').data('bootstrapValidator')
        .updateStatus('cp_PlanMonth','NOT_VALIDATED',null)
        .validateField('cp_PlanMonth');
});

/**
 * 添加用户
 * @returns {boolean}
 */
function addProgress(){
    $.ajax({
        url:"/progress/addProgress",
        data:$("#progressForm").serialize(),
        type:"post",
        dataType:"json",
        success:function(data){
            if(data>0){
                $("#sub").attr("disabled","disabled");
                $("#back").attr("disabled","disabled");
                $.notify({
                    offset: "200",
                    message: "添加成功"
                },{
                    type:"success"
                })
                window.setTimeout("window.location.href='/jumps/client-develop'",2000);
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
/*表单验证*/
$(function(){
    $('#progressForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            'cp_PlanCode': {
                validators: {
                    notEmpty: {
                        message: '输入的计划编码不能为空!'
                    },
                    regexp: {
                        /*正则表达式*/
                        regexp: /^[A-Za-z]{2,4}$/,
                        message: '只能2-4个是字母组成！'
                    }
                }
            }, 'clientCode': {
                validators: {
                    notEmpty: {
                        message: '输入的计划人编码不能为空!'
                    },
                    remote: {
                        message: '找不到该客户,请重新填写!',
                        url: '/progress/checkClient',
                        type:"post",
                        dataType:"json",
                        //这里默认会传递该验证字段的值到后端
                        delay:2000 //这里特别要说明，必须要加此属性，否则用户输入一个字就会访问后台一次，会消耗大量的系统资源，
                    },
                   /* regexp: {
                        /!*正则表达式*!/
                        regexp: /^[\u4e00-\u9fa5]{2,4}$/,
                        message: '只能2-4个是汉字组成！'
                    }*/
                }
            },'cp_PlanContent': {
                validators: {
                    /*正则表达式*/
                    regexp: {
                        regexp: /^.{0,50}$/,
                        message: '最多输入50字！'
                    }
                }
            },'cp_PlanMonth':  {
                validators: {
                    notEmpty: {
                        message: '请选择计划月份！'
                    }
                }
            }
        }
    }).on('success.form.bv',function(e) {
        e.preventDefault();
        addProgress();
    })
});
