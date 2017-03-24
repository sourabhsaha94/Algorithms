
function palindrome(str) {
  
  if(str===undefined)
    return false;
  
  var newStr = str.toLowerCase().replace(/\W+/g,'').replace('_','');  //remove special chars and _
  
  console.log(newStr);
  for(var i=0;i<newStr.length;i++){
    if(newStr[i]!==newStr[newStr.length-1-i])
    {  
      return false;
    }
  }
  
  return true;
}

