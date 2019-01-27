import React from 'react';
import Login from '../containers/login'
import {
    EMPLOYEE,
    COMPANY
} from '../constants';

const Main = () => (
    <div className='blockBorder'>
        <Login user={EMPLOYEE}/>
        <Login user={COMPANY}/>
    </div>
);

export default Main;