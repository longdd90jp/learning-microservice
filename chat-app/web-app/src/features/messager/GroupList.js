import React, {useMemo} from 'react';
import { useSelector } from 'react-redux';

let GroupItem = ({group}) => {
    return (
        <a href="#" className="list-group-item list-group-item-action border-0">
            {group.unreadCount > 0 && <div className="badge bg-success float-right">{group.unreadCount}</div>}
            <div className="d-flex align-items-start">
                <div className={'position-relative group-icon group-icon-' + group.style}>{group.name.substring(0, 2)}</div>
                <div className="flex-grow-1 group-name ml-3">
                    <span>{group.name}</span>
                </div>
            </div>
        </a>
    );
}
GroupItem = React.memo(GroupItem);

export const GroupList = () => {
    const groups = useSelector(state => state.messagerGroups);
    const renderedGroups = groups.map(group => (
        <GroupItem key={group.id} group={group}/>
    ))

    return (
        <div className="border-top">
            <div className="py-1 pl-1">
                <i className="fa fa-sort-desc mr-1 align-text-top cursor-pointer" aria-hidden="true"></i>
                <span className="ml-1">Groups</span>
                <i className="fa fa-plus text-success float-right mt-1 cursor-pointer"></i>
            </div>
            <div className="chat-user-list">
                {renderedGroups}
            </div>
        </div>
    )
}
