import axios from 'axios'

const axiosI = axios.create({
    baseURL: '/api',
    //timeout: 1000

});

export default class GlossaryController{

    getLetter(letter){
        return axiosI.get(this.getData(letter));
    }

    getData(letter){
        return 'glossary/'+letter+'/';
    }

}