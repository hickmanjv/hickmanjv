/*****************************************************************
 * Name: Josh Hickman
 * Pawprint: hickmanjv
 * Assignment: Programming Assignment 3
 * - Program to take in a sequence of integers based on floors
 *   in a building, starting floor, destination floor, number of
 *   floors an up press will go, number of floors a down press
 *   will go. Print out shortest number of button presses it takes
 *   to get to target floor, or if unable to reach target let the
 *   user know. 
 *******************************************************************/

#include <stdio.h>
#include <stdlib.h>
#define MAX 202

int queue[MAX];
int f, s, g, u, d;

/********************************************
 Function Prototypes
 ********************************************/
void elevator();

/*****************************************************
 Function: main
  - Function to take input from the user and call
    elevator function
 *****************************************************/
int main(int argc, char** argv) {
    
    printf("Input: ");
    scanf("%d %d %d %d %d", &f, &s, &g, &u, &d);
    
    while(f > 100 || s < 1 || g > f || u < 0 || d > 100)
    {
        printf("Error! Please enter appropriate values for input...\n\n");
        
        printf("Input: ");
        scanf("%d %d %d %d %d", &f, &s, &g, &u, &d);
    }
    
    elevator();
    
    return (EXIT_SUCCESS);
}

/*****************************************************************
 Function: elevator
  - Function that contains the elevator movement logic
 * Note * - It seems trivial, but the requirements for the
 *          program didn't mention to use Stacks, Queues, or BFS.
 *          Seemed excessive for this problem, based on examples
 *          I found.
 *****************************************************************/

void elevator(){
    
    int current = s;
    int i = 1, length = 0;
    
    if(f == s || s == g)
    {
        printf("\nNo elevator needed, you are on your destination floor!");
        return;
    }
    else if((u == 0 && g != s) || (d == 0 && g != s))
    {
        printf("use the stairs");
        return;
    }
    else if((u % 2 == 0 && d % 2 == 0 && g % 2 == 1))
    {
        printf("use the stairs");
        return;
    }
    
    while(current < g)
    {
        queue[i] = current;
        i++;
        length++;
        current += u;
    }
    
    if(current == g){
        queue[i] = g;
        length++;
        
        for(i = 1; i < length; i++)
        {
            printf("%d -> ", queue[i]);
        }
        
        printf("%d", queue[i]);
        return;
    }
    
    while(current > g)
    {
        queue[i] = current;
        i++;
        length++;
        current -= d;
        
        if(current < g)
        {
            printf("use the stairs");
            return;
        }
        
    }
    
    if(current == g){
        queue[i] = g;
        length++;
        
        for(i = 1; i < length; i++)
        {
            printf("%d -> ", queue[i]);
        }
        
        printf("%d", queue[i]);
        return;
    }
      
}
