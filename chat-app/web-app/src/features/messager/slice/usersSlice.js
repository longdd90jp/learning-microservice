import { createSlice } from '@reduxjs/toolkit'

const initialState = [
    { id: '1', name: 'Use 1', status: 1, unreadCount: 0, avatar: `https://bootdey.com/img/Content/avatar/avatar5.png`, lastMessage: 'Hello you 1'},
    { id: '2', name: 'Use 2', status: 1, unreadCount: 1, avatar: `https://bootdey.com/img/Content/avatar/avatar2.png` },
    { id: '3', name: 'Use 3', status: 2, unreadCount: 0, avatar: `https://bootdey.com/img/Content/avatar/avatar3.png`, lastMessage: 'Hello you 3' },
    { id: '4', name: 'Use 4', status: 1, unreadCount: 4, avatar: `https://bootdey.com/img/Content/avatar/avatar4.png`, lastMessage: 'Hello you 4'},
    { id: '5', name: 'Use 5', status: 2, unreadCount: 0, avatar: `https://bootdey.com/img/Content/avatar/avatar5.png` },
]

const usersSlice = createSlice({
    name: 'messagerUsers',
    initialState,
    reducers: {}
})

export default usersSlice.reducer;
