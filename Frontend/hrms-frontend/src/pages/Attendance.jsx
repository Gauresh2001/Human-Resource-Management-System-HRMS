import React from "react";
import "../index.css";
import Sidebar from "../components/Sidebar";
import Navbar from "../components/Navbar";

export default function Attendance() {

  return (
    <div className="layout">

      <Sidebar />

      <div className="main">

        <Navbar />

        <div className="dashboard-content">

          <div className="table-container">

            <h2>Attendance</h2>

            <table>

              <thead>
                <tr>
                  <th>Name</th>
                  <th>Present</th>
                  <th>Absent</th>
                  <th>Percentage</th>
                </tr>
              </thead>

              <tbody>

                <tr>
                  <td>Gauresh</td>
                  <td>26</td>
                  <td>2</td>
                  <td>96%</td>
                </tr>

              </tbody>

            </table>

          </div>

        </div>

      </div>

    </div>
  );
}