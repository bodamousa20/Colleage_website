import React, { useState, useEffect } from 'react';

function DoctorProfile({ doctorId }) {
    const [doctorProfile, setDoctorProfile] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        async function fetchDoctorProfile() {
            try {
                const response = await fetch(`http://localhost:8080/doctor/profile/${doctorId}`);
                if (!response.ok) {
                    throw new Error('Failed to fetch doctor profile');
                }
                const data = await response.json();
                setDoctorProfile(data);
                setLoading(false);
            } catch (error) {
                console.error('Error fetching doctor profile:', error);
            }
        }

        fetchDoctorProfile();

        // Cleanup function
        return () => {
            // Cleanup code if needed
        };
    }, [doctorId]);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (!doctorProfile) {
        return <div>Error: Failed to load doctor profile</div>;
    }

    return (
        <div>
            <h2>Doctor Profile</h2>
            <p>Name: {doctorProfile.name}</p>
            <p>Age: {doctorProfile.age}</p>
            <p>SSN: {doctorProfile.ssn}</p>
            <p>Email: {doctorProfile.email}</p>
            <p>Gender: {doctorProfile.gender}</p>
            <p>Salary: ${doctorProfile.salary}</p>
            <p>Courses:</p>
            <ul>
                {doctorProfile.courses.map(course => (
                    <li key={course.id}>
                        {course.name} - Degree: {course.degree}, Department: {course.department}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default DoctorProfile;
