import React, { useState, useEffect } from 'react';

// Import Bootstrap CSS
import 'bootstrap/dist/css/bootstrap.min.css';

function EnrollCourses() {
    const [selectedCourses, setSelectedCourses] = useState([]);
    const [allCourses, setAllCourses] = useState([]);
    const [loading, setLoading] = useState(true);

    // Fetch all courses when the component mounts
    useEffect(() => {
        fetch('http://localhost:8080/Student/allStudentCourse')
            .then(response => response.json())
            .then(data => {
                setAllCourses(data);
                setLoading(false);
            })
            .catch(error => console.error('Error fetching courses:', error));
    }, []);

    const handleCourseSelection = (e) => {
        const courseId = parseInt(e.target.value);
        setSelectedCourses(prevSelected => {
            if (prevSelected.includes(courseId)) {
                return prevSelected.filter(id => id !== courseId);
            } else {
                return [...prevSelected, courseId];
            }
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        const studentId = localStorage.getItem('userId');

        // Constructing the request body
        const requestBody = {
            student_id: parseInt(studentId),
            course_ids: selectedCourses
        };

        // Sending the selected course IDs to the API endpoint
        fetch('http://localhost:8080/Student/setCourses', {
            method: 'Put',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        })
        .then(response => {
            if (response.ok) {
                console.log('Courses enrolled successfully');
                // Handle success (e.g., redirect to another page)
            } else {
                console.error('Failed to enroll courses');
                // Handle error
            }
        })
        .catch(error => console.error('Error enrolling courses:', error));
    };

    return (
        <div className="container">
            <h2>Enroll Courses</h2>
            {loading ? (
                <p>Loading...</p>
            ) : (
                <form onSubmit={handleSubmit}>
                    <h3>Select Courses:</h3>
                    {allCourses.map(course => (
                        <div key={course.id} className="form-check">
                            <input
                                type="checkbox"
                                className="form-check-input"
                                id={`course-${course.id}`}
                                value={course.id}
                                onChange={handleCourseSelection}
                                checked={selectedCourses.includes(course.id)}
                            />
                            <label className="form-check-label" htmlFor={`course-${course.id}`}>
                                {course.name}
                            </label>
                        </div>
                    ))}
                    <button type="submit" className="btn btn-primary">Enroll Selected Courses</button>
                </form>
            )}
        </div>
    );
}

export default EnrollCourses;
