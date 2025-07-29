import { faArrowAltCircleRight } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useState } from "react";
import { Link } from "react-router-dom";

const UserSidebar = () => {

    const [openCategoryIds, setOpenCategoryIds] = useState([]);
    const categories = [
        {
            id: 1,
            name: "English Books",
            link: "/books/english",
            subcategories: [
                { id: 101, name: "Art & Photography", link: "/books/art-photography" },
                { id: 102, name: "Biographies & Memories", link: "/books/biographies-memories" },
                { id: 103, name: "Business & Economics", link: "/books/business-economics" },
                { id: 104, name: "How-to - Self Help", link: "/books/how-to-self-helf" },
                { id: 105, name: "Dictionary", link: "/books/dictionary" },
                { id: 106, name: "Education - Teaching", link: "/books/education-teaching" },
                { id: 107, name: "Fiction - Literature", link: "/books/fiction-literature" },
                { id: 108, name: "Magazines", link: "/books/magazines" },
                { id: 109, name: "Medical Books", link: "/books/medical" },
                { id: 110, name: "Parenting & Relationship", link: "/books/parenting-relationship" },
                { id: 111, name: "Reference", link: "/books/reference" },
                { id: 112, name: "Science - Technology", link: "/books/science-technology" },
                { id: 113, name: "History, Politics & Social Sciences", link: "/books/history-politics-social" },
                { id: 114, name: "Travel & Holiday", link: "/books/travel-holiday" },
                { id: 115, name: "Cookbooks, Food & Wine", link: "/books/cook-book-food-wine" },
            ]
        },
        {
            id: 2,
            name: "Sách tiếng Việt",
            link: "/books/vietnamese",
            subcategories: [
                { id: 301, name: "Văn học - Thơ ca", link: "/books/literature-poetry" },
                { id: 302, name: "Giáo dục", link: "/books/education" },
                { id: 303, name: "Tạp chí", link: "/books/magazine" }
            ]
        },
        {
            id: 3,
            name: "Văn phòng phẩm",
            link: "/books/stationery",
            subcategories: [
                { id: 301, name: "Đồ dùng học sinh", link: "/books/student-school-supplies" },
                { id: 302, name: "Đồ dùng giáo viên", link: "/books/teaching-supplies" },
            ]
        },
        {
            id: 4,
            name: "Đồ lưu niệm",
            link: "/books/souvenir",
            subcategories: [
                { id: 401, name: "Đồ thủ công", link: "/books/hand-made" },
                { id: 402, name: "Quà tặng", link: "/books/gifts" },
            ]
        }
    ];

    const toggleSubcategories = (categoryId) => {
        setOpenCategoryIds(prevOpenIds => {
            if (prevOpenIds.includes(categoryId)) {
                return prevOpenIds.filter(id => id !== categoryId);
            }
            else {
                return [...prevOpenIds, categoryId];
            }
        });
    };

    const isCategoryOpen = (categoryId) => {
         return openCategoryIds.includes(categoryId);
    };
    return (
        <aside className="shrink-0 flex flex-col bg-white w-42 border-r-1 border-[#c2c2c2]">

            {/* menu content */}
            <div className="menuCtn flex ">
                <ul className="p-0">
                    {categories.map((category) => (
                        <li key={category.id} className=" w-full border-[#ddd2d2] ">
                            <div className="catCtn flex justify-between items-center ">
                                <Link to={category.link} className="text-[15px] hover:text-blue-400 hover:underline ">{category.name}</Link>
                                <button type="button" onClick={() => toggleSubcategories(category.id)} className="p-1 hover:bg-gray-300 cursor-pointer rounded-md">
                                    <FontAwesomeIcon icon={faArrowAltCircleRight} alt="expandBtn" className={`size-7 transition-transform duration-200 
                                        ${isCategoryOpen(category.id) ? 'rotate-90' : 'rotate-0'}`} />
                                </button>
                            </div>
                            <div className={`subCatCtn overflow-hidden transition-all duration-200 ${isCategoryOpen(category.id) ? 'h-full' : 'max-h-0'}`}>
                                <ul className=" px-4">
                                    {category.subcategories.map((subcat) => (
                                        <li key={subcat.id}>
                                            <Link to={subcat.link} className="block rounded-lg px-4 py-1 text-[13px] hover:text-blue-400 hover:underline ">
                                                {subcat.name}
                                            </Link>
                                        </li>
                                    ))}
                                </ul>
                            </div>
                        </li>
                    ))}
                </ul>
            </div>
        </aside>
    )
}

export default UserSidebar;