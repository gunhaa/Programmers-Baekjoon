function solution(arr) {
    const row = arr.length;
    const col = arr[0].length;
    if(row>col){
        
        const addRow = row-col;
        
        arr.forEach((v)=>{                
        
            for(let i=0; i<addRow; i++){
                v.push(0);
            }
            
        });
        
        return arr;
        
    }else if(row<col){
        
        const addCol = col-row;
        const len = col;
        const addItem = Array.from({length : len}).fill(0);
        
        for(let i=0; i<addCol; i++){
            arr.push(addItem);
        }
        return arr;
        
        
        
    }else if(col===row){
        return arr;
    }
}