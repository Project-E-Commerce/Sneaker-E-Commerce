import { Link, NavLink } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faFacebook, faInstagram, faLinkedin, faTwitter} from '@fortawesome/free-brands-svg-icons';
import { faCopyright, faPaperPlane } from '@fortawesome/free-regular-svg-icons';

const UserFooter = () => {
    return (
        <footer className='bg-[#000000] text-[#ffffff] pt-[2.5rem]'>
            <div className='upper flex justify-between px-20 mb-18'>
                <div className='flex flex-col gap-3.5'>
                    <h1 className='text-2xl font-medium'>Buffalow Sneaker</h1>
                    <h3 className='text-xl'>Subscribe</h3>
                    <p className='text-sm'>Get 10% off your first order</p>
                    <div className='flex border-1 w-fit mitborder-[#ffffff] p-2.5 rounded-md '>
                        <input type="text" placeholder='Enter your email' className='focus:outline-none' />
                        <button className='hover:cursor-pointer'>
                            <FontAwesomeIcon icon={faPaperPlane} />
                        </button>
                    </div>
                </div>
                <div className='flex flex-col gap-3.5'>
                    <h3 className='text-xl'>Address and Contact</h3>
                    <p className='text-sm'>Address goes here</p>
                    <p className='text-sm'>buffalowsneaker101@gmail.com</p>
                    <p className='text-sm'>0234xxxxxxxx</p>
                    <div className='socialIcons flex gap-10'>
                        <FontAwesomeIcon icon={faFacebook} size='lg'/>
                        <FontAwesomeIcon icon={faTwitter} size='lg'/>
                        <FontAwesomeIcon icon={faInstagram} size='lg'/>
                        <FontAwesomeIcon icon={faLinkedin} size='lg'/>
                    </div>
                </div>
                <div className='flex flex-col gap-3.5'>
                    <h3 className='text-xl'>Account</h3>
                    <Link to='' className='hover:underline text-sm'>My Account</Link>
                    <Link to='' className='hover:underline text-sm'>Login/Register</Link>
                    <Link to='' className='hover:underline text-sm'>Cart</Link>
                    <Link to='' className='hover:underline text-sm'>Wishlist</Link>
                </div>
                <div className='flex flex-col gap-3.5'>
                    <h3 className='text-xl'>Quick Link</h3>
                    <Link to='' className='hover:underline text-sm'>Privacy Policy</Link>
                    <Link to='' className='hover:underline text-sm'>Terms Of Use</Link>
                    <Link to='' className='hover:underline text-sm'>FAQ</Link>
                </div>
                <div className='flex flex-col gap-3.5'>
                    <h3 className='text-xl'>Download App</h3>
                    <p className='text-[12px] text-[#8a8585]'>Save 10% with App New User Only</p>
                    
                </div>
            </div>
            <div className='lower border-t-[0.5px] border-[#3d3d3d] flex justify-center pt-3 pb-6 text-[#3d3d3d] '>
                <div className='flex items-center gap-2.5' >
                    <FontAwesomeIcon icon={faCopyright} />
                    <p>
                        Copyright Buffalow Sneaker 2025. All right reserved
                    </p>
                </div>
            </div>
        </footer>
    )
}

export default UserFooter;