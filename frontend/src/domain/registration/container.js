import React from 'react'
import PropTypes from 'prop-types'

import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'
import * as RegistrationActions from './actions'
import {Registration} from "./index"
import {createSelector, createStructuredSelector} from 'reselect'
import {pushHistory} from "../../utils/utils";

class RegistrationContainer extends React.Component {

    static propTypes = {
        registration: PropTypes.object.isRequired,
        login: PropTypes.object.isRequired,
    };

    pressEnter(event) {
        if (event.charCode === 13) {
            this.doRegister();
        }
    }

    changeUsername(event) {
        this.props.changeUsername(event.target.value);
    }

    changePassword(event) {
        this.props.changePassword(event.target.value)
    }

    changePasswordConfirm(event) {
        this.props.changePasswordConfirm(event.target.value)
    }

    changeRegistrationType() {
        this.props.changeRegistrationType(!this.props.registration.registrationType);
    }

    doRegister() {
        this.props.doRegister(this.props.registration.username,
            this.props.registration.password, this.props.registration.passwordConfirm,
            this.props.registration.registrationType
        )
    }

    componentDidMount() {
        if (this.props.login.isLogged &&
            this.props.isAuthenticated()
                .then(() => true)
                .catch(() => false)
        ) {
            console.log("Already logged");
            pushHistory("/");
        }
    }

    render() {
        return (
            <Registration
                error={this.props.registration.error}
                doRegister={this.doRegister.bind(this)}
                pressEnter={this.pressEnter.bind(this)}
                changeUsername={this.changeUsername.bind(this)}
                changePassword={this.changePassword.bind(this)}
                changePasswordConfirm={this.changePasswordConfirm.bind(this)}
                changeRegisterType={this.changeRegistrationType.bind(this)}
            />
        )
    }
}

function mapStateToProps(state) {
    return createStructuredSelector({
        registration: createSelector(state => state.registration, registration => registration),
        login: createSelector(state => state.login, registration => registration)
    })
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators(RegistrationActions, dispatch);
}

export default connect(
    mapStateToProps,
    mapDispatchToProps,
)(RegistrationContainer)