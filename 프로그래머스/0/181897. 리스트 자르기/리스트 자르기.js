function solution(n, slicer, num_list) {
    
    const temp = [];
    
    const operation = {
        "1" : (a,b,c) => num_list.slice(0, b+1),
        "2" : (a,b,c) => num_list.slice(a , num_list.length+1),
        "3" : (a,b,c) => num_list.slice(a,b+1),
        "4" : (a,b,c) => {
            
            for(let i=a ; i<b+1 ; i+=c){
                temp.push(num_list[i]);
            }
            
            return temp;
        }
   }

    return operation[n](slicer[0], slicer[1], slicer[2]);
}