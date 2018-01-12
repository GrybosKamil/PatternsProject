import {combineReducers} from 'redux'
import {application} from "../domain/application";
import {login} from "../domain/login";
import {registration} from "../domain/registration";

const rootReducer = combineReducers({
    application,
    login,
    registration
});

export default rootReducer