function solution(n) {

    const arr = Array.from({length : n+1}).fill(0);
    
    arr[1] = 1;
    arr[2] = 2;
    
    for(let i=3; i<n+1; i++){
        
        arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
        
    }
    return arr[n];
    
}