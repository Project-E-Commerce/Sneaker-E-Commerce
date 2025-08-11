import Carousel from "../../shared/component/user/Carousel"
import CategoryCarousel from "../../shared/component/user/CategoryCarousel"
import ProductsList from "../../shared/component/user/ProductsList"
import UserSidebar from "../../shared/component/user/Sidebar"

const UserHomePage = () => {
    return (
        <div>
            <div className="sidebCarouCtn flex gap-9 ">
                <UserSidebar />
                <div className="w-full">
                    <Carousel />
                </div>
            </div>
            <div className="catCarousel">
                <CategoryCarousel/>
            </div>
            <div className="bestSelMon">
                <ProductsList label={'This Month'} secName={'Best Selling Products'} itemNum={5} isDisabledTop={false} isDisabledBtm={true}/>
            </div>
            <div className="midCarou ml-20">
                <Carousel/>
            </div>
            <div className="allProducts">
                <ProductsList label={'Our Products'} secName={'Explore Our Products'} itemNum={10} isDisabledTop={true} isDisabledBtm={false}/>
            </div>
        </div>
    )
}
export default UserHomePage