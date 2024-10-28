function solution(arr) {

    const len = arr.length;
    let count = 0;
    let temp1 = arr;    

    while(true){
 
        const temp2 = temp1.map(v=>{
           
           if(v%2 === 0 && v >= 50){
               return v= v/2;
               
           } else if(v%2===1 && v <= 50){
               return v= (v*2)+1;
           } else {
               return v;
           }
           
        });
        
        if(temp1.every((v,i)=> temp2[i]===v)) break;
        else (count++ , temp1 = temp2);
    }
    
    return count;
    
}