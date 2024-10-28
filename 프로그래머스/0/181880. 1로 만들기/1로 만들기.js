function solution(num_list) {
    
    let answer = 0;
    
    num_list.forEach((v,i)=>{
        
        while(v!==1){
            
            if(v%2===0){
                v=v/2;
                answer++;
            } else if(v%2===1){
                v=(v-1)/2;
                answer++;
            }
            
        }
        
    });
    
    return answer;    
}