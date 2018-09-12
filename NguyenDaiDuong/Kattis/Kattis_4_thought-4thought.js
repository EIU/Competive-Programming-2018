var r1= +readline();
var temp = ['+','-','*','/' ];
for(var i=0;i<r1;i++){
    var number=+readline();
    var sum=0;
    var check=false;
    for (var f = 0; f < 4; f++) {
    for (var j = 0; j < 4; j++) {
        for (var g = 0; g < 4; g++) {
            sum=Math.round(eval(eval("4 +temp[f]+ 4 +temp[j]+ 4 +temp[g]+ 4")));
            if(sum===number&&check===false){
                print("4 "+temp[f]+" 4 "+temp[j]+" 4 "+temp[g]+" 4" +" = "+sum);
                check=true;
                }
            }
        }
    }
    if(check===false)
        print("no solution")
}