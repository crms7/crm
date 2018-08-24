$(function(){
    upRoleInfoValidator();
})
function upRoleInfoValidator(){
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            rm_Code: {
                validators: {
                    notEmpty: {
                        message: '角色编码不能为空'
                    }
                }
            },
            rm_Name: {
                validators: {
                    notEmpty: {
                        message: '角色名称不能为空'
                    }
                }
            },
            rm_Description: {
                validators: {
                    notEmpty: {
                        message: '备注信息不能为空'
                    }
                }
            }
        }
    });
}