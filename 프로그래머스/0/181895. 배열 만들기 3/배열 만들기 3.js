function solution(arr, intervals) {
    
    
    const answer = [];
    
    for(let i=0 ; i<intervals.length ; i++){
        
        const temp = arr.slice(intervals[i][0], intervals[i][1]+1);
        answer.push(...temp); 
        
    }
    
    return answer
    
}