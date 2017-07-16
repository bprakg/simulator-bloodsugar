import React, { Component } from 'react';
import '../css/App.css';
<<<<<<< HEAD
import Autocomplete from 'react-predictive-input';


export default class RowComponent extends Component {
  constructor(props) {
    super(props)
    console.log("RowComponent - constructor "+ this.props.masterEIOrGIList);
    this.state = {
      masterEIOrGIList : this.props.masterEIOrGIList
    }
  }

  render() {
    return (
      <div className="LeftAlign">
        {this.props.alteringEventList.map((item) =>
          <div><br />
          <div>
            <Autocomplete id={item.eventNum} data = {this.state.masterEIOrGIList}
            placeholder="Search a food/exercise" onChange = {this.props.parentOnTextEntry}
              onSelected={this.onTextSelect} />
              </div>
            <input type="hidden" name={item.eventNum} defaultValue={item.eventNum}
              className="CTextBox width80" />&nbsp;&nbsp;

            <input type="text" name={item.eventNum} defaultValue={item.timeHrs}
              className="CTextBox width2" onKeyUp={this.onHrEntry} />&nbsp;&nbsp;

            <input type="text" name={item.eventNum} defaultValue={item.timeMins}
              className="CTextBox width2" onKeyUp={this.onMinEntry} />&nbsp;&nbsp;
          </div>
        )}
=======
import Autocomplete from 'react-autocomplete';
import * as Consts from './DisplayConstants'
import * as axios from 'axios';


export default class RowComponent extends Component {

  constructor(props) {
    super(props);
    this.onTextEntry = this.onTextEntry.bind(this, props);
    this.onTextSelect = this.onTextSelect.bind(this, props);
    this.onHrSelect = this.onHrSelect.bind(this, props);
    this.onMinSelect = this.onMinSelect.bind(this, props);
  }


  onTextEntry(event, props, target) {
    console.log("BloodSugarAlteringEvent - onTextEntry - " + target);
    let newEvent = {};
    Object.assign(newEvent, this.props.alteringEventList[event.idx]);
    newEvent.indexName = event.item.indexName+target;
    // newEvent.indexValue = target.indexValue;
    this.props.onTextEntry(event.idx, newEvent);
  }

  onTextSelect(event, props, target) {

    console.log("RowComponent - onTextSelect");
    let newEvent = {};
    Object.assign(newEvent, this.props.alteringEventList[event.idx]);
    newEvent.alteringEvent = target.alteringEvent;
    newEvent.indexName = target.indexName;
    newEvent.indexValue = target.indexValue;
    this.props.onEventSelect(event.idx, newEvent);
  }

  onHrSelect(event, props, target) {
    console.log("RowComponent - onHrSelect");
    let newEvent = {};
    Object.assign(newEvent, this.props.alteringEventList[event.idx]);
    newEvent.hour = target.indexValue;
    this.props.onEventSelect(event.idx, newEvent);
  }

  onMinSelect(event, props, target) {
    this.inputElement;
    console.log("RowComponent - onMinSelect");
    let newEvent = {};
    Object.assign(newEvent, this.props.alteringEventList[event.idx]);
    newEvent.minute = target.indexValue;
    this.props.onEventSelect(event.idx, newEvent);
  }

  AutoCompleteComponent(data, currValue, onchange, onselect) {
    return (
      <div>
        <Autocomplete getItemValue={(item) => item.indexName}
          items={data}
          value={currValue}
          renderItem={(item, isHighlighted) =>
            <div style={{ background: isHighlighted ? 'lightgray' : 'white' }}>
              {item.indexName}
            </div>
          }
          onChange={onchange}
          onSelect={onselect}
        />
      </div>
    );
  }

  render() {

    return (
      <div className="LeftAlign"><br />
        <div className="width60">{this.AutoCompleteComponent(
          this.props.eIOrGIList, this.props.item.indexName,
          this.onTextEntry, this.onTextSelect)}</div>
        <div className="width10">{this.AutoCompleteComponent(
          Consts.hrsList, this.props.item.hour, {}, this.onHrSelect)}</div>
        <div className="width10">{this.AutoCompleteComponent(
          Consts.minsList, this.props.item.minute, {}, this.onMinSelect)}</div>
        <div className="width10"><label className="CancelBackGround circle">-</label></div>
>>>>>>> stash
      </div>
    );
  }
}