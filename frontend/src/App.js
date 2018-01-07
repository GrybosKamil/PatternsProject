import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
    render() {
        return (
            <div className="App">
                <div className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h2>Welcome to Spring Boot React Starter!</h2>
                </div>
                <p className="App-intro">
                    Hello World!
                    Whats your name, buddy?
                    Because, mine is Kamil
                </p>
            </div>
        );
    }
}

export default App;
