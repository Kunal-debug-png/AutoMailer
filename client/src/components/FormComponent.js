import React, { useState } from 'react';

const FormComponent = () => {
  const [formData, setFormData] = useState({
    fname: "",
    lname: "",
    to: "",
    companyName: "",
    role: "",
    person: "",
    jobId: "",
    jobUrl: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Handle form submission here
    console.log(formData);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="mb-3">
        <label htmlFor="fname" className="form-label">First Name</label>
        <input type="text" className="form-control" id="fname" name="fname" value={formData.fname} 
        onChange={handleChange} />
      </div>
      <div className="mb-3">
        <label htmlFor="lname" className="form-label">Last Name</label>
        <input type="text" className="form-control" id="lname" name="lname" value={formData.lname} onChange={handleChange} />
      </div>
      <div className="mb-3">
        <label htmlFor="to" className="form-label">To</label>
        <input type="text" className="form-control" id="to" name="to" value={formData.to} onChange={handleChange} />
      </div>
      <div className="mb-3">
        <label htmlFor="companyName" className="form-label">Company Name</label>
        <input type="text" className="form-control" id="companyName" name="companyName" value={formData.companyName} onChange={handleChange} />
      </div>
      <div className="mb-3">
        <label htmlFor="role" className="form-label">Role</label>
        <input type="text" className="form-control" id="role" name="role" value={formData.role} onChange={handleChange} />
      </div>
      <div className="mb-3">
        <label htmlFor="person" className="form-label">Person</label>
        <input type="text" className="form-control" id="person" name="person" value={formData.person} onChange={handleChange} />
      </div>
      <div className="mb-3">
        <label htmlFor="jobId" className="form-label">Job ID</label>
        <input type="text" className="form-control" id="jobId" name="jobId" value={formData.jobId} onChange={handleChange} />
      </div>
      <div className="mb-3">
        <label htmlFor="jobUrl" className="form-label">Job URL</label>
        <input type="text" className="form-control" id="jobUrl" name="jobUrl" value={formData.jobUrl} onChange={handleChange} />
      </div>
      <button type="submit" className="btn btn-primary">Submit</button>
    </form>
  );
};

export default FormComponent;
