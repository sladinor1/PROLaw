import axios from 'axios'

export default class UserController {

    ulr= "http://localhost:8080/api/";

    getFirst(){
        return axios.get();
    }

    insert(usuario){
        console.log(this.getData(usuario))
        return axios.post(this.ulr + this.getData(usuario));
    }

    getData(usuario){
        return 'user/{'+usuario.id+'}/'+'{'+usuario.names+'}/'+'{'+usuario.lastnames+'}/'+'{'+usuario.phone+'}/'
        +'{'+usuario.email+'}/'+'{'+usuario.pass+'}/'
    }

}