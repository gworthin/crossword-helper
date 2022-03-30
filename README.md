# crossword-helper

When solving crosswords, you might run into a problem where you don't know the answer the the clue, but you have a couple letters already filled in from other words. Here's an example from the New York Time's Mini Crossword on March 29th, 2022:

<img width="400" alt="Screen Shot 2022-03-29 at 8 22 17 PM" src="https://user-images.githubusercontent.com/102486685/160726946-65229d74-01fb-4909-af16-b78062dd1bcb.png">

The answer is "idea," but if you didn't know that, you could use this program to get the list of words that could possibly fill this space:

<img width="440" alt="Screen Shot 2022-03-29 at 8 23 28 PM" src="https://user-images.githubusercontent.com/102486685/160727042-08949138-29a9-457c-9b08-db8c114063b0.png">

The user types in the letters they know, with question marks in place of the blank spaces. The program outputs a list of all words in the English language that could fit that space. 

Another example:

<img width="996" alt="Screen Shot 2022-03-29 at 8 25 39 PM" src="https://user-images.githubusercontent.com/102486685/160727240-bf1b580b-f8f1-4487-af74-5949f894ec0f.png">

The **allwords.txt** file contains a list of all words in the English language. The **CrosswordHelper.java** file is a class with two methods, findWords, which takes a string with ?s representing blanks and returns of a list of all words that could be played in that space, and the main method, which handles user input and prints the list of words.
