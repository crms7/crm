function upPhoneClick(obj){
    if($(obj).html()=="修改"){
        $(obj).html("保存");
        $("#upPhone").removeAttr("disabled");
    }else{
        upPhone();
    }
}


function upPhone(){
    var phone=$("#upPhone").val();
    $.ajax({
        url:"/upEmp",
        type:"post",
        dataType:"json",
        data:phone,
        success:function(data){
            if(data>0){
                console.log("修改手机号成功");
            }else{
                console.log("修改手机号失败");
            }
        }
    })
    $("#upPhone").attr("disabled","disabled");
    $("#upP").html("修改");
}