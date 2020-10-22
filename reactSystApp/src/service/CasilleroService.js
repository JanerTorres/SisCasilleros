import axios from 'axios';

export class CasilleroService{
    baseUrl = "http://localhost:8080/api/v1/"
    getAll(){
        return axios.get(this.baseUrl + 'all').then(res => res.data);
    }

    save(casillero){
        return axios.post(this.baseUrl + "save", casillero).then(res => res.data);
    }

    delete(id){
        return axios.get(this.baseUrl + "delete/"+id).then(res => res.data);
    }

}