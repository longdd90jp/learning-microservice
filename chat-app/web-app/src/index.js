import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import store from './app/store';
import {Provider} from 'react-redux';

import {worker} from './api/server';

import {fetchUsers} from './features/users/usersSlice';

// Start our mock API server
worker.start({onUnhandledRequest: 'bypass'});

// Only need to fetch the list of users once, and we want to do it right when the application starts
store.dispatch(fetchUsers());

ReactDOM.render(
    <React.StrictMode>
        <Provider store={store}>
            <App/>
        </Provider>
    </React.StrictMode>,
    document.getElementById('root')
)