import axios from 'axios'

const axiosI = axios.create({
    baseURL: '/api',
    //timeout: 1000

});

export default class UserController {

    //ulr= "http://localhost:8080/api/";

    getFirst(){
        return axios.get();
    }

    insert(usuario){
        console.log(this.getData(usuario))
        //return axiosI.post(this.ulr + this.getData(usuario));
        return axiosI.post(this.getData(usuario));
    }

    getData(usuario){
        return '/user/{'+usuario.id+'}/'+'{'+usuario.names+'}/'+'{'+usuario.lastnames+'}/'+'{'+usuario.phone+'}/'
        +'{'+usuario.email+'}/'+'{'+usuario.pass+'}/'
    }

    login(usuario){
        return axiosI.get(this.getLogin(usuario));
    }

    getLogin(usuario){
        return '/user/'+usuario.email+'/'+usuario.password+'/'
    }

}