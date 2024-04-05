
export default function ListTodosComponent() {
    const today = new Date();
    const targetDate = new Date(today.getFullYear() + 12 , today.getMonth(), today.getDay());
  const todos = [
    {id: 1, description: "Learn AWS", done: false, targetDate:targetDate},
    {id: 2, description: "Learn Full Stack" , done: false, targetDate:targetDate}]

  return (
    <div className="container">
      <h1>Things You wnat to Do!</h1>
      <div>
        <table className="table">
          <thead>
            <tr>
              <td>id</td>
              <td>descripton</td>
              <td>is Done?</td>
              <td>target Date</td>
            </tr>
          </thead>
          <tbody>
            {
                todos.map(
                    todo => (
                        <tr key={todo.id}>
                        <td>{todo.id}</td>
                        <td>{todo.description}</td>
                        <td>{todo.done.toString()}</td>
                        <td>{todo.targetDate.toDateString()}</td>
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

 
