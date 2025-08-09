import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
const SectionLabel = ({ label, secName, children }) => {

    return (
        <div className="secLbCtn mx-20 mt-10">
            <div className="secLbBtn flex items-center gap-2.5 w-[20%]">
                <div className="labelBlk w-[20px] h-[30px] bg-[#ec0606] rounded-lg"></div>
                <div className="font-medium text-[15px] text-[#c90606]">{label}</div>
            </div>
            <div className="nameBtn flex items-center justify-between">
                <div className="secName mt-[1rem] text-2xl font-bold">{secName}</div>
                <div className="">
                    {children}
                </div>
            </div>
        </div>

    );
}
export default SectionLabel;