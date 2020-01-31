/* ------------------------------------------
Student: Josh Hickman - hickmanjv
Student ID: 10236503
Assignment: Lab 2 Section B
------------------------------------------ */

#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int vin_num;
    float mileage;
    char *color;
}Car;
:q
:
Car* read_data(int);
Car* sort_garage(Car*, int);
void print_garage(Car*, int);
int is_VIN(Car*, int);
int save_garage(Car*, int, char*);

/*==================================================



================================================= */

int main(int argc, char **argv)
{
    if(argc != 3)
           {
                printf("Incorrect number of command line arguements\n");
                printf("Should include number of cars and an output file\n\n");
                return 1;
           }

    int i, num_cars = 0, choice = -1, vin = -1; //sort = 0;
    Car *carPtr;
    FILE *filePtr
    num_cars = atoi(argv[1]);

    carPtr = read_data(num_cars);
    print_garage(carPtr, num_cars);

    printf("Would you like to search for a VIN number?\n");
    printf("Please enter 1 for yes and 0 for no: ");
    scanf("%d", &choice);
       
        while(choice > 1 || choice < 0)
        {
            printf("Invalid choice. Please select 1 for yes and 0 for no: \n");
            scanf("%d", &choice);

        }

        if(1 == choice)
        {
            printf("Please enter a VIN number: ");
            scanf("%d", &vin);
            
            for(i = 0; i < num_cars; i++)
            {
                int temp;
                temp = (is_VIN((carPtr + i), vin));
                 
                    if(temp == 1)
                    {  
                         printf("The vehicle has been found in inventory!\n\n");
                    }
            }

        }

   carPtr = sort_garage(carPtr, num_cars);
   print_garage(carPtr, num_cars);




    for(i = 0; i < num_cars; i++)
    {
        free(carPtr[i].color);
    }
    free(carPtr);

    return 0;
}

Car* read_data(int num_cars)
{
    int i;
    Car *aCar = (Car*)malloc(sizeof(Car) * num_cars);

    for(i = 0; i < num_cars; i++) 
    {
        Car cars;
        cars.color = malloc(sizeof(char) * 9);
        
        printf("\nPlease enter a VIN number: ");
            scanf("%d", &(cars.vin_num));
        printf("Please enter the mileage on the vehicle: ");
            scanf("%f", &(cars.mileage));
        printf("Please enter the color: ");
            scanf("%s", (cars.color));
        printf("\n");

        aCar[i] = cars;
    }

    return aCar;
}

void print_garage(Car* garage, int num_cars)
{
    int i;

    printf("Cars currently in garage:\n\n");

    for(i = 0; i < num_cars; i++)
    {
        printf("VIN number: %d\n", (garage + i)->vin_num);
        printf("Mileage: %.2f\n", (garage + i)->mileage);
        printf("Color: %s\n\n", (garage + i)->color);
    }

}

int is_VIN(Car* vehicle, int VIN)
{
    if(vehicle->vin_num == VIN)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

Car* sort_garage(Car* garage, int num_cars)
{
    int sort = 0, i, j;

    printf("Would you like to sort the output file by VIN number or mileage?\n");
    printf("Please enter 1 for VIN number or 2 for mileage: ");
        scanf("%d", &sort);

        while(sort < 1 || sort > 2)
        {
            printf("Invalid input, enter 1 for VIN and 2 for mileage: ");
                scanf("%d", &sort);
        }

        if(1 == sort)
        {
            for(i = 0; i < num_cars - 1; i++)
            {
                for(j = 0; j < num_cars - i - 1; j++)
                {
                    if((garage[j].vin_num) > ((garage[j+1].vin_num)))
                    {   Car temp;
                        
                        temp.vin_num = garage[j].vin_num;

                        garage[j].vin_num = garage[j+1].vin_num;

                        garage[j+1].vin_num = temp.vin_num;
                    }
                }
            }
        }
        else
        {
            for(i = 0; i < num_cars - 1; i++)
            {
                for(j = 0; j < num_cars - i - 1; j++)
                {
                    if((garage[j].mileage > (garage[j+1].mileage)))
                    {   Car temp;
                        temp.mileage = garage[j].vin_num;
                        garage[j].mileage = garage[j+1].mileage;
                        garage[j+1].mileage = temp.mileage;
                    }
                }
            }
        }

    return garage;
}

Car* sort_garage(Car* garage, int num_cars, *filePtr)
{
    FILE *outputfile;
    int i;

    if((outputfile = fopen(argv[2], "w")) == NULL)
    {
        printf("File could not be opened\n");
    }
    
    for(i = 0; i < num_cars, i++)
    {
        fprintf(outputfile, "VIN number: %d ", garage->vin_num);
        fprintf(outputfile, "Mileage: %.2f ", garage->mileage);
        fprintf(outputfile, "Color: %s ", garage->color);
        fprintf(outputfile, "\n");

    }
}
