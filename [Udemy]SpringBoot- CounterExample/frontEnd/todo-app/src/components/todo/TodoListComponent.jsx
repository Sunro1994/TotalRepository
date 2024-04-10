import { useEffect, useState } from "react";
import { DeleteTodo, retrieveAllTodosForUsername } from "./api/HellowWorldApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

export default function ListTodosComponent() {

    const [todos, setTodos] = useState([]);
    const [message, setMessage] = useState(null);

    const authContext = useAuth();

    const username = authContext.username;

    const navigate = useNavigate();

  useEffect(
    () => refreshTodos(),[]
  )

   function refreshTodos() {
     retrieveAllTodosForUsername(username)
    .then(resp => {
      setTodos(resp.data)
  })
    .catch(err => console.log(err))

  }
  function deleteTodo(id){
    DeleteTodo(username,id)
    .then(
      (resp)=> {
        setMessage(`deleted ${id} is successful`)
        
      }
    ).catch(
      (error) => console.log(error)
    )
  }

  function updateTodo(id){
    console.log(id);
    navigate(`/todo/${id}`)
  }

  function addNewTodo(){
    navigate('/todo/-1')
  }
  


  return (
    <div className="container">
      <h1>Things You wnat to Do!</h1>
      {message && <div className="alert alert-warning">{message}</div>}
      <div>
        <table className="table">
          <thead>
            <tr>
              <th>descripton</th>
              <th>is Done?</th>
              <th>target Date</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>
            {
                todos.map(
                    todo => (
                        <tr key={todo.id}>
                        <td>{todo.description}</td>
                        <td>{todo.done.toString()}</td>
                        <td>{todo.targetDate.toString()}</td>
                        <td><button 
                        className="btn btn-warning" 
                        onClick={() => deleteTodo(todo.id)}>Delete</button></td>
                        <td>
                          <button className="btn btn-success" 
                          onClick={() => updateTodo(todo.id)}>Update</button>
                        </td>
                        </tr>
                        
                    )
                )
            }
           
          </tbody>
        </table>
        <div>
          <button className="btn btn-success m-5" onClick={addNewTodo}>add NewTodo</button>
        </div>
      </div>
    </div>
  );
}

 
