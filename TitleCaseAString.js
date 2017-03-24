
function titleCase(str) {
  
  var stringArray = str.split(' ');
  
  var length = stringArray.length;
  
  while(length>0){
    var stringToChange = stringArray.shift().toLowerCase();
    stringToChange = stringToChange.charAt(0).toUpperCase()+stringToChange.slice(1);
    stringArray.push(stringToChange);
    length--;
  }
  
  var strNew = stringArray.join(' '); 
  
  return strNew;
}

titleCase("I'm a little tea pot");
//output I'm A Little Tea Pot
