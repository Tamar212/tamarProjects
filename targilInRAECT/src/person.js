function Person(props){
return(

<div className="bord">
<label >שם</label>
<div>{props.name}</div>
<label>גיל</label>
<div> {props.age}</div>
<label>עיר</label>
<div>{props.city}</div>
</div>
)

}
export default Person;