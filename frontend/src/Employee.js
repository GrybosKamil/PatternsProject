import React, {Component} from 'react';
import PropTypes from 'prop-types';
import axios from 'axios';

class Employee extends Component {
    triggerDelete(employee) {
        axios.delete(employee._links.self.href)
            .then(response => {
                console.log(response);
            })
            .catch(error => {
                console.log(error);
            });
    }

    triggerDownloadCustomers() {
        axios.get("http://localhost:8080/api/customers")
            .then(response => {
                console.log(response);
            })
            .catch(error => {
                console.log(error);
            });
    }


    render() {
        if (!this.props.employee) return null;
        return (
            <tr>
                <td>{this.props.employee.name}</td>
                <td>{this.props.employee.age}</td>
                <td>{this.props.employee.years}</td>
                <td>
                    <button onClick={() => this.triggerDelete(this.props.employee)}>DELETE</button>
                </td>
                <td>
                    <button onClick={() => this.triggerDownloadCustomers()}>GET customers</button>
                </td>
            </tr>
        );
    }
}

Employee.propTypes = {
    employee: PropTypes.object.isRequired
};

export default Employee;
