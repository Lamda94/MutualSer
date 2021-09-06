import axios from "axios";

export default class Alcancia {
  url = "http://localhost:8090/Alcancia/";
  getAll() {
    return axios.get(this.url).then((data) => data.data);
  }

  getByDenominacion(denominacion) {
    return axios.get(`${this.url}denominacion/${denominacion}`);
  }

  update(alcancia){
      console.log(alcancia);
      return axios.post(`${this.url}save`, alcancia).catch(err=>console.log(err.message));
  }
}
