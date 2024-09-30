$(document).ready(function() {
    const apiUrl = 'http://localhost:8080/students';
    const apiUrlDelete = 'http://localhost:8080/students?id={id}';

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
                    row.append($('<td>').text(student.name));
                    row.append($('<td>').text(student.surname));
                    row.append($('<td>').text(student.patronymic));
                    row.append($('<td>').text(student.birthdate));
                    row.append($('<td>').text(student.groupName));
                    row.append($('<td>').text(student.uniqueNumber));
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
            name: $('#name').val(),
            surname: $('#surname').val(),
            patronymic: $('#patronymic').val(),
            birthdate: $('#birthdate').val(),
            groupName: $('#groupName').val(),
            uniqueNumber: $('#uniqueNumber').val()
        };

        $.ajax({
            url: apiUrl,
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(student),
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
    // Обработчик события на отправку формы удаления студента
    $('#delete-student-form').on('submit', function(e) {
        e.preventDefault(); // Остановить стандартное поведение формы
        const uniqueNumber = $('#deleteUniqueNumber').val(); // Получаем уникальный номер из поля ввода

        // AJAX-запрос для удаления студента
        $.ajax({
            url: `${apiUrl}?id=${uniqueNumber}`, // Формируем URL для удаления по ID
            type: 'DELETE', // Указываем метод запроса
            success: function() {
                fetchStudents(); // Обновляем список студентов после успешного удаления
                $('#delete-student-form')[0].reset(); // Очищаем форму
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error deleting student:', textStatus, errorThrown); // Логируем ошибку
            }
        });
    });


    // Загружаем студентов при загрузке страницы
    fetchStudents();
});
