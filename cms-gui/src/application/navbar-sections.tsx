import React from "react";
import {BsFillPersonFill} from "react-icons/bs";

export interface NavbarItem {
    name: string,
    url: string,
    icon: React.JSX.Element,
}

export const NavbarSections: NavbarItem[] = [
    {
        name: 'Products',
        url: '/products',
        icon: <BsFillPersonFill />
    },
    {
        name: 'Products_2',
        url: '/products2',
        icon: <BsFillPersonFill />
    },
    {
        name: 'Operators',
        url: '/operators',
        icon: <BsFillPersonFill />
    }
];