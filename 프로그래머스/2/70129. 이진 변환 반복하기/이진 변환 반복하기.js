function solution(s) {
    var answer = [];
    
    let count = 0;
    let del = 0;
    
    let sArr = s.split("");
    let len = sArr.length;
    while(sArr.length!==1){

        count++;
        
        sArr = sArr.filter(v=> v==="1");
       
        del+=len-sArr.length;
        
        let result =sArr.length;

        sArr=result.toString(2).split("");
    
        len = sArr.length;
    }
    
    answer.push(count);
    answer.push(del);
    
    
    return answer;
}