$(document).ready(function() {
    const apiUrl = 'http://localhost:8080/students';

    // Функция для получения списка студентов
    function fetchStudents() {
        $.ajax({
            url: apiUrl,
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                const tbody = $('#students-body');
                tbody.empty(); // Очищаем таблицу перед добавлением новых данных
                $.each(data, function(index, student) {
                    const row = $('<tr>');
                    row.append($('<td>').text(student.id));
                    row.append($('<td>').text(student.first_name));
                    row.append($('<td>').text(student.last_name));
                    row.append($('<td>').text(student.patronymic));
                    row.append($('<td>').text(student.birth_date));
                    row.append($('<td>').text(student.group));
                    tbody.append(row);
                });
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error fetching students:', textStatus, errorThrown);
            }
        });
    }

    // Функция для добавления студента
    $('#add-student-form').on('submit', function(e) {
        e.preventDefault(); // Остановить стандартное поведение формы
        const student = {
            first_name: $('#name').val(),
            last_name: $('#surname').val(),
            patronymic: $('#patronymic').val(),
            birth_date: $('#birthdate').val(),
            group: $('#groupName').val()
        };

        $.ajax({
            url: apiUrl,
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            data: student,
            success: function() {
                fetchStudents(); // Обновляем список студентов
                $('#add-student-form')[0].reset(); // Очищаем форму
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error adding student:', textStatus, errorThrown);
            }
        });
    });

    // Функция для удаления студента
    $('#delete-student-form').on('submit', function(e) {
        e.preventDefault(); // Остановить стандартное поведение формы
        const uniqueNumber = $('#deleteUniqueNumber').val();

        $.ajax({
            url: `${apiUrl}?id=${uniqueNumber}`,
            type: 'DELETE',
            success: function() {
                fetchStudents();
                $('#delete-student-form')[0].reset();
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error deleting student:', textStatus, errorThrown);
            }
        });
    });

    // Загружаем студентов при загрузке страницы
    fetchStudents();
});
