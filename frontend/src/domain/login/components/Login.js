import React from 'react';
import pure from 'recompose/pure'

function Login({error, pressEnter, changeUsername, changePassword, doLogin}) {
    return (
        <div className="login-panel">

            <div className="form-signin">
                <h2 className="form-heading">Log in</h2>
                <div className={"form-group" + error !== null ? 'hasError' : ''}>
                    <div className="form-group ">
                        <input name="username" type="text"
                               className="form-control"
                               placeholder="Username"
                               onChange={changeUsername.bind(this)}
                               onKeyPress={pressEnter.bind(this)}
                               autoFocus="true"/>
                        <input name="password" type="password"
                               className="form-control"
                               onChange={changePassword.bind(this)}
                               onKeyPress={pressEnter.bind(this)}
                               placeholder="Password"/>
                        {error ?
                            <div>{error}</div>
                            :
                            null
                        }
                        <button className="btn btn-lg btn-primary btn-block"
                                onClick={doLogin.bind(this)}>
                            Log In
                        </button>
                        <h4 className="text-center">
                            <a href={"/registration"}>Create an account</a>
                        </h4>
                    </div>
                </div>
            </div>

        </div>
    )
}

export default pure(Login)