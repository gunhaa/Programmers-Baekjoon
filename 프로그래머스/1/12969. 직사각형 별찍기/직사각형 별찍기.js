process.stdin.setEncoding('utf8');
process.stdin.on('data', data => {
    const n = data.split(" ");
    const a = Number(n[0]), b = Number(n[1]);
    
    
    let line = ""
    let answer = ""
    for(let i=0; i<a ; i++){
        line += "*"
    }
    
    for(let j=0; j<b; j++){
        answer += line+"\n"
    }
    console.log(answer);
    
});