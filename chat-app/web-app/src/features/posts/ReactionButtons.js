import React from 'react'
import {useDispatch} from 'react-redux';

import {reactionAdded} from './postsSlice';
import {reactionEmojis} from '../../constants/reactionConstant';

export const ReactionButtons = ({post}) => {
    const dispatch = useDispatch();

    const reactionButtons = Object.entries(reactionEmojis).map(([name, emoji]) => {
        return (
            <button
                key={name} type="button" className="muted-button reaction-button"
                onClick={() =>
                    dispatch(reactionAdded({postId: post.id, reaction: name}))
                }
            >
                {emoji} {post.reactions[name]}
            </button>
        )
    })

    return <div>{reactionButtons}</div>
}