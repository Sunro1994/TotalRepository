import { Component } from "react"

export  default function FirstComponent(){
    return(
        <div className="FirstComponent">First Component</div>
    )
}

export  function FifthComponent(){
    return(
        <div className="FifthComponent">Fifth Component</div>
    )
}

export  function SecondComponent(){
    return (
      <div className="SecondComponent">Second Component</div>
    )
  }


  
export class ThirdComponent extends Component{
    render(){
        return (
            <>
          <div className="ThridComponent">Third Component</div>
          <div className="ThridComponent">Third Component</div>
          </>
        )
        
    }
  }