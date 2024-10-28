function solution(my_string, queries) {

    const string = [...my_string];
    
    queries.forEach((v,i) => {
        const temp = string.splice(v[0], v[1]-v[0]+1).reverse();
        
        string.splice(v[0], 0, ...temp);
    })
    return string.join("");
}