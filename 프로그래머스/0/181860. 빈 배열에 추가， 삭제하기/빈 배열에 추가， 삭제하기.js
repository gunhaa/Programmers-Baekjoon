function solution(arr, flag) {

    const answer = [];
    
    arr.forEach((v,i)=>{
        console.log(`arr[i] : ${arr[i]} / flag[i] : ${flag[i]}`)
        if(flag[i]){
            
            for(let j=0; j<arr[i]*2 ; j++){
                answer.push(arr[i]);
            }
            
        }else{
            
            for(let j=0; j<arr[i]; j++){
                answer.pop();
            }
            
        }
        
    });

    return answer;
    
}