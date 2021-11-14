import {configureStore} from '@reduxjs/toolkit';

import messagerUsersReducer from '../features/messager/slice/usersSlice';
import messagerGroupsReducer from '../features/messager/slice/groupsSlice';

export default configureStore({
    reducer: {
        messagerUsers: messagerUsersReducer,
        messagerGroups: messagerGroupsReducer
    }
})
