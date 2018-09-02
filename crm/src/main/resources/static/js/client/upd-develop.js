$(function(){
    $('#developForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
           'cp_PlanContent': {
                validators: {
                    /*正则表达式*/
                    regexp: {
                        regexp: /^.{0,200}$/,
                        message: '最多输入200字！'
                    }
                }
            }, 'cp_PlanStatus':  {
                validators: {
                    notEmpty: {
                        message: '请选择！'
                    }
                }
            }, 'cp_PlanMonth':  {
                validators: {
                    notEmpty: {
                        message: '请选择！'
                    }
                }
            }
        }
    }).on('success.form.bv',function(e) {
        e.preventDefault();
        updDevelopInfo();
    })
});

function  updDevelopInfo(){

    $.ajax({
        url:"/progress/changeProgress",
        data:$("#developForm").serialize(),
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
                window.setTimeout("window.location.href='/jumps/client-develop'",2000);
            }else{
                $.notify({
                    offset: "200",
                    message: "修改失败"
                },{
                    type:"danger"
                })
                $("#sub").attr("disabled","none");
            }
        }
    })
    return false;
}
