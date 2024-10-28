function solution(arr1, arr2) {

    if(arr1.length>arr2.length){
        
        return 1
        
    }
    
    if(arr1.length<arr2.length){
        return -1
    }

    if(arr1.length===arr2.length){
        
        let arr1sum = arr1.reduce((acc, item)=> acc+item,0);
        let arr2sum = arr2.reduce((acc, item)=> acc+item,0);
        if(arr1sum===arr2sum) return 0
        
        return arr1sum>arr2sum ? 1 : -1
    }
    
}