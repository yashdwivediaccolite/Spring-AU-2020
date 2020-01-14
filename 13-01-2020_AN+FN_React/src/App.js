import React,{Component} from 'react';
import './App.css';
import Data from "./display.json";
import Child from "./Child/Child";
import {connect} from "react-redux";

class App extends Component {

  constructor(props){
    super(props);
  }

  render(){
      return (
        <div>
            <div className="left">
              <h2>Select a row</h2>
              <b>ENTER CITY:</b> <input type="text" onChange={this.props.addToUserInput} value={this.props.userInput}/><br/><br/>
              <table>
                <thead>
                <tr>
                  <th>Id</th>
                  <th>Country</th>
                  <th>State</th>
                  <th>City</th>
                </tr>
                </thead>
                <tbody>
              {
                Data
                  .filter(elem=>{
                     const pattern=new RegExp(this.props.userInput,"i");
                     return pattern.test(elem.city);
                  })
                  .map((elem,index)=>{
                    return <tr key={`${index}`} onClick={this.props.addToDisplayData.bind(this,elem)}>
                  <td>{elem.id}</td>
                  <td>{elem.country}</td>
                  <td>{elem.state}</td>
                  <td>{elem.city}</td>
                  </tr>
                })
              }
              </tbody>
          </table>
        </div>
        <div className="right">
          <Child data={this.props.displayData} />
        </div>
        </div>  
      )

  }
}


const mapStateToProps=state=>{
  return {
    displayData:state.displayData,
    userInput:state.userInput
  }
}

const mapDispatchToProps=dispatch=>{
  return {
    addToDisplayData:(data)=>{dispatch({type:"PUSH",val:data})},
    addToUserInput:({target})=>{dispatch({type:"CHANGE",val:target.value})}
  }
}

export default connect(mapStateToProps,mapDispatchToProps)(App);
  