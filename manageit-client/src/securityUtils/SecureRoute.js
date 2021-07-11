import React from 'react';
import { connect } from 'react-redux';
import { Redirect, Route } from 'react-router-dom';
import PropTypes from 'prop-types';

const SecuredRoute = ({ component: Component, security, ...otherProps }) => (
  <Route
    {...otherProps}
    render={props => (security.validToken === true ? <Component {...props} /> : <Redirect to="login" />)}
  />
);

SecuredRoute.propTypes = {
  security: PropTypes.object.isRequired,
};

const mapStateToProps = state => ({
  security: state.security,
});

export default connect(mapStateToProps)(SecuredRoute);
