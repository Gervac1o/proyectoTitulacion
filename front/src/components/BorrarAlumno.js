import React, { Component } from 'react';
import axios from 'axios';

class BorrarAlumno extends React.Component {


    state = {
        statusDoc: null,
        statusLista: null,
        idAlumno: this.props.id
      };

        delete = () => {
            axios.delete("alumno/delete/" + 81)
            .then(res => {
                this.setState({
                    statusLista: "true"
                });
            });
        }

        delete2 = () => {
            axios.delete("user/dictamen/delete/" + 162)
            .then(res => {
                this.setState({
                    statusLista: "true"
                });
            });
        }

    render(){

        if(this.state.statusDoc === "true" && this.state.statusLista === "true"){
            window.location.reload();
        }

        return(
            <React.Fragment>
            <button  id="btn_delete" onClick={this.delete}>Eliminar Alumno</button>
            <br></br><br></br><br></br><br></br>
            <button  id="btn_delete" onClick={this.delete2}>Eliminar Dictamen</button>
            </React.Fragment>
        )
    
    }
}
export default BorrarAlumno;