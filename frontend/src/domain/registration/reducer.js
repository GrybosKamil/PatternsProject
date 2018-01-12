import {CHANGE} from './actionTypes'

const initialState = {
    employees: []
};

function registration(state = initialState, action) {
    switch (action.type) {
        case CHANGE:
            return Object.assign({}, state, {
                employees: action.employees
            });
        default:
            return state;
    }

}

export default registration