import React from 'react'
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom'
import {ApplicationContainer} from '../domain/application'
import {LoginContainer} from '../domain/login'
import {RegistrationContainer} from "../domain/registration";

function Routes() {
    return (
        <Router>
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