function solution(sizes) {

    let x = 0;
    let y = 0;
    
    for(let i=0; i<sizes.length; i++){
        
        if(sizes[i][0] >= sizes[i][1]) [sizes[i][0] , sizes[i][1]] = [sizes[i][1] , sizes[i][0]];
        
        if(x<sizes[i][0]) x = sizes[i][0];
        
        if(y<sizes[i][1]) y = sizes[i][1];
        
    }
    
    return x*y    
}