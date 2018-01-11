import * as applicationActionTypes from './actionTypes'
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