function solution(a, b, c) {

    const set = new Set();
    
    set.add(a);
    set.add(b);
    set.add(c);
    
    
    let answer = 0 ;
    answer += a+b+c;
    console.log(set)
    
    if(set.size===2 || set.size===1){
        answer *= (Math.pow(a,2)+ Math.pow(b,2) + Math.pow(c,2))  
    } 
    
    if(set.size===1){
        answer *= (Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3))
    }
    
    return answer;
}