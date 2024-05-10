import React from 'react';
import { useNavigate } from 'react-router-dom';

// Import Bootstrap CSS
import 'bootstrap/dist/css/bootstrap.min.css';

function AdminHome() {
    const navigate = useNavigate(); // Initialize useNavigate

    // Function to handle adding a new student
    const handleAddStudent = () => {
        navigate('/add-student'); // Navigate to the Add Student page
    };
    const handleAddDoctor = () => {
        navigate('/add-doctor'); // Navigate to the Add Student page
    };
    const handleAddcource = () => {
        navigate('/add-course'); // Navigate to the Add Student page
    };
    const handleAssignCoursetoDoctor = () => {
        navigate('/assign-cource-doctor'); // Navigate to the Add Student page
    };

    return (
        <div className="container">
            <h2>Admin Home</h2>
            <button onClick={handleAddStudent} className="btn btn-primary mr-2">Add Student</button>
            <button onClick={handleAddDoctor} className="btn btn-primary mr-2">Add Doctor</button>
            <button onClick={handleAddcource} className="btn btn-primary mr-2">Add Course</button>
            <button onClick={handleAssignCoursetoDoctor} className="btn btn-primary">Assign Course to Doctor</button>
        </div>
    );
}

export default AdminHome;
