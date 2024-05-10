import React from 'react';
import { BrowserRouter , Route, Routes } from 'react-router-dom';
import LoginForms from './pages/login'; // Import LoginForm component
import AdminHome from './pages/Adminhome';
import AddStudent from './pages/Addstudent';
import AddDoctor from './pages/adddoctor';
import AddCourse from './pages/addcourse';
import CourseTodoctor from './pages/courcetodoctor';
import StudentHome from './pages/Studenthome';
import AllCource from './pages/allcources';
import Profile from './pages/studentprofile';
import SelectCource from './pages/studentselectcourse';
import DoctorHome from './pages/DoctrorHome';
import Doctorprofile from './pages/doctorprof';








function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<LoginForms />} />
    
      <Route path="/admin-home" element={<AdminHome />} />
        <Route path="/add-student" element={<AddStudent />} />
        <Route path="/add-doctor" element={<AddDoctor />} />
        <Route path="/add-course" element={<AddCourse />} />
        <Route path="/assign-cource-doctor" element={<CourseTodoctor />} />
        <Route path="/student-home" element={< StudentHome/>} />
        <Route path="/allCource" element={< AllCource/>} />
        <Route path="/profile" element={< Profile/>} />
        <Route path="/selectcourse" element={< SelectCource/>} />
        <Route path="/doctor-home" element={< DoctorHome/>} />
        <Route path="/doctor-profile" element={< Doctorprofile/>} />

        









        </Routes>
    </BrowserRouter>
  );
}

export default App;
