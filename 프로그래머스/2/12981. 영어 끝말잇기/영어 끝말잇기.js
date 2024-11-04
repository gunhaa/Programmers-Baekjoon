function solution(n, words) {
    
    const wordList = [];
    let index;
    console.log(words[3]);
    for(let i=0; i<words.length; i++){
        
        if(wordList.indexOf(words[i]) > -1 || words[i].length ===1 ){
            index = i+1; 
            break;   
            
        }
        
        if(words[i+1]!==undefined){
            
            if(words[i][words[i].length-1] !== words[i+1][0]){
                index = i+2; 
                break;
            }
            
        }

        wordList.push(words[i]);
        
        
    }
    
    return index === undefined ? [0,0] : [ index%n === 0 ? n : index%n , Math.ceil(index/n) ];
}