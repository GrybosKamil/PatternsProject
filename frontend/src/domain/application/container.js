import React from 'react'
import PropTypes from 'prop-types'

import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'
import * as ApplicationActions from './actions'
import {Application} from "./index"
import {createSelector, createStructuredSelector} from 'reselect'

class ApplicationContainer extends React.Component {

    static propTypes = {
        application: PropTypes.object.isRequired,
        getEmployees: PropTypes.func.isRequired
    };

    componentDidMount() {
        this.props.getEmployees();
    }

    render() {
        return (
            <Application employees={this.props.application.employees}/>
        )
    }
}

// function mapStateToProps(state) {
//     return createStructuredSelector({
//         employees: createSelector(state => state.employees, applicationState => applicationState)
//     })
// }

const mapStateToProps = createStructuredSelector({
    // employees: createSelector(state => state.employees, applicationState => applicationState),
    application: createSelector(state => state.application, application => application)
});

function mapDispatchToProps(dispatch) {
    return bindActionCreators(ApplicationActions, dispatch);
}

export default connect(
    mapStateToProps,
    mapDispatchToProps,
)(ApplicationContainer)