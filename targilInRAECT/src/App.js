import './App.css';
import Login from './login'
import Home from './home'
import Class from './class'
import {NavLink,Route,Switch} from 'react-router-dom'
import { Redirect } from 'react-router-dom/cjs/react-router-dom.min';

function App1() {
  
const add=(f)=>{
  alert("helo!"+f)
}

  
  return (
  <div>
    <NavLink to="/login"> Login</NavLink>
    <NavLink to="/home"> home</NavLink>
    <NavLink to="/Class"> class</NavLink>
    <hr/>
   {/* <Login/> */}
    <button onClick={()=>add(6)} >click me!</button>
    <hr/>
       {/* <Redirect path="/login" to="/class"/> */}
    <Switch>
    <Route  path='/login/:id' component={Login} />
    	 <Route  path='/login' component={Login} exact/>
       <Route  path='/gg' component={Login} />
       <Route  path='/class' component={Class} />
       <Route  path='/home/:Id' component={Home} />
       <Route  path='/home' component={Home} />
     {/* <Route  path='/' component={Home} exact />
    <Route  path='**' component={Home} /> */}
    </Switch>
  </div>
  );
}

export default App1;
