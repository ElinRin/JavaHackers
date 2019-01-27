import React, { Component } from 'react';
import { connect } from 'react-redux';
import { withRouter } from 'react-router-dom';
import { withCookies } from 'react-cookie';


import {
    identity,
    login
} from '../../actions/login';

import './styles.css';

class Withdraw extends Component {
    constructor(props) {
        super(props);
        this.state = {
            days: 0
        }
    };



    render() {
        const {
            employee
        } = this.props;

        return (
            <div className='block'>
                <form className='loginForm'  >
                    <div className='input'>
                        <label>
                            <span>На данный момент вы можете снять</span>
                            <input type='text'
                                   name='email'
                                   id='email'
                                   size='25'
                                   required=''
                                   autoFocus=''
                                   value={employee.realMoney}
                            />
                        </label>
                    </div>
                    <div className='input'>
                        <label>
                            <span>До конца месяца вы еще заработаете</span>
                            <input type='text'
                                   name='email'
                                   id='email'
                                   size='25'
                                   required=''
                                   autoFocus=''
                                   value={employee.futureMoney}
                            />
                        </label>
                    </div>
                    <div className='input'>
                        <label>
                            <span>Количество проработанных дней</span>
                            <input type='text'
                                   name='email'
                                   id='email'
                                   size='25'
                                   required=''
                                   autoFocus=''
                                   value={employee.realDays}
                            />
                        </label>
                    </div>
                    <div className='input'>
                        <label>
                            <span>За какое количество дней вы хотите снять зарплату?</span>
                            <input type='text'
                                   name='email'
                                   id='email'
                                   size='25'
                                   required=''
                                   autoFocus=''
                                   value={this.state.days}
                                   onChange={event => {this.setState({days: event.target.value })}}
                            />
                        </label>
                    </div>
                    <div className='butt'>
                        <div className=''>
                            <button type='submit' className='button'>Выплатить</button>
                        </div>
                    </div>
                </form>
            </div>
        );
    };
}

const mapStateToProps = state => ({
    employee: state.employee
});

const mapDispatchToProps = ({
    identity,
    login
});

export default withCookies(withRouter(connect(mapStateToProps, mapDispatchToProps)(Withdraw)));