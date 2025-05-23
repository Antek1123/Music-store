import ReactDOM from 'react-dom/client'
import './styles/base/index.scss'
import router from "./router/router";
import {RouterProvider} from "react-router-dom";

ReactDOM.createRoot(document.getElementById('root')!).render(
  <RouterProvider router={router} />
)
