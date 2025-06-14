import {createApi, fetchBaseQuery} from '@reduxjs/toolkit/query/react'

export const apiSlice = createApi({
    reducerPath: 'api',
    baseQuery: fetchBaseQuery({baseUrl: '/fakeApi'}),
    tagTypes: ['Post'],
    endpoints: (builder) => ({
        getPosts: builder.query({
            query: () => '/posts',
            providesTags: (result = [], error, arg) => [
                'Post',
                ...result.map(({id}) => ({type: 'Post', id})),
            ],
        }),
        getPost: builder.query({
            query: (postId) => `/posts/${postId}`,
            providesTags: (result, error, arg) => [{type: 'Post', id: arg}],
        }),
        addNewPost: builder.mutation({
            query: (initialPost) => ({
                url: '/posts',
                method: 'POST',
                body: initialPost,
            }),
            invalidatesTags: ['Post'],
        }),
        editPost: builder.mutation({
            query: (post) => ({
                url: `posts/${post.id}`,
                method: 'PATCH',
                body: post,
            }),
            invalidatesTags: (result, error, arg) => [{type: 'Post', id: arg.id}],
        }),
        addReaction: builder.mutation({
            query: ({postId, reaction}) => ({
                url: `posts/${postId}/reactions`,
                method: 'POST',
                // In a real app, we'd probably need to base this on user ID somehow
                // so that a user can't do the same reaction more than once
                body: {reaction},
            }),
            async onQueryStarted({postId, reaction}, {dispatch, queryFulfilled}) {
                const patchPost = dispatch(
                    apiSlice.util.updateQueryData('getPost', postId, (draft) => {
                        console.log(reaction + ' - update post');
                        draft.reactions[reaction]++;
                    })
                );
                // `updateQueryData` requires the endpoint name and cache key arguments,
                // so it knows which piece of cache state to update
                const patchPostList = dispatch(
                    apiSlice.util.updateQueryData('getPosts', undefined, draft => {
                        // The `draft` is Immer-wrapped and can be "mutated" like in createSlice
                        const post = draft.find(post => post.id === postId);
                        if (post) {
                            post.reactions[reaction]++;
                        }
                        console.log(reaction + ' - update post list');
                    })
                );
                try {
                    await queryFulfilled;
                } catch {
                    patchPost.undo();
                    patchPostList.undo();
                }
            }
        }),
    }),
})

export const {
    useGetPostsQuery,
    useGetPostQuery,
    useAddNewPostMutation,
    useEditPostMutation,
    useAddReactionMutation,
} = apiSlice
