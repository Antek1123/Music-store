import '../../../styles/components/list/list.scss'
import {AiFillDelete} from "react-icons/ai";

interface DeleteActionProp {
    url: string;
}

export const DeleteAction = ({url}: DeleteActionProp) => {

    const deleteRecord = (url: string) => {
        console.log('todo deleteRecord', url)
        //todo implementation
    }

    return (
        <div className='action' onClick={() => deleteRecord(url)}>
            <AiFillDelete />
        </div>
    )
}

