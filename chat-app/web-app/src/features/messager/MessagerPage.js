import React from 'react';
import {UserList} from './UserList';
import {GroupList} from './GroupList';
import {SearchBox} from './SearchBox';
import {MessageMenu} from './MessageMenu';
import {MessageList} from './MessageList';
import {MessageBox} from './MessageBox';
import './MessagerStyle.css';

export const MessagerPage = () => (
    <main className="content">
        <div className="container p-0">

            <h1 className="h3 mb-3">Messages</h1>

            <div className="card">
                <div className="row g-0">
                    <div className="col-12 col-lg-5 col-xl-3 border-right pr-0">
                        <SearchBox/>
                        <UserList/>
                        <GroupList/>
                        <hr className="d-block d-lg-none mt-1 mb-0"/>
                    </div>
                    <div className="col-12 col-lg-7 col-xl-9">
                        <MessageMenu/>
                        <MessageList/>
                        <MessageBox/>
                    </div>
                </div>
            </div>
        </div>
    </main>
);
