import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

const EditStudent = () => {

    const { studentId } = useParams();

    let navigate = useNavigate();

    useEffect(() => {
        loadStudent()

    }, []);

    const loadStudent = async () => {

        const result = await axios.get(`http://localhost:8085/api/student/get/${studentId}`);

        setStudent(result.data);

    }

    const [student, setStudent] = useState({

        firstName: "",
        lastName: "",
        email: "",
        department: "",
    });

    const { firstName, lastName, email, department } = student;

    const handleInputChange = (e) => {

        setStudent({
            ...student, [e.target.name]: e.target.name,
        })
    }

    const updateStudent = async (e) => {

        e.preventDefault();
        await axios.put(`http://localhost:8085/api/student/update/${studentId}`, student);
        navigate("/view-students");
    }

    return (
        <div className="col-sm-8 py-2 px-5 offset-2 shadow">
            <h2 className="mt-5">Edit Student</h2>

            <form onSubmit={(e) => updateStudent(e)}>
                <div className="input-group mb-5">
                    <label className="input-group-text" htmlFor="firstName">First Name</label>
                    <input className="form-control col-sm-6" type="text" name="firstName" id="firstName" required value={firstName} onChange={(e) => handleInputChange(e)} />
                </div>
                <div className="input-group mb-5">
                    <label className="input-group-text" htmlFor="lastName">Last Name</label>
                    <input className="form-control col-sm-6" type="text" name="lastName" id="lastName" required value={lastName} onChange={(e) => handleInputChange(e)} />

                </div>
                <div className="input-group mb-5">
                    <label className="input-group-text" htmlFor="email"> Email</label>
                    <input className="form-control col-sm-6" type="email" name="email" id="email" required value={email} onChange={(e) => handleInputChange(e)} />

                </div>
                <div className="input-group mb-5">
                    <label className="input-group-text" htmlFor="department">Department</label>
                    <input className="form-control col-sm-6" type="text" name="department" id="department" required value={department} onChange={(e) => handleInputChange(e)} />
                </div>
            </form>
        </div>
    )
}

export default EditStudent