import React, {Component} from 'react';
import {connect} from 'react-redux';
import { withRouter } from 'react-router-dom';

import {
} from '../../actions';
import {
} from '../../utils';

import './styles.css';


const Info = () => (<div/>);

const mapStateToProps = state => {
    return {
        info: state.employee.info
    }
};

const mapDispatchToProps = {
};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Info));
