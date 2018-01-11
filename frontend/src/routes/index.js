import React from 'react'
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom'
import {ApplicationContainer} from '../domain/application'

function Routes() {
    return (
        <Router>
            <div>
                <Switch>
                    <Route exact path={"/"} component={ApplicationContainer}/>
                </Switch>
            </div>
        </Router>
    )
}

export default Routes