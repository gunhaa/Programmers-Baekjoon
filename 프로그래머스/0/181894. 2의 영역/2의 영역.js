function solution(arr) {
    
    const temp = [];
    arr.filter((v,i)=> v===2 ? temp.push(i) : false );
    return temp.length > 0 ?  arr.slice(temp[0], temp[temp.length-1]+1 ): [-1]       
    
}