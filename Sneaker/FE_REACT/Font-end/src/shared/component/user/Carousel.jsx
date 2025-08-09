import { useEffect, useState } from "react";
const Carousel = () => {
    const data = ['hehe', 'hehehe', 'hehehehehehehe', 'fasdklfjsdaklfjadsklfhjklewfjlkadsjfkldsajfklasdj'];
    const [currentIndex, setCurrentIndex] = useState(0);
    const carouselInfiniteScroll = () => {
        if (currentIndex === data.length - 1) {
            return setCurrentIndex(0);
        }
        return setCurrentIndex(currentIndex + 1);
    }
    useEffect(() => {
        const interval = setInterval(() => { carouselInfiniteScroll() }, 3000);
        return () => clearInterval(interval)
    })
    return (
        <div className="carouselCtn bg-[#20851c] flex flex-nowrap overflow-hidden h-[12rem] mr-20 mt-10 relative z-0 ">
            {data.map((item, index) => {
                return <h1 className='carouselItem h-[10rem] min-w-[100%] w-[100%] flex items-center justify-center transition-all duration-1000 [transition-timing-function:cubic-bezier(0.39,0.575,0.565,1)]'
                    style={{ transform: `translate(-${currentIndex * 100}%)` }}
                    key={index}>{item}</h1>
            })}
        </div>
        
    );
}
export default Carousel;