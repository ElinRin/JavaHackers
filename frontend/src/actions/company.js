import {
    FETCH_COMPANY_DATA
} from './constants';
import {
    API_URL
} from '../constants';

const post = (token, email) => ({
    method: 'POST',
    headers: {
        'Token': token
    },
    body: {
        email
    }
})

export const getInfo = (token, email) => async dispatch => {
    return fetch(API_URL + 'company/info/', post(token, email) )
        .then(res => {
            if (res.status === 404) {
                throw {
                    message: 'email не зарегистрирован',
                    code: 404
                };
            }
            return res.json();
        })
        .then(data => {
            dispatch({
                type: FETCH_COMPANY_DATA,
                payload: { [email]: data }
            });
        })
        .catch()
};

export const deleteInfo = (token, email) => async dispatch => {
    return fetch(API_URL + 'company/delete/', post(token, email) )
        .then(res => res.json())
        .then(() => {
            dispatch({
                type: FETCH_COMPANY_DATA,
                payload: { [email]: {} }
            });
        })
};

export const changeInfo = (token, email, info) => async dispatch => {
    return fetch(API_URL + 'company/change/', {
        method: 'POST',
        headers: {
            'Token': token
        },
        body: {
            email,
            info
        }
    } )
        .then(res => res.json())
        .then(() => {
            dispatch({
                type: FETCH_COMPANY_DATA,
                payload: { [email]: info }
            });
        })
};