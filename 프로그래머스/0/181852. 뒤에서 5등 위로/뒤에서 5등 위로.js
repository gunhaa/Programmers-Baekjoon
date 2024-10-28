function solution(num_list) {
    
    const sorted = num_list.sort((a,b) => a-b);
    
    console.log(sorted)
    return sorted.splice(5 , num_list.length+1);
    
}