import React, { Component } from 'react';
import axios from 'axios';


class DocServicio extends React.Component{



    state = {
        docServicio: "",
        status: null
    };
        componentWillMount = () => {
            const { match: { params } } = this.props;
            var doc = params.doc;
            this.setState({
                    docServicio: doc,
                    status: "true"
            })
        }
    render() {
        if(this.state.status == "true"){
            return(
                <div>
                        <iframe  src={"http://localhost:8080/docServicio/getDoc/" + this.state.docServicio}></iframe>
                </div>
            );
        }
    }//Fin de Render ()
}//Fin de Classs DocServicio

export default DocServicio;