import React from 'react'
import PropTypes from 'prop-types'
import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'
import * as LoginActions from "./actions";
import {Login} from "./index"
import {createSelector, createStructuredSelector} from 'reselect'

class LoginContainer extends React.Component {

    static propTypes = {
        login: PropTypes.object.isRequired,
    };

    pressEnter(event) {
        if (event.charCode === 13) {
            this.doLogin();
        }
    }

    changeUsername(event) {
        this.props.changeUsername(event.target.value);
    }

    changePassword(event) {
        this.props.changePassword(event.target.value)
    }

    doLogin() {
        this.props.doLogin(this.props.login.username, this.props.login.password)
    }

    componentDidMount() {
    }

    render() {
        return (
            <Login error={this.props.login.error}
                   doLogin={this.doLogin.bind(this)}
                   pressEnter={this.pressEnter.bind(this)}
                   changeUsername={this.changeUsername.bind(this)}
                   changePassword={this.changePassword.bind(this)}/>
        )
    }
}

function mapStateToProps(state) {
    return createStructuredSelector({
        login: createSelector(state => state.login, login => login),
    })
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators(LoginActions, dispatch);
}

export default connect(
    mapStateToProps,
    mapDispatchToProps,
)(LoginContainer)