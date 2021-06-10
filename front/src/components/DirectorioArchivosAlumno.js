import React, { Component } from 'react';
import axios from 'axios';
import { Link, Switch } from 'react-router-dom';
import DirectorioAdmin from './DirectorioAdmin';
import Cookies from 'universal-cookie';
import AdminBajaArchivos from './AdminBajaArchivos';
import AdminDictamenArchivos from './AdminDictamenArchivos';
import AdminLiberacionArchivos from './AdminLiberacionArchivos';
import AdminServicioArchivos from './AdminServicioArchivos';
import RecuperacionContraseña from './RecuperacionContraseña';
const cookies = new Cookies();

class DirectorioArchivosAlumno extends Component {

    state = {
        idAlumno: "",
        idTramite: "",
        status: null,
        alumno:{}
    };

    componentWillMount() {
        
        const { match: { params } } = this.props;
        console.log(params.id + "id por parametros")
        var id = params.id;
        this.setState({
            idAlumno: params.id
        })
       
        
    }
    componentDidMount () {
        this.getAlumno();
    }

    getAlumno = () => {
        axios.get("/alumno/find/"+ this.state.idAlumno)
        .then(response => {
        this.setState({
            alumno: response.data,
        });
        } );   
    }//Fin de getAlumno()

    tramite1 = () => {
        this.setState({
            idTramite: 1
        })
    }
    tramite2 = () => {
        this.setState({
            idTramite: 2
        })
    }
    tramite3 = () => {
        this.setState({
            idTramite: 3
        })
    }
    tramite4 = () => {
        this.setState({
            idTramite: 4
        })
    }
    tramite5 = () => {
        this.setState({
            idTramite: 5
        })
    }
    cancel=()=>{
        this.setState({
            idTramite: 1
        })
    }

    render() {


        return (
            <div className="center">



                <DirectorioAdmin />



                {/**AQUI VA LOS DATOS DEL ALUMNO */}
                <tbody>
                    <tr >
                        <th className="table_lista"> </th>
                        <th className="table_lista">Alumno</th>
                        <th className="table_lista">Boleta</th>
                        <th className="table_lista">Programa Academico</th>

                    </tr>
                </tbody>
                <tbody>
                    <tr>
                        <td className="table_lista">TRÁMITE</td>
                        <td className="table_lista">{this.state.alumno.apellidoPaterno} {this.state.alumno.apellidoMaterno} {this.state.alumno.nombre}</td>
                        <td className="table_lista">{this.state.alumno.boleta}</td>
                        <td className="table_lista">{this.state.alumno.programaAcademico}</td>

                    </tr>
                </tbody>


                <tbody>
                    <tr>
                        <tr>
                            <td className="table_lista"> <button class="btn" id= "btn-table" onClick={this.tramite1} > Dictamen de 70%</button></td>
                        </tr>
                        <tr>
                            <td className="table_lista"><button class="btn" id= "btn-table"  onClick={this.tramite2} > Liberacion Extemporanea</button></td>
                        </tr>
                        <tr>
                            <td className="table_lista"><button class="btn" id= "btn-table" onClick={this.tramite3} > Baja de Servicio Social</button></td>
                        </tr>
                        <tr>
                            <td className="table_lista"><button class="btn" id= "btn-table" onClick={this.tramite4} > Servicio Social</button></td>
                        </tr>
                        <tr>
                            <td className="table_lista"><button class="btn" id= "btn-table" onClick={this.tramite5} > Restablecer contraseña de alumno</button></td>
                        </tr>
                    </tr>
                </tbody>

                {(() => {
                    switch (this.state.idTramite) {
                        case 1:
                            return (
                                <AdminDictamenArchivos
                                    id={this.state.idAlumno} />
                            );
                            break;
                        case 2:
                            return (
                                <AdminLiberacionArchivos
                                    id={this.state.idAlumno} />
                            );
                            break;
                        case 3:
                            return (
                                <AdminBajaArchivos
                                    id={this.state.idAlumno} />
                            );
                        case 4:
                            return (
                                <AdminServicioArchivos
                                    id={this.state.idAlumno} />
                            )
                            case 5:
                            return (
                                <RecuperacionContraseña
                                cancel ={this.tramite1}
                                    id={this.state.idAlumno} 
                                    className="archivosAdminCenter"
                                    />
                            )
                        default: break;

                    }


                })()}

            </div>
        );


    }
}
export default DirectorioArchivosAlumno;