/*Perform a search and replace on the sentence using the arguments provided and return the new sentence.

First argument is the sentence to perform the search and replace on.

Second argument is the word that you will be replacing (before).

Third argument is what you will be replacing the second argument with (after).

NOTE: Preserve the case of the original word when you are replacing it.
For example if you mean to replace the word "Book" with the word "dog", it should be replaced as "Dog"
*/

function myReplace(str, before, after) {
  
  var stringArray = str.split(' ');
  var newAfter=[];
  var temp='';
  for(var i=0;i<stringArray.length;i++){
    if(stringArray[i].toLowerCase() === before.toLowerCase()){
      
      if(stringArray[i][0]>='A' && stringArray[i][0]<='Z'){
        newAfter = after.split('');
        newAfter[0] = newAfter[0].toUpperCase();
        after = newAfter.join('');
      }
      else if(stringArray[i][0]>='a' && stringArray[i][0]<='z'){
        newAfter = after.split('');
        newAfter[0] = newAfter[0].toLowerCase();
        after = newAfter.join('');
      }
      
      stringArray[i] = after;
      
      break;
    }
  }
  
  temp = stringArray.join(' ');
  
  return temp;
}

myReplace("A quick brown fox Jumped over the lazy dog", "Jumped", "leaped");
//output 
A quick brown fox Leaped over the lazy dog
