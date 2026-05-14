import { useState } from "react";

import { useNavigate } from "react-router-dom";

import API from "../services/api";

export default function Login() {

  const nav = useNavigate();

  const [email, setEmail] =
    useState("");

  const [password, setPassword] =
    useState("");

  const login = async (e) => {

    e.preventDefault();

    try {

      const res = await API.post(
        "/auth/login",
        {
          email,
          password,
        }
      );

      localStorage.setItem(
        "token",
        res.data.token
      );

      nav("/dashboard");

    } catch (error) {

      alert("Invalid Credentials");
    }
  };

  return (

    <div className="auth-container">

      <div className="auth-card">

        <h2>HRMS Login</h2>

        <form onSubmit={login}>

          <input
            type="email"
            placeholder="Enter Email"
            onChange={(e) =>
              setEmail(e.target.value)
            }
          />

          <input
            type="password"
            placeholder="Enter Password"
            onChange={(e) =>
              setPassword(e.target.value)
            }
          />

          <button
            type="submit"
            className="auth-btn"
          >
            Login
          </button>

        </form>

        <p
          className="auth-link"
          onClick={() =>
            nav("/register")
          }
        >
          Create Account
        </p>

      </div>

    </div>
  );
}