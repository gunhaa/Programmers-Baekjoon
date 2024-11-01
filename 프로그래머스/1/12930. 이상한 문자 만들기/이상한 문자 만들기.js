function solution(s) {
    
    const word = s.split(" ");
    
    const answer = word.map((v,i)=>{
       
        return v.split("").map((v,i)=> i%2===0 ? v.toUpperCase() : v.toLowerCase() ).join("");
        
    });  
    
    return answer.join(" ");
}