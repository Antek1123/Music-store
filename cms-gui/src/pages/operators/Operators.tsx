import {List} from "../../components/list/List";
import Urls from "../../common/Urls";

export const Operators = () => {
    return (
        <>
            <List
                fetchUrl={Urls.OPERATORS}
                columns={
                    [
                        {
                            name: 'Name',
                            field: 'name',
                        },
                        {
                            name: 'Surname',
                            field: 'surname',
                        },
                        {
                            name: 'Email',
                            field: 'email',
                        }
                    ]
                }
                addAction={true}
                deleteAction={true}
                editAction={true}
            />
        </>
    );
}