import * as axios from 'axios';
import * as TestData from './TestData';

const defaultAlteringEvent = (idx) => {
    return ({
        eventNum: idx+1,
        indexValue: idx+1,
        alteringEventName: "Describe Food/Exercise event",
        timeHrs: 0,
        timeMins: 0
    });
}

const initialState = {
    masterEIOrGIList: [],
    alteringEventList: [(defaultAlteringEvent(0))],
    simulatedBloodSugarOverTime: {
        labelList : [],
        bloodsugarList : [],
        glycationList : []
    }
}

export default function reducer(state = initialState, action) {
    console.log(state);
    switch (action.type) {
        case "GET_MASTER_EI_OR_GI_LIST":
            console.log("GET_MASTER_EI_OR_GI_LIST - " + JSON.stringify(action.payload));
            state = { ...state, masterEIOrGIList: action.payload };
            break;
        case "ADD_ALTERING_EVENT":
            console.log("ADD_ALTERING_EVENT ");
            let list = state.alteringEventList;
            list.push(defaultAlteringEvent(list.length+1));
            state = {
                ...state,
                simulatedBloodSugarOverTime: getSimulatedBloodSugarOverTime(state.alteringEventList),
                alteringEventList: list
            };
            break;
        case "ON_TEXT_ENTRY":
            console.log("ON_TEXT_ENTRY - " + JSON.stringify(action.payload));
           /* axios.get('http://localhost:8080/simulator/'+action.payload)
                .then(function (response) {
                    console.log(response);
                    state = {
                        ...state,
                        masterEIOrGIList: response
                    };
                })
                .catch(function (error) {
                    console.log(error);
                });*/
                state = {...state,
                        masterEIOrGIList: TestData.getMasterEIOrGIList()
                    };
            
            break
        default:
            console.log("default");
    }
    console.log(state);
    return state;
}

function getSimulatedBloodSugarOverTime(list) {
    //axios call here
    console.log("getSimulatedBloodSugarOverTime");
    let simulatedBloodSugarList = [];
    let simulatedGlycationList = [];
    let labelList = [];
    TestData.getSimulatedBloodSugarOverTime().map((item) => {
        // let itemDate = new Date(item.simulationTime.year, item.simulationTime.monthValue, 
        // item.simulationTime.dayOfMonth, item.simulationTime.hour, item.simulationTime.minute);
        let itemDate = item.simulationTime.hour+":"+item.simulationTime.minute;
        labelList.push(itemDate);
        simulatedBloodSugarList.push(item.bloodSugar);
        simulatedGlycationList.push(item.glycation);
    });
    return ({
        labelList: labelList,
        bloodsugarList : simulatedBloodSugarList,
        glycationList : simulatedGlycationList
    });
}