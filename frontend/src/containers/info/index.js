import React, { Component } from 'react';
import { connect } from 'react-redux';
import { withRouter } from 'react-router-dom';
import { withCookies } from 'react-cookie';


import {
    identity,
    login
} from '../../actions/login';

import './styles.css';

class Info extends Component {
    constructor(props) {
        super(props);
    };



    render() {
        const {
            info,
            companyName
        } = this.props;

        return (
            <div className='block'>
                <form className='loginForm'  >
                    <div className='input'>
                        <label>
                            <span>E-mail</span>
                            <input type='text'
                                    name='email'
                                    id='email'
                                    size='25'
                                    required=''
                                    autoFocus=''
                                    value={info.email}
                            />
                        </label>
                    </div>
                    <div className='input'>
                        <label>
                            <span>Имя</span>
                            <input type='text'
                                   name='email'
                                   id='email'
                                   size='25'
                                   required=''
                                   autoFocus=''
                                   value={info.name}
                            />
                        </label>
                    </div>
                    <div className='input'>
                        <label>
                            <span>Компания</span>
                            <input type='text'
                                   name='email'
                                   id='email'
                                   size='25'
                                   required=''
                                   autoFocus=''
                                   value={companyName}
                            />
                        </label>
                    </div>
                    <div className='input'>
                        <label>
                            <span>Зарплата</span>
                            <input type='text'
                                   name='email'
                                   id='email'
                                   size='25'
                                   required=''
                                   autoFocus=''
                                   value={info.salary}
                            />
                        </label>
                    </div>
                    <div className='input'>
                        <label>
                            <span>График работы</span>
                            <input type='text'
                                   name='email'
                                   id='email'
                                   size='25'
                                   required=''
                                   autoFocus=''
                                   value={info.schedule}
                            />
                        </label>
                    </div>
                </form>
            </div>
        );
    };
}

const mapStateToProps = state => ({
    info: state.employee.info,
    companyName: state.employee.companyName
});

const mapDispatchToProps = ({
    identity,
    login
});

export default withCookies(withRouter(connect(mapStateToProps, mapDispatchToProps)(Info)));