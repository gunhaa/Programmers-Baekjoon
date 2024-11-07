function solution(k, tangerine) {

    const box = new Map();
    let answer = 0;
    let acc = 0;
    
    for(let i=0; i<tangerine.length; i++){
        
        if(box.has(tangerine[i])){
            
            box.set(tangerine[i], box.get(tangerine[i])+1);
            
        } else {
            box.set(tangerine[i], 1);
        }
        
    }
    
    const sortedBox = Array.from(box.entries()).sort((a, b) => b[1] - a[1]);

    sortedBox.forEach( ([key , value]) => {

        if(acc<k){
            acc += value;
            answer++;     
        }
        
    });
    
    return answer;

}