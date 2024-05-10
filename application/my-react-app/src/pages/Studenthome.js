import React from 'react';
import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS

function StudentHome() {
    const navigate = useNavigate();

    const handleProfileClick = () => {
        navigate('/profile');
    };

    const handleShowStudentCoursesClick = () => {
        navigate('/allCource');
    };

    const selectCourse = () => {
        navigate('/selectcourse');
    };

    return (
        <div className="container">
            <h2 className="mt-5">Student Home</h2>
            <button onClick={handleProfileClick} className="btn btn-primary me-2 mt-3">Profile</button>
            <button onClick={handleShowStudentCoursesClick} className="btn btn-primary me-2 mt-3">Show Student Courses</button>
            <button onClick={selectCourse} className="btn btn-primary me-2 mt-3">Select Courses</button>
        </div>
    );
}

export default StudentHome;
