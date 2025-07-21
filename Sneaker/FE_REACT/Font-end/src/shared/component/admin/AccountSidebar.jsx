import React from 'react';

const AccountSidebar = () => {
  return (
    <div className="w-full max-w-xs p-4 text-sm text-gray-700">
      <div className="mb-4">
        <h2 className="font-semibold text-black mb-2">Manage My Account</h2>
        <ul className="space-y-1">
          <li className="text-red-500 font-medium">My Profile</li>
          <li className="text-gray-500">Address Book</li>
          <li className="text-gray-500">My Payment Options</li>
        </ul>
      </div>

      <div className="mb-4">
        <h2 className="font-semibold text-black mb-2">My Orders</h2>
        <ul className="space-y-1">
          <li className="text-gray-500">My Returns</li>
          <li className="text-gray-500">My Cancellations</li>
        </ul>
      </div>

      <div>
        <h2 className="font-semibold text-black">My Wishlist</h2>
      </div>
    </div>
  );
};

export default AccountSidebar;