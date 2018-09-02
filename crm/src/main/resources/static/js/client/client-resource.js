/*附加信息查询*/
function format ( d ) {
    // d 是该行的原始数据对象
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
        '<td>客户编码:</td>'+
        '<td>'+d.cr_ClientCode+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>客户姓名:</td>'+
        '<td>'+d.cr_ClientName+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>性别:</td>'+
        '<td>'+(d.cr_Sex==0?"男":"女")+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>生日:</td>'+
        '<td>'+moment(d.cr_Birthday).format("YYYY-MM-DD")+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>类型:</td>'+
        '<td>'+d.clientType+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>状态:</td>'+
        '<td>'+d.clientStatus+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>手机:</td>'+
        '<td>'+d.cr_Email+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>办公电话:</td>'+
        '<td>'+(d.cr_WorkTelephone==null?'':d.cr_WorkTelephone)+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>电子邮箱:</td>'+
        '<td>'+d.cr_Email+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>家庭电话:</td>'+
        '<td>'+(d.cr_HomeTelephone==null?'':d.cr_HomeTelephone)+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>联系地址:</td>'+
        '<td>'+d.cr_Address+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td>备注信息:</td>'+
        '<td>'+(d.cr_Remark==null?'':d.cr_Remark)+'</td>'+
        '</tr>'+
        '</table>';
}


/*页面表格信息查询*/
$(document).ready(function() {
   var table= $('#datatable-responsive').DataTable({
        "serverSide":true,//服务器端获取数据
        "bStateSave": false,//不缓存数据
       "ordering": false,//不排序
        "ajax": {
            url:"/client/clientListInfo",
            "type": "POST",
            "dataType" : "JSON",
            "data": function (datas) {
                /*客户文本框值*/
                if($("#clientTypeOpt").val()=="name"){
                    datas.cr_ClientName=$("#clientTypeVal").val();
                }else if($("#clientTypeOpt").val()=="phone"){
                    datas.cr_Phone=$("#clientTypeVal").val();
                }
                datas.cr_AllotStatus=$('#clientAllocaion option:selected').val();
            }
        },
        lengthMenu: [ //自定义分页长度
            [ 2, 5, 10 ],
            [ '2', '5', '10' ]
        ],
        "searching" : false,//关闭搜索框
        "columnDefs":[
            {"title":"  ","targets":0},
            {"title":"id","targets":1},
            {"title":"   ","targets":2},
            {"title":"客户姓名","targets":3},
            {"title":"性别","targets":4},
            {"title":"类型","targets":5},
            {"title":"状态","targets":6},
            {"title":"分配状态","targets":7},
            {"title":"录入时间","targets":8},
            {"title":"录入人","targets":9}
        ],
        "columns": [
            {
                "class":'details-control',
                "orderable":false,
                "data":null,
                "defaultContent": ''
            },
            { "data": "cr_Id" },
            {"data": "cr_Id",
                "render": function (data, type, full, meta) {
                //判断每一页的第一行选中
                    return  meta.row==0?'<input type="radio" checked="checked" value="'+data+'"  name="cr_Id" class="checkchild"/>':'<input type="radio"  value="'+data+'" onclick="getCr_Id()" name="cr_Id" class="checkchild"/>';
                },"bSortable": false},
            { "data": "cr_ClientName" },
            { "data": "cr_Sex",
                "render": function (data, type, full, meta) {
                    return data==0?'男':'女';
                },"bSortable": false},
            { "data": "clientType" },
            { "data": "clientStatus",defaultContent:"" },
            { "data": "clientAllotStatus",defaultContent:"" },
            { "data": "cr_EnterTime",defaultContent:"",
                "render": function (data, type, full, meta) {
                    return  moment(data).format("YYYY-MM-DD HH:mm:ss");
                }},
            { "data": "employeeInfo",defaultContent:"" ,
                "render": function (data, type, full, meta) {
                    return  data.e_Name;
                }}
        ],
       "order": [[1, 'asc']],
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


    $(".btn-success").on("click",function () {
        $('#datatable-responsive').DataTable().ajax.reload();
    });

    $('#datatable-fixed-header').DataTable({
        fixedHeader: true
    });
});

/**
 * 修改客户的查询
 */
function updClient(){
    var cr_Id= $("input[name='cr_Id']:checked").val();
    window.location.href = "/client/getOneClient/"+cr_Id;
}
/*获取分配状态下拉框的值*/
$(document).ready(function (){
    $.ajax({
        url:"/dataDict/getAllocaionState",
        type:"post",
        dataType:"json",
        data:{"typeName":"客户分配"} ,
        success:function(data){
            if(null!=data){
                for(var i = 0; i < data.length; i++){
                    $("#clientAllocaion").append("<option name='dataDictName' value='"+data[i].valueId+"'>"+data[i].valueName+"</option>");
                }
            }
        }
    });
});