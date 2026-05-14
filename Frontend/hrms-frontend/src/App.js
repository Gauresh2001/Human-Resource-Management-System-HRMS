import { BrowserRouter, Routes, Route } from "react-router-dom";

import Dashboard from "./pages/Dashboard";
import Employees from "./pages/Employees";
import Attendance from "./pages/Attendance";
import Leave from "./pages/Leave";
import Payroll from "./pages/Payroll";

function App() {
  return (
    <BrowserRouter>

      <Routes>

        <Route path="/" element={<Dashboard />} />

        <Route path="/dashboard" element={<Dashboard />} />

        <Route path="/employees" element={<Employees />} />

        <Route path="/attendance" element={<Attendance />} />

        <Route path="/leave" element={<Leave />} />

        <Route path="/payroll" element={<Payroll />} />

      </Routes>

    </BrowserRouter>
  );
}

export default App;