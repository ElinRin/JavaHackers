import React, { Component } from 'react';
import { connect } from 'react-redux';
import { withRouter } from 'react-router-dom';
import { withCookies } from 'react-cookie';


import {
    identity,
    login
} from '../../actions';

import './styles.css';
import {COMPANY} from "../../constants";

class Withdraw extends Component {
    constructor(props) {
        super(props);
        this.state = {
            error: '',
            user: ''
        };

        this.onSubmit = this.onSubmit.bind(this);
        this.onChange = this.onChange.bind(this);
        this.onChangeCheckbox = this.onChangeCheckbox.bind(this);
    };

    componentDidMount() {
        const {
            cookies,
            user,
            login
        } = this.props;

        const token = cookies.get('token');

        this.setState({
            email: cookies && cookies.get('email'),
            password: cookies && cookies.get('password'),
            user: cookies && cookies.get('user')
        });

        if (this.state.user === user && token) {
            login(user, token)
        }

    };


    onSubmit(event) {
        const {
            email,
            password,
            remember
        } = this.state;

        const {
            identity,
            cookies,
            user
        } = this.props;

        event.preventDefault();
        identity(user, email, password).then(
            (token) => {
                if (remember) {
                    cookies.set('token', token, { path: '/' });
                    cookies.set('email', email, { path: '/' });
                    cookies.set('password', password, { path: '/' });
                    cookies.set('user', user, { path: '/' });
                }

                this.login(user, token);
            },
            (err) => {
                if (err.code === 403) {
                    this.setState({ error: err.message })
                }
            }
        );
    };

    onChange(event) {
        this.setState({ [event.target.name]: event.target.value });
    };

    onChangeCheckbox(event) {
        this.setState({ [event.target.name]: event.target.checked });
    };

    render() {

        return (
            <div className='block'>
                На данный момент вы можете снять '{mapStateToProps(this.state).employee.realMoney}'.


            </div>
        );
    };
}

const mapStateToProps = state => ({
    employee: state.employee
});

const mapDispatchToProps = {
    identity,
    login
};

export default withCookies(withRouter(connect(mapStateToProps, mapDispatchToProps)(Login)));