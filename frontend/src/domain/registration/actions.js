import base64 from "base-64"
import utf8 from "utf8"
import {endPoints} from '../../configuration/configuration'
import * as registrationActionTypes from './actionTypes'
import {isAuthenticated as isauthenticated} from '../login/actions'
import {requestPost} from "../../utils/apiUtils";
import {pushHistory} from "../../utils/utils";

export function doRegister(username, password, passwordConfirm, registerType) {
    if (username && password && password === passwordConfirm) {
        return function (dispatch) {
            let url;
            if (registerType) {
                url = endPoints.registrationOrganizer;
            } else {
                url = endPoints.registrationMember;
            }
            url = url +
                '?username=' + username +
                '&password=' + base64.encode(utf8.encode(password));
            requestPost(url)
                .then((data) => {
                    console.log(data);
                    if (data === 400) {
                        throw data;
                    }
                    dispatch({
                        type: registrationActionTypes.REGISTRATION_SUCCESS,
                        payload: data
                    });
                    pushHistory("/");
                })
                .catch((error) => {
                    dispatch({
                        type: registrationActionTypes.REGISTRATION_FAILED,
                        payload: "Username already used"
                    })
                })
        }
    }
    if (password !== passwordConfirm) {
        return function (dispatch) {
            dispatch({
                    type: registrationActionTypes.REGISTER_INVALID,
                    payload: "Passwords do not match"
                }
            )
        }
    }
    return function (dispatch) {
        dispatch({
                type: registrationActionTypes.REGISTER_EMPTY,
                payload: "Empty username or password."
            }
        )
    };
}

export function changeUsername(username) {
    return function (dispatch) {
        dispatch({
            type: registrationActionTypes.CHANGE_USERNAME,
            payload: username
        });
    }
}

export function changePassword(password) {
    return function (dispatch) {
        dispatch({
            type: registrationActionTypes.CHANGE_PASSWORD,
            payload: password
        });
    }
}

export function changeRegistrationType(registrationType) {
    return function (dispatch) {
        dispatch({
            type: registrationActionTypes.CHANGE_REGISTRATION_TYPE,
            payload: registrationType
        });
    }
}

export function changePasswordConfirm(passwordConfirm) {
    return function (dispatch) {
        dispatch({
            type: registrationActionTypes.CHANGE_PASSWORD_CONFIRM,
            payload: passwordConfirm
        });
    }
}

export function isAuthenticated() {
    return isauthenticated();
}