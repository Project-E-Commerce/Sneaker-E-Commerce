import { Link, NavLink } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMagnifyingGlass, faCartShopping } from '@fortawesome/free-solid-svg-icons';
import { faHeart } from '@fortawesome/free-regular-svg-icons';

const UserHeader = () => {
    return (
        <header className="bg-white w-full flex items-center justify-between border-b-1 border-[#c2c2c2] pt-[2.5rem] pb-4 px-20">
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
            <div className='btnsCtn flex items-center justify-between w-[26%]'>
                <div className=' rounded-md py-2 px-3 bg-[#f2f2f2]'>
                    <input type='text' className='mr-2 placeholder:text-sm  focus:outline-none' placeholder='What are you looking for?' />
                    <button>
                        <FontAwesomeIcon icon={faMagnifyingGlass} size={'lg'} className='text-black hover:cursor-pointer' />
                    </button>
                </div>
                <button>
                    <FontAwesomeIcon icon={faHeart} size={'lg'} className='hover:cursor-pointer'/>
                </button>
                <button>
                    <FontAwesomeIcon icon={faCartShopping} size={'lg'} className='hover:cursor-pointer'/>
                </button>
            </div>


        </header>
    )
}

export default UserHeader;