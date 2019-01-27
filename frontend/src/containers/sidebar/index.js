import React, {Component} from 'react';
import {connect} from 'react-redux';
import { withRouter } from 'react-router-dom';
import { withCookies } from 'react-cookie';

import {
    login,
    EmployeeOut,
    CompanyOut
} from '../../actions';
import {
    EMPLOYEE,
    COMPANY
} from '../../constants';

import './styles.css';


class Sidebar extends Component {
    constructor(props) {
        super(props);
        this.state = {
            error: ''
        };

        this.hadleClick = this.hadleClick.bind(this);
        this.handleOutput = this.handleOutput.bind(this);
    }

    componentWillMount () {
        const {
            cookies,
            login,
            match
        } = this.props;

        const token = cookies.get('token');
        const user = cookies.get('user');

        if (user) {
            this.setState({user});
        }
        else {
           if (match.location.pathname === `/${EMPLOYEE}`) {
               this.setState({user: EMPLOYEE});
           }
            if (match.location.pathname === `/${COMPANY}`) {
                this.setState({user: COMPANY});
            }

        }

        if (!token) {
            login(token)
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
            // if (this.props.user.id) {
            //     this.props.history.push(`/${path}`);
            // }
            // else {
            //     this.props.history.push(`/login`);
            // }
        };
    }

    handleOutput() {
        this.props.EmployeeOut();
        this.props.history.push(`/login`);
        this.props.cookies.remove('token', { path: '/' });
    }

    renderSidebar() {

        return (
            <div className="sidebar">
                <div className="icons">
                    <ul>
                        <li>
                            <div className="icon a" onClick={this.hadleClick()}>
                            </div>
                        </li>
                        <li>
                            <div className="icon c" onClick={this.hadleClick()}>
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
                            <div className="link" onClick={this.hadleClick()}><br/>Загрузка</div>
                        </li>
                        <li>
                            <div className="link" onClick={this.hadleClick()}><br/>Сотрудник</div>
                        </li>
                        <li>
                            <div className="link" onClick={this.handleOutput}><br/>Выход</div>
                        </li>
                    </ul>
                </div>
            </div>
        )
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
        else {
            history.push(`/login`);
        }

        return (
            <div>
            </div>
        );
    }

}

const mapStateToProps = state => {

};

const mapDispatchToProps = {
    login,
    EmployeeOut,
    CompanyOut
};

export default withCookies(withRouter(connect(mapStateToProps, mapDispatchToProps)(Sidebar)));