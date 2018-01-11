import {CHANGE} from './actionTypes'

const initialState = {
    employees: []
};

function application(state = initialState, action) {
    switch (action.type) {
        case CHANGE:
            return Object.assign({}, state, {
                employees: action.employees
            });
        default:
            return state;
    }

}

export default application