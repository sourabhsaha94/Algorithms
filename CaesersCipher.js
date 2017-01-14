/*One of the simplest and most widely known ciphers is a Caesar cipher, also known as a shift cipher. 
In a shift cipher the meanings of the letters are shifted by some set amount.
A common modern use is the ROT13 cipher, where the values of the letters are shifted by 13 places. Thus 'A' ↔ 'N', 'B' ↔  'O' and so on.
Write a function which takes a ROT13 encoded string as input and returns a decoded string.*/

function rot13(str) { // LBH QVQ VG!
  
  var decodedArray = [];
  var newIndex;
  
  
  for(var i=0;i<str.length;i++){
    if(str.charCodeAt(i)>=65 && str.charCodeAt(i)<=92){
      newIndex = (str.charCodeAt(i)-65);
      newIndex = (newIndex+13)%26;
      newIndex = newIndex+65;
      decodedArray.push(String.fromCharCode(newIndex));
    }
    else{
      decodedArray.push(str[i]);
    }
  }
  
  return decodedArray.join("");
}

// Change the inputs below to test
rot13("SERR PBQR PNZC");
//output "FREE CODE CAMP"
