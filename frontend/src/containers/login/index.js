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

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: '',
            error: '',
            remember: false,
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
        const {
            email,
            password,
            error
        } = this.state;

        return (
            <div className='block'>
                <h3 className='loginHeader'>{this.props.user === COMPANY ? 'Компания' : 'Сотрудник'}</h3>
                <form className='loginForm' onSubmit={this.onSubmit} >
                    <div className='input'>
                        <label>
                            <span>E-mail</span>
                            <input type='text'
                                    name='email'
                                    id='email'
                                    size='25'
                                    required=''
                                    autoFocus=''
                                    value={email}
                                    onChange={this.onChange}
                            />
                        </label>
                    </div>

                    <div className='input'>
                        <label>
                            <span>Пароль</span>
                            <input type='password'
                                    name='password'
                                    id='password'
                                    value={password}
                                    size='25'
                                    maxLength='30'
                                    required=''
                                    onChange={this.onChange}
                            />
                        </label>
                    </div>

                    <div className='check'>
                        <label>
                            <input
                                id='remember'
                                className=''
                                type='checkbox'
                                name='remember'
                                onChange={this.onChangeCheckbox}
                            />Запомнить меня
                        </label>
                    </div>

                    <div className={error ? 'error' : 'absent'}>
                        {error.toString()}
                    </div>

                    <div className='butt'>
                        <div className=''>
                            <button type='submit' className='button'>Вход</button>
                        </div>
                    </div>
                </form>
            </div>
        );
    };
}

const mapStateToProps = state => ({});

const mapDispatchToProps = {
    identity,
    login
};

export default withCookies(withRouter(connect(mapStateToProps, mapDispatchToProps)(Login)));