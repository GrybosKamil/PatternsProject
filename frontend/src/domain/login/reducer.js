import {CHANGE, LOGIN} from './actionTypes'

const initialState = {
    employees: [],
    user: null
};

function login(state = initialState, action) {
    switch (action.type) {
        case LOGIN:
            return Object.assign({}, state, {
                user: action.user
            });
        case CHANGE:
            return Object.assign({}, state, {
                employees: action.employees
            });
        default:
            return state;
    }

}

export default login