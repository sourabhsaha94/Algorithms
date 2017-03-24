
function reverseString(str) {
  var splitArray = [];
  splitArray = str.split('');//to get each character
  splitArray.reverse();
  str = splitArray.join('');
  return str;
}

reverseString("hello");
