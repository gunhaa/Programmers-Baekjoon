function solution(arr, queries) {

    while(queries.length !== 0){
        
        const query = queries.shift();
        [ arr[query[0]], arr[query[1]] ] = [ arr[query[1]] , arr[ query[0] ] ];
        
    }
    
    return arr;
}