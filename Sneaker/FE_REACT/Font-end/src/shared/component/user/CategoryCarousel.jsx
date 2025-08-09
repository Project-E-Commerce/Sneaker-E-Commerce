import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import SectionLabel from "./SectionLabel";
import { PrevAndNext } from "./Buttons/PrevAndNext";
const CategoryCarousel = () => {
    const data = [
        { id: 1, cateName: 'Women', link: 'linkcategory' },
        { id: 2, cateName: 'Men', link: 'linkcategory' },
        { id: 3, cateName: 'Kids', link: 'linkcategory' },
        { id: 4, cateName: 'Sport', link: 'linkcategory' },
        { id: 5, cateName: 'Casual', link: 'linkcategory' },
        { id: 5, cateName: 'Casual', link: 'linkcategory' },
        { id: 5, cateName: 'Casual', link: 'linkcategory' },
    ];
    const [currentIndex, setCurrentIndex] = useState(0);

    const handlePrev = () => {
        if (currentIndex > 0) {
            setCurrentIndex(currentIndex - 1);
        }
    };

    const handleNext = () => {
        if (currentIndex < data.length - 1) {
            setCurrentIndex(currentIndex + 1);
        }
    };
    return (
        <>
            <SectionLabel label={'Categories'} secName={'Browse By Category'}>
                <PrevAndNext onNext={''} onPrev={''}/>
            </SectionLabel>
            <div className="carouselCtn flex mx-20 mt-10 relative justify-between pb-[3rem] border-b-10 border-[#c4c4c4]">
                {data.map((item, id) =>
                (
                    <Link key={id} to={item.link}
                        className="carouselItemCtn h-[8rem] w-[8rem] flex-shrink-0 flex items-center justify-center border-1 border-[#c4baba] bg-[#ffffff] cursor-pointer rounded-md hover:bg-[#ce7474fd]"
                        style={{ transform: `translateX(-${currentIndex * 10}rem)` }}>
                        {item.cateName}
                    </Link>
                )
                )}
            </div>
        </>


    );
}
export default CategoryCarousel;