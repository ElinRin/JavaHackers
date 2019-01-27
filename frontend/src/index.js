import React from 'react';
import ReactDOM from 'react-dom';
import {
    BrowserRouter as Router,
    Route,
    Switch
} from 'react-router-dom';
import { Provider } from 'react-redux';
import {createStore, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import {composeWithDevTools} from 'redux-devtools-extension';
import { CookiesProvider } from 'react-cookie';

import reducers from './reducers';
import Main from './pages/Main';

import './styles.css';

const store = createStore(reducers, composeWithDevTools(
    applyMiddleware(thunk)
));


ReactDOM.render((
    <Provider store={store}>
        <CookiesProvider>
            <Router>
                {/* <div>
                    <Sidebar/> */}
                    <Switch>
                        <Route exact path='/' component={Main} />
                    </Switch>
                {/* </div> */}
            </Router>
        </CookiesProvider>
    </Provider>
), document.getElementById('root'));
