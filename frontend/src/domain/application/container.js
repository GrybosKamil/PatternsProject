import React from 'react'
import PropTypes from 'prop-types'

import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'
import * as ApplicationActions from './actions'
import {Application} from "./index"
import {createSelector, createStructuredSelector} from 'reselect'
import {isLogged, pushHistory} from "../../utils/utils";

class ApplicationContainer extends React.Component {

    static propTypes = {
        application: PropTypes.object.isRequired,
        login: PropTypes.object.isRequired,
        getEmployees: PropTypes.func.isRequired
    };

    doLogin() {
        pushHistory("/login");
    }

    doLogout() {
        this.props.doLogout();
    }

    componentDidMount() {
        if (isLogged() &&
            this.props.isAuthenticated()
                .then(() => true)
                .catch(() => false)
        ) {
            console.log("logged, get employees!");
            this.props.getEmployees();
        } else {
            console.log("not logged, redirect!");
            pushHistory("/login");
        }
    }

    render() {
        return (
            <Application
                logged={isLogged()}
                employees={this.props.application.employees}
                doLogin={this.doLogin.bind(this)}
                doLogout={this.doLogout.bind(this)}
            />
        )
    }
}

function mapStateToProps(state) {
    return createStructuredSelector({
        application: createSelector(state => state.application, application => application),
        login: createSelector(state => state.login, login => login)
    })
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators(ApplicationActions, dispatch);
}

export default connect(
    mapStateToProps,
    mapDispatchToProps,
)(ApplicationContainer)