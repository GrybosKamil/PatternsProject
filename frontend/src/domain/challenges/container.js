import React from 'react'
import PropTypes from 'prop-types'

import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'
import {Challenges} from "./index"
import * as ChallengesActions from "./actions"
import {createSelector, createStructuredSelector} from 'reselect'
import {pushHistory} from "../../utils/utils";

class ChallengesContainer extends React.Component {

    static propTypes = {
        challenges: PropTypes.object.isRequired,
        login: PropTypes.object.isRequired
    };

    componentDidMount() {
        if (this.props.login.isLogged &&
            this.props.isAuthenticated()
                .then(() => true)
                .catch(() => false)
        ) {
            this.props.getChallenges();
        } else {
            pushHistory("/login");
        }
    }

    render() {
        console.log(this.props.challenges);
        return (
            <div>
                <Challenges
                    error={this.props.challenges.error}
                    success={this.props.challenges.success}
                    challenges={this.props.challenges.challenges}
                />
            </div>
        )
    }
}

function mapStateToProps(state) {
    return createStructuredSelector({
        challenges: createSelector(state => state.challenges, challenges => challenges),
        login: createSelector(state => state.login, login => login)
    })
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators(ChallengesActions, dispatch);
}

export default connect(
    mapStateToProps,
    mapDispatchToProps,
)(ChallengesContainer)