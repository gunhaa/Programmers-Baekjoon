function solution(num_list, n) {
    
    let arr1 = num_list.slice(n, num_list.length);
    let arr2 = num_list.slice(0,n);
    return arr1.concat(arr2);
    
}