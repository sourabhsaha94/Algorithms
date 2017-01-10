
function largestOfFour(arr) {
  
  var resultArray = [];
  var min =0;
  for(var i=0;i<arr.length;i++){
    min =0;
    for(var j=0;j<arr[i].length;j++){
      if(arr[i][j]>min){
        min = arr[i][j];
      }
    }
    resultArray.push(min);
  }
  return resultArray;
}

largestOfFour([[4, 5, 1, 3], [13, 27, 18, 26], [32, 35, 37, 39], [1000, 1001, 857, 1]]);
//output [5,27,39,1001]
