function solution(a, d, included) {    
    return included.reduce((acc, item , index)=>item === true ? acc + d * index + a : acc, 0)    
}