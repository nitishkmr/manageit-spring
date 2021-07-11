import './App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import { Provider } from 'react-redux';
import store from './store';
import Dashboard from './components/Dashboard';
import Header from './components/Layout/Header';
import AddProject from './components/Project/AddProject';
import UpdateProject from './components/Project/UpdateProject';
import ProjectBoard from './components/ProjectBoard/ProjectBoard';
import AddProjectTask from './components/ProjectBoard/ProjectTasks/AddProjectTask';
import UpdateProjectTask from './components/ProjectBoard/ProjectTasks/UpdateProjectTask';
import Landing from './components/Layout/Landing';
import Register from './components/UserManagement/Register';
import Login from './components/UserManagement/Login';

function App() {
  return (
    <Provider store={store}>
      <Router>
        <div>
          <Header />
          {/* Public Routes */}
          <Route exact path="/" component={Landing} />
          <Route exact path="/register" component={Register} />
          <Route exact path="/login" component={Login} />

          {/* Private Routes */}
          <Route exact path="/dashboard" component={Dashboard} />
          <Route exact path="/add-project" component={AddProject} />
          <Route exact path="/update-project/:id" component={UpdateProject} />
          <Route exact path="/project-board/:id" component={ProjectBoard} />
          <Route exact path="/add-project-task/:id" component={AddProjectTask} />
          <Route exact path="/update-project-task/:backlog_id/:pt_id" component={UpdateProjectTask} />
        </div>
      </Router>
    </Provider>
  );
}

export default App;
