import { Link } from "react-router-dom"


const UserLogin = () => {
    return (
        <div className="flex gap-10">
            <div className="leftPic">hehe</div>
            <div className="formCtn">
                <form className="flex flex-col">
                    <h1>Login to Buffalow</h1>
                    <p>Enter your details below</p>
                    <input type='text' placeholder="Email or Phone Number" id="emailPhone" className="border-b-1" />
                    <input type='password' placeholder="Password" id="password" className="border-b-1" />
                    <div className="lowerForm flex">
                        <button type="submit" className="bg-[#DB4444] px-10 py-2.5 rounded-[4px] text-white cursor-pointer">
                            Log In
                        </button>

                        <Link className="forget text-[#DB4444]">Forget Password?</Link>
                    </div>
                </form>
            </div>
        </div>
    )
}
export default UserLogin