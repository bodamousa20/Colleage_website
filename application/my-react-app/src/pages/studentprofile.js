import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS

function Profile() {
    const [profileData, setProfileData] = useState(null);

    useEffect(() => {
        const studentId = localStorage.getItem('userId');

        fetch(`http://localhost:8080/Student/profile/${studentId}`)
            .then(response => response.json())
            .then(data => {
                setProfileData(data);
            })
            .catch(error => console.error('Error fetching student profile:', error));
    }, []);

    return (
        <div className="container">
            <h2 className="mt-5">Profile</h2>
            {profileData ? (
                <div>
                    <ul className="list-group mt-3">
                        <li className="list-group-item"><strong>ID:</strong> {profileData.id}</li>
                        <li className="list-group-item"><strong>Name:</strong> {profileData.name}</li>
                        <li className="list-group-item"><strong>Age:</strong> {profileData.age}</li>
                        <li className="list-group-item"><strong>SSN:</strong> {profileData.ssn}</li>
                        <li className="list-group-item"><strong>Email:</strong> {profileData.email}</li>
                        <li className="list-group-item"><strong>Gender:</strong> {profileData.gender}</li>
                        <li className="list-group-item"><strong>Level:</strong> {profileData.level}</li>
                        <li className="list-group-item"><strong>Accumulator GPA:</strong> {profileData.accumulator_gpa}</li>
                        <li className="list-group-item"><strong>Department:</strong> {profileData.department}</li>
                    </ul>
                    <h3 className="mt-4">Enrolled Courses:</h3>
                    <ul className="list-group">
                        {profileData.enrolledCourses.map(course => (
                            <li key={course.id} className="list-group-item">
                                <strong>ID:</strong> {course.id}, <strong>Name:</strong> {course.name}, <strong>Degree:</strong> {course.degree}, <strong>Department:</strong> {course.department}
                            </li>
                        ))}
                    </ul>
                </div>
            ) : (
                <p>Loading...</p>
            )}
        </div>
    );
}

export default Profile;
