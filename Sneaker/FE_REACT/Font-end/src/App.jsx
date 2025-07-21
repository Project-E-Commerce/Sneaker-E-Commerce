// import { useState } from 'react'

import './App.css'
import UserHeader from './shared/component/user/Header'
import UserFooter from './shared/component/user/Footer'
import AccountSidebar from './shared/component/admin/AccountSidebar'
import EditProfileForm from './shared/component/admin/EditProfileForm'


function App() {

  return (
    <div className="min-h-screen bg-gray-100">
      {/* <UserHeader />
      <UserFooter/> */}
      <AccountSidebar/>
      <EditProfileForm/>
    </div>
  )
}

export default App
