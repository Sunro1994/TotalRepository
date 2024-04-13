import { apiClient } from "./ApiClient";

export function retrieveHelloWorldBean() {
  return apiClient.get("/hello-world");
}

export const retrieveHelloWorldPathVariable = (name,token) =>
  apiClient.get(`/hello-world/path-variable/${name}`)




export const retrieveAllTodosForUsername = (username) =>
  apiClient.get(`/users/${username}/todos`);

export const DeleteTodo = (username, id) =>
  apiClient.delete(`/users/${username}/todos/${id}`);

export const retreiveTodoApi = (username, id) =>
  apiClient.get(`users/${username}/todos/${id}`);

  
export const updateTodoApi = (username, id, todo) =>
apiClient.put(`users/${username}/todos/${id}`, todo);
  
export const createTodoApi = (username, todo) =>
apiClient.post(`users/${username}/todos`, todo);
