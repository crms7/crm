/*附加信息查询*/
function format ( d ) {
    // d 是该行的原始数据对象
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
        '<td>计划编码:</td>'+
        '<td>'+d.cp_PlanCode+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>计划人姓名:</td>'+
        '<td>'+d.clientResource.cr_ClientName+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>计划月份:</td>'+
        '<td>'+moment(d.cp_PlanMonth).format("YYYY-MM")+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>计划状态:</td>'+
        '<td>'+d.cp_PlanStatus+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>计划内容:</td>'+
        '<td>'+(d.cp_PlanContent==null?'':d.cp_PlanContent)+'</td>'+
        '</tr>'+
        '</table>';
}
$(document).ready(function() {
  var table=  $('#datatable-responsive').DataTable({
        "serverSide":true,//服务器端获取数据
        "bStateSave": false,//不缓存数据
      "ordering": false,//不排序
        "ajax": {
            url:"/progress/clientProgressInfo",
            "type": "POST",
            "dataType" : "JSON",
            "data": function (datas) {
                if($("#pickdate").val()!=null){
                    datas.cp_PlanMonth=$("#pickdate").val();
                }
            }
        },
        lengthMenu: [ //自定义分页长度
            [ 2, 20, 50 ],
            [ '2 页', '20 页', '50页' ]
        ],
        "searching" : false,//关闭搜索框
        "columnDefs":[
            {"title":"  ","targets":0},
            {"title":"id","targets":1},
            {"title":"   ","targets":2},
            {"title":"姓名","targets":3},
            {"title":"月份","targets":4},
            {"title":"创建时间","targets":5},
            {"title":"最后操作时间","targets":6},
            {"title":"操作人","targets":7}
        ],
        "columns": [
            {
                "class":'details-control',
                "orderable":false,
                "data":null,
                "defaultContent": ''
            },
            { "data": "cp_Id" },
            {"data": "cp_Id",
                "render": function (data, type, full, meta) {
                    //判断每一页的第一行选中
                    return  meta.row==0?'<input type="radio" checked="checked" value="'+data+'"  name="cp_Id" class="checkchild"/>':'<input type="radio"  value="'+data+'" onclick="getCr_Id()" name="cp_Id" class="checkchild"/>';
                },"bSortable": false},
            { "data": "clientResource",defaultContent:"",
                "render": function (data, type, full, meta) {
                    return data.cr_ClientName;
                }},
            { "data": "cp_PlanMonth" ,defaultContent:"",
                "render": function (data, type, full, meta) {
                    return  moment(data).format("YYYY-MM");
                }},
            { "data": "cp_CreationTime" ,defaultContent:"",
                "render": function (data, type, full, meta) {
                    return  moment(data).format("YYYY-MM-DD HH:mm:ss");
                }},
            { "data": "cp_OperationTime",defaultContent:"" ,
                "render": function (data, type, full, meta) {
                    return  moment(data).format("YYYY-MM-DD HH:mm:ss");
                }},
            { "data": "employeeInfo",defaultContent:"" ,
                "render": function (data, type, full, meta) {
                    return data.e_Name;
                }}

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
     * 附加信息或显示隐藏
     */
    $('#datatable-responsive tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row(tr);
        if ( row.child.isShown() ) {
            //这一行已经打开了-关闭它
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // 打开当前行
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );

    $("#queryClientProgress").on("click",function () {
        $('#datatable-responsive').DataTable().ajax.reload();
    });
    $('#datatable-fixed-header').DataTable({
        fixedHeader: true
    });
});
function updDevelop() {
    var cp_Id= $("input[name='cp_Id']:checked").val();
    window.location.href = "/progress/selectOneInfo/"+cp_Id;
}

function delProgress() {
    $.ajax({
        url:"/progress/delProgress/"+$("input[name='cp_Id']:checked").val(),
        type:"post",
        dataType:"json",
        success:function(data){
            if(data>0){
                $.notify({
                    offset: "200",
                    message: "删除成功"
                },{
                    type:"success"
                })
                $('#datatable-responsive').DataTable().ajax.reload();
            }else{
                $.notify({
                    offset: "200",
                    message: "删除失败"
                },{
                    type:"danger"
                })
            }
        }
    })
    return false;
}