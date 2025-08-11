export const ViewAll = ({ viewAll, disable }) => {
    if (disable) return null;
    return (
            <button type='button'  onClick={viewAll} className="px-[24px] py-[10px] bg-[#ff2929] text-[#ffffff] text-[14px] font-medium rounded-md cursor-pointer">
                View All
            </button>
    )

}