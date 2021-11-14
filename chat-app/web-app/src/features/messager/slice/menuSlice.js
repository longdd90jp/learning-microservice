import { createSlice } from '@reduxjs/toolkit'

const initialState = [
    { id: '1', name: 'G1 Team', unreadCount: 0, style: 1},
    { id: '2', name: 'AT Team', unreadCount: 1, style: 2},
    { id: '3', name: 'DEVX Team', unreadCount: 1, style: 3},
]

const menuSlice = createSlice({
    name: 'messagerMenu',
    initialState,
    reducers: {}
})

export default menuSlice.reducer;
