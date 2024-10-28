function solution(order) {
    
    return order.reduce((ac,v)=>v.indexOf("latte") > -1 ? ac+5000 : ac+4500,0);
}