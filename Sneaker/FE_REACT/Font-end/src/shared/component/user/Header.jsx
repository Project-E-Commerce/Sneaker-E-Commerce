import { useState } from 'react'
import { Link, NavLink } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMagnifyingGlass, faCartShopping, faUser, faBagShopping, faX, faStar, faArrowRightFromBracket } from '@fortawesome/free-solid-svg-icons';
import { faHeart } from '@fortawesome/free-regular-svg-icons';

const UserHeader = () => {
    const [showMenu, setShowMenu] = useState(false);

    const toggleUserMenu = () => {
        setShowMenu(!showMenu);
    }

    return (
        <header className="bg-white w-full flex items-center justify-between border-b-1 border-[#c2c2c2] pt-[2.5rem] pb-4 px-20 relative">
            <div className='logoNameCtn flex items-center gap-2'>
                <img src="logo" alt="logo" className=' border-1 border-black' />
                <Link to='' className='text-black text-2xl font-bold'>BuffalowSneaker</Link>
            </div>
            <div className='linksCtn flex items-center justify-between w-[35%] font-medium'>
                <div>
                    <Link to='' className='hover:underline'>Home</Link>
                </div>
                <div>
                    <Link to='' className='hover:underline'>Contact</Link>
                </div>
                <div>
                    <Link to='' className='hover:underline'>About</Link>
                </div>
                <div>
                    <Link to='' className='hover:underline'>Sign Up</Link>
                </div>
            </div>
            <div className='btnsCtn flex items-center justify-between w-[30%]'>
                <div className=' rounded-md py-2 px-3 bg-[#f2f2f2]'>
                    <input type='text' className='mr-2 placeholder:text-sm  focus:outline-none' placeholder='What are you looking for?' />
                    <button>
                        <FontAwesomeIcon icon={faMagnifyingGlass} size={'lg'} className='text-black hover:cursor-pointer' />
                    </button>
                </div>
                <Link>
                    <FontAwesomeIcon icon={faHeart} size={'lg'} className='cursor-pointer' />
                </Link>
                <Link>
                    <FontAwesomeIcon icon={faCartShopping} size={'lg'} className='cursor-pointer' />
                </Link>
                <div className='userBtnCtn' >
                    <button onClick={toggleUserMenu}>
                        <FontAwesomeIcon icon={faUser} size={'lg'} className='cursor-pointer' />
                    </button>
                </div>
            </div>

            {showMenu && (
                <div className='userMenu absolute top-full right-20 border-1 border-black py-3 px-3.5 flex flex-col gap-3.5 text-[12px] text-white bg-gray-900 z-1'>
                    <Link to='/profile' className='flex gap-2 items-center'>
                        <FontAwesomeIcon icon={faUser} size={'lg'} />
                        <p>Manage My Account</p>
                    </Link>
                    <Link to='/orders' className='flex gap-2 items-center '>
                        <FontAwesomeIcon icon={faBagShopping} size={'lg'} />
                        <p>My Orders</p>
                    </Link>
                    <Link to='/cancelled' className='flex gap-2 items-center'>
                        <FontAwesomeIcon icon={faX} size={'lg'} />
                        <p>My Cancellations</p>
                    </Link>
                    <Link to='/reviews' className='flex gap-2 items-center'>
                        <FontAwesomeIcon icon={faStar} size={'lg'} />
                        <p>My Reviews</p>
                    </Link>
                    <Link to='/logout' className='flex gap-2 items-center'>
                        <FontAwesomeIcon icon={faArrowRightFromBracket} size={'lg'} />
                        <p>Logout</p>
                    </Link>
                </div>
            )}

        </header>
    )
}

export default UserHeader;