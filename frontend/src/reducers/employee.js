import {
    FETCH_EMPLOYEE_DATA
} from '../actions/constants';

const initialState = {
    token: '',
    companyName: '',
    realMoney: 0,
    futureMoney: 0,
    payList: [],
    costHour: 0,
    realDays: 0,
    info: {
        name: '',
        email: '',
        salary: 0,
        schedule: ''
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