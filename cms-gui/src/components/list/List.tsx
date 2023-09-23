import '../../styles/components/list/list.scss'
import {ListItemProps} from "./ListItem";
import {http} from "../../http/http";
import {AxiosResponse} from "axios";
import {useEffect, useState} from "react";
import {DeleteAction} from "./actions/DeleteAction";
import {EditAction} from "./actions/EditAction";
import {SaveAction} from "./actions/SaveAction";

interface ListProps {
    columns: ListItemProps[];
    fetchUrl: string;
    addAction?: boolean;
    deleteAction?: boolean;
    editAction?: boolean;
}

export const List = (props: ListProps) => {
    const [records, setRecords] = useState([]);
    let index = 0;

    useEffect(() => {
        http.get(props.fetchUrl).then((response: AxiosResponse) => {
            setRecords(response.data);
        })
    }, [])

    return (
        <div className='list-container'>
            {props.addAction ? <SaveAction url={props.fetchUrl} /> : null}
            <div className='table-wrapper'>
                <table className='table'>
                    <thead className='table'>
                    <tr className='title-row'>
                        {props.columns.map((column: ListItemProps) =>
                            <th key={column.name} className='title-head'>
                                {column.name}
                            </th>)
                        }
                        {(props.deleteAction || props.editAction) ?
                            <th className='title-head'>
                                Actions
                            </th>
                            : null}
                    </tr>
                    </thead>
                    <tbody className='table'>
                    {records.map((record: any) => {
                            return (
                                <tr className={++index % 2 ? 'selected' : 'bad'} key={record.id}>
                                    {props.columns.map((column: ListItemProps) => (
                                        <td key={column.field}>
                                            {record[column.field]}
                                        </td>
                                    ))}
                                    <td className='actions'>
                                        {props.deleteAction ? <DeleteAction url={`${record.id}`}/> : null}
                                        {props.editAction ? <EditAction url={`${record.id}`}/> : null}
                                    </td>
                                </tr>
                            )
                        }
                    )}
                    </tbody>
                </table>
            </div>
        </div>
    )
}