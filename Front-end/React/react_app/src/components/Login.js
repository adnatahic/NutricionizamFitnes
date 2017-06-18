import React,{Component} from "react";
import ReactDOM from 'react-dom';
import {Row,Input,Col,Button,Icon,Modal,Chip} from 'react-materialize';
import $http from '../$http';


export class Login extends Component{
  constructor(props){
    super(props);
    this.state={
      username:"",
      password:"",
      notifications:[]
    }
    this.onLogin=this.onLogin.bind(this);
    this.handleChangePassword=this.handleChangePassword.bind(this);
    this.handleChangeUsername=this.handleChangeUsername.bind(this);
  }
  render(){
    const notifications=this.state.notifications.map((notification)=>(<Chip>
                <Icon tiny>new_releases</Icon>
                {notification}
              </Chip>))
    return(<Row>
      <Col offset="s2" s={8}>
		    <Input label="Username" s={12} onChange={this.handleChangeUsername}/>
        <Input type="password" label="password" s={12} onChange={this.handleChangePassword}/>
        <Col s={12}>
        {notifications}
        </Col>
        <Button waves='light' onClick={this.onLogin}><Icon left>cloud</Icon>Login</Button>
      </Col>
      <br/>
      <div>

      </div>
      <Modal
	header='Modal Header'
	trigger={
		<Button waves='light'>HELP</Button>
	}>
	<p> Ukoliko nemate korisnicki nalog kontaktirajte NUT-centar kako bi vam se isti dodjelio</p>
</Modal>
    </Row>);
  }

  handleChangePassword(event){
  this.setState({password: event.target.value});
  }
  handleChangeUsername(event){
    this.setState({username: event.target.value});
  }

  onLogin(){
    this.props.printaj(this.state.username,this.state.password,this);
  }

}
