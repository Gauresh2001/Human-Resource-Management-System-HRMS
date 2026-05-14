import { useState } from "react";

import { useNavigate } from "react-router-dom";

import API from "../services/api";

export default function Register() {

  const nav = useNavigate();

  const [form, setForm] = useState({

    firstName: "",
    lastName: "",
    email: "",
    password: "",
    phone: "",
    address: "",
    gender: "",
    salary: "",

  });

  const handleChange = (e) => {

    setForm({
      ...form,
      [e.target.name]:
        e.target.value,
    });
  };

  const submit = async (e) => {

    e.preventDefault();

    try {

      await API.post(
        "/auth/register",
        form
      );

      alert(
        "Registered Successfully"
      );

      nav("/");

    } catch (error) {

      alert(
        "Registration Failed"
      );
    }
  };

  return (

    <div className="auth-container">

      <div className="auth-card">

        <h2>Employee Register</h2>

        <form onSubmit={submit}>

          <input
            name="firstName"
            placeholder="First Name"
            onChange={handleChange}
          />

          <input
            name="lastName"
            placeholder="Last Name"
            onChange={handleChange}
          />

          <input
            name="email"
            placeholder="Email"
            onChange={handleChange}
          />

          <input
            type="password"
            name="password"
            placeholder="Password"
            onChange={handleChange}
          />

          <input
            name="phone"
            placeholder="Phone"
            onChange={handleChange}
          />

          <input
            name="address"
            placeholder="Address"
            onChange={handleChange}
          />

          <select
            name="gender"
            onChange={handleChange}
          >
            <option value="">
              Select Gender
            </option>

            <option value="MALE">
              Male
            </option>

            <option value="FEMALE">
              Female
            </option>

          </select>

          <input
            name="salary"
            placeholder="Salary"
            onChange={handleChange}
          />

          <button
            type="submit"
            className="auth-btn"
          >
            Register
          </button>

        </form>

      </div>

    </div>
  );
}