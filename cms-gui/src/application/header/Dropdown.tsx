import '../../styles/components/header/dropdown.scss'
import {DropdownItem} from "./DropdownItem";
import {NavbarSections} from "../navbar-sections";

export const Dropdown = ({innerRef}: any) => {

    return (
        <div className="dropdown">
            <ul className="dropdown list" ref={innerRef}>
                <li className='dropdown-item row>'>
                    {NavbarSections.map((navbarItem) =>
                        <DropdownItem {...navbarItem} key={navbarItem.name} />
                    )}
                </li>
            </ul>
        </div>
    )
}