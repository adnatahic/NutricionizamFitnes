import React from 'react'
import { Link } from 'react-router-dom'
import {Navbar, NavItem} from 'react-materialize'

export const Header = (props) => (
  <header>
    <Navbar brand=' Nutricionizam BIH ' right>
      <li><Link to='/'>Home</Link></li>
      <li><Link to='/users'>Users</Link></li>
      <li><Link to='/userall'>Korisnici</Link></li>
      {props.logged &&<li><Link to='/register'>Register</Link></li>}
      {props.logged &&<li><Link to='/plan'>Plan i Program</Link></li>}
      {!props.logged &&<li><Link to='/login'>Login</Link></li>}
      {props.logged && <li onClick={()=>{if(props.logout!=undefined)props.logout()}}><a>Logout</a></li>}
    </Navbar>
  </header>)
