import { combineReducers } from 'redux';
import { routerReducer } from 'react-router-redux';
import company from './company';
import employee from './employee';

const reducers = combineReducers({
    routing: routerReducer,
    company,
    employee
});

export default reducers;
