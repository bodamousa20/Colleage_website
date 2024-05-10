import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS

function AssignDoctorToCourse() {
    const [doctorId, setDoctorId] = useState('');
    const [courseId, setCourseId] = useState('');
    const [error, setError] = useState('');

    const handleDoctorIdChange = (e) => {
        setDoctorId(e.target.value);
    };

    const handleCourseIdChange = (e) => {
        setCourseId(e.target.value);
    };

    const handleAssign = () => {
        // Perform validation if needed

        // Run API request to assign doctor to course
        fetch(`http://localhost:8080/admin/${doctorId}/courses/${courseId}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            // You can optionally pass additional data in the request body if needed
        })
        .then(response => {
            if (response.ok) {
                console.log('Doctor assigned to course successfully');
                // Redirect or show success message
            } else {
                console.error('Failed to assign doctor to course');
                // Handle error
                setError('Failed to assign doctor to course');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            // Handle error
            setError('Error occurred while assigning doctor to course');
        });
    };

    return (
        <div className="container">
            <h2 className="mt-5">Assign Doctor to Course</h2>
            <div className="mb-3">
                <label htmlFor="doctorId" className="form-label">Doctor ID:</label>
                <input type="text" id="doctorId" value={doctorId} onChange={handleDoctorIdChange} className="form-control" />
            </div>
            <div className="mb-3">
                <label htmlFor="courseId" className="form-label">Course ID:</label>
                <input type="text" id="courseId" value={courseId} onChange={handleCourseIdChange} className="form-control" />
            </div>
            <button onClick={handleAssign} className="btn btn-primary">Assign</button>
            {error && <div className="mt-3 text-danger">{error}</div>}
        </div>
    );
}

export default AssignDoctorToCourse;
