import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate from React Router
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS

function LoginForm() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate(); // Initialize useNavigate

    const handleEmailChange = (event) => {
        setEmail(event.target.value);
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };

    const login = (event) => {
        event.preventDefault(); // Prevent the default form submission behavior

        // Make a POST request to the login API
        fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                Email: email,
                password: password
            })
        })
        .then(response => {
            if (response.ok) {
                return response.json(); // Parse response JSON
            } else {
                throw new Error('Login failed');
            }
        })
        .then(data => {
            // Save user ID and role to local variables or localStorage
            const { id, role } = data;
            // Save to localStorage
            localStorage.setItem('userId', id);
            localStorage.setItem('userRole', role);
            console.log(data);
            
            // Redirect to different home pages based on role
            switch (role) {
                case 'admin':
                    navigate('/admin-home');
                    break;
                case 'student':
                    navigate('/student-home');
                    break;
                case 'doctor':
                    navigate('/doctor-home');
                    break;
                default:
                    console.error('Invalid role');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            setError('Login failed. Please try again.');
        });
    };

    return (
        <div className="container" style={{ maxWidth: '400px', margin: '100px auto' }}>
            {/* Render error message if login fails */}
            {error && <div className="alert alert-danger">{error}</div>}
            <h2>Login Form</h2>
            <form onSubmit={login}>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email:</label>
                    <input type="text" id="email" name="email" placeholder="Enter your email" value={email} onChange={handleEmailChange} className="form-control" />
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password:</label>
                    <input type="password" id="password" name="password" placeholder="Enter your password" value={password} onChange={handlePasswordChange} className="form-control" />
                </div>
                <div>
                    <button type="submit" className="btn btn-primary">Sign in</button>
                </div>
            </form>
        </div>
    );
}

export default LoginForm;
