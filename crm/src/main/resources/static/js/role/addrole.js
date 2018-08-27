function addRole(){
    $.ajax({
        url: "/addRole",
        type: "post",
        dataType: "json",
        data: $("#addform1").serialize(),
        success:function(data){
                if(data>0){
                    $("#sub").attr("disabled","disabled");
                    $.notify({
                        offset: "50",
                        message: "新增成功"
                    },{
                        type:"success"
                    });
                    window.setTimeout("window.location.href='/jumps/role-manage'",2000);
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
            return false;

}

// var flag_code=false;
// $("#rm_Code").blur(function (){
//     var code  = $("#rm_Code").val();
//     var id=$("#roleId").val();
//     $.ajax({
//         url:"/roleExits",
//         type:"post",
//         dataType:"json",
//         data:{code:code},
//         success:function(data){
//             if(data.rm_Code==code&&data.rm_Id!=id){
//                 alert("存在");
//                 flag_code= false;
//             }else{
//                 flag_code= true;
//             }
//         }
//     })
// })
// var flag_name=false;
// $("#rm_Name").blur(function(){
//     var name  = $("#rm_Name").val();
//     var id=$("#roleId").val();
//     $.ajax({
//         url:"/roleExits",
//         type:"post",
//         dataType:"json",
//         data:{name:name},
//         success:function(data){
//             if(data.rm_Name==name&&data.rm_Id!=id){
//                 alert("存在");
//                 flag_name=false;
//             }else{
//                 flag_name=true;
//             }
//         }
//     })
// })
