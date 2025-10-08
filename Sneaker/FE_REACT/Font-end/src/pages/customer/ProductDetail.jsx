import { useState } from "react";
import SectionLabel from "../../shared/component/user/SectionLabel";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHeart as faHeartSolid, faRotate, faTruck } from "@fortawesome/free-solid-svg-icons";
import { faHeart as faHeartReg } from "@fortawesome/free-regular-svg-icons";
import QuantitySelector from "../../shared/component/user/QuantitySelector";

const ProductDetail = () => {
    const data = {
        productName: 'Product 1 Name',
        size: ['1', '2', '3'],
        price: 100.00,
        images: [
            'https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i3Yp1mXpDIMA/v2/1200x836.webp',
            'https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i3Yp1mXpDIMA/v2/1200x836.webp',
            'https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i3Yp1mXpDIMA/v2/1200x836.webp',
            'https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i3Yp1mXpDIMA/v2/1200x836.webp'
        ],
        colors: ['red', 'blue'],
        description: ['description1', 'description2'],
        status: "In Stock",
    }

    const [mainImg, setMainImg] = useState();
    const [select, setSelect] = useState(null);
    return (
        <>
            <div className="breadCrum"></div>
            <div className="content flex mx-20 mt-20">
                <div className="picList flex justify-between border-b-amber-950 border-1">
                    <div className="colPics flex flex-col justify-between ">
                        {data.images.map((img, index) => (
                            <img
                                key={index}
                                src={img}
                                className="w-20 h-20 object-cover cursor-pointer hover:boder-blue-500"
                                onClick={() => setMainImg(img)}
                            />
                        )
                        )}
                    </div>
                    <div className="mainPic ml-4.5 w-96 ">
                        <img src={'https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i3Yp1mXpDIMA/v2/1200x836.webp'} className="h-[100%] object-cover" />
                    </div>
                </div>
                <div className="prodDetail flex flex-col gap-1.5 ml-20 ">
                    <div className="name text-lg font-bold">
                        {data.productName}
                    </div>
                    <div className="status text-[12px] text-[#028017]">
                        {data.status}
                    </div>
                    <div className="price text-lg ">
                        ${data.price}
                    </div>
                    <div className="description text-[13px] pb-3 border-b-1 ">
                        {data.description.map((des, index) => (
                            <div className="flex items-start" key={index}>
                                <span className="mr-2">•</span>
                                <span>{des}</span>
                            </div>
                        ))}
                    </div>
                    <div className="color mt-2">
                        Colours: {data.colors}
                    </div>
                    <div className="size mt-2 flex justify-start items-center gap-4">
                        <span>Size:</span>
                        {data.size.map((size, index) => (
                            <div className="flex" key={index}>
                                <button type="button"
                                    className={`border-1 rounded-md px-2.5 cursor-pointer ${select == index ? "bg-[#474343] text-[#ffffff]" : ""}`}
                                    onClick={() => {
                                        if (select == index) {
                                            setSelect(null)
                                        } else {
                                            setSelect(index)
                                        };
                                        console.log(select)
                                    }}
                                >
                                    {size}
                                </button>
                            </div>
                        ))}
                    </div>
                    <div className="btnRow mt-4 flex gap-3 items-center justify-between">
                        <QuantitySelector initialQuantity={1} />
                        <div className="">
                            <button className="buy rounded-md bg-[#e20f0f] text-[#ffffff] px-8 py-1.5">
                                Buy Now
                            </button>
                        </div>
                        <div>
                            <button className="fav border-1 rounded-md px-2 py-1">
                                <FontAwesomeIcon icon={faHeartReg} />
                            </button>
                        </div>

                    </div>
                    <div className="badges border-1 rounded-md border-[#c2c2c2] mt-8">
                        <div className="freeDeli flex border-b-1 border-[#c2c2c2]">
                            <div className="icon p-4 flex items-center">
                                <FontAwesomeIcon icon={faTruck} size='lg' />
                            </div>
                            <div className="badgeDetail p-4 flex flex-col ">
                                <p className="text">Free Delivery</p>
                                <p className="smallDetail text-[12px] underline">Enter your postal code for Delivery Availability</p>
                            </div>
                        </div>
                        <div className="returnDeli flex ">
                            <div className="icon p-4 flex items-center">
                                <FontAwesomeIcon icon={faRotate} size='lg' />
                            </div>
                            <div className="badgeDetail p-4 flex flex-col ">
                                <p className="text">Return Delivery</p>
                                <div className="flex gap-1">
                                    <p className="smallDetail text-[12px]">Free 30 days Delivery Returns. </p>
                                    <p className="underline text-[12px]">Details</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="relatedItems">
                <SectionLabel label={'Related Items'} secName={''} />
            </div>
        </>
    )
}
export default ProductDetail;