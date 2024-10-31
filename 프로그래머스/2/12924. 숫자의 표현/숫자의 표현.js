function solution(n) {

    const arr = Array.from({ length: n }, (_, i) => i + 1);
    
    if(arr.length === 1) return 1;

    let count = 0;
    let p1 = 0;
    let p2 = 0;
    let sum = 0;
    while(p2 < n){
        sum+= arr[p2];
        
        while(sum > n){
            
            sum-=arr[p1];
            p1++;
            
        }
        if(sum===n) count++;
            
        p2++;
    }
    return count;
    
}