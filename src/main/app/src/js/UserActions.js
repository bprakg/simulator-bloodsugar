
<<<<<<< HEAD
export function getMasterEIOrGIList (masterEIOrGIList) {
    return {
        type: "GET_MASTER_EI_OR_GI_LIST",
        payload: masterEIOrGIList
    }
}

export function addAlteringEvent () {
    return {
        type: "ADD_ALTERING_EVENT"
    }
}

export function onTextEntry (eiorgientry) {
    return {
        type: "ON_TEXT_ENTRY",
        payload: eiorgientry
=======
export function addAnEntryToEvent(idx, target) {
    return {
        type: "ADD_AN_ENTRY_TO_EVENT",
        payload: {
            idx: idx,
            target: target
        }
    }
}

export function addRow() {
    return {
        type: "ADD_ROW",
    }
}

export function generateGraph(simulatedBloodSugarOverTime) {

    return {
        type: "GENERATE_GRAPH",
        payload: simulatedBloodSugarOverTime
    }
}

export function showEIOrGIList(eiOrGIList) {

    return {
        type: "SHOW_EI_OR_GI_LIST",
        payload: eiOrGIList
>>>>>>> stash
    }
}