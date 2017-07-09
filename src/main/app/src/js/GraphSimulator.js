import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import '../css/App.css';
import { Line } from 'react-chartjs-2';
import { moment } from 'moment';

export default class GraphSimulator extends Component {

    getGraphDataset(label, isFill, lineBackgroundColor, showLine, lineData) {
        return ({
            label: label,
            fill: isFill,
            lineTension: 0.1,
            backgroundColor: lineBackgroundColor,
            borderColor: lineBackgroundColor,
            pointBorderColor: lineBackgroundColor,
            pointBackgroundColor: lineBackgroundColor,
            pointBorderWidth: 0.5,
            pointHoverRadius: 1,
            pointHoverBackgroundColor: lineBackgroundColor,
            pointHoverBorderColor: lineBackgroundColor,
            pointHoverBorderWidth: 0.5,
            pointRadius: 0.05,
            pointHitRadius: 10,
            showLine: showLine,
            data: lineData
        });
    }

    options = () => {
        return ({
            scales: {
                xAxes: [{
                    gridLines: {
                        display: false
                    }
                }],
                yAxes: [{
                    gridLines: {
                        display: false
                    }
                }]
            }
        });
    }
    data = (dataset) => {
        return ({
            labels: dataset.labelList,
            datasets: [
                this.getGraphDataset('Blood Sugar', false,
                    'rgba(75,0,192,180)', false,
                    dataset.bloodsugarList),
                this.getGraphDataset('Glycation', false,
                    'rgba(190,0,0,120)', false,
                    dataset.glycationList),
            ]
        });
    };

    render() {
        return (
            <div className="div58pc">
                <p> <b>Simulated Bloodsugar and Glycation graph </b></p>
                <Line data={this.data(this.props.simulatedBloodSugarOverTime)} options={this.options} />
            </div>
        );
    }
}
