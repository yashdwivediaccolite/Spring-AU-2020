import { createStore } from "redux";

const initialState={
    displayData:[],
    userInput:""
}

function reducer(state=initialState,action){
    console.log(action.val);
    switch (action.type){
        case "PUSH":
            return {
                ...state,
                displayData:state.displayData.concat(action.val)
            }
        case "CHANGE":return {
            ...state,
            userInput:action.val
        }
        default :
            return {...state};    
    }
}

let store=createStore(reducer);

export default store;
