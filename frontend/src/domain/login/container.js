import React from 'react'
import PropTypes from 'prop-types'

import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'
import * as LoginActions from './actions'
import {Login} from "./index"
import {createSelector, createStructuredSelector} from 'reselect'

class LoginContainer extends React.Component {

    static propTypes = {
        login: PropTypes.object.isRequired,
        getEmployees: PropTypes.func.isRequired
    };

    componentDidMount() {
        this.props.getEmployees();
    }

    render() {
        return (
            <Login message={this.props.login.message}
                   error={this.props.login.error}/>
        )
    }
}

function mapStateToProps(state) {
    return createStructuredSelector({
        login: createSelector(state => state.login, login => login)
    })
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators(LoginActions, dispatch);
}

export default connect(
    mapStateToProps,
    mapDispatchToProps,
)(LoginContainer)