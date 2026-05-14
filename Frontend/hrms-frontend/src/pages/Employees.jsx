import React, { useEffect, useState } from "react";
import axios from "axios";
import "../index.css";

import Sidebar from "../components/Sidebar";
import Navbar from "../components/Navbar";

export default function Employees() {

  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    fetchEmployees();
  }, []);

  const fetchEmployees = async () => {
    try {

      const response = await axios.get(
        "http://localhost:8080/api/employees"
      );

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

        <div className="dashboard-content">

          <div className="table-container">

            <h2 style={{ marginBottom: "20px" }}>
              Employees List
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