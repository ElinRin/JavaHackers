import {
    API_URL,
    EMPLOYEES,
    SKIPS
} from '../constants';

export const parseXlsx = file => {
    let data = {};


    return data;
};

const sendData = (type, token, file) => fetch(API_URL + `company/${type}` , {
        method: 'POST',
        headers: {
            'Token': token,
        },
        body: parseXlsx(file),
    })
        .then(res => res.json());