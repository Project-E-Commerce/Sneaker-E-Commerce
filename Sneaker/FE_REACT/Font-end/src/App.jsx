import { useState } from 'react'

import './App.css'
import UserHeader from './shared/component/user/Header'
import UserFooter from './shared/component/user/Footer'

function App() {

  return (
    <div className="min-h-screen bg-gray-100">
      <UserHeader />
      <UserFooter/>
    </div>
  )
}

export default App
