var str = readline(),v1= 0, v2= 0,res='';
var left = str.substring(0,str.length/2).split('').map(x=>{x = x.charCodeAt()-65;v1+=x;return x;}), right = str.substring(str.length/2,str.length).split('').map(x=>{x = x.charCodeAt()-65;v2 += x;return x});
right = right.map(x=> (x + v2)%26);
left.forEach((x,i)=>{
   res += String.fromCharCode(((x + v1)%26 + right[i])%26 + 65);
});
print(res);