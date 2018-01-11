export const checkStatus = response => {
    const hasError = response.status < 200 || response.status >= 300;
    if (hasError) {
        const error = new Error(response.statusText);
        error.response = response;
        throw error
    }
    return response;
};

export const extractData = response => response.data._embedded;