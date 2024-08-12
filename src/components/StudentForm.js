import React, { useState } from 'react';

const StudentForm = ({ onAddStudent, onDeleteStudent }) => {
    const [student, setStudent] = useState({
        name: '',
        surname: '',
        patronymic: '',
        birthdate: '',
        groupName: '',
        uniqueNumber: ''
    });

    const handleChange = (e) => {
        setStudent({ ...student, [e.target.name]: e.target.value });
    };

    const handleAdd = (e) => {
        e.preventDefault();
        onAddStudent(student);
        setStudent({
            name: '',
            surname: '',
            patronymic: '',
            birthdate: '',
            groupName: '',
            uniqueNumber: ''
        });
    };

    const handleDelete = (e) => {
        e.preventDefault();
        onDeleteStudent(student.uniqueNumber);
    };

    return (
        <div>
            <h2>Add Student</h2>
            <form onSubmit={handleAdd}>
                <input type="text" name="name" placeholder="Name" value={student.name} onChange={handleChange} required />
                <input type="text" name="surname" placeholder="Surname" value={student.surname} onChange={handleChange} required />
                <input type="text" name="patronymic" placeholder="Patronymic" value={student.patronymic} onChange={handleChange} required />
                <input type="date" name="birthdate" placeholder="Birthdate" value={student.birthdate} onChange={handleChange} required />
                <input type="text" name="groupName" placeholder="Group Name" value={student.groupName} onChange={handleChange} required />
                <input type="number" name="uniqueNumber" placeholder="Unique Number" value={student.uniqueNumber} onChange={handleChange} required />
                <button type="submit">Add Student</button>
            </form>

            <h2>Delete Student</h2>
            <form onSubmit={handleDelete}>
                <input type="number" name="uniqueNumber" placeholder="Unique Number" value={student.uniqueNumber} onChange={handleChange} required />
                <button type="submit">Delete Student</button>
            </form>
        </div>
    );
};

export default StudentForm;