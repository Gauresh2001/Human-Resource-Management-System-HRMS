import React from "react";
import { Link } from "react-router-dom";

export default function Sidebar() {
  return (
    <div className="sidebar">

      <div className="sidebar-logo">
        HRMS
      </div>

      <Link to="/dashboard">Dashboard</Link>

      <Link to="/employees">Employees</Link>

      <Link to="/attendance">Attendance</Link>

      <Link to="/leave">Leave</Link>

      <Link to="/payroll">Payroll</Link>

    </div>
  );
}