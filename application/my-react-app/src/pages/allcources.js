import React, { useEffect, useState } from 'react';

// Import Bootstrap CSS
import 'bootstrap/dist/css/bootstrap.min.css';

function StudentCourses() {
    const [courses, setCourses] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/Student/allStudentCourse')
            .then(response => response.json())
            .then(data => {
                setCourses(data);
            })
            .catch(error => console.error('Error fetching courses:', error));
    }, []);

    return (
        <div className="container">
            <h2>All Courses</h2>
            <ul className="list-group">
                {courses.map(course => (
                    <li key={course.id} className="list-group-item">
                        <strong>Course ID:</strong> {course.id}<br />
                        <strong>Name:</strong> {course.name}<br />
                        <strong>Degree:</strong> {course.degree}<br />
                        <strong>Department:</strong> {course.department}<br />
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default StudentCourses;
