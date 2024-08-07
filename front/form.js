document.addEventListener('DOMContentLoaded', function () {
    // Получение списка всех студентов при загрузке страницы
    fetch('/getAllStudents')
        .then(response => response.json())
        .then(students => displayStudents(students))
        .catch(error => console.error('Ошибка:', error));

    // Добавление нового студента
    document.getElementById('addStudentForm').addEventListener('submit', function (event) {
        event.preventDefault();
        const formData = new FormData(event.target);
        const studentData = Object.fromEntries(formData.entries());

        fetch('/addStudent', {
            method: 'POST',
            body: JSON.stringify(studentData),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(() => window.location.reload()) // Перезагрузка страницы после добавления
        .catch(error => console.error('Ошибка:', error));
    });

    // Удаление студента по уникальному номеру
    document.getElementById('deleteButton').addEventListener('click', function () {
        const uniqueNumber = document.getElementById('uniqueNumberInput').value;
        fetch(`/deleteStudent/${uniqueNumber}`, {method: 'DELETE'})
            .then(() => window.location.reload()) // Перезагрузка страницы после удаления
            .catch(error => console.error('Ошибка:', error));
    });
});

function displayStudents(students) {
    const tableBody = document.querySelector('#studentsTable tbody');
    tableBody.innerHTML = ''; // Очистка таблицы перед заполнением новыми данными
    students.forEach(student => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.patronymic}</td>
            <td>${student.birthdate}</td>
            <td>${student.groupName}</td>
            <td>${student.uniqueNumber}</td>
            <td><button class="delete-button" data-unique-number="${student.uniqueNumber}">Удалить</button></td>
        `;
        tableBody.appendChild(row);
    });
}
