import {CHANGE_USERNAME, CHANGE_PASSWORD, LOGIN_EMPTY, LOGOUT, LOGIN_FAILED, LOGIN_SUCCESS} from './actionTypes'

const initialState = {
    username: null,
    password: null,
    error: null,
    success: null,
};

function login(state = initialState, action) {
    switch (action.type) {
        case CHANGE_USERNAME:
            return Object.assign({}, state, {
                username: action.payload
            });
        case CHANGE_PASSWORD:
            return Object.assign({}, state, {
                password: action.payload
            });
        case LOGIN_EMPTY:
            return Object.assign({}, state, {
                error: action.payload,
            });
        case LOGIN_FAILED:
            return Object.assign({}, state, {
                error: action.payload,
                success: null,
            });
        case LOGIN_SUCCESS:
            return Object.assign({}, state, {
                success: action.payload,
                error: null,
            });
        case LOGOUT:
            return Object.assign({}, state, {
                success: action.payload,
                error: null,
            });
        default:
            return state;
    }
}

export default login