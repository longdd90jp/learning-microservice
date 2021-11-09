import {configureStore} from '@reduxjs/toolkit';

import messagerUsersReducer from '../features/messager/slice/usersSlice';

export default configureStore({
    reducer: {
        messagerUsers: messagerUsersReducer
    }
})
