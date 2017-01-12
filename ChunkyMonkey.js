
/*Write a function that splits an array (first argument) into groups the length of size (second argument)
and returns them as a two-dimensional array.*/

function chunkArrayInGroups(arr, size) {
    
  var internalArray = [];
  
  var start=0;
  var end = size;
  
  var leftOut = arr.length%size;
  
  while(end<=arr.length){
    internalArray.push(arr.slice(start,end));
    start = end;
    end = end+size;1
  }
  
  if(leftOut!==0)
    internalArray.push(arr.slice(-leftOut));
  
  return internalArray;
}

chunkArrayInGroups(["a", "b", "c", "d"], 2);
//output [["a","b"],["c","d"]]
