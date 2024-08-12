import React, { useState, useEffect } from 'react';
import StudentForm from './components/StudentForm';
import StudentTable from './components/StudentTable';

const App = () => {
    const [students, setStudents] = useState([]);

    useEffect(() => {
        fetchStudents();
    }, []);

    const fetchStudents = async () => {
        const response = await fetch('/api/students');  // API endpoint для получения всех студентов
        const data = await response.json();
        setStudents(data);
    };

    const addStudent = async (student) => {
        const response = await fetch('/api/students', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(student),
        });
        const newStudent = await response.json();
        setStudents([...students, newStudent]);
    };

    const deleteStudent = async (uniqueNumber) => {
        await fetch(`/api/students/${uniqueNumber}`, {
            method: 'DELETE',
        });
        setStudents(students.filter(student => student.uniqueNumber !== parseInt(uniqueNumber)));
    };

    return (
        <div className="App">
            <h1>Student Management</h1>
            <StudentForm onAddStudent={addStudent} onDeleteStudent={deleteStudent} />
            <StudentTable students={students} />
        </div>
    );
}

export default App;