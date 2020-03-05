import java.util.Scanner;

class Knapsack_Discrete_without_Repetitions
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in) ;

        int Total_Weight = scan.nextInt();

        int size  = scan.nextInt() ;

        int[] values = new int[size] ;
        int[] weights = new int[size] ;

        for(int i = 0 ; i < size ; i++)
        {
            values[i] =  weights[i] = scan.nextInt();
            
        }

        System.out.println(""+max_value(values, weights, Total_Weight));

        //max_value(values, weights, Total_Weight);
    }

    public static int max_value(int[] values, int[] weights , int Total_Weight)
    {
        //System.out.println("Values.length  " + values.length) ;

        //System.out.println("Values.length  " + Total_Weight) ;


        int[][] arr = new int[values.length+1][Total_Weight+1] ;

        int[] values_new = new int[values.length+1];
        int[] weights_new = new int[weights.length+1];

        for(int i = 1 ; i < values_new.length ; i++)
        {
            values_new[i] = values[i-1] ;
            weights_new[i] = weights[i-1]; 
        }



        //arr[3][7] = 10;

        
        for(int i = 1 ; i <= values.length ; i++)
        {
            for(int j = 1 ; j <= Total_Weight ; j++)
            {
                int val =  arr[i-1][j] ;
                if( weights_new[i] <= j )
                {
                    int temp_val = arr[i-1][j - weights_new[i]] + values_new[i];
                    if(temp_val > val)
                    {
                        val = temp_val ;
                    }
                }
                arr[i][j] = val ;
            }
        }

        
        /*for(int i = 0 ; i <= values.length ; i++)
        {
            for(int j = 0 ; j <= Total_Weight ; j++ )
            {
                System.out.print("   " + arr[i][j]);
            }
            System.out.println();
        }*/

        return arr[values.length][Total_Weight] ;
        
    }



}