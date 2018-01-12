import React from 'react';
import pure from 'recompose/pure'

function Login({message, error}) {
    return (
        <div className="login-panel">

            <form method="POST" className="form-signin">
                <h2 className="form-heading">Log in</h2>

                <div className={"form-group" + error != null ? 'hasError' : ''}>
                    <div className="form-group ">
                        <span>{message}</span>
                        <input name="username" type="text"
                               className="form-control"
                               placeholder="Username"
                               autoFocus="true"/>
                        <input name="password" type="password"
                               className="form-control"
                               placeholder="Password"/>
                        <span>{error}</span>
                        {/*<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>*/}

                        <button className="btn btn-lg btn-primary btn-block"
                                type="submit">Log In
                        </button>
                        <h4 className="text-center">
                            <a href="/register">Create an account</a>
                        </h4>
                    </div>
                </div>

            </form>

        </div>
    )
}

export default pure(Login)