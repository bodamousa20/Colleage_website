import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS

function AddDoctor() {
    const handleSubmit = (e) => {
        e.preventDefault();

        // Capture form data using document.getElementById
        const formData = {
            id: parseInt(document.getElementById('id').value, 10),
            name: document.getElementById('name').value,
            age: parseInt(document.getElementById('age').value, 10),
            ssn: document.getElementById('ssn').value,
            email: document.getElementById('email').value,
            password: document.getElementById('password').value,
            gender: document.getElementById('gender').value,
            salary: parseInt(document.getElementById('salary').value, 10)
        };

        // Run API request here using formData
        fetch('http://localhost:8080/admin/createDoctor', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(response => {
            if (response.ok) {
                console.log('Doctor added successfully');
                // Redirect or show success message
            } else {
                console.error('Failed to add doctor');
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
            <h2 className="mt-5">Add Doctor</h2>
            <form onSubmit={handleSubmit} className="mt-4">
                <div className="mb-3">
                    <label htmlFor="id" className="form-label">ID:</label>
                    <input type="number" id="id" className="form-control" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="name" className="form-label">Name:</label>
                    <input type="text" id="name" className="form-control" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="age" className="form-label">Age:</label>
                    <input type="number" id="age" className="form-control" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="ssn" className="form-label">SSN:</label>
                    <input type="text" id="ssn" className="form-control" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email:</label>
                    <input type="email" id="email" className="form-control" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password:</label>
                    <input type="password" id="password" className="form-control" required />
                </div>
                <div className="mb-3">
                    <label htmlFor="gender" className="form-label">Gender:</label>
                    <select id="gender" className="form-select" required>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>
                <div className="mb-3">
                    <label htmlFor="salary" className="form-label">Salary:</label>
                    <input type="number" id="salary" className="form-control" required />
                </div>
                <button type="submit" className="btn btn-primary">Add Doctor</button>
            </form>
        </div>
    );
}

export default AddDoctor;
