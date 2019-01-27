import {
    FETCH_COMPANY_DATA
} from '../actions/constants';

const initialState = {
    token: '',
    name: ''
};

export default (state = initialState, {type, payload}) => {
    switch (type) {
        case FETCH_COMPANY_DATA:
            return  {
                ...state,
                ...payload
            };
        default:
            return state;

    }
    return state;
};