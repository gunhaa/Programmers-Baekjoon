function solution(s) {
    let count = 0;
    for(let i=0; i<s.length; i++){
        
        const stack = [];
        
        let loop = 0;
        // console.log(`----------------`)
        for(let j=i; j<s.length+i; j++){
            let temp = j<s.length ? j : j-s.length
            if(s[temp] === "{" || s[temp]==="(" || s[temp] === "[") {
                // console.log(`[({ : ${s[temp]}`)
                loop++;
                stack.push(s[temp]);
            }else if(s[temp]==="]" || s[temp] === ")" || s[temp] === "}") {
                
                let pop = stack[stack.length-1];
                                
                if(pop==="["){
                    if(s[temp] === "]"){
                        loop++;
                        stack.pop();
                    }else{
                        break;
                    }
                }
                if(pop==="{"){
                    if(s[temp] === "}"){
                        loop++;
                        stack.pop();
                    }else{
                        break;
                    }
                }if(pop==="("){
                    if(s[temp] === ")"){
                        stack.pop();
                        loop++;
                    }else{
                        break;
                    }
                }
                
            }
        }
        if(stack.length === 0 && loop===s.length) count++;
        // console.log(`loop : ${loop}`)
        // console.log(`stack : ${stack}`)
        // console.log(`count : ${count}`)
    }
    return count;
}