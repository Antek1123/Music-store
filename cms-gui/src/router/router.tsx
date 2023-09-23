import {createBrowserRouter, createRoutesFromElements, Route} from "react-router-dom";

import App from "../application/App";
import Login from "../modules/login/Login";
import Products from "../pages/products/Products";
import Products2 from "../pages/products/Products2";
import {Operators} from "../pages/operators/Operators";

const router = createBrowserRouter(
    createRoutesFromElements(
        <Route>
            <Route
                path='/'
                element={<App />}>
                <Route
                    path='operators'
                    element={<Operators />}
                />
                <Route
                    path='products'
                    element={<Products />}
                />
                <Route
                    path='products2'
                    element={<Products2 />}
                />
            </Route>
            <Route
                path='login'
                element={<Login />}
            />
        </Route>
    )
);

export default router;