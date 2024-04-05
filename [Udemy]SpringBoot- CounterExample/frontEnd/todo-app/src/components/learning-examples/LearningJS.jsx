const person = {
    name: 'sunro',
    address : {
        line1 : 'Baker street',
        city : 'London',
        country : 'UK',
    },
    profiles:['twitter','linkedin','instagram'],
    printProfile: () => {
        person.profiles.map(
            (profiles) =>                 console.log(profiles)
            
        )
        // console.log(person.profiles[0])
    }
}

export default function LearningJS(){
    return(
        <>
        <div>Learning {person.name} JS</div>
        <div>{person.address.line1}</div>
        <div>{person.profiles[0]}</div>
        <div>{person.printProfile()}</div>
        </>
    )
}