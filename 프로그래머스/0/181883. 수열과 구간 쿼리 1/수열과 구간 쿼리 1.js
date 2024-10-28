function solution(arr, queries) {
    
    queries.forEach((v,i)=>{
        
        for(let i=v[0]; i<v[1]+1; i++){
            
            arr[i]+=1;
            
        }
    });
    
    
    return arr;
}