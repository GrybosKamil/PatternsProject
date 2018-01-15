// import axios from 'axios';
import {token, userName} from '../configuration/configuration'
import history from '../configuration/customHistory'

export const pushHistory = url => {
    history.push(url);
};
export const getActualUrl = () => {
    return history.location.pathname;
};

export const getConfiguration = () => {
    let configuration = {};
    if (localStorage.getItem(token)) {
        configuration = {
            headers: {'Authorization': 'Bearer ' + localStorage.getItem(token)}
        };
    }
    return configuration
};

export const isLogged = () => {
    return localStorage.getItem(userName) !== null &&
        localStorage.getItem(token) !== null;
};