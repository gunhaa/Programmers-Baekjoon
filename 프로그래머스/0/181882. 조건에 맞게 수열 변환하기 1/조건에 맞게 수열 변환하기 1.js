function solution(arr) {
    return arr.map((item , index) => {
        
        if(50<=item && item%2 ===0){
            return item/2
        } 
        if(50>item && item%2 ===1 ){
            return item*2
        }
        return item
        
    } );
}