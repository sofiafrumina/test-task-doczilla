import React from 'react';

const StudentTable = ({ students }) => {
    return (
        <div>
            <h2>Student List</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Patronymic</th>
                        <th>Birthdate</th>
                        <th>Group Name</th>
                        <th>Unique Number</th>
                    </tr>
                </thead>
                <tbody>
                    {students.map((student) => (
                        <tr key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.name}</td>
                            <td>{student.surname}</td>
                            <td>{student.patronymic}</td>
                            <td>{student.birthdate}</td>
                            <td>{student.groupName}</td>
                            <td>{student.uniqueNumber}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default StudentTable;