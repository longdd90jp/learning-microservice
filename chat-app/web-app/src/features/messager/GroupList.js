import React, {useMemo} from 'react';

let GroupItem = ({group}) => {
    return (
        <a href="#" className="list-group-item list-group-item-action border-0">
            <div className="badge bg-success float-right">5</div>
            <div className="d-flex align-items-start">
                <img src="https://bootdey.com/img/Content/avatar/avatar5.png"
                     className="rounded-circle mr-1" alt="Vanessa Tucker" width="40" height="40"/>
                <div className="flex-grow-1 ml-3">
                    Vanessa Tucker
                    <div className="small"><span className="fa fa-circle chat-online"></span>online</div>
                </div>
            </div>
        </a>
    );
}
GroupItem = React.memo(GroupItem);

export const GroupList = () => {
    return (
        <div className="border-top">
            <div className="py-1 pl-1">
                <i className="fa fa-sort-desc mr-1 align-text-top" aria-hidden="true"></i>
                <span className="ml-1">Groups</span>
                <i className="fa fa-plus text-success float-right mr-4 mt-1"></i>
            </div>
            <div className="chat-user-list">
                <a href="#" className="list-group-item list-group-item-action border-0">
                    <div className="badge bg-success float-right">5</div>
                    <div className="d-flex align-items-start">
                        <img src="https://bootdey.com/img/Content/avatar/avatar5.png"
                             className="rounded-circle mr-1" alt="Vanessa Tucker" width="40" height="40"/>
                        <div className="flex-grow-1 ml-3">
                            Vanessa Tucker
                            <div className="small"><span className="fa fa-circle chat-online"></span>online</div>
                        </div>
                    </div>
                </a>
                <a href="#" className="list-group-item list-group-item-action border-0">
                    <div className="badge bg-success float-right">2</div>
                    <div className="d-flex align-items-start">
                        <img src="https://bootdey.com/img/Content/avatar/avatar2.png"
                             className="rounded-circle mr-1" alt="William Harris" width="40" height="40"/>
                        <div className="flex-grow-1 ml-3">
                            William Harris
                            <div className="small"><span className="fas fa-circle chat-online"></span> Online</div>
                        </div>
                    </div>
                </a>
                <a href="#" className="list-group-item list-group-item-action border-0">
                    <div className="d-flex align-items-start">
                        <img src="https://bootdey.com/img/Content/avatar/avatar3.png"
                             className="rounded-circle mr-1" alt="Sharon Lessman" width="40" height="40"/>
                        <div className="flex-grow-1 ml-3">
                            Sharon Lessman
                            <div className="small"><span className="fas fa-circle chat-online"></span> Online</div>
                        </div>
                    </div>
                </a>
                <a href="#" className="list-group-item list-group-item-action border-0">
                    <div className="d-flex align-items-start">
                        <img src="https://bootdey.com/img/Content/avatar/avatar4.png"
                             className="rounded-circle mr-1" alt="Christina Mason" width="40" height="40"/>
                        <div className="flex-grow-1 ml-3">
                            Christina Mason
                            <div className="small"><span className="fas fa-circle chat-offline"></span> Offline</div>
                        </div>
                    </div>
                </a>
                <a href="#" className="list-group-item list-group-item-action border-0">
                    <div className="d-flex align-items-start">
                        <img src="https://bootdey.com/img/Content/avatar/avatar5.png"
                             className="rounded-circle mr-1" alt="Fiona Green" width="40" height="40"/>
                        <div className="flex-grow-1 ml-3">
                            Fiona Green
                            <div className="small"><span className="fas fa-circle chat-offline"></span> Offline</div>
                        </div>
                    </div>
                </a>
                <a href="#" className="list-group-item list-group-item-action border-0">
                    <div className="d-flex align-items-start">
                        <img src="https://bootdey.com/img/Content/avatar/avatar2.png"
                             className="rounded-circle mr-1" alt="Doris Wilder" width="40" height="40"/>
                        <div className="flex-grow-1 ml-3">
                            Doris Wilder
                            <div className="small"><span className="fas fa-circle chat-offline"></span> Offline</div>
                        </div>
                    </div>
                </a>
                <a href="#" className="list-group-item list-group-item-action border-0">
                    <div className="d-flex align-items-start">
                        <img src="https://bootdey.com/img/Content/avatar/avatar4.png"
                             className="rounded-circle mr-1" alt="Haley Kennedy" width="40" height="40"/>
                        <div className="flex-grow-1 ml-3">
                            Haley Kennedy
                            <div className="small"><span className="fas fa-circle chat-offline"></span> Offline</div>
                        </div>
                    </div>
                </a>
                <a href="#" className="list-group-item list-group-item-action border-0">
                    <div className="d-flex align-items-start">
                        <img src="https://bootdey.com/img/Content/avatar/avatar3.png"
                             className="rounded-circle mr-1" alt="Jennifer Chang" width="40" height="40"/>
                        <div className="flex-grow-1 ml-3">
                            Jennifer Chang
                            <div className="small"><span className="fas fa-circle chat-offline"></span> Offline</div>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    )
}
