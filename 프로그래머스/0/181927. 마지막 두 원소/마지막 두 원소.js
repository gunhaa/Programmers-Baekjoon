function solution(num_list) {
    

    num_list[num_list.length-1] > num_list[num_list.length-2] ?
        num_list[num_list.length] = num_list[num_list.length-1] - num_list[num_list.length-2]
        : num_list[num_list.length] = num_list[num_list.length-1]*2 

    return num_list
}