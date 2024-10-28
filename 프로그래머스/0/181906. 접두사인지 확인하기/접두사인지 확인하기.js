function solution(my_string, is_prefix) {
    let answer =0;
    let arr = [];
    
    for(let i=0; i<my_string.length; i++){
        arr.push(my_string.slice(0,i+1));    
    }
    
    return arr.findIndex(v => v===is_prefix) > -1 ? 1 : 0;
}