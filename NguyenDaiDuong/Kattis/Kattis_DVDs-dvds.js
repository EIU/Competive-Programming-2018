var test=+readline();
for(var i=0;i<test;i++){
    var count=1;
    var long= +readline();
    var arr=readline().split(" ").forEach(item=>{count=count===+item?count+1:count});
    print(long-count+1);
}