function solution(arr, queries) {
    var answer = [];
    
    while(queries.length!==0){
        
        const query = queries.shift();
        
        const temp = arr.slice(query[0] , query[1] + 1).filter((v) => v > query[2])
        if(temp.length > 0){
            answer.push(Math.min(...temp));            
        } else {
            answer.push(-1);
        }

        
    }
    
    return answer;
}