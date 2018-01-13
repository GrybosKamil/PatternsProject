import React from 'react'
import {Router, Switch, Route} from 'react-router-dom'
import {ApplicationContainer} from '../domain/application'
import {LoginContainer} from '../domain/login'
import {RegistrationContainer} from "../domain/registration";

import history from '../configuration/customHistory'

function Routes() {
    return (
        <Router history={history}>
            <div>
                {/*<HeaderContainer/>*/}
                <Switch>
                    <Route exact path={"/"} component={ApplicationContainer}/>
                    <Route exact path={"/login"} component={LoginContainer}/>
                    <Route exact path={"/registration"} component={RegistrationContainer}/>
                </Switch>
                {/*<FooterContainer/>*/}
            </div>
        </Router>
    )
}

export default Routes