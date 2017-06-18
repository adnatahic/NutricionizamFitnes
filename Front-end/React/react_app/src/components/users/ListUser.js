var React = require('react');


var ListUser = React.createClass({
  
  render: function()
 

 {

    var createUserRow = function(user)
   {
              return (
                <tr key = {user.username}>
                <td>{user.ime} {user.prezime} </td>
                </tr>
                );
  };

      return (
        <div>
              <table className="table">
               <thead>
                  <th>ID</th>
                  <th>Name</th>
               </thead>
               <tbody>
                 {this.props.user.map(createUserRow, this)}
              </tbody>
            </table> 
        </div>


        );


  }
});

module.exports = ListUser;