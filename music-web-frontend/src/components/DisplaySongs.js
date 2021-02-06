import axios from 'axios';
import React from 'react';

class DisplaySongs extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            songs:[]
        }
    }

    async componentDidMount(){
        const res = await axios.get('http://localhost:8080/songs/');
        let details = [];
            for (var i in res.data) {
                details.push({ name: i, value: res.data[i] })
            }

        this.setState({ songs: details})
        console.log(details)
    }

    render (){
        return(
            <div>
                {
                    this.state.songs.map( song => (
                        <tr>
                            <td>{song.name}</td>
                            <td>{song.artist}</td>
                        </tr>
                    ))
                }
            </div>
        )
    }
}

export default DisplaySongs;
