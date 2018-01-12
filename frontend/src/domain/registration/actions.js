import * as registrationActionTypes from './actionTypes'
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
                    type: registrationActionTypes.CHANGE,
                    employees: data.employees
                });
                return data.employees;
            })
            .catch(error => {
                console.log(error);
                dispatch({
                    type: registrationActionTypes.CHANGE,
                    employees: []
                });
                return error;
            });
    }
}

export function register() {
    return (dispatch, getState) => {
        return axios.post("http://localhost:8080/api/register")
            .then(checkStatus)
            .then(extractData)
            .then(data => {
                console.log(data);
                dispatch({
                    type: registrationActionTypes.REGISTER,
                    employees: data.employees
                });
                return data.employees;
            })
            .catch(error => {
                console.log(error);
                dispatch({
                    type: registrationActionTypes.REGISTER,
                    employees: []
                });
                return error;
            });
    }
}