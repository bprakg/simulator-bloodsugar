import React, { Component } from 'react';
import '../css/App.css';
import BloodSugarAlteringEvent from './BloodSugarAlteringEvent';
import GraphSimulator from './GraphSimulator';
import { connect } from "react-redux";
import * as action from "./UserActions";

class App extends Component {
  constructor(props) {
    super(props)
    this.updateAppState = this.updateAppState.bind(this);
  }

  updateAppState() {
    console.log("App - updateState");
    this.props.dispatch(action.addAlteringEvent());
  }

  render() {
    return (
      <div className="App">
        <div className="App-header">
          <b>Health I. Q. - BloodSugar and Glycation Simulator</b>
        </div>
        <div className="main">
          <BloodSugarAlteringEvent updateAppState = {this.updateAppState}/>
          <GraphSimulator simulatedBloodSugarList = 
          {this.props.store.simulatedBloodSugarOverTime.simulatedBloodSugarList}
            simulatedGlycationList = {this.props.store.simulatedBloodSugarOverTime.simulatedGlycationList}/>
        </div>
        <div className="App-footer">
        </div>
      </div>
    );
  }
}

App = connect((store) => {
  return {
    store: store
  }
})(App)

export default App