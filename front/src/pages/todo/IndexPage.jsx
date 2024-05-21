import { Outlet } from "react-router-dom";
import BasicLayout from "../../layouts/BasicLayout";

const IndexPage = () => {
    return(
    <BasicLayout>
        <div>
            <div className="text-xl m-1 p-2 w-20 font-extrabold text-center underline">추천</div>
            <div className="text-xl m-1 p-2 w-20 font-extrabold text-center underline">추천2</div>
            <div className="text-xl m-1 p-2 w-20 font-extrabold text-center underline">추천3</div>
            <div className="text-xl m-1 p-2 w-20 font-extrabold text-center underline">추천4</div>
            <div className="text-xl m-1 p-2 w-20 font-extrabold text-center underline">추천5</div>
        </div>
        <div className="flex flex-wrap w-full">
            <Outlet/>
        </div>
    </BasicLayout>
    );
}

export default IndexPage;