import React from 'react';
import logo from '../../../logo.svg';
import pure from 'recompose/pure'

import Employee from "../../../Employee";


function Application({employees}) {
    let rows = employees.map((employee, i) =>
        (<Employee key={i} employee={employee}/>)
    );

    return (
        <div className="App">
            <div className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <h2>Welcome to Spring Boot React Starter!</h2>
            </div>
            <p className="App-intro">
                Hello World!
                Dude, what's your name?
                Because, mine is Kamil
            </p>

            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Years</th>
                </tr>
                </thead>
                <tbody>{rows}</tbody>
            </table>

        </div>
    )
}

export default pure(Application)