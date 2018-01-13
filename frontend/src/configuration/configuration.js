const token = "token";

const protocol = "http";
const host = "localhost";
const port = "8080";

const serverPath = protocol + "://" + host + ":" + port;
const apiPath = serverPath + "/api";

const employees = "/employees";
const customers = "/customers";
const authentication = "/authentication";

module.exports = {
    protocol: protocol,
    host: host,
    port: port,
    serverPath: serverPath,
    apiPath: apiPath,
    endpoints: {
        employees: apiPath + employees,
        customers: apiPath + customers,
        authentication: apiPath + authentication,
    },
    token: token
};