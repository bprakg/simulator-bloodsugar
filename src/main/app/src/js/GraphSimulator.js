import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import '../css/App.css';
import { Line } from 'react-chartjs-2';

export default class GraphSimulator extends Component {

    getGraphDataset(label, isFill, lineBackgroundColor, lineData) {
        return ({
            label: label,
            fill: isFill,
            lineTension: 0.1,
            backgroundColor: 'rgba(75,192,192,0.4)',
            borderColor: lineBackgroundColor,
            borderDash: [],
            borderDashOffset: 0.0,
            borderJoinStyle: 'miter',
            pointBorderColor: 'rgba(75,192,192,1)',
            pointBackgroundColor: '#fff',
            pointBorderWidth: 1,
            pointHoverRadius: 5,
            pointHoverBackgroundColor: 'rgba(75,192,192,1)',
            pointHoverBorderColor: 'rgba(220,220,220,1)',
            pointHoverBorderWidth: 2,
            pointRadius: 1,
            pointHitRadius: 10,
            data: lineData
        });
    }

    options = () => {
        return({
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero:true
                        }
                    }]
                }
            }
        });
    }
    data = (dataset) => {
        return ({
            labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
            datasets: [
                this.getGraphDataset('Blood Sugar', false,
                    'rgba(75,0,192,180)',
                    //[80, 90, 109, 80, 81, 126, 80, 90]
                    dataset
                    ),
                
                this.getGraphDataset('Glycation', true,
                    'rgba(190,0,0,120)', 
                    [0, 1, 2, 3, 4, 5, 6, 7, 8]),
            ]
        });
    };

    render() {
        return (
            <div className="div58pc">
                <p> <b>Simulated Bloodsugar and Glycation graph </b></p>
                <Line data={this.data(this.props.simulatedBloodSugarList)} options={this.options}/>
            </div>
        );
    }
}
