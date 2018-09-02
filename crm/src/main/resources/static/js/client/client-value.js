/*附加信息查询*/
function format ( d ) {
    // d 是该行的原始数据对象
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
        '<td>客户编码:</td>'+
        '<td>'+d.cv_Id+'</td>'+
        '</tr>'+
        '</table>';
}

$(document).ready(function() {
  var table=  $('#datatable-responsive').DataTable({
        "serverSide":true,//服务器端获取数据
        "bStateSave": false,//不缓存数据
        "ajax": {
            url:"/clientValue/selectClientValue",
            "type": "POST",
            "dataType" : "JSON",
            "data": function (datas) {
                  datas.cr_Name=$("#cr_Name").val();
                  if( $("#clientValueType").val()!=''){
                    datas.cv_ClientType=$("#clientValueType").val();
                  }
            }
        },
        lengthMenu: [ //自定义分页长度
            [ 2, 10, 20 ],
            [ '2', '10', '20' ]
        ],
        "searching" : false,//关闭搜索框
        "columnDefs":[
            {"title":"  ","targets":0},
            {"title":"id","targets":1},
            {"title":"客户姓名","targets":2},
            {"title":"性别","targets":3},
            {"title":"客户类型","targets":4},
            {"title":"已消费次数","targets":5},
            {"title":"消费总额(单位：万元)","targets":6},
            {"title":"服务代表","targets":7}
        ],
        "columns": [
            {
                "class":'details-control',
                "orderable":false,
                "data":null,
                "defaultContent": ''
            },
            { "data": "cv_Id" },
            { "data": "clientResource" ,
                "render": function (data, type, full, meta) {
                    return data.cr_ClientName;
                }},
            { "data": "cv_Sex",
                "render": function (data, type, full, meta) {
                    return data==0?'男':'女';
                }},
            { "data": "dataDictionary" ,
                "render": function (data, type, full, meta) {
                    return data.valueName;
                }},
            { "data": "cv_ConsumeNum",defaultContent:"" },
            { "data": "cv_ConsumeSum",defaultContent:"" },
            { "data": "employeeInfo",
                "render": function (data, type, full, meta) {
                    return data.e_Name;
                },defaultContent:"" }

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
    $("#valueSelect").on("click",function () {
        $('#datatable-responsive').DataTable().ajax.reload();
    });
    $('#datatable-fixed-header').DataTable({
        fixedHeader: true
    });

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
});

/*获取分配状态下拉框的值*/
$(document).ready(function (){
    $.ajax({
        url:"/dataDict/getAllocaionState",
        type:"post",
        dataType:"json",
        data:{"typeName":"客户类型"} ,
        success:function(data){
            if(null!=data){
                for(var i = 0; i < data.length; i++){
                    $("#clientValueType").append("<option name='dataDictName' value='"+data[i].valueId+"'>"+data[i].valueName+"</option>");
                }
            }
        }
    });
});