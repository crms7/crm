$(function(){
    $("#oldPwd").blur(function(){
        oldPwd();
    })
    $("#updPwd1").blur(function(){
        var newPwd1 = $("#newPwd").val();
        var newPwd2=$("#updPwd1").val();
        if(newPwd2.trim()!=newPwd1.trim()){
            console.log("两次密码不一样");
        }
    })
})

function oldPwd(){
    $.ajax({
        url:"/uppwd",
        type:"post",
        dataType:"json",
        async:true,
        data:{
            "e_Id":$("#upPwd_eId").val(),
            "e_Pwd":$("#oldPwd").val()
        },
        success:function(data){
            if(data>0){
                console.log("旧密码正确");
            }else{
                console.log("旧密码错误");
            }
        }
    })
}





