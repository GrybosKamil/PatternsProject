import React, {Component} from 'react';
import Employee from "./Employee";
import PropTypes from "prop-types";

class EmployeeTable extends Component {
    render() {
        let rows = this.props.employees.map((employee, i) =>
            (<Employee key={i} employee={employee}/>)
        );

        return (
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
        )
    }
}
Employee.propTypes = {
    employees: PropTypes.array.isRequired
};

export default EmployeeTable;
