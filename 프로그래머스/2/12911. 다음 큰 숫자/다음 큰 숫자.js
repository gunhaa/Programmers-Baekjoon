function solution(n) {
    
    const len = n.toString(2).split("").reduce( (acc, v)=> v==="1" ? acc+1 : acc , 0);
    let temp = n;
    
    while(true){
        let count=0;
        temp+=1;
        
        for(const item of temp.toString(2)){
            
            if(item === "1"){
                count +=1;
            }
            
        }
        
        if(count === len){
            return temp;
        }
        
    }
    
    
}