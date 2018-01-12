import React from 'react';
import pure from 'recompose/pure'

function Registration({message, error, status}) {
    return (
        <div className="registration-panel">

            <form method="POST" className="form-signin">
                <h2 className="form-signin-heading">Create your account</h2>
                <div className={"form-group " + status.error ? 'has-error' : ''}>
                    <input type="text" path="username" className="form-control"
                           placeholder="Username" autoFocus="true"/>
                    <span>{error}</span>
                </div>

                <div className={"form-group " + status.error ? 'has-error' : ''}>
                    <input type="password" path="password" className="form-control"
                           placeholder="Password"/>
                    <span>{error}</span>
                </div>

                <div className={"form-group " + status.error ? 'has-error' : ''}>
                    <input type="password" path="passwordConfirm" className="form-control"
                           placeholder="Confirm your password"/>
                    <span>{error}</span>
                </div>

                <button className="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                <h4 className="text-center">
                    <a href={"/login"}>Login</a>
                </h4>
            </form>

        </div>
    )
}

export default pure(Registration)