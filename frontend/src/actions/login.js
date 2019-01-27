import {
    API_URL
} from '../constants';

export const identity = (user, email, password) => async dispatch =>
    fetch(API_URL + `${user}/`, {
        method: 'POST',
        body: JSON.stringify({
            email,
            password
        })
    })
        .then(res => {
            if (res.status === 403) {
                throw {
                    message: 'Неверный e-mail или пароль',
                    code: 403
                };
            }
            return res.json();
        })
        .then(({ token }) => dispatch(
            {
                type: `FETCH_${user.toUpperCase()}_DATA`,
                payload: { token }
            }
        ))

export const login = (user, token) => async dispatch => fetch(API_URL + `${user}/`, {
        method: 'GET',
        headers: {
            'Token': token,
        }
    })
        .then(res => {
            if (res.status === 401) {
                throw {
                    message: 'Неверный token',
                    code: 401
                };
            }
            return res.json();
        })
        .then(data => {
            dispatch({
                type: `FETCH_${user.toUpperCase()}_DATA`,
                payload: data
            });
        });
