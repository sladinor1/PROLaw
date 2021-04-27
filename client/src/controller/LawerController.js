import axios from 'axios'

const axiosI = axios.create({
    baseURL: '/api',
    //timeout: 1000

});

export default class UserController {

    insert(user){
        axiosI.post(user);
    }

}