function solution(phone_number) {

    const len = phone_number.length;
    let answer = "";
    
    
    for(let i=0; i<len; i++){
        
        if(len-5<i){
            answer += phone_number[i]
        } else {
            answer += "*"
        }
        
    }        
    
    return answer;
    
}