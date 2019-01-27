import {
    FETCH_EMPLOYEE_DATA,
    FETCH_COMPANY_DATA
} from './constants';

export const EmployeeOut = () => async dispatch =>
    dispatch({
        type: FETCH_EMPLOYEE_DATA,
        payload: {
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
        }
    });

export const CompanyOut = () => async dispatch => 
    dispatch({
        type: FETCH_COMPANY_DATA,
        payload: {
            token: '',
            name: ''
        }
    });