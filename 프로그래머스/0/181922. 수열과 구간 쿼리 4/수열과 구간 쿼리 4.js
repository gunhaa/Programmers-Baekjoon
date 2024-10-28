function solution(arr, queries) {

    for(let v of queries) {
        
        
        for(let i = v[0] ; i<v[1]+1 ; i++){
            
            if(i % v[2] === 0){
                
                arr[i] += 1
                
            }
            
        }
        
        
        
    }
    
    return arr;
}