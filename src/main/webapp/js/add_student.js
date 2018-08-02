$(document).ready(function () {
    $.get('/datadictionaries/items/department', function (data) {
        $.each(data, function (i, v) {
            $('[name=departmentSelect]').append('<option value=' + v.value + '>' + v.text + '</option>');
        });
    });

    $('[name=departmentSelect]').change(function () {
        $.get('/datadictionaries/items/major?parentValue=' + $(this).val(), function (data) {
            $('[name=majorSelect]').empty();
            $.each(data, function (i, v) {
                $('[name=majorSelect]').append('<option value=' + v.value + '>' + v.text + '</option>');
            });
        });
    });
});