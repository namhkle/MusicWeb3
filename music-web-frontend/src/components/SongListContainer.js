import React, { Component } from 'react';
import { Fragment } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from "redux";
import * as songActions from "../store/modules/song";
import SongList from "./SongList";

class SongListContainer extends Component {
    getSongList = async() => {
        const {SongActions} = this.props;
        try{
            await SongActions.getSongList(1);
        }catch(e){
            console.log("error log :" + e);
        }
    }

    componentDidMount(){
        this.getSongList();
    }

    render() {
        const {songs, loading, error, success} = this.props;
        return (
            <Fragment>
                {loading && "loading..."}
                {error && "server error!"}
                {success && <SongList songs = {songs}/>}
            </Fragment>
        );
    }
}

export default connect(
    state => ({
        songs: state.song.get("songs"),
        loading: state.pender.pending["song/GET_SONG_LIST"],
        error: state.pender.failure["song/GET_SONG_LIST"],
        success: state.pender.success["song/GET_SONG_LIST"],
    }),
    dispatch => ({
        SongActions: bindActionCreators(songActions, dispatch)
    })
)(SongListContainer);

