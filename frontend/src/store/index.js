import {applyMiddleware, createStore} from 'redux'
import ReduxThunk from 'redux-thunk'
import {composeWithDevTools} from 'redux-devtools-extension'
import rootReducer from '../reducers'


function configureStore(initialState = {}) {
    const middlewares = [ReduxThunk];
    const enhancers = [
        applyMiddleware(...middlewares),
    ];
    const composeEnchancers = composeWithDevTools({});

    return createStore(rootReducer, initialState, composeEnchancers(...enhancers));
}


export default configureStore;