import axios from 'axios'

const axiosI = axios.create({
    baseURL: '/api',
    //timeout: 1000

});

export default class ForumController {
    
    //Rutas
    getOne(id){
        return 'cases/'+id+'/';
    }

    getAll(){
        return 'cases/';
    }

    //Funciones
    getQuestion(id){
        return axiosI.get(this.getOne(id));
    }

    getList(){
        return axiosI.get(this.getAll());
    }

    
    //Funciones
    saveQuestion(comment){
        return axiosI.post(this.addCase(comment));
    }

    editQuestion(comment){
        return axiosI.post(this.addCase(comment));
    }

    deleteQuestion(comment){
        return axiosI.post(this.addCase(comment));
    }

    saveAnswer(rta){
        return axiosI.post(this.addAns(rta));
    }

    editAnswer(rta){
        return axiosI.post(this.addAns(rta));
    }

    deleteAnswer(rta){
        return axiosI.post(this.addAns(rta));
    }

    //Rutas
    addCase(comment){
        return 'cases/new/'+comment.id+'/'+comment.user+'/'+comment.tema+'/'+comment.description+'/'
    }
    addAns(rta){
        return 'answer/new/'+rta.id+'/'+rta.user+'/'+rta.description+'/'
    }
}