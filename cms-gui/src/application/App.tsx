import '../styles/base/App.scss'
import Header from "../application/header/Header"
import {useEffect, useState} from "react";
import {http} from "../http/http";
import Urls from "../common/Urls";
import {Outlet, useNavigate} from "react-router-dom";
import {AxiosError, AxiosResponse} from "axios";
import {Operator} from "./Operator";

function App() {
    const [operator, setOperator] = useState<Operator>();
    const navigate = useNavigate();

    useEffect(() => {
        http.get(Urls.OPERATORS_DETAILS).then((response: AxiosResponse) => {
            setOperator(response.data);
        }).catch((reason: AxiosError) => {
            if (reason.response!.status == 403) {
                navigate('/login');
            }
        })
    }, []);

    return (
        <div className='detail-view'>
            <div className='header'>
                { operator ? <Header operator={operator} /> : null }
            </div>
            <div className='detail'>
                <Outlet />
            </div>
        </div>
    )
}

export default App
