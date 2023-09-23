import '../../../styles/components/list/list.scss'
import {IoMdAdd} from "react-icons/io";

interface SaveActionProp {
    url: string;
}

export const SaveAction = ({url}: SaveActionProp) => {

    return (
        <div className='config-wrapper'>
            <button className='button-add'>
                <IoMdAdd/>
            </button>
        </div>
    )
}