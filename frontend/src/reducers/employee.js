import {
    FETCH_EMPLOYEE_DATA
} from '../actions/constants';

const initialState = {
    token: 1,
    companyName: '1c',
    realMoney: 160000,
    futureMoney: 192000,
    payList: [],
    costHour: 2000,
    realDays: 10,
    info: {
        name: 'Aндрей',
        email: 'mail@mail',
        salary: 320000,
        schedule: '5/2'
    }
};

export default (state = initialState, {type, payload}) => {
    switch (type) {
        case FETCH_EMPLOYEE_DATA:
            return  {
                ...state,
                ...payload
            };
        default:
            return state;

    }
    return state;
};