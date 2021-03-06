import React, { Component } from 'react';
import ProjectTask from './ProjectTasks/ProjectTask';

class Backlog extends Component {
  render() {
    const { project_tasks } = this.props;

    let todoItems = [];
    let inprogressItems = [];
    let doneItems = [];

    project_tasks.forEach(project_task => {
      if (project_task.status === 'TO_DO')
        todoItems.push(<ProjectTask key={project_tasks.id} project_task={project_task} />);
      else if (project_task.status === 'IN_PROGRESS')
        inprogressItems.push(<ProjectTask key={project_tasks.id} project_task={project_task} />);
      else doneItems.push(<ProjectTask key={project_tasks.id} project_task={project_task} />);
    });

    return (
      <div className="container">
        <div className="row">
          <div className="col-md-4">
            <div className="card text-center mb-2">
              <div className="card-header bg-secondary text-white">
                <h3>TO DO</h3>
              </div>
            </div>
            {/* <!-- PROJECT TASK STARTS HERE --> */}
            {todoItems}
          </div>

          <div className="col-md-4">
            <div className="card text-center mb-2">
              <div className="card-header bg-primary text-white">
                <h3>In Progress</h3>
              </div>
            </div>
            {inprogressItems}
          </div>
          <div className="col-md-4">
            <div className="card text-center mb-2">
              <div className="card-header bg-success text-white">
                <h3>Done</h3>
              </div>
            </div>
            {doneItems}
          </div>
        </div>
      </div>
    );
  }
}

export default Backlog;
