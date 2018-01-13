import axios from 'axios/index'
import {isLogged} from './utils'
import {token} from '../configuration/configuration'

export const checkStatus = response => {
    const hasError = response.status < 200 || response.status >= 300;
    if (hasError) {
        const error = new Error(response.statusText);
        error.response = response;
        throw error
    }
    return response;
};

export const extractData = response => response.data;
export const extractDataEmbedded = response => response.data._embedded;

export const getConfiguration = () => {
    let configuration = {};
    if (isLogged()) {
        configuration = {
            headers: {'Authorization': 'Bearer ' + sessionStorage.getItem(token)}
        }
    }
    return configuration;
};

export const requestGet = (url) => {
    let configuration = getConfiguration();
    return axios.get(url, configuration)
        .then(checkStatus)
        .then(extractData);
};

export const requestGetEmbedded = (url) => {
    let configuration = getConfiguration();
    return axios.get(url, configuration)
        .then(checkStatus)
        .then(extractDataEmbedded);
};

export const requestPost = (url) => {
    let configuration = getConfiguration();
    return axios.post(url, configuration)
        .then(checkStatus)
        .then(extractData);
};

export const requestDelete = (url) => {
    let configuration = getConfiguration();
    return axios.delete(url, configuration)
        .then(checkStatus)
        .then(extractData);
};