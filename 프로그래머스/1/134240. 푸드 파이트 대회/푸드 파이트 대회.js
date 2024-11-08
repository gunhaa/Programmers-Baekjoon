function solution(food) {
    
    
    const useFood = food.map((v,i)=>{
        
       if(v%2 === 0 ) return v;
        else return v-1;
        
    });

    const answer = [0];
    
    for(let i=useFood.length-1 ; i>0; i--){

        for(let j=0; j<useFood[i]; j++){
            
            if(j<useFood[i]/2) answer.unshift(i);
            else answer.push(i);
            
        }
    }    
    return answer.join("");
}