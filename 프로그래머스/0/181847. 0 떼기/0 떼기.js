function solution(n_str) {
            
    let strArr = [...n_str];
    let answer = [...n_str]
    if(n_str.startsWith("0")){

        strArr.some((v,i) => {
            console.log(`here : ${v}`)
            if(v==0){
                answer.shift();
                return false;    
            }
            
            return true
        });      
    }
    
    return answer.join("");
}