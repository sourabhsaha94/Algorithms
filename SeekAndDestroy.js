/*You will be provided with an initial array (the first argument in the destroyer function), followed by one or more arguments.
Remove all elements from the initial array that are of the same value as these arguments.*/

function destroyer(arr) {
  // Remove all the values
  for(var i=1;i<arguments.length;i++){
    arr = arr.filter(removeElements,arguments[i]);
  }
  return arr;
}

function removeElements(value){
  "use strict"; //this makes the "this" object not behave as an "object" but as a number
  return value!==this;
}

destroyer([1, 2, 3, 1, 2, 3], 2, 3);
//output [1,1]
