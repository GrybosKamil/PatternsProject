import {endPoints} from '../../configuration/configuration'
import * as applicationActionTypes from './actionTypes'
import {requestGet} from "../../utils/apiUtils";

import {doLogout as logout, isAuthenticated as isauthenticated} from '../login/actions'

export function changeName(name) {
    return function (dispatch) {
        dispatch({
            type: applicationActionTypes.DRAW_NAME,
            payload: name
        });
    }
}

export function getMember(username) {
    return (dispatch, getState) => {
        let url = endPoints.member + "/get";
        return requestGet(url)
            .then(data => {
                console.log(data);
                dispatch({
                    type: applicationActionTypes.GET_NAME,
                    payload: data.name
                });
                return data
            })
            .catch(error => {
                dispatch({
                    type: applicationActionTypes.GET_MEMBER_ERROR,
                });
                return error;
            });
    }
}

export function doChangeName(username, originalName, name) {
    return (dispatch, getState) => {
        let url = endPoints.member + "/changename" +
            "?name=" + name;
        return requestGet(url)
            .then(data => {
                console.log(data);
                if (data.name === originalName) {
                    dispatch({
                        type: applicationActionTypes.CHANGE_NAME_ERROR
                    });
                } else {
                    dispatch({
                        type: applicationActionTypes.CHANGE_NAME,
                        payload: data.name
                    });
                }
                return data
            })
            .catch(error => {
                dispatch({
                    type: applicationActionTypes.CHANGE_NAME_ERROR,
                });
                return error;
            });
    }
}


export function doLogout() {
    return logout();
}

export function isAuthenticated() {
    return isauthenticated();
}