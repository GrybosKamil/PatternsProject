import {endPoints} from '../../configuration/configuration'
import * as applicationActionTypes from './actionTypes'
import {requestGet, requestGetEmbedded} from "../../utils/apiUtils";

import {doLogout as logout, isAuthenticated as isauthenticated} from '../login/actions'

export function getEmployees() {
    return (dispatch, getState) => {
        return requestGetEmbedded(endPoints.employees)
            .then(data => {
                console.log(data);
                dispatch({
                    type: applicationActionTypes.CHANGE,
                    employees: data.employees
                });
                return data.employees;
            })
            .catch(error => {
                console.log(error);
                dispatch({
                    type: applicationActionTypes.CHANGE,
                    employees: []
                });
                return error;
            });
    }
}

export function getMember(username) {
    return (dispatch, getState) => {
        let url = endPoints.member + "/get" +
            "?username=" + username;
        return requestGet(url)
            .then(data => {
                console.log(data);
                // dispatch({
                //     type: applicationActionTypes.CHANGE,
                //     employees: data.employees
                // });
                // return data.employees;
            })
            .catch(error => {
                // console.log(error);
                // dispatch({
                //     type: applicationActionTypes.CHANGE,
                //     employees: []
                // });
                // return error;
            });
    }
}

export function doLogout() {
    return logout();
}

export function isAuthenticated() {
    return isauthenticated();
}