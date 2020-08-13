import java.util.Scanner;
 
// Coins
public class Main {
    static void print_config(int[] config){
        int total = config[0]+config[1]+config[2];
        System.out.println(total + " " + config[0]+" "+config[1]+" "+config[2]);
    }
 
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
 
        int[][] first_ten = {{0,0,1},{0,0,2},{0,1,1},{0,1,2},{0,2,1},{0,2,2},{0,3,1},{0,3,2},{1,1,2},{1,2,1}};
 
        int n = scan.nextInt();
 
        if(n<10)
            print_config(first_ten[n-1]);
        else
        {
            int[] config = {0,0,0};
            int counter_five = 0;
            int remainder = 0;
 
            if(n%10 == 0)
            {
                counter_five = (n-10)/5;
                config = first_ten[9];
                config[0]+= counter_five;
            }
            else if(n%10 < 5){
               counter_five = (n-(n%10)-5)/5;
               config = first_ten[n%10+5-1];
               config[0]+= counter_five;
            }
            else if(n%10>=5){
                counter_five = (n-(n%10))/5;
                config = first_ten[n%10-1];
                config[0]+= counter_five;
            }
 
            print_config(config);
        }
 
    }
}




