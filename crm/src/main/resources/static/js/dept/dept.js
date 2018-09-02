$(function(){
    showRoleList;
    imgs();
})

function format (d) {
    // d 是该行的原始数据对象
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
        '<td>部门编码:</td>'+
        '<td>'+d.dp_Code+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>部门名称:</td>'+
        '<td>'+d.dp_Name+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>最后修改时间:</td>'+
        '<td>'+moment(d.dp_LastTime).format("YYYY-MM-DD HH:mm:ss")+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>操作人:</td>'+
        '<td>'+d.employeeInfo.e_Name+'</td>'+
        '</tr>'+
        '<tr>'+
        '<tr>'+
        '<td>部门简介:</td>'+
        '<td>'+d.dp_DeptProfile+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>备注说明:</td>'+
        '<td>'+d.dp_Description+'</td>'+
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
        url:"/showDepts",
        "type": "POST",
        "dataType" : "JSON",
        "data": function (datas) {
            datas.dp_Name=$("#dp_Name").val();
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
        {"title":"名称","targets":3},
        {"title":"最后修改时间","targets":4},
        {"title":"操作人","targets":5},
        {"title":"备注说明","targets":6}
    ],
    "columns": [
        {
            "class":'details-control',
            "orderable":false,
            "data":null,
            "defaultContent":''
        },
        { "data": "dp_Id" },
        {"data": "dp_Id",
            "render": function (data, type, full, meta) {
                if(meta.row==0){
                    return  '<input type="radio" class="checkchild" name="d_id"  value='+data+' checked="checked"   />';
                }else{
                    return  '<input type="radio" class="checkchild" name="d_id"  value='+data+'  />';
                }
            },"bSortable": false},
        { "data": "dp_Name" },
        {"data":"dp_LastTime",
            "render": function (data, type, full, meta) {
                return  moment(data).format("YYYY-MM-DD HH:mm:ss");
            }},
        {"data":"employeeInfo",
            "render":function(data,type,full,meta){
            return data.e_Name;
            }
        },
        { "data": "dp_Description",defaultContent:""}
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

function showupdept(){
    window.location.href="/jumps/upd-dept"+$("input[name='d_id']:checked").val();
    alert($("input[name='d_id']:checked").val());
}

$(".btn-success").on("click",function () {
    $('#datatable-responsive').DataTable().ajax.reload();
});

$('#datatable-fixed-header').DataTable({
    fixedHeader: true
});

//根据条件重新绘制
$("#queryDeptName").on("click",function () {
    $('#datatable-responsive').DataTable().ajax.reload();
});


