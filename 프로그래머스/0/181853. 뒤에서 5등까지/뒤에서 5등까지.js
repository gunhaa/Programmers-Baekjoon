function solution(num_list) {
    const sortedArr = num_list.sort((a,b) => a-b);
     return sortedArr.splice(0,5);
}