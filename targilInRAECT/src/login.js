import React, { Component } from 'react'
class Login extends Component {
    state = {
        form: {
            Lastname: {
                value: "dvora",
                placeholder: "שם ",
                class: "name",
                valid:false,
                config:{
                    reqierd:true,
                    maxlength:9
                }
            },
            userName: {
                value: "dvora",
                placeholder: "  משתמשים ",
                class: "name"
            },
            hoby: {
                value: "5",
                placeholder: " משפחה",
                class: "name",
                type: "text"
            },
            age: {
                value: "8",
                placeholder: "סיסמא",
                class: "name",
                type: "password"
            },
            city: {
                value: "dvora",
                placeholder: "שם משפחה",
                class: "name"
            },
            tz: {
                value: "203333",
                placeholder:"ת.ז ",
                class: "name"
            },
        }
        ,
        validForm:true,
        counter:2
    }
onChangeForm=(event,x)=>{
const form1={...this.state.form};
const curentForm={...form1[x]};
curentForm.value=event.target.value;
form1[x]=curentForm;
this.setState({form:form1});

}

    render() {
        const arr = [];
        for (let x in this.state.form) {
           // console.log(this.state.form[x]);
            arr.push({ key: x, value: this.state.form[x] })
        };
        return <div>
            {arr.map(x => <div key={x.key}>
                <p>{x.value.placeholder}</p>
                <input
                onChange={(event)=>this.onChangeForm(event,x.key)}
                    value={x.value.value}
                    type={x.value.type}
                    className={x.value.class}
                    placeholder={x.value.placeholder} /></div>)}
                    {
                        arr.map(x=> <div key={x.key}>{x.value.value} <br/></div>)
                    }
            {/*  <p>name</p>
            <input value={this.state.name.firstName} 
                onChange={(event) => this.setState({ name: { ...this.state.name, firstName: event.target.value } })} />
            <input value={this.state.name.Lastname}
                onChange={(event) => this.setState({ name: { ...this.state.name, Lastname: event.target.value } })} />
            <p>age</p>
            <input value={this.state.age}
                onChange={(event) => this.setState({ age: event.target.value })} />
            <p>city</p>
            <input value={this.state.city}
                onChange={(event) => this.setState({ city: event.target.value })}
            />
            <div>
                <p>  My name is {this.state.name.Lastname} {this.state.name.firstName}
                </p>
            </div>
             {this.state.counter}
            <button onClick={()=> this.setState({counter:this.state.counter+1})} > Count</button>
     */}
        </div>
    }
}
export default Login