import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
// Import other necessary components or stylesheets here

function AddCourse() {
    const handleSubmit = (e) => {
        e.preventDefault();

        // Extracting data from form fields
        const courseId = parseInt(document.getElementById('id').value, 10);
        const courseName = document.getElementById('name').value;
        const courseDepartment = document.getElementById('department').value;

        // Constructing course object
        const courseData = [{
            id: courseId,
            name: courseName,
            department: courseDepartment
        }];

        // Run API request here using courseData
        fetch('http://localhost:8080/admin/addCourse', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(courseData)
        })
            .then(response => {
                if (response.ok) {
                    console.log('Course added successfully');
                    // Redirect or show success message
                } else {
                    console.error('Failed to add course');
                    // Handle error
                }
            })
            .catch(error => {
                console.error('Error:', error);
                // Handle error
            });
    };

    return (
        <div className="container">
            <h2>Add Course</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="id" className="form-label">ID:</label>
                    <input type="number" id="id" className="form-control" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="name" className="form-label">Name:</label>
                    <input type="text" id="name" className="form-control" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="department" className="form-label">Department:</label>
                    <input type="text" id="department" className="form-control" required />
                </div>
                <button type="submit" className="btn btn-primary">Add Course</button>
            </form>
        </div>
    );
}

export default AddCourse;
