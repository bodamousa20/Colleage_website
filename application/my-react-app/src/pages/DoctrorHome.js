import React from 'react';
import { useNavigate } from 'react-router-dom';

function DoctorHome() {
    const navigate = useNavigate(); // Initialize useNavigate

    // Function to handle navigating to profile page
    const handleProfile = () => {
        navigate('/doctor-profile'); // Navigate to the Profile page
    };

    return (
        <div>
            <h2>Doctor Home</h2>
            <button onClick={handleProfile}>Profile</button>
            {/* Add more buttons or content specific to the doctor's homepage */}
        </div>
    );
}

export default DoctorHome;
