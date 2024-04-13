import { useNavigate, useParams } from "react-router-dom";
import { createTodoApi, retreiveTodoApi, updateTodoApi } from "./api/HellowWorldApiService";
import { useAuth } from "./security/AuthContext";
import { useEffect, useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";

export default function TodoComponent() {
  const { id } = useParams();
  const authContext = useAuth();
  const username = authContext.username;

  useEffect(() => retreiveTodo(), [parseInt(id)]);
  const [description, setDescription] = useState("");
  const [targetDate, settargetDate] = useState("");

  const navigate = useNavigate();

  function retreiveTodo() {
    if(id != -1) {

        retreiveTodoApi(username, id)
        .then((resp) => {
            setDescription(resp.data.description);
            settargetDate(resp.data.targetDate);
        })
        .catch((resp) => console.log(resp));
    }
  }
  function onSubmit(values) {
    const todo = {
        id :    id,
        username: username,
        description: values.description ,
        targetDate: values.targetDate,
        done:false
    
    }
if(id == -1){
  console.log('id =' + id)
    createTodoApi(username,todo)
    .then(resp => {
        navigate('/todos')
    })
}else{
    
    updateTodoApi(username,id,todo)
    .then(resp => {
        navigate('/todos')
    })
}
}

  function validate(values) {
    let errors = {
    //   description: "Eneter a valid description",
    //   targetDate: "Eneter a valid targetDate",
    };
    
    if(values.description.length<5){
        errors.description = "enter at least 5 characters"
    }
    if(values.description == null ||
        values.description === '' 
        // !moment(values.targetDate).isValid()
    ){
        errors.description += "enter a target date"
    }
    return errors
  }

  return (
    <div className="container">
      <h1>Enter Todo Details</h1>
      <div>
        <Formik
          initialValues={{ description, targetDate }}
          enableReinitialize={true}
          onSubmit={onSubmit}
          validate={validate}
            validateOnChange={false}
            validateOnBlur={false}
        >
          {(props) => (
            <Form>
              <ErrorMessage
                name="description"
                component="div"
                className="alert alert-warning"
              />{" "}
              <ErrorMessage
                name="targetDate"
                component="div"
                className="alert alert-warning"
              />
              <fieldset className="form-group">
                <label>Description</label>
                <Field className="form-control" name="description" />
              </fieldset>
              <fieldset className="form-group">
                <label>Target Dtae</label>
                <Field type="date" className="form-control" name="targetDate" />
              </fieldset>
              <div>
                <button className="btn  btn-success m-5" type="submit">
                  Save
                </button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
}
