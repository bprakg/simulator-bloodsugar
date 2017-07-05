import React, { Component } from 'react';
import '../css/App.css';
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
      </div>
    );
  }
}