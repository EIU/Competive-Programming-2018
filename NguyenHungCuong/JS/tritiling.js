var f = new Array(31);
f[0] =1,f[2] = 3;
for (var i = 4;i<31;i+=2){
    f[i] = 4*f[i-2] - f[i-4];
}
var n;
while ((n = +readline()) != -1){
    print(f[n] || 0)
}