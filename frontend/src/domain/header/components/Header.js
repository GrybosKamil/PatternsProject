import React from 'react';
import pure from 'recompose/pure'

function Header({logged, doLogin, doLogout}) {
    return (
        <div className="App">
            <nav className="navbar navbar-inverse">
                <div className="container-fluid">
                    <div className="navbar-header">
                        <a className="navbar-brand" href="/">TakeTheChallenge</a>
                    </div>

                    {logged ?
                        <ul className="nav navbar-nav">
                            <li onClick={doLogout}><a href={"/login"}>Logout</a></li>
                            <li><a href={"/challenges"}>All challenges</a></li>
                            <li><a>My challenges</a></li>
                            <li><a>Statistics</a></li>
                        </ul>
                        :
                        <ul className="nav navbar-nav">
                            <li><a href={"/login"}> Login</a></li>
                            <li><a href={"/registration"}>Registration</a></li>
                        </ul>
                    }

                </div>
            </nav>

        </div>
    )
}

export default pure(Header)