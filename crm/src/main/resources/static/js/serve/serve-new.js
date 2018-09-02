/*附加信息查询*/
function format ( d ) {
    // d 是该行的原始数据对象
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
        '<td>计划编码:</td>'+
        '<td>'+d.sc_Id+'</td>'+
        '</tr>'+
        '</table>';
}

$(document).ready(function() {
   var table= $('#datatable-responsive').DataTable({
        "serverSide":true,//服务器端获取数据
        "bStateSave": false,//不缓存数据
        "ajax": {
            url:"/service/selectServiceCreate",
            "type": "POST",
            "dataType" : "JSON",
            "data": function (datas) {
                dats.sc_Name=$("#serveName").val();
            }
        },
        lengthMenu: [ //自定义分页长度
            [ 2, 20, 50 ],
            [ '10 页', '20 页', '50页' ]
        ],
        "searching" : false,//关闭搜索框
        "columnDefs":[
            {"title":"   ","targets":0},
            {"title":"id","targets":1},
            {"title":"   ","targets":2},
            {"title":"服务名称","targets":3},
            {"title":"类型","targets":4},
            {"title":"状态","targets":5},
            {"title":"最后操作时间","targets":6},
            {"title":"操作人","targets":7},
            {"title":"待处理人","targets":8}
        ],
        "columns": [
            {
                "class":'details-control',
                "orderable":false,
                "data":null,
                "defaultContent": ''
            },
            { "data": "sc_Id" },
            {"data": "sc_Id",
                "render": function (data, type, full, meta) {
                    return  meta.row==0?'<input type="radio" checked="checked" value="'+data+'"  name="cs_Id" class="checkchild"/>':'<input type="radio"  value="'+data+'" onclick="getCr_Id()" name="cs_Id" class="checkchild"/>';
                },"bSortable": false},
            { "data": "sc_Name" },
            { "data": "serviceType" },
            { "data": "serviceState" },
            { "data": "sc_OperaTime",
                "render": function (data, type, full, meta) {
                    return  moment(data).format("YYYY-MM-DD HH:mm:ss");
                },defaultContent:"" },
            { "data": "operaPerson",defaultContent:"" },
            { "data": "dealPeople",defaultContent:"" }
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
    $("#queryAppInfo").on("click",function () {
        $('#datatable-responsive').DataTable().ajax.reload();
    });
    $('#datatable-fixed-header').DataTable({
        fixedHeader: true
    });
});
