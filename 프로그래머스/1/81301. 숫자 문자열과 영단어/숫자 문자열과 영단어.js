function solution(s) {
    
    const answer = [];
    const stack = [];    
    const str = s.split("");
    const parseWord = {
        "zero" : 0,
        "one" : 1, 
        "two" : 2,
        "three" : 3,
        "four" : 4,
        "five" : 5,
        "six" : 6,
        "seven" : 7,
        "eight" : 8,
        "nine" : 9        
    }

    
    while(str.length !== 0){
        
        const temp = str.shift();

        if(isNaN(temp)){
            
            stack.push(temp);
            let num = stack.join(""); 
            if(parseWord[num] !== undefined ){
                
                answer.push(parseWord[num]);
                stack.length = 0;
                
            }
            
        }else if(!isNaN(temp)){
            let num = stack.join(""); 
            
            if(parseWord[num] !== undefined ){
                
                answer.push(parseWord[num]);
                stack.length = 0;
                
            }
            
            answer.push(temp);
        }
        
    }

    
    return Number(answer.join(""));
}