import axios from 'axios'
const axiosI = axios.create({
    baseURL: '/api',
    //timeout: 1000

});

export default class UserController {

    //ulr= "http://localhost:8080/api/";

    getFirst(id){
        return axiosI.get('user/'+id);
    }

    getUser(id){
        return axiosI.get('user/U/'+id);
    }

    insert(usuario){
        //console.log(this.getData(usuario))
        return axiosI.post(this.getData(usuario));
    }

    getData(usuario){
        return 'user/'+usuario.typeId+'/'+usuario.id+'/'+usuario.names+'/'+usuario.lastnames+'/'+usuario.phone+'/'
        +usuario.email+'/'+usuario.pass+'/'+usuario.city+'/'
    }

    login(usuario){
        return axiosI.get(this.getLogin(usuario));
    }

    getLogin(usuario){
        return '/user/login/'+usuario.email+'/'+usuario.password+'/'
    }

}