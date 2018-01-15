import {
    CHANGE_PASSWORD,
    CHANGE_PASSWORD_CONFIRM,
    CHANGE_REGISTRATION_TYPE,
    CHANGE_USERNAME,
    REGISTER_EMPTY,
    REGISTER_INVALID,
    REGISTRATION_FAILED,
    REGISTRATION_SUCCESS
} from './actionTypes'

const initialState = {
    username: null,
    password: null,
    passwordConfirm: null,
    registrationType: false,
    error: null,
    success: null,
};

function registration(state = initialState, action) {
    switch (action.type) {
        case CHANGE_USERNAME:
            return Object.assign({}, state, {
                username: action.payload
            });
        case CHANGE_PASSWORD:
            return Object.assign({}, state, {
                password: action.payload
            });
        case CHANGE_PASSWORD_CONFIRM:
            return Object.assign({}, state, {
                passwordConfirm: action.payload
            });
        case CHANGE_REGISTRATION_TYPE:
            return Object.assign({}, state, {
                registrationType: action.payload
            });
        case REGISTER_EMPTY:
            return Object.assign({}, state, {
                error: action.payload,
            });
        case REGISTER_INVALID:
            return Object.assign({}, state, {
                error: action.payload,
            });
        case REGISTRATION_FAILED:
            return Object.assign({}, state, {
                error: action.payload,
                success: null,
            });
        case REGISTRATION_SUCCESS:
            return Object.assign({}, state, {
                success: action.payload,
                error: null,
            });
        default:
            return state;
    }
}

export default registration