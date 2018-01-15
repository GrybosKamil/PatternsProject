import React from 'react'
import PropTypes from 'prop-types'

import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'
import * as HeaderActions from './actions'
import {Header} from "./index"
import {createSelector, createStructuredSelector} from 'reselect'
import {getActualUrl, pushHistory} from "../../utils/utils";

class HeaderContainer extends React.Component {

    static propTypes = {
        login: PropTypes.object.isRequired,
    };

    doLogin() {
        pushHistory("/login");
    }

    doRegistration() {
        pushHistory("/registration");
    }

    doLogout() {
        this.props.doLogout();
    }

    componentDidMount() {
        let actualUrl = getActualUrl();
        if (actualUrl !== "/login" &&
            actualUrl !== "/registration" &&
            !this.props.login.isLogged &&
            !this.props.isAuthenticated()
                .then(() => true)
                .catch(() => false)
        ) {
            pushHistory("/login");
        }
    }

    render() {
        return (
            <div>
                <Header
                    logged={this.props.login.isLogged}
                    doLogin={this.doLogin.bind(this)}
                    doRegistration={this.doRegistration.bind(this)}
                    doLogout={this.doLogout.bind(this)}
                />

            </div>
        )
    }
}

function mapStateToProps(state) {
    return createStructuredSelector({
        login: createSelector(state => state.login, login => login)
    })
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators(HeaderActions, dispatch);
}

export default connect(
    mapStateToProps,
    mapDispatchToProps,
)(HeaderContainer)