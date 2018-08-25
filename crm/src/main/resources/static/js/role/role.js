$(function(){
    showRoleList;
})

/**
 * 分页显示数据
 * @type {*|jQuery}
 */
var showRoleList= $('#datatable-responsive').DataTable({
    "serverSide":true,//服务器端获取数据
    "bStateSave": false,//不缓存数据
    "ajax": {
        url:"/roleList",
        "type": "POST",
        "dataType" : "JSON",
        "data": function (datas) {
            datas.rm_Name=$("#roleName").val();
        }
    },
    lengthMenu: [ //自定义分页长度
        [ 5, 10, 50 ],
        [ '5 页', '10 页', '50页' ]
    ],
    "searching" : false,//关闭搜索框
    "columnDefs":[
        {"title":"id","targets":0},
        {"title":"   ","targets":1},
        {"title":"角色名称","targets":2},
        {"title":"所属部门","targets":3},
        {"title":"最后修改时间","targets":4},
        {"title":"操作人","targets":5},
        {"title":"备注说明","targets":6}
    ],
    "columns": [
        { "data": "rm_Id" },
        {"data": "rm_Id",
            "render": function (data, type, full, meta) {
                if(data==1){
                    return  '<input type="radio" class="checkchild" name="r_id"  value='+data+' checked="checked" onclick="getRoleId()"  />';
                }else{
                    return  '<input type="radio" class="checkchild" name="r_id"  value='+data+' onclick="getRoleId()" />';
                }
            },"bSortable": false},
        { "data": "rm_Name" },
        { "data": "dept",
            "render": function (data, type, full, meta) {
                return  data.dp_Name;
            }
        },
        {"data":"rm_LastTime",
            "render": function (data, type, full, meta) {
                return  moment(data).format("YYYY-MM-DD HH:mm:ss");
            }},
        {"data":"rm_Operator"},
        { "data": "rm_Description",defaultContent:""},

    ],
    "oLanguage" : { // 国际化配置
        "sProcessing": "正在获取数据，请稍后...",
        "sLengthMenu": "显示 _MENU_ 条",
        "sZeroRecords": "没有找到数据",
        "sInfo": "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
        "sInfoEmpty": "记录数为0",
        "sInfoFiltered": "(全部记录数 _MAX_ 条)",
        "sInfoPostFix": "",
        "sSearch": "查询",
        "sUrl": "",
        "oPaginate": {
            "sFirst": "第一页",
            "sPrevious": "上一页",
            "sNext": "下一页",
            "sLast": "最后一页"
        }
    }
});

/**
 * 删除角色
 */
function delRole(){
    var did = $("#roleId").val();
    $.ajax({
        url:"/delRole/"+did,
        type:"post",
        dataType:"json",
        success:function(data){
            if(data>0){
                alert("删除成功");
                $('#datatable-responsive').DataTable().ajax.reload();
            }else{
                alert("删除失败");
            }
        }
    })
}

function getRoleId(){
    $("#roleId").val($("input[name='r_id']:checked").val());
}

function showUpInfo(){
    window.location.href="/showUpInfo/"+$("#roleId").val();
}

$(".btn-success").on("click",function () {
    $('#datatable-responsive').DataTable().ajax.reload();
});
$("#queryRoleName").on("click",function () {
    $('#datatable-responsive').DataTable().ajax.reload();
});
$('#datatable-fixed-header').DataTable({
    fixedHeader: true
});

