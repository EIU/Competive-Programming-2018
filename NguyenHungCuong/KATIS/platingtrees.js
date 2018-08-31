readline();
var max =0;
var arr = readline().split(' ').map(Number).sort((a,b)=>b-a).forEach(function(value,index){max = Math.max(max,value + index + 2);});
print(max);