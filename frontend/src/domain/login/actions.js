import base64 from "base-64"
import utf8 from "utf8"
import {apiPath, endPoints, token, userName} from '../../configuration/configuration'
import {requestGet, requestPost} from "../../utils/apiUtils";
import {pushHistory} from "../../utils/utils";
import * as loginActionTypes from '../login/actionTypes'

export function changeUsername(username) {
    return function (dispatch) {
        dispatch({
            type: loginActionTypes.CHANGE_USERNAME,
            payload: username
        });
    }
}

export function changePassword(password) {
    return function (dispatch) {
        dispatch({
            type: loginActionTypes.CHANGE_PASSWORD,
            payload: password
        });
    }
}

export function isAuthenticated() {
    return function (dispatch) {
        return requestGet(apiPath)
            .then((data) => {
                dispatch({
                    type: loginActionTypes.IS_AUTHENTICATED,
                    payload: data
                });
                return data;
            })
            .catch((error) => {
                dispatch({
                    type: loginActionTypes.LOGOUT,
                    payload: ''
                });
                localStorage.removeItem(userName);
                localStorage.removeItem(token);
                pushHistory("/");
                return error;
            })
    }
}

export function doLogin(username, password) {
    if (username && password) {
        return function (dispatch) {
            let url = endPoints.authentication +
                '?username=' + username +
                '&password=' + base64.encode(utf8.encode(password));
            requestPost(url)
                .then((data) => {
                    localStorage.removeItem(token);
                    localStorage.setItem(token, data.token);
                    localStorage.removeItem(userName);
                    localStorage.setItem(userName, username);
                    dispatch({
                        type: loginActionTypes.LOGIN_SUCCESS,
                        payload: data.token
                    });
                    pushHistory("/");
                })
                .catch((error) => {
                    dispatch({
                        type: loginActionTypes.LOGIN_FAILED,
                        payload: "Invalid username or password"
                    })
                })
        }
    }
    return function (dispatch) {
        dispatch({
                type: loginActionTypes.LOGIN_EMPTY,
                payload: "Empty username or password."
            }
        )
    };
}

export function doLogout() {
    console.log("remove");
    localStorage.removeItem(token);
    localStorage.removeItem(userName);
    pushHistory("/login");
    return {
        type: loginActionTypes.LOGOUT,
        payload: ''
    };
}