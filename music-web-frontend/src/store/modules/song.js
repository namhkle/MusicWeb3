import { createAction, handleActions } from 'redux-actions';
import axios from 'axios';
import { Map, List, fromJS } from 'immutable';
import { pender } from 'redux-pender';


//action types
const GET_SONG_LIST = 'song/GET_SONG_LIST';

const getSongAPI = (songId) => {axios.get('https://jsonplaceholder.typicode.com/posts/${songId}')}

export const getSong = createAction(GET_SONG_LIST, getSongAPI);

const initialState = Map({
    songs: List(),
  });

export default handleActions({
    ...pender({
      type: GET_SONG_LIST,
      onSuccess: (state, action) => {
        const { data: content } = action.payload;
        console.log("GET_SONG_LIST onSuccess")
        return state.set('songs', fromJS(content))
        //fromJS(): Objects are converted into maps. Arrays are converted into lists.
      },
      onFailure: (state, action) => {
        console.log("GET_SONG_LIST onFailure")
        return state;
      },
      onPending: (state, action) => {
        console.log("GET_SONG_LIST onPending")
        return state;
      }
    })
}, initialState)