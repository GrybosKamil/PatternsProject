import {doLogout as logout, isAuthenticated as isauthenticated} from '../login/actions'

export function doLogout() {
    return logout();
}

export function isAuthenticated() {
    return isauthenticated();
}