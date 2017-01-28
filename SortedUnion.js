/*Write a function that takes two or more arrays and returns a new array of unique values in the order of 
the original provided arrays.

In other words, all values present from all arrays should be included in their original order, 
but with no duplicates in the final array.

The unique numbers should be sorted by their original order, but the final array should not be sorted in numerical order.*/

function uniteUnique(arr) {
  var finalArray = [];
  
  for(var i=0;i<arguments[0].length;i++){
    finalArray.push(arguments[0][i]);
  }
  
  for(var j=1;j<arguments.length;j++){
    for(var k=0;k<arguments[j].length;k++)
    {
      if(finalArray.indexOf(arguments[j][k])===-1){
        finalArray.push(arguments[j][k]);
      }
    }
  }
  
  return finalArray;
}

uniteUnique([1, 3, 2], [5, 2, 1, 4], [2, 1]);
//output [1,3,2,5,4]
