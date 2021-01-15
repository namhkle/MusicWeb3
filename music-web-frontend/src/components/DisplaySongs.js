import axios from 'axios';
import React from 'react';
import SpringBootAPI from '../API/SpringBoot';

class DisplaySongs extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            songs:[]
        }
    }

    componentDidMount(){
        axios.get("http://localhost:8080/addsong/")
        .then(response => response.data)
        .then ((data) =>{
            this.setState({songs : data})
        });
    }

    render (){
        return(
            <div>
                {
                    this.state.songs.map(
                        song => 
                        <tr>
                            <td>{song.name}</td>
                            <td>{song.artist}</td>
                        </tr>
                        )
                }
            </div>
        )
    }
}

export default DisplaySongs;
