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
import Sidebar from './containers/sidebar';

import './styles.css';
import Employee from './pages/Employee';
import Company from './pages/Company';
import Info from './containers/info';
import Withdraw from './containers/Withdraw'

const store = createStore(reducers, composeWithDevTools(
    applyMiddleware(thunk)
));


ReactDOM.render((
    <Provider store={store}>
        <CookiesProvider>
            <Router>
                <div>
                    <Sidebar/>
                    <Switch>
                        <Route exact path='/' component={Main} />
                        <Route exact path='/employee' component={Info} />
                        <Route exact path='/employee/info' component={Info} />
                        <Route exact path='/employee/withdraw' component={Withdraw} />
                        <Route exact path='/company' component={Company} />
                    </Switch>
                </div>
            </Router>
        </CookiesProvider>
    </Provider>
), document.getElementById('root'));
