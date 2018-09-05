function upPhoneClick(obj){
    if($(obj).html()=="修改"){
        $(obj).html("保存");
        $("#upPhone").removeAttr("disabled");
    }else{
        var reg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
        var phone =$("#upPhone").val();
        if(reg.test(phone)){
            upPhone();
        }else{
            layer.tips('请检查手机号', '#upPhone', {
                tips: [1, '#cc6065'],
                time: 2500
            })
        }
    }
}

function upPhone(){
    $.ajax({
        url:"/upEmp/phone",
        type:"post",
        dataType:"json",
        data:{
            "e_Phone":$("#upPhone").val(),
            "e_Id":$("#empIdi").val()
        }
    })
    $("#upPhone").attr("disabled","disabled");
    $("#upP").html("修改");
}


