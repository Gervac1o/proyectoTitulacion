
import React from 'react';
import logo from '../assets/images/esimez2.jpg';
import logo2 from '../assets/images/esimelogo.png'

class HeaderDEyAE extends React.Component{
//{/*<div><img src={logo} id="logo" alt="esime" /><img src={logo2} id="logo2" alt="politecnico" /></div>*/}

    render(){
        return(
            <div className="jumbotron" >
               
            <img src={logo2} id="logo2" alt="politecnico" />
            <br/>
            <br/> 
            <h2 id = "Header">Escuela Superior de Ingeniería Mecánica y Eléctrica</h2>
            <br/> 
            <h4>Trámites de Servicio Social</h4>
			
            </div>	
            
        );//Fin de Return
    }//Fin de Render
}//Fin de Class ErickComponente

export default HeaderDEyAE;