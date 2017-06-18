import React,{Component} from "react";


var axios = require('axios');
var List = require('./ListUser');

export class UserList extends Component{
	constructor(props) {
		super(props);
    this.state={users:[]}/*
		this.handleNavFirst = this.handleNavFirst.bind(this);
		this.handleNavPrev = this.handleNavPrev.bind(this);
		this.handleNavNext = this.handleNavNext.bind(this);
		this.handleNavLast = this.handleNavLast.bind(this);
		this.handleInput = this.handleInput.bind(this);*/
  }
  componentDidMount(){

    event.preventDefault();
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
                <td>{user.ime} {user.prezime} </td>
                </tr>
                );
  };
   
    return(
     
            <div>
            <h1>Korisnici</h1>  
            <UserList user = {this.state.user}/>      
           
        </div>      
     

    )
  }
}
