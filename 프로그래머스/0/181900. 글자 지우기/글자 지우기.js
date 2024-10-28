function solution(my_string, indices) {

    const str = [...my_string];
    
    while(indices.length!==0){
        
        const temp = indices.pop();
        
        str[temp] = "";
        
        
    }
    
    return str.join("");
}