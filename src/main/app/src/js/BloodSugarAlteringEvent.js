import React, { Component } from 'react';
import '../css/App.css';
import RowComponent from './RowComponent';
import { connect } from "react-redux";
import * as action from "./UserActions";


class BloodSugarAlteringEvent extends Component {

  constructor(props) {
    super(props);
    this.parentOnTextEntry = this.parentOnTextEntry.bind(this);
    this.state = {
      alteringEventList: props.store.alteringEventList
    };
    console.log("BloodSugarAlteringEvent - props - "+props.store.alteringEventList);
    this.addRow = this.addRow.bind(this);
  }

  addRow(props) {
    this.setState ({
      alteringEventList: this.props.store.alteringEventList
    })
    this.props.updateAppState();
  }

  parentOnTextEntry(event) {
    console.log(event);
    this.props.dispatch(action.onTextEntry(event));
  }

  render() {
    return (
      <div className="div40pc">
        <p> <b> Assuming day break at 7 AM </b></p>
        <RowComponent alteringEventList={this.state.alteringEventList} 
          masterEIOrGIList = {[]}
          parentOnTextEntry = {this.onTextEntry}/>
        <br/><br />
        <button onClick={this.addRow}>Add Row</button>
      </div>
    );
  }
}

BloodSugarAlteringEvent = connect((store) => {
  return {
    store: store
  }
})(BloodSugarAlteringEvent)

export default BloodSugarAlteringEvent