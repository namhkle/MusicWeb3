import axios from 'axios';
import React from 'react';
import { Link } from 'react-router-dom';
import { Button } from 'reactstrap';


const SongList = ({songs}) => {
    if(songs === undefined){
        return null;
    }

    const songList = songs.map(song => {
        return(
            <div key={song.get("id")}>
                <Button
                tag={Link}
                to={"/songs/" + song.get("id")}>
                Go to song
                </Button>
            </div>
        )
    })
}
export default SongList;
