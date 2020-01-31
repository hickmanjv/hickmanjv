/* ------------------------------------------------------------
Student: Josh Hickman - hickmanjv
StudentID: 10236503
Assignment: Lab 6
    Program to demonstrate recursion principles using the 
    Towers of Hanoi as a template to move a linked list 
    between 3 different stacks
----------------------------------------------------------- */

#include <stdio.h>
#include <stdlib.h>

/* =============================
 Struct data type declaration
============================= */
typedef struct disk
{
    int disk_size;
    struct disk* next;
    struct disk* prev;
}disk;

/* ===========================
Function Prototypes
=========================== */
void push(disk**, disk*);
disk* pop(disk**);
void move_stack(int, disk**, disk**, disk**);
disk* return_tail(disk*);
void print_game(disk*, disk*, disk*, int);
disk* init_game(int);
void free_mem(disk*);

/* ================================================================
Function: main()
    - A function that checks command line arguements to ensure
    the user includes the number of disks from the command line
    and that the number of disks isn't very large. Initializes
    the 3 different stacks for the game and calls the functions
    that setup, print and moved the nodes that represent The
    Tower of Hanoi
================================================================ */
int main (int argc, char **argv)
{
    if(argc != 2)
    {
        puts("IMPROPER COMMAND LINE ARGUMENTS!");
        puts("<a.out> <# number of disks only between 3 to 9>");
        return 1;
    }

    int size = 0;
    size = atoi(argv[1]);

    if(size < 3 || size > 9)
    {
        puts("IMPROPER NUMBER OF DISKS!");
        puts("DISK NUMBER MUST BE BETWEEN 3 AND 9 INCLUSIVE!");
        return 2;
    }

    disk *head = NULL, *stack1 = NULL, *stack2 = NULL, *stack3 = NULL;// *pop_disk = NULL;

    head = init_game(size);
    stack1 = head;
    
    print_game(stack1, stack2, stack3, size);

    /*// Test to see if pop function works
    puts("Testing pop function");

    for(int i = 0; i < size; i++)
    {
        pop_disk = pop(&stack1);
        printf("\n%d\n", (pop_disk->disk_size));
    }// end test */

    move_stack(size, &stack1, &stack2, &stack3);

    print_game(stack1, stack2, stack3, size);

    free_mem(head);

    return 0;

}

/* =============================================
Function: return_tail()
    - A function that will return a pointer to 
      the top of a stack
============================================= */
disk* return_tail(disk* stack)
{
    disk *temp = stack;
    
    if(temp != NULL)
    {
        while(temp->next != NULL)
        {
            temp = temp->next;
        }
    }

    return temp;
}

/* ==============================================================
Function: print_game()
    - A function that will print output to the screen in the
    format that will resemble the Towers of Hanoi
============================================================== */
void print_game(disk* stack_one, disk* stack_two, disk* stack_three, int num_disks)
{
    disk *temp_one = return_tail(stack_one);
    disk *temp_two = return_tail(stack_two);
    disk *temp_three = return_tail(stack_three);

    char arr_one[num_disks];
    char arr_two[num_disks];
    char arr_three[num_disks];

    int i;

    for(i = 0; i < num_disks; i++)
    {
        if(temp_one != NULL)
        {
            arr_one[i] = temp_one->disk_size + '0';
            temp_one = temp_one->prev;
        }
        else
        {
            arr_one[i] = '-';
        }

        if(temp_two != NULL)
        {
            arr_two[i] = temp_two->disk_size + '0';
            temp_two = temp_two->prev;
        }
        else
        {
            arr_two[i] = '-';
        }

        if(temp_three != NULL)
        {
            arr_three[i] = temp_three->disk_size + '0';
            temp_three = temp_three->prev;
        }
        else
        {
            arr_three[i] = '-';
        }
    }
    printf("\n");

    for(i = 0; i <= num_disks -1; i++)
    {
        printf(" %c %c %c \n", arr_one[i], arr_two[i], arr_three[i]);
    }

    printf("___________\n\n");
}

/* ======================================================
Function: init_game()
    - A function that will initialize the first
    stack in Towers of Hanoi with the number of disks 
    being the number entered from the command line
====================================================== */
disk* init_game(int num_disks)
{
    disk *head = NULL;

    int i;

    for(i = num_disks; i > 0; i--)
    {
        disk *new_disk = malloc(sizeof(disk));
        new_disk->disk_size = i;
        new_disk->next = NULL;
        new_disk->prev = NULL;

        push(&head, new_disk);
    }

    return head;
}

/* =====================================================
Function: push()
    - A function to push a node onto a stack, used
    inside the init_game() and move_stack() functions
===================================================== */
void push(disk** head, disk* new_disk)
{
    if(head == NULL)
    {
        *head = new_disk;        // pushes the first disk on the stack
    }
    else
    {
       new_disk->prev = *head; 
       *head = new_disk;         
    }
}

/* ===================================================
Function: pop()
    - A function to remove a node from the top of a
    stack, make the previous node the new head and 
    returns the node that was popped off
=================================================== */
disk* pop(disk** stack)
{
    disk *temp = *stack;

    if(temp)
    {
        *stack = temp->prev;
    }

    return temp;
}

/* ===========================================================
Function: move_stack()
    - A function that pops and pushes node to different
    stacks without putting a 'larger' node on top of a
    smaller one. This function recursively moves all of the
    nodes from the first stack to the last
=========================================================== */
void move_stack(int level, disk** from, disk** to, disk** spare)
{
    if(level > 0)       // condition for stopping recursive call
    {
        
        move_stack((level - 1), from, spare, to);
            
            disk *pop_disk = pop(from);
            push(spare, pop_disk);
       
        move_stack((level - 1), to, from, spare);
    }
        
}

/* ============================================
Function: free_mem()
    - A function to free all of the malloc'd
    nodes created for the game
============================================ */
void free_mem(disk* head)
{
    while(head->prev != NULL)
    {
        disk* temp = head;
        head = head->prev;
        free(temp);
    }

    free(head);
}
