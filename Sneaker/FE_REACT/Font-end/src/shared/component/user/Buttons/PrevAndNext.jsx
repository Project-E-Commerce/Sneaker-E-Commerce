import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faArrowAltCircleLeft, faArrowAltCircleRight } from '@fortawesome/free-solid-svg-icons';

export const PrevAndNext = ({ onPrev, onNext }) => {
    return (
        <div className='flex gap-[1rem]'>
            <button type='button' onClick={onPrev}>
                <FontAwesomeIcon icon={faArrowAltCircleLeft} size={'2xl'} className='text-black hover:cursor-pointer' />
            </button>
            <button type='button' onClick={onNext}>
                <FontAwesomeIcon icon={faArrowAltCircleRight} size={'2xl'} className='text-black hover:cursor-pointer' />
            </button>
        </div>
    )

}