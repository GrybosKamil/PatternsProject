import React from 'react';
import PropTypes from 'prop-types';
import {endPoints} from './configuration/configuration'
import {requestDelete, requestGetEmbedded} from "./utils/apiUtils";

class Employee extends React.Component {
    triggerDelete(employee) {
        requestDelete(employee._links.self.href)
            .then(data => {
                console.log(data);
            })
            .catch(error => {
                console.log(error);
            });
    }

    triggerDownloadCustomers() {
        requestGetEmbedded(endPoints.customers)
            .then(data => {
                console.log(data);
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
