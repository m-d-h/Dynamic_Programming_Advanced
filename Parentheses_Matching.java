import java.util.Scanner ;
import java.lang.*;
import java.util.Arrays ;

class Parentheses_Matching
{

    public static long[][] min_arr  ;
    public static long[][] max_arr  ;
    public static long a ;
    public static long b ;
    public static long c ;
    public static long d ;
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in) ;

        String str = scan.nextLine() ;

        int numbers_size = str.length() - (str.length()/2);
        int operations_size = (str.length() - (str.length()/2)) - 1;

        long[] numbers = new long[numbers_size] ;
        char[] operations = new char[operations_size] ;

        int j = 0 ;
        for(int i = 0 ; i < numbers.length ; i++)
        {
            numbers[i] = Long.parseLong(String.valueOf(str.charAt(j)));
            //System.out.print("  " + numbers[i]) ;
            j = j+2 ;
        }
        //System.out.println();

        j = 1 ;
        for(int i = 0 ; i < operations.length ; i++)
        {
            operations[i] = str.charAt(j) ;
            //System.out.print("  " + operations[i]) ;
            j = j+2 ;
            
        }

        System.out.println(Maximum_Value_of_the_Expression(numbers, operations));

        
    }

    public static long Maximum_Value_of_the_Expression(long[] numbers , char[] operations)
    {
        
        Parentheses_Matching.min_arr = new long[numbers.length][numbers.length] ;
        Parentheses_Matching.max_arr = new long[numbers.length][numbers.length] ;
        

        for(int i = 0 ; i < numbers.length ; i++)
        {
            Parentheses_Matching.min_arr[i][i] = numbers[i] ;
        }

        for(int i = 0 ; i < numbers.length ; i++)
        {
            Parentheses_Matching.max_arr[i][i] = numbers[i] ;
        }
        

        int k = 0 ;
        for(int s = 0 ; s < numbers.length  ; s++)
        {
            for(int i = 0 ; i < numbers.length - s  ; i++)
            {
                k = i + s ;
                if( i != k)
                {
                    Parentheses_Matching.min_arr[i][k] = Min_and_Max(i, k, numbers, operations)[0] ; 
                    Parentheses_Matching.max_arr[i][k] = Min_and_Max(i, k, numbers, operations)[1] ; 
                    //System.out.println(i + " " + k) ;
                }
               
            }

        }
      
      /*
      for(int l = 0 ; l < numbers.length ; l++)
      {
          for(int m = 0 ; m < numbers.length ; m++)
          {
              System.out.print("     " + Parentheses_Matching.max_arr[l][m]);
          }
          System.out.println() ;
      }
      */


      return  (Parentheses_Matching.max_arr[0][(numbers.length - 1)]);
      

    }

    public static long[] Min_and_Max(int i , int j , long[] numbers , char[] operations)
    {
        long[] arr = {1000000,-1000000}  ; //min,max

        
        for(int k = i ; k < j ; k++)
        {
            Parentheses_Matching.a = eval(Parentheses_Matching.max_arr[i][k] , operations[k] , Parentheses_Matching.max_arr[k+1][j]);
            Parentheses_Matching.b = eval(Parentheses_Matching.max_arr[i][k] , operations[k] , Parentheses_Matching.min_arr[k+1][j]);
            Parentheses_Matching.c = eval(Parentheses_Matching.min_arr[i][k] , operations[k] , Parentheses_Matching.max_arr[k+1][j]);
            Parentheses_Matching.d = eval(Parentheses_Matching.min_arr[i][k] , operations[k] , Parentheses_Matching.min_arr[k+1][j]);

            long[] arr_temp1_for_min  = {arr[0] , Parentheses_Matching.a , Parentheses_Matching.b , Parentheses_Matching.c , Parentheses_Matching.d} ;
            long[] arr_temp2_for_max  = {arr[1] , Parentheses_Matching.a , Parentheses_Matching.b , Parentheses_Matching.c , Parentheses_Matching.d} ;

            Arrays.sort(arr_temp1_for_min) ;
            Arrays.sort(arr_temp2_for_max) ;

            arr[0] = arr_temp1_for_min[0] ; //min
            arr[1] = arr_temp2_for_max[4] ; //max
        }
        

       

       

        

        

        //System.out.println("Minimum"  + arr[0]);
        //System.out.println("Maximum"  + arr[1]);

        return arr ;

    }

    private static long eval(long a, char op , long b ) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

}