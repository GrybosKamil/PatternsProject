const protocol = "http";
const host = "localhost";
const port = "8080";

const api = "/api";
const employees = "/employees";
const customers = "/customers";

module.exports = {

    protocol: protocol,
    host: host,
    port: port,
    serverPath: protocol + "://" + host + ":" + port,
    api: api,
    endpoints: {
        employees: employees,
        customers: customers
    }
};