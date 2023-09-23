import '../../styles/components/header/header.scss'
import {Operator} from "../Operator";
import Header from "./Header";
import {http} from "../../http/http";
import Urls from "../../common/Urls";
import {useNavigate} from "react-router-dom";
import {AiOutlineMail, AiOutlineLogin} from "react-icons/ai";

interface HeaderOperator {
    operator: Operator | undefined;

}

function HeaderOperator({operator}: Header) {
    const navigate = useNavigate();

    const logout = () => {
        http.post(Urls.LOGOUT).then(() => navigate('login'));
    }

    return (
        <div className="operator-modal-wrapper">
            <div className="operator-modal-row">
                <span className="operator-modal-row icon">
                    <AiOutlineMail />
                </span>
                <span>{operator?.email}</span>
            </div>
            <div className="operator-modal-row">
                <span className="operator-modal-row icon">
                    <AiOutlineLogin />
                </span>
                <span>{operator?.lastLoggedAt.toString()}</span>
            </div>
            <div className="operator-modal-row">
                <button className="operator-modal-btn">Change password</button>
            </div>
            <div className="operator-modal-row">
                <button className="operator-modal-btn" onClick={logout}>Logout</button>
            </div>
        </div>
    )
}

export default HeaderOperator;