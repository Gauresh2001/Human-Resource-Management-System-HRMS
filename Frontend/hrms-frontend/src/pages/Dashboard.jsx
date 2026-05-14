import React, { useEffect, useState } from "react";
import "../index.css";
import Sidebar from "../components/Sidebar";
import Navbar from "../components/Navbar";
import API from "../services/api";

export default function Dashboard() {

  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    fetchEmployees();
  }, []);

  const fetchEmployees = async () => {
    try {

      const response = await API.get("/employees");

      setEmployees(response.data);

    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="layout">

      <Sidebar />

      <div className="main">

        <Navbar />

        <div className="content">

          <h1>
            Welcome Admin 👋
          </h1>

          <div className="cards">

            {/* Total Employees */}
            <div className="card">
              <h3>Total Employees</h3>

              <h1>
                {employees.length}
              </h1>
            </div>

            {/* Attendance */}
            <div className="card">
              <h3>Attendance</h3>

              <h1>96%</h1>
            </div>

            {/* Leave */}
            <div className="card">
              <h3>Leave Requests</h3>

              <h1>0</h1>
            </div>

            {/* Payroll */}
            <div className="card">
              <h3>Payroll</h3>

              <h1>
                ₹
                {employees.reduce(
                  (total, emp) =>
                    total + (emp.salary || 0),
                  0
                )}
              </h1>
            </div>

          </div>

          {/* Recent Employees */}

          <div className="table-container">

            <h2 style={{ marginBottom: "20px" }}>
              Recent Employees
            </h2>

            <table>

              <thead>
                <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Department</th>
                  <th>Status</th>
                </tr>
              </thead>

              <tbody>

                {employees.map((emp) => (

                  <tr key={emp.id}>

                    <td>{emp.id}</td>

                    <td>
                      {emp.firstName} {emp.lastName}
                    </td>

                    <td>{emp.email}</td>

                    <td>
                      {emp.department?.departmentName}
                    </td>

                    <td>{emp.status}</td>

                  </tr>

                ))}

              </tbody>

            </table>

          </div>

        </div>

      </div>

    </div>
  );
}