import axios from 'axios'

const axiosI = axios.create({
    baseURL: '/api',
    //timeout: 1000

});

export default class LawyerController{

    insertLawyer(user){
        axiosI.post(this.getLawyer(user));
    }

    getLawyer(user){
        return 'lawyer/'+user.typeId+'/'+user.id+'/'+user.names+'/'+user.lastnames+'/'+
        user.phone+'/'+user.email+'/'+user.pass+'/'+user.city+'/'+user.especialidad+'/'+'null';
    }

}