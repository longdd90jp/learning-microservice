import React, {useMemo} from 'react';
import { useSelector } from 'react-redux';

let UserItem = ({user}) => {
    const GetStatusClass = (status) => {
        let className = '';
        switch (status) {
            case 1:
                className = 'chat-online';
                break;
            case 2:
                className = 'chat-offline';
                break;
        }
        return className;
    };
    return (
        <a href="#" className="list-group-item list-group-item-action border-0">
            {user.unreadCount > 0 && <div className="badge bg-success float-right">{user.unreadCount}</div>}
            <div className="d-flex align-items-start">
                <div className="position-relative">
                    <img src={user.avatar} className="rounded-circle mr-1" alt="Vanessa Tucker" width="40" height="40"/>
                    <span className={'position-absolute fa fa-circle user-status-icon ' + (GetStatusClass(user.status))}></span>
                </div>
                <div className="flex-grow-1 ml-3">
                    <span>{user.name}</span>
                    <div className="small">
                        <span>{user.lastMessage}</span>
                    </div>
                </div>
            </div>
        </a>
    );
}
UserItem = React.memo(UserItem);

export const UserList = () => {
    const users = useSelector(state => state.messagerUsers);
    const renderedUsers = users.map(user => (
        <UserItem key={user.id} user={user}/>
    ))

    return (
        <div className="border-top">
            <div className="py-1 pl-1">
                <i className="fa fa-sort-desc mr-1 align-text-top cursor-pointer" aria-hidden="true"></i>
                <span className="ml-1">Users</span>
                <i className="fa fa-plus text-success float-right mt-1 cursor-pointer"></i>
            </div>
            <div className="chat-user-list">
                {renderedUsers}
            </div>
        </div>
    )
}
