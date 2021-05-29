import React,{Component} from 'react'
class Persons extends Component
{
    state={
        personim:[
            {name:"",age:"5", city:"בני hh"},
            {age:"5", city:"hhhבני ברק"},
            {age:"18", city:"hh ברק"}
          ]
    }
render(){
    return <div>

{this.state.personim.map((x,i)=><Person key={i} name={x.name} age={x.age} city={x.city}/>)}
    
    </div>
}
}
export default Persons;