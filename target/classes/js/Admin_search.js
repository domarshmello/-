$('#gardenCombox').combobox({
    url: "",
    editable: false,
    valueField: 'hid',
    textField: 'hotRegion',
    panelHeight: 'auto',
    onSelect: function (data) {
        $('#garden').val(data.hid);
        //查询类型
        $('#typeId').val('');
        $('#gardenApprovalTypeCombox').combobox({
            url: "",
            editable: false,
            valueField: 'tid',
            textField: 'typeName',
            panelHeight: 'auto',
            width: 100,
        }).combobox('clear');
    }
});

//查询类型
$('#gardenApprovalTypeCombox').combobox({
    url: "",
    editable: false,
    valueField: 'tid',
    textField: 'typeName',
    panelHeight: 'auto',
    width: 100,
    onSelect: function (data) {
        $('#typeId').val(data.tid);
    }
});