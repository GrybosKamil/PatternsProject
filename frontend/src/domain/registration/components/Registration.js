import React from 'react';
import pure from 'recompose/pure'

function Registration({error, pressEnter, changeUsername, changePassword, changePasswordConfirm, changeRegisterType, doRegister}) {
    return (
        <div className="registration-panel">

            <div method="POST" className="form-signin">
                <h2 className="form-signin-heading">Create your account</h2>
                <div className={"form-group" + error !== null ? 'hasError' : ''}>
                    <input type="text"
                           className="form-control"
                           onChange={changeUsername.bind(this)}
                           onKeyPress={pressEnter.bind(this)}
                           placeholder="Username"
                           autoFocus="true"/>
                    <input type="password"
                           className="form-control"
                           onChange={changePassword.bind(this)}
                           onKeyPress={pressEnter.bind(this)}
                           placeholder="Password"/>
                    <input type="password"
                           className="form-control"
                           onChange={changePasswordConfirm.bind(this)}
                           onKeyPress={pressEnter.bind(this)}
                           placeholder="Confirm your password"/>
                    <input type="checkbox"
                           className="form-control"
                           default={false}
                           onChange={changeRegisterType.bind(this)}/>
                        Organizer
                    {error ?
                        <div>{error}</div>
                        :
                        null
                    }
                    <button className="btn btn-lg btn-primary btn-block"
                            onClick={doRegister.bind(this)}>
                        Register
                    </button>
                    <h4 className="text-center">
                        <a href={"/login"}>Login</a>
                    </h4>
                </div>
            </div>

        </div>
    )
}

export default pure(Registration)