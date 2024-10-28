function solution(arr, delete_list) {
    
    
    
    return arr.filter((v,i)=>{
        
        for(let va of delete_list){
            if(va===v) return false
        }
        return true
    });
}