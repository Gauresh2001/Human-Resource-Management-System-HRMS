import React from "react";
import "../index.css";
import Sidebar from "../components/Sidebar";
import Navbar from "../components/Navbar";

export default function Leave() {
  return (
    <div className="layout">

      <Sidebar />

      <div className="main">

        <Navbar />

        <div className="dashboard-content">

          <div className="table-container">

            <h2>Leave Requests</h2>

            <table>

              <thead>
                <tr>
                  <th>Name</th>
                  <th>Type</th>
                  <th>Days</th>
                  <th>Status</th>
                </tr>
              </thead>

              <tbody>

                <tr>
                  <td>Gauresh</td>
                  <td>Sick Leave</td>
                  <td>2</td>
                  <td>Approved</td>
                </tr>

              </tbody>

            </table>

          </div>

        </div>

      </div>

    </div>
  );
}