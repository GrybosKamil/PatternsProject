import {CHANGE_PASSWORD, CHANGE_USERNAME, LOGIN_EMPTY, LOGIN_FAILED, LOGIN_SUCCESS, LOGOUT} from './actionTypes'
import {token, userName} from '../../configuration/configuration'

const initialState = {
    username: localStorage.getItem("username"),
    password: null,
    isLogged: localStorage.getItem(userName) && localStorage.getItem(token),
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
                isLogged: false,
            });
        case LOGIN_FAILED:
            return Object.assign({}, state, {
                error: action.payload,
                success: null,
                isLogged: false,
            });
        case LOGIN_SUCCESS:
            return Object.assign({}, state, {
                success: action.payload,
                password: null,
                error: null,
                isLogged: true
            });
        case LOGOUT:
            return Object.assign({}, state, {
                success: action.payload,
                username: null,
                password: null,
                error: null,
                isLogged: false,
            });
        default:
            return state;
    }
}

export default login