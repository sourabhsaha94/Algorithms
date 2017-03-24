
function findLongestWord(str) {
  
  var strArray = str.split(' ');
  
  var lengthArray = [];
  
  for(var i=0;i<strArray.length;i++){
    lengthArray.push(strArray[i].length);
  }
  
  var longestLength = lengthArray[0];
  
  for(var i=0;i<lengthArray.length;i++){
    if(longestLength<lengthArray[i])
      longestLength = lengthArray[i];
  }
  
  return longestLength;
}
