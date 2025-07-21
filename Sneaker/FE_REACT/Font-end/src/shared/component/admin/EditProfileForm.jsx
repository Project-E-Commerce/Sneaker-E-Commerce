// EditProfileForm.js
import React, { useState } from 'react';

const EditProfileForm = () => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    address: '',
    currentPassword: '',
    newPassword: '',
    confirmPassword: '',
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  return (
    <div className="max-w-3xl mx-auto p-6 bg-white rounded shadow">
      <h2 className="text-lg font-semibold text-red-500 mb-6">Edit Your Profile</h2>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        <div>
          <label className="block mb-1 text-sm">First Name</label>
          <input
            name="firstName"
            value={formData.firstName}
            onChange={handleChange}
            className="w-full border border-gray-300 rounded px-3 py-2"
          />
        </div>
        <div>
          <label className="block mb-1 text-sm">Last Name</label>
          <input
            name="lastName"
            value={formData.lastName}
            onChange={handleChange}
            className="w-full border border-gray-300 rounded px-3 py-2"
          />
        </div>
        <div>
          <label className="block mb-1 text-sm">Email</label>
          <input
            name="email"
            type="email"
            value={formData.email}
            onChange={handleChange}
            className="w-full border border-gray-300 rounded px-3 py-2"
          />
        </div>
        <div>
          <label className="block mb-1 text-sm">Address</label>
          <input
            name="address"
            value={formData.address}
            onChange={handleChange}
            className="w-full border border-gray-300 rounded px-3 py-2"
          />
        </div>
      </div>

      <div className="mt-6">
        <label className="block mb-2 font-semibold text-sm">Password Changes</label>
        <input
          name="currentPassword"
          type="password"
          placeholder="Current Password"
          value={formData.currentPassword}
          onChange={handleChange}
          className="w-full mb-3 border border-gray-300 rounded px-3 py-2"
        />
        <input
          name="newPassword"
          type="password"
          placeholder="New Password"
          value={formData.newPassword}
          onChange={handleChange}
          className="w-full mb-3 border border-gray-300 rounded px-3 py-2"
        />
        <input
          name="confirmPassword"
          type="password"
          placeholder="Confirm New Password"
          value={formData.confirmPassword}
          onChange={handleChange}
          className="w-full border border-gray-300 rounded px-3 py-2"
        />
      </div>

      <div className="flex justify-end gap-4 mt-6">
        <button className="text-gray-500 hover:underline">Cancel</button>
        <button className="bg-red-500 hover:bg-red-600 text-white px-6 py-2 rounded">
          Save Changes
        </button>
      </div>
    </div>
  );
};

export default EditProfileForm;
