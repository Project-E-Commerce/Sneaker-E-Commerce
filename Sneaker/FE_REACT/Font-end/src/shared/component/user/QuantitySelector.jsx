import { faMinus, faPlug, faPlus } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useState, useEffect } from 'react';

const QuantitySelector = ({ initialQuantity, }) => {
    const [quantity, setQuantity] = useState(initialQuantity);

    useEffect(() => {
        // Update local state if initialQuantity changes from parent
        setQuantity(initialQuantity);
    }, [initialQuantity]);

    const handleDecrease = () => {
        if (quantity > 1) {
            const newQuantity = quantity - 1;
            setQuantity(newQuantity);
            // onQuantityChange(newQuantity);
        } else {
            // Option to remove item if quantity goes to 0
            // onQuantityChange(productId, 0); 
        }
    };

    const handleIncrease = () => {
        const newQuantity = quantity + 1;
        setQuantity(newQuantity);
        // onQuantityChange(newQuantity);
    };

    const handleInputChange = (e) => {
        const value = parseInt(e.target.value, 10);
        if (!isNaN(value) && value >= 1) {
            setQuantity(value);
            // onQuantityChange(value);
        }
    };

    return (
        <div className="quantitySelector flex border-1 border-[#918c8c] rounded-md w-[40%] ">
            <button className='border-r-1  border-[#918c8c] px-2 py-1.5 cursor-pointer' onClick={handleDecrease} disabled={quantity <= 1}>
                <FontAwesomeIcon icon={faMinus} />
            </button>
            <input
                className='w-full text-center appearance-none [&::-webkit-inner-spin-button]:appearance-none [&::-webkit-outer-spin-button]:appearance-none'
                type="number"
                value={quantity}
                onChange={handleInputChange}
                min="1"
                disabled={true}

            />
            <button onClick={handleIncrease} className='border-l-1  border-[#918c8c] px-2 py-1.5 cursor-pointer'>
                <FontAwesomeIcon icon={faPlus} />
            </button>
        </div>
    );
};

export default QuantitySelector;