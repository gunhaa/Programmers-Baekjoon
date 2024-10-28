function solution(num_list) {
    
    return num_list.length>10 ? num_list.reduce((acc, item) => acc+item , 0) : num_list.reduce((acc,item) => acc*item , 1);
    
}