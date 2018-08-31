function upPhoneClick(obj){
    if($(obj).html()=="修改"){
        $(obj).html("保存");
        $("#upPhone").removeAttr("disabled");
    }else{
        upPhone();
    }
}

function upPhone(){
    $.ajax({
        url:"/upEmp",
        type:"post",
        dataType:"json",
        data:{
            "e_Phone":$("#upPhone").val(),
            "e_Id":$("#empIdi").val()
        },
        success:function(data){
            if(data>0){
                $.notify({
                    offset: "50",
                    message: "修改成功"
                },{
                    type:"success"
                });
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
    $("#upPhone").attr("disabled","disabled");
    $("#upP").html("修改");
}


