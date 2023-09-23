import {Operator} from "../Operator";
import {BsFillPersonFill} from "react-icons/bs";
import '../../styles/components/header/header.scss'
import HeaderOperator from "./HeaderOperator";
import {useRef, useState} from "react";
import {Dropdown} from "./Dropdown";
import {RxDropdownMenu} from "react-icons/rx";

interface Header {
    operator: Operator | undefined;
}

function Header({operator}: Header) {
    const catDropdown = useRef(null)
    const catOperatorModal = useRef(null);

    const [openDropdown, setOpenDropdown] = useState(false);
    const [openOperatorModal, setOpenOperatorModal] = useState(false);

    const closeOperatorModal = (e) => {
        if (catOperatorModal.current && openOperatorModal && !catOperatorModal.current.contains(e.target)) {
            setOpenOperatorModal(false);
        }
    }

    const closeDropdown = (e) => {
        if (catDropdown.current && openDropdown && !catDropdown.current.contains(e.target)) {
            setOpenDropdown(false);
        }
    }

    document.addEventListener('mousedown', closeOperatorModal);
    document.addEventListener('mousedown', closeDropdown);

    return (
        <>
            <div className="app-header nav">
                <span className="app-header dropdown-icon" onClick={() => setOpenDropdown(!openDropdown)} ref={catDropdown}>
                    <RxDropdownMenu />
                </span>
                {openDropdown && <Dropdown innerRef={catDropdown} />}
                <div className="app-header operator">
                    <button className="app-header operator-btn" onClick={() => setOpenOperatorModal(!openOperatorModal)}>
                        <span className='app-header operator-btn operator-name'>
                            {operator!.name}
                            {' '}
                            {operator!.surname}
                        </span>
                        <span className="app-header operator-btn operator-icon">
                            <BsFillPersonFill/>
                        </span>
                    </button>
                </div>
                <div ref={catOperatorModal}>
                    {openOperatorModal && <HeaderOperator operator={operator}/>}
                </div>
            </div>
        </>
    )
}

export default Header;