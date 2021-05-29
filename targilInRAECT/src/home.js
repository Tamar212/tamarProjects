
function Person(props){
    console.log(props)
    const url=props.match.params.Id
    return(
    
    <div>Home!/{url}</div>
    )
    
    }
    export default Person;