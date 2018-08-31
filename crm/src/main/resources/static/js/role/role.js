$(function(){
    showRoleList;
    imgs();
})

function format (d) {
    // d 是该行的原始数据对象
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
        '<td>角色编码:</td>'+
        '<td>'+d.rm_Code+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>角色名称:</td>'+
        '<td>'+d.rm_Name+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>所属部门:</td>'+
        '<td>'+d.dept.dp_Name+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>最后修改时间:</td>'+
        '<td>'+moment(d.rm_LastTime).format("YYYY-MM-DD HH:mm:ss")+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>操作人:</td>'+
        '<td>'+d.rm_Operator+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>备注说明:</td>'+
        '<td>'+d.rm_Description+'</td>'+
        '</tr>'+
        '</table>';
}

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
        {"title":"  ","targets":0},
        {"title":"id","targets":1},
        {"title":"   ","targets":2},
        {"title":"角色名称","targets":3},
        {"title":"所属部门","targets":4},
        {"title":"最后修改时间","targets":5},
        {"title":"操作人","targets":6},
        {"title":"备注说明","targets":7}
    ],
    "columns": [
        {
            "class":'details-control',
            "orderable":false,
            "data":null,
            "defaultContent":''
        },
        { "data": "rm_Id" },
        {"data": "rm_Id",
            "render": function (data, type, full, meta) {
                if(meta.row==0){
                    return  '<input type="radio" class="checkchild" name="r_id"  value='+data+' checked="checked"   />';
                }else{
                    return  '<input type="radio" class="checkchild" name="r_id"  value='+data+' onclick="getRoleId()"  />';
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
        { "data": "rm_Description",defaultContent:""}
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


function imgs(){
    $('#datatable-responsive tbody').on('click', 'td.details-control', function () {
        var table = $('#datatable-responsive').DataTable();
        var tr = $(this).closest('tr');
        var row = table.row(tr);
        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } )
}

/**
 * 删除角色
 */
function delRole(){
    $.ajax({
        url:"/delRole/"+$("input[name='r_id']:checked").val(),
        type:"post",
        dataType:"json",
        success:function(data){
            if(data>0){
                $('#datatable-responsive').DataTable().ajax.reload();
            }else{
                $.notify({
                    offset: "50",
                    message: "删除失败"
                },{
                    type:"danger"
                });
            }
        }
    })
}



function showUpInfo(){
    window.location.href="/showUpInfo/"+$("input[name='r_id']:checked").val();
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
