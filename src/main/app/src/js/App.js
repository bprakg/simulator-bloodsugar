import React, { Component } from 'react';
import '../css/App.css';
import BloodSugarAlteringEvent from './BloodSugarAlteringEvent';
import GraphSimulator from './GraphSimulator';

class App extends Component {
  render() {
    return (
      <div className="App">
        <div className="App-header">
          <b>Health I. Q. - BloodSugar and Glycation Simulator</b>
        </div>
        <div className="main">
          <BloodSugarAlteringEvent /><GraphSimulator />
        </div>
        <div className="App-footer">
        </div>
      </div>
    );
  }
}

export default App;
