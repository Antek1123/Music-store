import '../../../styles/components/list/list.scss'
import {AiFillEdit} from "react-icons/ai";
import {useNavigate} from "react-router-dom";

interface EditActionProp {
    url: string;
}

export const EditAction = ({url}: EditActionProp) => {
    const navigate = useNavigate();

    return (
        <div className='action' onClick={() => navigate(url)}>
            <AiFillEdit />
        </div>
    )
}