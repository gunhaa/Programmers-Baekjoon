function solution(people, limit) {

    let count = 0;
    let sortPeople = people.sort((a,b) => a-b);
    
    while(sortPeople.length !== 0){
        
        const pop = sortPeople.pop();
        
        if (sortPeople.length > 0 && pop + sortPeople[0] <= limit) {
            sortPeople.shift();
        }

        count++;
        
    }
    return count
}