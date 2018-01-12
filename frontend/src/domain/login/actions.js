import * as loginActionTypes from './actionTypes'
import axios from "axios/index";
import {checkStatus, extractData} from "../../utils/apiUtils";

export function getEmployees() {
    return (dispatch, getState) => {
        return axios.get("http://localhost:8080/api/employees")
            .then(checkStatus)
            .then(extractData)
            .then(data => {
                console.log(data);
                dispatch({
                    type: loginActionTypes.CHANGE,
                    employees: data.employees
                });
                return data.employees;
            })
            .catch(error => {
                console.log(error);
                dispatch({
                    type: loginActionTypes.CHANGE,
                    employees: []
                });
                return error;
            });
    }
}

export function logIn() {
    return (dispatch, getState) => {
        return axios.post("http://localhost:8080//employees")
            .then(checkStatus)
            .then(extractData)
            .then(data => {
                console.log(data);
                dispatch({
                    type: loginActionTypes.CHANGE,
                    employees: data.employees
                });
                return data.employees;
            })
            .catch(error => {
                console.log(error);
                dispatch({
                    type: loginActionTypes.CHANGE,
                    employees: []
                });
                return error;
            });
    }
}