import React from "react";

const Child=(props)=>{
    if(props.data.length>0){
        return (
            <div>
                <h2>Selected Rows:</h2>
                <div className="rightContent">
                <table> 
                <thead>
                    <th>Id</th>
                    <th>Country</th>
                    <th>State</th>
                    <th>City</th>
                </thead>           
                <tbody>
                    {props.data.map((elem,index)=>{
                        return <tr key={`${index}`}>
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
            </div>    
        );
    }
    else{
        return(
            <div style={{textAlign:"center"}}>
                <h2>None Selected</h2>
            </div>
        )
    }

}

export default Child;