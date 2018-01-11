import React, {Component} from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';
import EmployeeTable from "./EmployeeTable";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            employees: []
        }
    }

    loadEmployeesFromServer() {
        let self = this;
        axios.get("http://localhost:8080/api/employees")
            .then(response => {
                self.setState({employees: response.data._embedded.employees});
            })
            .catch(error => {
                console.log(error);
            });
    }

    componentDidMount() {
        this.loadEmployeesFromServer();
    }

    render() {
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
                <EmployeeTable employees={this.state.employees}/>
            </div>
        );
    }
}

export default App;
