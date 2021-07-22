import axios from 'axios'

const axiosI = axios.create({
    baseURL: '/api',
    //timeout: 1000

});

export default class ForumController {
        
    //traer el json de todas las preguntas
    getList(){
        return axiosI.get();
    }

    //Guardar pregunta
    /*comment: {
        idUserC: '', 
        descripCas: '',
        dateAns: ''
        },*/
    saveQuestion(comment){
        return axiosI.post(comment);
    }

    //guardar respuestas
    /*respuesta: {
                idUserA: '',
                descripAns: '',
                dateAns: ''
            },*/
    saveAnswer(rta){
        return axiosI.post(rta);
    }
}