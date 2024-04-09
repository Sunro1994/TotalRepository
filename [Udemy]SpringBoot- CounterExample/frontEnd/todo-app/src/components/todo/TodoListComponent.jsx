import { useEffect, useState } from "react";
import { DeleteTodo, retrieveAllTodosForUsername } from "./api/HellowWorldApiService";

export default function ListTodosComponent() {
    const today = new Date();
    const targetDate = new Date(today.getFullYear() + 12 , today.getMonth(), today.getDay());

    const [todos, setTodos] = useState([]);
    const [message, setMessage] = useState(null);


  useEffect(
    () => refreshTodos(),  []
  )

  function refreshTodos() {
    retrieveAllTodosForUsername('in28minutes')
    .then(resp => {
      setTodos(resp.data)
  })

    .catch(err => console.log(err))
    .finally(console.log('clean'))

  }
  function deleteTodo(id){
    DeleteTodo('in28minutes',id)
    .then(
      (resp)=> {
        setMessage(`deleted ${id} is successful`)

      }
    ).catch(
      (error) => console.log(error)
    )
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
                        </tr>
                    )
                )
            }
           
          </tbody>
        </table>
      </div>
    </div>
  );
}

 
