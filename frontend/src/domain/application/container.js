import React from 'react'
import PropTypes from 'prop-types'

import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'
import * as ApplicationActions from './actions'
import {MemberInterface} from "./index"
import {createSelector, createStructuredSelector} from 'reselect'
import {pushHistory} from "../../utils/utils";

class ApplicationContainer extends React.Component {

    static propTypes = {
        application: PropTypes.object.isRequired,
        login: PropTypes.object.isRequired
    };

    doLogin() {
        pushHistory("/login");
    }

    doLogout() {
        this.props.doLogout();
    }

    pressEnter(event) {
        if (event.charCode === 13) {
            this.doChangeName();
        }
    }

    changeName(event) {
        this.props.changeName(event.target.value);
    }

    doChangeName() {
        this.props.doChangeName(this.props.login.username,
            this.props.application.name, this.props.application.drawName);
    }

    componentDidMount() {
        if (this.props.login.isLogged &&
            this.props.isAuthenticated()
                .then(() => true)
                .catch(() => false)
        ) {
            this.props.getMember(this.props.login.username);
        } else {
            pushHistory("/login");
        }
    }

    render() {
        return (
            <div>
                <MemberInterface
                    error={this.props.application.error}
                    success={this.props.application.success}
                    originalName={this.props.application.name}
                    drawName={this.props.application.drawName}
                    pressEnter={this.pressEnter.bind(this)}
                    changeName={this.changeName.bind(this)}
                    doChangeName={this.doChangeName.bind(this)}
                />
            </div>
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