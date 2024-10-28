function solution(strArr) {
    
    strArr = strArr.map(v=>{
        return v.length;
    });
    

    const answer = Array.from({length : Math.max(...strArr) +1 }).fill(0);
    
    strArr.forEach((v,i)=>{
        
       answer[v] += 1; 
        
    });  

    return Math.max(...answer);
}