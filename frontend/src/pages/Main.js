import React from 'react';
import Login from '../containers/login'
import {
    EMPLOYEE,
    COMPANY
} from '../constants';
import './styles.css';

const Main = () => (
    <div className=''>
        <Login user={COMPANY}/>
        <Login user={EMPLOYEE}/>
    </div>
);

export default Main;