import * as axios from "axios";

const initialState = {
    masterEIOrGIList: [],
    alteringEventList: [{
        eventNum: 1,
        indexValue: 0,
        alteringEventName: "Describe Food/Exercise event",
        timeHrs: "HR",
        timeMins: "MIN",
        amOrPm: "AM"
    }],
    simulatedBloodSugarOverTime: ""
}

export default function reducer(state = initialState, action) {
    console.log(state);
    switch (action.type) {
        case "GET_MASTER_EI_OR_GI_LIST":
            console.log("GET_MASTER_EI_OR_GI_LIST - " + action.payload);
            state = { ...state, masterEIOrGIList: action.payload };
            break;
        case "ADD_ALTERING_EVENT":
            console.log("ADD_ALTERING_EVENT - " + action.payload);
            let newItem = {
                eventNum: action.payload.length + 1,
                indexValue: 0,
                alteringEventName: "Describe Food/Exercise event",
                timeHrs: "HR",
                timeMins: "MN",
                amOrPm: "AM"
            };
            let list = action.payload;
            list.push(newItem);
            state = {
                ...state,
                alteringEventList: list,
                simulatedBloodSugarOverTime: ""
            };
            break;
        case "ON_TEXT_ENTRY":
            console.log("ON_TEXT_ENTRY - " + action.payload);
            axios.get('http://localhost:8080/simulator/'+action.payload)
                .then(function (response) {
                    console.log(response);
                    state = {
                        ...state,
                        masterEIOrGIList: response
                    };
                })
                .catch(function (error) {
                    console.log(error);
                });
            break
        default:
            console.log("default");
    }
    return state;
}
