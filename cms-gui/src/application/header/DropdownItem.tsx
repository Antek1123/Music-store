import '../../styles/components/header/dropdown.scss'
import {useNavigate} from "react-router-dom";
import {NavbarItem} from "../navbar-sections";

export const DropdownItem = (navbarItem: NavbarItem) => {
    const navigate = useNavigate();

    return (
        <div className='dropdown-item wrapper' onClick={() => navigate(navbarItem.url)}>
            <span className='dropdown-item icon'>
                {navbarItem.icon}
            </span>
            <span className='dropdown-item name'>
                {navbarItem.name}
            </span>
        </div>
    );
}
