import React from 'react'
import {Route, Router, Switch} from 'react-router-dom'
import history from '../configuration/customHistory'
import {LoginContainer} from '../domain/login'
import {RegistrationContainer} from "../domain/registration";
import {HeaderContainer} from "../domain/header";
import {ApplicationContainer} from '../domain/application'
import {ChallengesContainer} from "../domain/challenges/index";


function Routes() {
    return (
        <Router history={history}>
            <div>
                <HeaderContainer/>
                <Switch>
                    <Route exact path={"/login"} component={LoginContainer}/>
                    <Route exact path={"/registration"} component={RegistrationContainer}/>
                    <Route exact path={"/"} component={ApplicationContainer}/>
                    <Route exact path={"/challenges"} component={ChallengesContainer}/>
                </Switch>
            </div>
        </Router>
    )
}

export default Routes