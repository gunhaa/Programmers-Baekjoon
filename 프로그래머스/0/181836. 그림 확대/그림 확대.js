function solution(picture, k) {

    let res = [];
    
    picture.forEach(v=>{
        
        let str = v.split("");
        let result = "";       
        str.forEach(v2=>{
    
            for(let i=0; i<k; i++){
                 result += v2;
            }    
            
        });
        
        for(let j=0; j<k; j++){
            res.push(result);
        }
        
    });
    
    return res;

}