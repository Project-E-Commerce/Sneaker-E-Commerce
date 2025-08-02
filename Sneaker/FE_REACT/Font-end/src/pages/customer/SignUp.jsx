import { Link } from "react-router-dom"


const UserSignUp = () => {
    return (
        <div className="flex gap-10 my-16">
              <div className="leftPic">hehe</div>
              <div className="formCtn">
                <form className="flex flex-col"> 
                    <h1 className="text-[36px] mb-2">Create an account</h1>
                    <p className="text-[16px] mb-8">Enter your details below</p>
                    <input type='text' placeholder="Name" id="name" className="border-b-1 border-[#c2c2c2] pb-1.5 mb-8 focus:outline-none "/>
                    <input type='text' placeholder="Email" id="email" className="border-b-1 border-[#c2c2c2] pb-1.5 mb-8 focus:outline-none"/>
                    <input type='text' placeholder="Phone Number" id="phone" className="border-b-1 border-[#c2c2c2] pb-1.5 mb-8 focus:outline-none"/>
                    <input type='text' placeholder="Phone Number" id="phone" className="border-b-1 border-[#c2c2c2] pb-1.5 mb-8 focus:outline-none"/>
                    <input type='password' placeholder="Password" id="password" className="border-b-1 border-[#c2c2c2] pb-1.5 mb-8 "/>
                    <button type="submit" className="bg-[#DB4444] px-10 py-2.5 rounded-[4px] cursor-pointer text-white">
                        Create Account
                    </button>
                </form>
                <div className="loginLink flex gap-3 mt-6 items-center justify-center">
                    <p className="text-[#807d7d]">Already have an account?</p>
                    <Link to="/login" className="hover:underline font-medium">Login</Link>
                </div>
              </div>
        </div>
    )
}
export default UserSignUp