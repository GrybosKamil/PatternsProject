import React from 'react';
import logo from '../../../logo.svg';
import pure from 'recompose/pure'

import Employee from "../../../Employee";

function Application({logged, doLogin, doLogout}) {

    return (
        <div className="App">
            <nav className="navbar navbar-inverse">
                <div className="container-fluid">
                    <div className="navbar-header">
                        <a className="navbar-brand" href="/">TakeTheChallenge</a>
                    </div>
                    <ul className="nav navbar-nav">
                        {logged ?
                            <li onClick={doLogout}><a href={"/login"}>Logout</a></li>
                            :
                            <li onClick={doLogin}><a href={"/login"}>Login</a></li>
                        }
                        <li><a>All challenges</a></li>
                        <li><a>My challenges</a></li>
                        <li><a>Statistics</a></li>
                    </ul>
                </div>
            </nav>
            <div className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <h2>Welcome to Spring Boot React Starter!</h2>
            </div>

            <p className="App-intro">
                Hello World!
                Dude, what's your name?
                Because, mine is Kamil
            </p>

        </div>
    )
}

export default pure(Application)