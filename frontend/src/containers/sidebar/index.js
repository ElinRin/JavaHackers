import React, {Component} from 'react';
import {connect} from 'react-redux';
import { withRouter } from 'react-router-dom';
import { withCookies } from 'react-cookie';

import {
    EmployeeOut,
    CompanyOut
} from '../../actions/logout';
import {
    login
} from '../../actions/login';

import {
    EMPLOYEE,
    COMPANY
} from '../../constants';

import './styles.css';


class Sidebar extends Component {
    constructor(props) {
        super(props);
        this.state = {
            error: '',
            user: ''
        };

        this.hadleClick = this.hadleClick.bind(this);
        this.handleOutput = this.handleOutput.bind(this);
    }

    componentWillMount () {
        const {
            cookies,
            login,
            location
        } = this.props;

        const token = cookies.get('token');
        const user = cookies.get('user');

        if (user) {
            this.setState({user});
        }
        else {
           if (location && (location.pathname.split('/')[1] === EMPLOYEE)) {
               this.setState({user: EMPLOYEE});
           }
            if (location && (location.pathname.split('/')[1] === COMPANY)) {
                this.setState({user: COMPANY});
            }
        }

        const newUser = user || this.state.user;
        if (token && newUser) {
            login(newUser, token)
                .then((data) => {
                    if (user === EMPLOYEE) {
                        this.props.history.push(`/${EMPLOYEE}`)
                    }
                    if (user === COMPANY) {
                        this.props.history.push(`/${COMPANY}`)
                    }
                })
                .catch((err) => {
                    this.setState({error: err.message})
                })
        }

    }

    hadleClick(path) {
        return () =>  {
            if (this.state.user) {
                this.props.history.push(`/${path}`);
            }
            else {
                this.props.history.push(`/login`);
            }
        };
    }

    handleOutput() {
        this.props.EmployeeOut();
        this.props.history.push(`/login`);
        this.props.cookies.remove('token', { path: '/' });
    }

    renderSidebar() {

        if (this.state.user === COMPANY) {
            return (
                <div className="sidebar">
                    <div className="icons">
                        <ul>
                            <li>
                                <div className="icon a" onClick={this.hadleClick('company/upload')}>
                                </div>
                            </li>
                            <li>
                                <div className="icon c" onClick={this.hadleClick('company/employee')}>
                                </div>
                            </li>
                            <li>
                                <div className="icon d" onClick={this.handleOutput}>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div className="links">
                        <ul>
                            <li>
                                <div className="link" onClick={this.hadleClick('company/upload')}><br/>Загрузка</div>
                            </li>
                            <li>
                                <div className="link" onClick={this.hadleClick('company/employee')}><br/>Сотрудник</div>
                            </li>
                            <li>
                                <div className="link" onClick={this.handleOutput}><br/>Выход</div>
                            </li>
                        </ul>
                    </div>
                </div>
            )
        }

        if (this.state.user === EMPLOYEE) {
            return (
                <div className="sidebar">
                    <div className="icons">
                        <ul>
                            <li>
                                <div className="icon b" onClick={this.hadleClick('employee/info')}>
                                </div>
                            </li>
                            <li>
                                <div className="icon e" onClick={this.hadleClick('employee/withdraw')}>
                                </div>
                            </li>
                            <li>
                                <div className="icon f" onClick={this.hadleClick('employee/paylist')}>
                                </div>
                            </li>
                            <li>
                                <div className="icon d" onClick={this.handleOutput}>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div className="links links_bigger">
                        <ul>
                            <li>
                                <div className="link link_big" onClick={this.hadleClick('employee/info')}><br/>Информация</div>
                            </li>
                            <li>
                                <div className="link link_big" onClick={this.hadleClick('employee/withdraw')}><br/>Вывести деньги</div>
                            </li>
                            <li>
                                <div className="link link_big" onClick={this.hadleClick('employee/paylist')}><br/>История платежей</div>
                            </li>
                            <li>
                                <div className="link link_big" onClick={this.handleOutput}><br/>Выход</div>
                            </li>
                        </ul>
                    </div>
                </div>
            )
        }
    }

    render() {
        const {
            history
        } = this.props;

        if (this.state.user) {
            return (
                <div>
                    {this.renderSidebar()}
                </div>
            )
        }
        // else {
        //     history.push(`/login`);
        // }

        return (
            <div>
            </div>
        );
    }

}

const mapStateToProps = state => ({

});

const mapDispatchToProps = ({
    login,
    EmployeeOut,
    CompanyOut
});

export default withCookies(withRouter(connect(mapStateToProps, mapDispatchToProps)(Sidebar)));