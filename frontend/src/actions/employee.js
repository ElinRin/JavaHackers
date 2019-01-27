import {
    FETCH_EMPLOYEE_DATA
} from './constants';
import {
    API_URL
} from '../constants';

export const getInfo = token => async dispatch =>
    fetch(API_URL + 'employee/', {
        method: 'GET',
        headers: {
            'Token': token
        }
    })
        .then(res => res.json())
        .then(info => {
            dispatch({
                type: FETCH_EMPLOYEE_DATA,
                payload: { info }
            });
        })

export const withdrawal = (token, days) => async dispatch =>
    fetch(API_URL + 'employee/withdrawal/', {
        method: 'POST',
        headers: {
            'Token': token
        },
        body: {
            days
        }
    })
        .then(res => {
            if (res.status === 405) {
                throw {
                    message: 'Превышено количество дней',
                    code: 405
                };
            }
            return res.json();
        })
        .then(({ info, paylist }) => {
            dispatch({
                type: FETCH_EMPLOYEE_DATA,
                payload: { info, paylist }
            });
        })

export const getInfo = (token) => async dispatch =>
    fetch(API_URL + 'employee/paylist', {
        method: 'GET',
        headers: {
            'Token': token
        }
    })
        .then(res => res.json())
        .then(paylist => {
            dispatch({
                type: FETCH_EMPLOYEE_DATA,
                payload: { paylist }
            });
        })