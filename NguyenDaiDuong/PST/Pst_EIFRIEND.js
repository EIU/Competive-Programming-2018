var check=readline().split('');
var result="konichiwa".split('');
var temp=false;
var j=0;
for(var i=0;i<check.length;i++){
    if(check[i]===result[j]){
        j+=1;
        if(j===result.length){
            temp=true;
            break;
        }
    }
}
print(temp===true?"YES":"NO");