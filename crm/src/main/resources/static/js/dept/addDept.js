$(function(){
    $('#addDeptForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            'dp_Code': {
                validators: {
                    notEmpty: {
                        message: '输入的部门编码不能为空!'
                    },
                    regexp: {
                        regexp:  /^[A-Za-z_]{2,18}$/,
                        message: '部门编码只能是2-18位字母和_'
                    },
                    remote: {
                        message: '编码已存在',
                        url: '/deptexits',
                        type:"post",
                        dataType:"json",
                        data:{
                            "dp_Code":$("#dp_Code").val(),
                        },  //这里默认会传递该验证字段的值到后端
                        delay:2000 //这里特别要说明，必须要加此属性，否则用户输入一个字就会访问后台一次，会消耗大量的系统资源，
                    },
                },
            }, 'dp_Name': {
                validators: {
                    notEmpty: {
                        message: '输入的部门名称不能为空!'
                    } ,
                    /*正则表达式*/
                    regexp: {
                        regexp:  /^[\u4e00-\u9fa5]{2,8}$/,
                        message: '部门名称只能是2-8位的中文字符,'
                    },
                    remote: {
                        message: '名称已存在',
                        url: '/deptexits',
                        type:"post",
                        dataType:"json",
                        data:{
                            "dp_Name":$("#dp_Name").val(),
                        },  //这里默认会传递该验证字段的值到后端
                        delay:2000 //这里特别要说明，必须要加此属性，否则用户输入一个字就会访问后台一次，会消耗大量的系统资源，
                    },
                }
            }
        }
    }).on('success.form.bv',function(e) {
        e.preventDefault();
        addDept();
    })
});


function addDept(){
    $.ajax({
        url:"/insertDept",
        data:$("#addDeptForm").serialize(),
        type:"post",
        dataType:"json",
        success:function(data){
            if(data>0){
                $.notify({
                    offset: "50",
                    message: "新增成功"
                },{
                    type:"success"
                });
                window.setTimeout("window.location.href='/jumps/dept-manage'",2000);
            }else{
                $.notify({
                    offset: "50",
                    message: "新增失败"
                },{
                    type:"danger"
                });
            }
        }
    })
}