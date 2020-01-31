/* -----------------------------------------------------
Student: Josh Hickman - hickmanjv
Student ID: 10236503
Assignment: Lab 4
    b-lab4.c 

----------------------------------------------------- */

#include <stdio.h>
#include <stdlib.h>

/* ============================
 Declaring struct data type
 =========================== */

typedef struct instructor
{
    float average_gpa;
    float average_rating;
    char *name;
}Instructor;


/* ===========================
 Function Prototypes
 ========================== */

Instructor* read_data(char*, int);
Instructor* merge_sort(Instructor*, int, int);
void merge(Instructor*, int, int, int);
int binary_search(Instructor*, int, int, float);
void print_data(Instructor*, int);
int is_equal(float, float);

/* ===============================================
 Function: main()


 =============================================== */

int main(int argc, char **argv)
{
    if(argc != 3)
    {
        puts("Invalid number of command line arguements!\n");
        puts("<a.out> <# of instructors> <input-1.txt>\n\n");
        return 1;
    }

    int num = 0, index = -1;
    float rating = -1;

    num = atoi(argv[1]);

    Instructor *inst;
        
    inst = read_data(argv[2], num);
    puts("\nUnsorted list\n");
    print_data(inst, num);

    inst = merge_sort(inst, 0, num - 1);
    puts("\n\nSorted with Merge Sort\n");
    print_data(inst, num);

    puts("What average rating would you like to search for?\n");
    puts("Please enter a rating between 0 and 10: ");
        scanf("%f", &rating);

    index = binary_search(inst, 0, num - 1, rating); 

        if(index != -1)
        {
            printf("%s has an average rating of %.2f that matches your search request!", inst[index].name, inst[index].average_rating);
        }
        else
        {
            puts("There is not an instructor that matches your search.");
        }

   for(int i = 0; i < num; i++)
   {
      free(inst[i].name);
   }

    free(inst);

    return 0;
}

Instructor* read_data(char* inputFile, int size)
{
    FILE *inFile = fopen(inputFile, "r");

        if(inFile == NULL)
        {
            perror("Cannot open input file!\n");
            exit(1);
        }

    int i;
    Instructor *arr = malloc(sizeof(Instructor) * size);
    
    for(i = 0; i < size; i++)
    {
        Instructor temp;
        temp.name = malloc(sizeof(char) * 16);

        fscanf(inFile, "%f%f%s", &(temp.average_gpa), &(temp.average_rating), temp.name);

        arr[i] = temp;;
    }
   
    fclose(inFile);

    return arr;
}

void print_data(Instructor* inst, int size)
{
    int i;

    for(i = 0; i < size; i++)
    {
        printf("\n%.2f %.2f %s\n", inst[i].average_gpa, inst[i].average_rating, inst[i].name);
    }
}

Instructor* merge_sort(Instructor* inst, int left, int r)
{
    if(left < r)
    {
        int m = left + (r - left)/2;

        merge_sort(inst, left, m);
        merge_sort(inst, m+1, r);

        merge(inst, left, m, r);
    }

    return inst;
}

void merge(Instructor *inst, int left, int m, int r)
{
    int i, j, k;
    int n1 = m - left + 1;
    int n2 = r - m;

    Instructor Left[n1], Right[n2];

    for(i = 0; i < n1; i++)
    {
        Left[i] = inst[left + i];
    }
    for(j = 0; j < n2; j++);
    {
        Right[j] = inst[m + 1 + j];
    }

    i = 0;
    j = 0;
    k = left;

    while(i < n1 && j < n2)
    {
        if(Left[i].average_rating <= Right[j].average_rating)
        {
            inst[k] = Left[i];
            i++;
        }
        else
        {
            inst[k] = Right[j];
            j++;
        }

        k++;
    }

    while(i < n1)
    {
        inst[k] = Left[i];
        i++;
        k++;
    }

    while(j < n2)
    {
        inst[k] = Right[j];
        j++;
        k++;
    }
}

int binary_search(Instructor *inst, int l, int r, float value)
{
    if(r >= l)
    {
        int mid = 1 + (r-1)/2;

        if(is_equal(inst[mid].average_rating, value) == 1)
        {
            return mid;
        }
        else if(inst[mid].average_rating > value)
        {
            return binary_search(inst, l, mid - 1, value);
        }
        else
        {
            return binary_search(inst, mid + 1, r, value);
        }
    }

    return -1;
}

int is_equal(float f1, float f2)
{
    float precision = 0.01;

    if((f1 - precision) < f2 && (f1 + precision) > f2)
    {
        return 1;
    }

    return 0;
}
