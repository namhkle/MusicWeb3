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
        const response = await axios.get('http://localhost:8080/songs');
        this.setState({songs:response.data});
        console.log(response.data)
    }

    render (){
        return(
            <div>
                {
                    this.state.songs.map((song) => (
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
