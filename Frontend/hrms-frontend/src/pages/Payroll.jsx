import React from "react";
import "../index.css";
import Sidebar from "../components/Sidebar";
import Navbar from "../components/Navbar";

export default function Payroll() {
  return (
    <div className="layout">

      <Sidebar />

      <div className="main">

        <Navbar />

        <div className="dashboard-content">

          <div className="table-container">

            <h2>Payroll</h2>

            <table>

              <thead>
                <tr>
                  <th>Name</th>
                  <th>Salary</th>
                  <th>Bonus</th>
                  <th>Total</th>
                </tr>
              </thead>

              <tbody>

                <tr>
                  <td>Gauresh</td>
                  <td>₹50,000</td>
                  <td>₹5,000</td>
                  <td>₹55,000</td>
                </tr>

              </tbody>

            </table>

          </div>

        </div>

      </div>

    </div>
  );
}