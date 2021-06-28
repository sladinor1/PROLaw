import axios from 'axios'
const axiosI = axios.create({
    baseURL: '/api',
    //timeout: 1000

});
export default class GetData {

	getA() {
		return axiosI.get('glossary/A').then(res => res.data.data);
        //return axios.
	}

	getB() {
		return axios.get('../jsons/B.json').then(res => res.data.data);
	}

	getC() {
		return axios.get('../jsons/C.json').then(res => res.data.data);
	}
}