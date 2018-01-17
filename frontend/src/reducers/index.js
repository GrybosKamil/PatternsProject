import {combineReducers} from 'redux'
import {application} from "../domain/application";
import {login} from "../domain/login";
import {registration} from "../domain/registration";
import {challenges} from "../domain/challenges";

const rootReducer = combineReducers({
    application,
    login,
    registration,
    challenges
});

export default rootReducer