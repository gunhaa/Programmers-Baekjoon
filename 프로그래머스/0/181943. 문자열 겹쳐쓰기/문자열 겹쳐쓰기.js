function solution(my_string, overwrite_string, s) {

    let stringArr = my_string.split("");
    let overwriteArr = overwrite_string.split("");
    for(let i=s ; i<stringArr.length ; i++){
        
        if(overwriteArr.length>0){
            stringArr[i] = overwriteArr.shift();                        
        }

        
    }
    
    return stringArr.join("");
}