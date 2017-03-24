
function confirmEnding(str, target) {
  
  var targetLength = target.length;
  
  var endsWithString = str.substr(-targetLength);
  
  if(target === endsWithString)
    return true;
  else
    return false;
}

confirmEnding("Bastian", "n");
//output true
