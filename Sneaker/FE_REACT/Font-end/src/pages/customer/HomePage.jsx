import Carousel from "../../shared/component/user/Carousel"
import CategoryCarousel from "../../shared/component/user/CategoryCarousel"
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
        </div>
    )
}
export default UserHomePage