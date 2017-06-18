import React,{Component} from "react";

var axios = require('axios');

import {Row,Input,Col,Button,Icon,Modal,Chip} from 'react-materialize';


export class PlanList extends Component{

 constructor(props){
    super(props);
   /* this.state={user:{username:"",email:""}};*/
    this.state={user:[]};
  }
onDelete(ide,ctx){


   /* axios.get('http://localhost:8081/korisnici/osobe/izbrisi/3', {
      headers: {'Content-Type': 'application/json', 'Authorization': 'Bearer ' + localStorage["token"]}

      

    })
      .then((resp) => {
        console.dir(resp);

      })
      .catch(err => {
        console.log(err);
      });*/
  }

  


   componentDidMount() {




  
      var self = this;
      axios.get('http://localhost:8081/korisnici/osobe/svi', {
      headers: {'Content-Type': 'application/json', 'Authorization': 'Bearer ' + localStorage["token"]}


       
             
         
           
        }).then(function(response) {
           { self.setState({user: response.data}); }
           
        });

   

  }
 
  render(){


    var createUserRow = function(user)
   {
              return (
                
                <tr key = {user.username}>
                <td>{user.username}</td>
                <td>{user.ime} </td>
                <th>{user.prezime}</th>
                <th>{user.email}</th>
                 

                 <Button waves='red'  onClick={this.onDelete(user.id)}><span className="glyphicon glyphicon-remove"></span> Prikazi plan </Button>
                </tr>
                    
                 
                );
  };

  
   return (
        <div>
            <h1>Korisnici</h1> 
               <div>
              <table className="table">
               <thead>
                <tr>
                  <th>Username</th>
                  <th>Ime</th>  
                  <th>Prezime</th>
                  <th>Email</th>
                  <th>Obrisi</th>
                </tr>
               </thead>
               <tbody>
                {this.state.user.map(createUserRow, this)}
              </tbody>
            </table> 
        </div>      
          
               
           
        </div>


        );

  }
}
