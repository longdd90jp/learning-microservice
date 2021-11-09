import React, {useMemo} from 'react';

export const SearchBox = () => {
    return (
        <div className="px-4 d-none d-md-block">
            <div className="d-flex align-items-center">
                <div className="flex-grow-1">
                    <input type="text" className="form-control my-3" placeholder="Search for Users, Groups..."/>
                </div>
            </div>
        </div>
    )
}
