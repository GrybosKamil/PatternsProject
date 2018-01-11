import React from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';
import configureStore from './store';
import Routes from './routes';
import registerServiceWorker from './registerServiceWorker';
import './index.css';

render(
    <Provider store={configureStore()}>
        <Routes/>
    </Provider>,
    document.getElementById('root')
);
registerServiceWorker();
