function solution(d, budget) {

    const sort = d.sort((a,b)=> a-b);
    let count = 0;
    let sum = 0;
    return sort.filter( (v,i) => {
        sum += v;       
        return sum <= budget ? true : false;
        
    }).length;
}