import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import SectionLabel from "./SectionLabel";
import { PrevAndNext } from "./Buttons/PrevAndNext";
import { ViewAll } from "./Buttons/ViewAll";
const ProductsList = ({ label, secName, itemNum, isDisabledTop, isDisabledBtm }) => {
    const data = [
        { id: 1, prodName: 'Shoes 1', img: 'https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i3Yp1mXpDIMA/v2/1200x836.webp', price: '$100' },
        { id: 2, prodName: 'Shoes 1', img: 'https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i3Yp1mXpDIMA/v2/1200x836.webp', price: '$100' },
        { id: 3, prodName: 'Shoes 1', img: 'https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i3Yp1mXpDIMA/v2/1200x836.webp', price: '$100' },
        { id: 4, prodName: 'Shoes 1', img: 'https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i3Yp1mXpDIMA/v2/1200x836.webp', price: '$100' },
        { id: 5, prodName: 'Shoes 1', img: 'https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i3Yp1mXpDIMA/v2/1200x836.webp', price: '$100' },
        { id: 5, prodName: 'Shoes 1', img: 'https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i3Yp1mXpDIMA/v2/1200x836.webp', price: '$100' },
        { id: 5, prodName: 'Shoes 1', img: 'https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i3Yp1mXpDIMA/v2/1200x836.webp', price: '$100' },
    ];

    const displayData = itemNum ? data.slice(0, itemNum) : data;
    
    const [currentIndex, setCurrentIndex] = useState(0);

    const handlePrev = () => {
        if (currentIndex > 0) {
            setCurrentIndex(currentIndex - 1);
        }
    };

    return (
        <>
            <SectionLabel label={label} secName={secName}>
                <ViewAll viewAll={''} disable={isDisabledTop} />
            </SectionLabel>
            <div className="carouselCtn flex flex-wrap mx-20 mt-10 overflow-hidden relative justify-start gap-[35px] pb-[1rem]"
                // style={{ maxWidth: 'calc(14rem * 5 + 4 * 4rem)' }}
            >
                {data.slice(0, itemNum).map((item, id) =>
                (
                    <Link key={id} to={''}
                        className="carouselItemCtn font-medium text-[16px] flex-shrink-0 flex flex-col justify-center bg-[#ffffff] cursor-pointer rounded-md pb-4"
                        
                        >
                        <img src={item.img} alt={item.prodName} className="h-[12rem] w-[14rem]" />
                        <div className=" mt-[0.5rem]">{item.prodName}</div>
                        <div className="text-[#e70d0d]">{item.price}</div>
                    </Link>
                )
                )}
            </div>
            <div className="flex justify-center items-center">
                <ViewAll viewAll={''} disable={isDisabledBtm} />
            </div>
        </>


    );
}
export default ProductsList;