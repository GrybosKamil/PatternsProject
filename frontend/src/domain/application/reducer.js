import {CHANGE_NAME, CHANGE_NAME_ERROR, DRAW_NAME, GET_MEMBER_ERROR, GET_NAME} from './actionTypes'

const initialState = {
    name: null,
    drawName: null,
    error: null,
    success: null
};

function application(state = initialState, action) {
    switch (action.type) {
        case DRAW_NAME:
            return Object.assign({}, state, {
                drawName: action.payload
            });
        case GET_NAME:
            return Object.assign({}, state, {
                name: action.payload,
                drawName: action.payload
            });
        case CHANGE_NAME:
            return Object.assign({}, state, {
                name: action.payload,
                drawName: action.payload,
                success: "Name changed!",
                error: null
            });
        case GET_MEMBER_ERROR:
            return Object.assign({}, state, {
                error: action.error
            });
        case CHANGE_NAME_ERROR:
            return Object.assign({}, state, {
                drawName: state.name,
                error: "Cannot change name",
                success: null
            });
        default:
            return state;
    }

}

export default application