const token = "token";
const userName = "username";

const protocol = "http";
const host = "localhost";
const port = "8080";

const serverPath = protocol + "://" + host + ":" + port;
const apiPath = serverPath + "/api";

const employees = "/employees";
const customers = "/customers";
const authentication = "/authentication";
const registration = "/registration";

const member = "/member";
const organizer = "/organizer";
const challenge = "/challenge";

module.exports = {
    protocol: protocol,
    host: host,
    port: port,
    serverPath: serverPath,
    apiPath: apiPath,
    endPoints: {
        authentication: apiPath + authentication,
        registrationMember: apiPath + registration + member,
        registrationOrganizer: apiPath + registration + organizer,

        employees: apiPath + employees,
        customers: apiPath + customers,
        member: apiPath + member,

        challenge: apiPath + challenge,
    },
    token: token,
    userName: userName
};