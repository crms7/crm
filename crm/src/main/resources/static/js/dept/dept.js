
function getDeptName(){
    $.ajax({
        url:"/getDName",
        type:"post",
        dataType:"json",
        success:function(data){
            if(data!=null){
                $("#deptName").html("");
                var options;
                for(var i = 0; i < data.length; i++){
                    options ="<option name='dName' value='"+data[i].dp_Id+"'  >"+data[i].dp_Name+"</option>";
                    $("#deptName").append(options);
                }
            }
        }
    })
}
