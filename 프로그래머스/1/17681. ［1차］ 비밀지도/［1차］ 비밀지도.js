function solution(n, arr1, arr2) {

    const base2 = (arr) => {
        
        return arr.map(v => v.toString(2).padStart(n, '0'));
        
    }

    const base2arr1 = base2(arr1);
    const base2arr2 = base2(arr2);

    const answer = [];
    
    for(let i=0; i<n; i++){
        
        let row = "";
        
        for(let j=0; j<n; j++){
            
            base2arr1[i][j] === "1" || base2arr2[i][j] === "1" ? row+="1" : row+="0"
            
                        
        }
       
        answer.push(row);
        
    }    

    return answer.map(v=>{
       let str = "";        
       for(let i=0; i<v.length; i++){
           v[i] === "1" ? str += "#" : str += " "
       } 
        return str;
    });
}