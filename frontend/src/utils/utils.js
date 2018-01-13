// import axios from 'axios';
import {token} from '../configuration/configuration'
import history from '../configuration/customHistory'

export const pushHistory = url => {
    history.push(url);
};

export const getConfiguration = () => {
    let configuration = {};
    if (sessionStorage.getItem(token)) {
        configuration = {
            headers: {'Authorization': 'Bearer ' + sessionStorage.getItem(token)}
        };
    }
    return configuration
};

export const isLogged = () => {
    return sessionStorage.getItem(token) !== null;
};

// export const isAuthenticated = () => {
//     const url = "http://localhost:8080/api/user";
//     axios.get(url, getConfiguration())
//         .then((data) => {
//             return true;
//         })
//         .catch((error) => {
//             return false;
//         })
// };