import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Landing extends Component {
  render() {
    return (
      <div className="landing">
        <div className="light-overlay landing-inner text-dark">
          <div className="container">
            <div className="row">
              <div className="col-md-12 text-center">
                <h1 className="display-2">ManageIt</h1>
                <h3 className="mb-4">Personal Project Management Tool</h3>
                <p className="lead">Create your account or Login to start managing your projects</p>
                <p>Use email: test@test.com password: test123 for testing the app</p>
                <hr />
                <Link to="/register" className="btn btn-lg btn-danger mr-2">
                  Sign Up
                </Link>
                <Link to="/login" className="btn btn-lg btn-secondary mr-2">
                  Login
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Landing;
