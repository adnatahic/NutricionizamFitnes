import React,{Component} from "react";

var axios, mime, client;
axios = require('axios');
var UserList = require('./UserList');
mime = require('rest/interceptor/mime');

export class ShowUser extends Component{


 
  render(){

  
   return (
        <div>
            <h1>Korisnici</h1> 
          
               
           
        </div>


        );

  }
}
