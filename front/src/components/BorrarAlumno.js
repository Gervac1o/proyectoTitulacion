import React, { Component } from 'react';
import axios from 'axios';

class BorrarAlumno extends React.Component {


    state = {
        idAlumno: this.props.id
      };
    
      componentWillMount() {
        this.changeState();
    }

    changeState = () => {
        this.setState({
                idAlumno: this.props.id
        });
    }

        delete = () => {
            axios.delete("alumno/delete/"+this.state.idAlumno)
            .then(res => {
                this.setState({
                    status: "true"
                });
            });
        }

    render(){

     {/*   if(this.state.statusDoc === "true" && this.state.statusLista === "true"){
            window.location.reload();
        } */}
        return(
            <React.Fragment>
            <button  id="btn_delete" onClick={this.delete}>Eliminar Alumno</button>
            </React.Fragment>
        )
    }
}
export default BorrarAlumno;