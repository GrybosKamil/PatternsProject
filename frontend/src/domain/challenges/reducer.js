import {GET_CHALLENGES, GET_CHALLENGES_ERROR} from './actionTypes'

const initialState = {
    challenges: [],
    error: null,
    success: null
};

function challenges(state = initialState, action) {
    switch (action.type) {
        case GET_CHALLENGES:
            return Object.assign({}, state, {
                challenges: action.payload,
            });
        case GET_CHALLENGES_ERROR:
            return Object.assign({}, state, {
                error: action.error,
                challenges: []
            });
        default:
            return state;
    }

}

export default challenges