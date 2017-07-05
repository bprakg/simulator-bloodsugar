import { applyMiddleware, createStore } from "redux";
import reducer from "./SimulatorReducer"

/*const logger = (store) => (next) => (action) => {
    console.log("Action fired - " + action);
    next(action);
}*/
const middleware = applyMiddleware();

export default createStore(reducer, middleware);
