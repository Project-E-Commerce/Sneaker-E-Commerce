import Carousel from "../../shared/component/user/Carousel"
import UserSidebar from "../../shared/component/user/Sidebar"

const UserHomePage = () => {
    return (
        <div className="sidebCarouCtn flex gap-9 ">
                <UserSidebar />
            <div className="w-full">
                <Carousel />
            </div>
        </div>
    )
}
export default UserHomePage