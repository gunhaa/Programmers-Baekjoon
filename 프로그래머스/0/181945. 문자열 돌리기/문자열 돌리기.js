const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    let str = input[0];
    
    let strArr = str.split("");
    
    for(let i=0; i<strArr.length; i++){
        console.log(strArr[i]);
    }
    
});