import {endPoints} from '../../configuration/configuration'
import * as challengesActionTypes from './actionTypes'
import {requestGet} from "../../utils/apiUtils";

import {isAuthenticated as isauthenticated} from '../login/actions'

export function getChallenges() {
    return (dispatch, getState) => {
        let url = endPoints.challenge + "/all";
        return requestGet(url)
            .then(data => {
                console.log(data);
                dispatch({
                    type: challengesActionTypes.GET_CHALLENGES,
                    payload: data
                });
                return data
            })
            .catch(error => {
                dispatch({
                    type: challengesActionTypes.GET_CHALLENGES_ERROR,
                });
                return error;
            });
    }
}

export function isAuthenticated() {
    return isauthenticated();
}