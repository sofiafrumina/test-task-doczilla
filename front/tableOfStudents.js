<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
    $.ajax({
        url: '/api/students', // URL вашего контроллера для получения списка студентов
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            var tbody = $('#studentsTable tbody');
            tbody.empty(); // Очищаем таблицу перед добавлением новых данных

            $.each(data, function(index, item) {
                var row = $('<tr>');

                row.append($('<td>').text(item.name));
                row.append($('<td>').text(item.surname));
                row.append($('<td>').text(item.patronymic));
                row.append($('<td>').text(item.birthdate)); // Предполагается, что дата рождения представлена в формате, совместимом с HTML
                row.append($('<td>').text(item.groupName));
                row.append($('<td>').text(item.uniqueNumber));

                tbody.append(row);
            });
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error(textStatus, errorThrown);
        }
    });
});
</script>