import axios from 'axios'

const SpringBoot = "http://localhost:8080/addsong/";

class SpringBootAPI{
    getSongs(){
        return axios.get(SpringBoot);
    }
}

export default new SpringBootAPI(); 

