import React, { Component } from 'react';
import '../css/App.css';
import Row from './RowComponent';
import { connect } from "react-redux";
import { addRow, generateGraph, addAnEntryToEvent, showEIOrGIList } from "./UserActions";
import * as axios from 'axios';

class BloodSugarAlteringEvent extends Component {
  idx = 0; newEvent = {};
  constructor(props) {
    super(props);

    this.onEventSelect = this.onEventSelect.bind(this, this.idx, this.newEvent);
    this.addRow = this.addRow.bind(this);
    this.onTextEntry = this.onTextEntry.bind(this, this.idx, this.newEvent);
  }


  addRow(props) {
    console.log("BloodSugarAlteringEvent - addRow");

    this.props.dispatch((dispatch) => {

      dispatch(addRow())

      Promise.all([axios.post('http://localhost:8080/simulator/', this.props.store.alteringEventList)])
        .then((response) => {
          console.log('response ->');
          console.log(response[0]);
          dispatch(generateGraph(response[0].data))
        })
        .catch((error) => {
          console.log('error ->');
          console.log(error);
        });
    });
  }

  onTextEntry(event, target, idx, newEvent) {
    console.log("BloodSugarAlteringEvent - addRow");

    this.props.dispatch((dispatch) => {

    this.props.dispatch(addAnEntryToEvent(idx, newEvent));

      // axios.get('/simulator/' + action.payload.target)
      Promise.all([axios.get('http://localhost:8080/simulator/' + newEvent.indexName)])
        .then((response) => {
          console.log('response ->');
          console.log(response[0].data);
          this.props.dispatch(showEIOrGIList(response[0].data));
        })
        .catch((error) => {
          console.log('error ->');
          console.log(error);
        });
    });
  }

  onEventSelect(event, target, idx, newEvent) {
    console.log("BloodSugarAlteringEvent - onEventSelect");
    this.props.dispatch(addAnEntryToEvent(idx, newEvent));
  }

  render() {
    return (
      <div className="div40pc">
        <p> <b> Assuming day break at 7 AM </b></p>
        <div className="LeftAlign">
          <div className="LeftAlign"><br />
            <div className="width60">Describe food</div>
            <div className="width10">Hours</div>
            <div className="width10">Minutes</div>
            <div className="width10"><label className="CancelBackGround circle display:hidden"></label></div>
          </div>

          {this.props.store.alteringEventList.map((item, idx) =>
            <Row eIOrGIList={this.props.store.eIOrGIList}
              onTextEntry={this.onTextEntry}
              onEventSelect={this.onEventSelect}
              item={item}
              idx={idx}
              alteringEventList={this.props.store.alteringEventList}
            />
          )}
        </div>

        <br /><br />
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