import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from "react-redux";
import App from './js/App';
import registerServiceWorker from './registerServiceWorker';
import reducer from "./js/SimulatorReducer"

import { createStore } from 'redux';


let store = createStore(reducer);

ReactDOM.render(
    <Provider store = {store}><App />
    </Provider>, document.getElementById('root'));
registerServiceWorker();
