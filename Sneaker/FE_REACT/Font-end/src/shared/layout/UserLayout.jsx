import { useEffect, useState } from "react";
import UserHeader from "../component/user/Header";
import UserSidebar from "../component/user/Sidebar";
import Carousel from "../component/user/Carousel";
import UserFooter from "../component/user/Footer";
import { Outlet } from "react-router-dom";

const UserLayout = () => {

    return (
        <div className="">
            <UserHeader />
            <main>
                <Outlet />
            </main>
            <UserFooter />
        </div>
    )
}
export default UserLayout;