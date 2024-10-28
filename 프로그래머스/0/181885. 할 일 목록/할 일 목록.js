function solution(todo_list, finished) {
    return todo_list.filter((item,idx) => finished[idx] === true ? false : true);
}