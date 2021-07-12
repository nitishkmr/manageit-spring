import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';
import Carousel from './Carousel';

class Landing extends Component {
  componentDidMount() {
    if (this.props.security.validToken) {
      this.props.history.push('/dashboard');
    }
  }

  render() {
    return (
      <div className="landing">
        <div className="light-overlay landing-inner text-dark">
          <div className="container">
            <div className="row">
              <div className="col-md-12 text-center">
                <h1 className="display-2">ManageIt</h1>
                <h3 className="mb-4">Personal Project Management Tool</h3>
                <hr />
                <Carousel />
                <p>
                  Use email: <span style={{ color: 'rgb(220,53,69)' }}>test@test.com</span> password:{' '}
                  <span style={{ color: 'rgb(220,53,69)' }}>test123 </span>
                  for testing the app
                </p>
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

Landing.propTypes = {
  security: PropTypes.object.isRequired,
};

const mapStateToProps = state => ({
  security: state.security,
});

export default connect(mapStateToProps)(Landing);
