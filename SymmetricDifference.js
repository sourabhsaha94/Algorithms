/*Compare two arrays and return a new array with any items only found in one of the two given arrays, but not both. 
In other words, return the symmetric difference of the two arrays.*/


function diffArray(arr1, arr2) {
  var newArr = [];
 
  arr1.forEach(function(item){
    
    if(arr2.indexOf(item)<0 && newArr.indexOf(item)<0)
      newArr.push(item);
    
  });
  
  arr2.forEach(function(item){
    
    if(arr1.indexOf(item)<0 && newArr.indexOf(item)<0)
      newArr.push(item);
    
  });
  
  return newArr;
}

diffArray([1, 2, 3, 5], [1, 2, 3, 4, 5]);
//output [4]
