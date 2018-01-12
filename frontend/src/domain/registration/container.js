import React from 'react'
import PropTypes from 'prop-types'

import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'
import * as RegistrationActions from './actions'
import {Registration} from "./index"
import {createSelector, createStructuredSelector} from 'reselect'

class RegistrationContainer extends React.Component {

    static propTypes = {
        registration: PropTypes.object.isRequired,
        getEmployees: PropTypes.func.isRequired
    };

    componentDidMount() {
        this.props.getEmployees();
    }

    render() {
        return (
            <Registration message={this.props.registration.message}
                          error={this.props.registration.error}/>
        )
    }
}

function mapStateToProps(state) {
    return createStructuredSelector({
        registration: createSelector(state => state.registration, registration => registration)
    })
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators(RegistrationActions, dispatch);
}

export default connect(
    mapStateToProps,
    mapDispatchToProps,
)(RegistrationContainer)