function solution(absolutes, signs) {

    return absolutes.reduce((acc,v,i)=>{
        
        return signs[i]===true ? acc+v : acc-v;
        
    } , 0)

}