import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
const CategoryCarousel = () => {
    const data = [
        { id: 1, cateName: 'Women', link: 'linkcategory' },
        { id: 2, cateName: 'Men', link: 'linkcategory' },
        { id: 3, cateName: 'Kids', link: 'linkcategory' },
        { id: 4, cateName: 'Sport', link: 'linkcategory' },
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
        <div className="carouselCtn bg-none flex mx-20 mt-10 relative justify-between ">
            {data.map((item, id) =>
            (
                <Link key={id} to={item.link} 
                className="carouselItemCtn h-[5rem] w-[5rem] flex-shrink-0 flex items-center justify-center border bg-gray-100 cursor-pointer rounded-md hover:bg-[#ce7474fd]"
                style={{ transform: `translateX(-${currentIndex * 10}rem)` }}>
                    {item.cateName}
                </Link>
            )
            )}
        </div>

    );
}
export default CategoryCarousel;