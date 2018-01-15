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

        </div>
    )
}

export default pure(Header)