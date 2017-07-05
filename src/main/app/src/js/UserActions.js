
export function getMasterEIOrGIList (masterEIOrGIList) {
    return {
        type: "GET_MASTER_EI_OR_GI_LIST",
        payload: masterEIOrGIList
    }
}

export function addAlteringEvent (alteringEventName) {
    return {
        type: "ADD_ALTERING_EVENT",
        payload: alteringEventName
    }
}

export function onTextEntry (eiorgientry) {
    return {
        type: "ON_TEXT_ENTRY",
        payload: eiorgientry
    }
}