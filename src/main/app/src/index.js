<<<<<<< HEAD
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
=======
import React from 'react';
import ReactDOM from 'react-dom';
import { createStore, applyMiddleware } from 'redux';
import { Provider } from "react-redux";
import thunk from 'redux-thunk';
// import logger from 'redux-logger';
import App from './js/App';
import registerServiceWorker from './registerServiceWorker';
import reducer from "./js/SimulatorReducer"

let store = createStore(reducer, applyMiddleware(thunk));

ReactDOM.render(
    <Provider store = {store}><App />
    </Provider>, document.getElementById('root'));
registerServiceWorker();
>>>>>>> stash
