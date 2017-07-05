
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
    }
}