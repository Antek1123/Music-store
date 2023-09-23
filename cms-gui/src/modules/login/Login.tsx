import '../../styles/login/login.scss'
import {useState} from "react";
import {http} from "../../http/http";
import Urls from "../../common/Urls";
import {useNavigate} from "react-router-dom";

function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleSubmit = (e: Event) => {
        e.preventDefault();

        let formData = new FormData();
        formData.append('username', email);
        formData.append('password', password);

        http.post(Urls.LOGIN, formData).then(() => {
                navigate('/products');
            }
        ).catch(() => {
            //todo show incorrect cred
            console.log('Haslo bledne')
        });
    }

    return (
        <div className='login-wrapper'>
            <div className="container-login">
                <form action="" className="form-login">
                    <label className="label-login" form="email">Email: </label>
                    <input type="email" className="input-login" placeholder="xyz@example.com" onChange={e => setEmail(e.target.value)}/>
                    <label className="label-login" form="password">Password: </label>
                    <input type="password" className="input-login" placeholder="********" onChange={e => setPassword(e.target.value)}/>
                    <button className="button-login" type="submit" onClick={(event) => handleSubmit(event)}> Log in</button>
                </form>
            </div>
        </div>
    )
}

export default Login