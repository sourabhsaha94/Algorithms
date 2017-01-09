
function factorialize(num) {
  
  var fact = num-1;
  if(num===0)
    return 1;

  while(fact>0){
    num = num*fact;
    fact--;
  }
  return num;
}

factorialize(5);
