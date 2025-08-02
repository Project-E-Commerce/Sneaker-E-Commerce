import { Link } from "react-router-dom"


const UserLogin = () => {
    return (
        <div className="flex gap-10 my-16">
            <div className="leftPic">hehe</div>
            <div className="formCtn">
                <form className="flex flex-col">
                    <h1 className="text-[36px] mb-2">Login to Buffalow</h1>
                    <p className="text-[16px] mb-8">Enter your details below</p>
                    <input type='text' placeholder="Email or Phone Number" id="emailPhone" className="border-b-1 border-[#c2c2c2] pb-1.5 mb-8 focus:outline-none " />
                    <input type='password' placeholder="Password" id="password" className="border-b-1 border-[#c2c2c2] pb-1.5 mb-8 focus:outline-none " />
                    <div className="lowerForm flex items-center justify-between">
                        <button type="submit" className="bg-[#DB4444] px-10 py-2.5 rounded-[4px] cursor-pointer text-white">
                            Log In
                        </button>
                        <div className="forgetCtn ">
                            <Link className="forget text-[#DB4444] hover:underline font-medium">Forget Password?</Link>
                            
                        </div>
                    </div>
                </form>
            </div>
        </div>
    )
}
export default UserLogin