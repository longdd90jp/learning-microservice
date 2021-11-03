import React from 'react';

import {useAddReactionMutation} from '../api/apiSlice';
import {reactionEmojis} from '../../constants/reactionConstant';

export const ReactionButtons = ({post}) => {
    const [addReaction] = useAddReactionMutation();

    const reactionButtons = Object.entries(reactionEmojis).map(([reactionName, emoji]) => {
        return (
            <button
                key={reactionName} type="button" className="muted-button reaction-button"
                onClick={() =>
                    addReaction({postId: post.id, reaction: reactionName})
                }
            >
                {emoji} {post.reactions[reactionName]}
            </button>
        )
    })

    return <div>{reactionButtons}</div>
}
