#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

#include <readline/readline.h>
#include <readline/history.h>


/*--- Day 1: Not Quite Lisp ---

Santa was hoping for a white Christmas, but his weather machine's "snow" function is powered by stars, and he's fresh out! To save Christmas, he needs you to collect fifty stars by December 25th.

Collect stars by helping Santa solve puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

Here's an easy puzzle to warm you up.

Santa is trying to deliver presents in a large apartment building, but he can't find the right floor - the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows the instructions one character at a time.

An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.

The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.

For example:
(()) and ()() both result in floor 0.
((( and (()(()( both result in floor 3.
))((((( also results in floor 3
()) and ))( both result in floor -1 (the first basement level).
))) and )())()) both result in floor -3.

To what floor do the instructions take Santa?

*/

#define STRINGLENGTH 10000


char **parseCommand(char *command);
int getNumberOfTokens(char *command); 
int countParentheses(char *command);


int main(){
	
    //printf("Hello World\n");

    char *command;  

    while(1){ 
      // 1. Print prompt   
      command = readline("Enter ()s\n");
      //Ctrl-d (EOF) will exit the shell 
      if(command == NULL){
         printf("\n");
	 break;
      }

      int count = countParentheses(command); 
      printf("\n");
      printf("Count is %d\n",count);

      free(command);	       

   }


}

void freeParseCommand(char **tokens,int tokenNum){

      for(int i = 0;i<tokenNum;i++){
         free(tokens[i]);
      }

      free(tokens);

}

int countParentheses(char *command){
   int count = 0;
   int i = 0;
   while(command[i] != NULL){

      if(command[i] == '('){
	 printf("+1\n");
         count++;
      } else if(command[i] == ')'){
	 printf("-1\n");
         count--;
      }
      i++;
   }
   return count;


}






