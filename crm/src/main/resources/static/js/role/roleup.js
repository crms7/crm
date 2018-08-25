
// $(function(){
//     roleValidator();
// })

function  upRoleInfo(){
     $.ajax({
         url:"/updateRole",
         data:$("#formId").serialize(),
         type:"post",
         dataType:"json",
        success:function(data){
            if(data>0){
                $("#sub").attr("disabled","disabled");
                $.notify({
                    offset: "50",
                    message: "修改成功"
                },{
                    type:"success"
                })
                window.setTimeout("window.location.href='/jumps/role-manage'",2000);
            }else{
                $.notify({
                    offset: "50",
                    message: "修改失败"
                },{
                    type:"danger"
                })
            }
        }
    })
    return false;
}




// function roleValidator(){
//     $('form').bootstrapValidator({
//         message: 'This value is not valid',
//         feedbackIcons: {
//             valid: 'glyphicon glyphicon-ok',
//             invalid: 'glyphicon glyphicon-remove',
//             validating:'glyphicon glyphicon-refresh'
//         },
//         fields: {
//             rm_Code: {
//                 message: 'The username is not valid',
//                 validators: {
//                     notEmpty: {
//                         message: '角色编码不能为空',
//                     }
//                 }
//             },
//             rm_Name: {
//                 validators: {
//                     notEmpty: {
//                         message: '角色名称不能为空',
//                     }
//                 }
//             },
//         }
//     });
// }