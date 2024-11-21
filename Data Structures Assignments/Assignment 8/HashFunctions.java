
import java.util.Scanner;

public class HashFunctions{
    public static void main(String[] args) {
        // create scanner for user input
        Scanner input = new Scanner(System.in);
        // create keys array
        int[] keys = {  1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                        5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                        5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                        5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                        5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523  };
        // create table 2d array
        int[][] table = new int[50][2];

        while(true){
            try{
                // display menu
                System.out.println("\n-----MAIN MENU--------------------------------------\r\n" + //
                                        "1. Run HF1 (Division method with Linear Probing)\r\n" + //
                                        "2. Run HF2 (Division method with Quadratic Probing)\r\n" + //
                                        "3. Run HF3 (Division method with Double Hashing)\r\n" + //
                                        "4. Run HF4 (Student Designed HF)\r\n" + //
                                        "5. Exit program\r\n\n" + //
                                        "Enter option number: ");
                // read user input
                int option = Integer.parseInt(input.nextLine());
                System.out.println();
                // run hash function 1 and print table
                if(option == 1){
                    HF1(table, keys);
                    printTable(table);
                }
                // run hash function 2 and print table
                else if(option == 2){
                    HF2(table, keys);
                    printTable(table);
                }
                // run hash function 3 and print table
                else if(option == 3){
                    HF3(table, keys);
                    // note that the unhashed values print above the table
                    printTable(table);
                }
                // run hash function 4 and print table
                else if(option == 4){
                    HF4(table, keys);
                    printTable(table);
                }
                // break from loop
                else if(option == 5){
                    break;
                }
                // print if invalid input
                else{
                    System.out.println("Invalid input");
                }
            }
            // catch exceptions from user input
            catch(Exception e){
                System.out.println("Invalid input");
            }
        }
        input.close();
    }
    // method to sum probes after a hash function
    public static int sumProbes(int[][] table){
        int sum = 0;
        for(int i = 0; i < table.length; i++){
            sum += table[i][1];
        }
        return sum;
    }
    // method to display the table
    public static void printTable(int[][] table){
        System.out.println("Index   Key    Probes");
        System.out.println("------------------------");
        for(int i = 0; i < table.length; i++){
            // formatting to align the table entries
            System.out.printf("%3d     %-8d %d%n", i, table[i][0], table[i][1]);
        }
        System.out.println("------------------------");
        // print total number of probes
        System.out.println("\nSum of Probe Values = " + sumProbes(table) + " probes.");
    }
    // clears the table for each use
    public static void clearTable(int[][] table){
        for(int i = 0; i < table.length; i++){
            table[i][0] = 0;
            table[i][1] = 0;
        }
    }
    // division method and linear probing
    public static void HF1(int[][] table, int[] keys){
        clearTable(table);
        int size = table.length;
        for(int i = 0; i < keys.length; i++){
            int numProbes = 0;
            int key = keys[i];
            // division method with table index starting at 0 
            int hf = key % size;
            int newIndex = hf;
            int j = 0;
            // continue with linear probing until there is an empty space
            while(table[newIndex][0] != 0){
                numProbes++;
                j++;
                newIndex = (hf + j) % size;
            }
            table[newIndex][0] = key;
            table[newIndex][1] = numProbes;
        }
    }
    // division method and quadratic probing
    public static void HF2(int[][] table, int[] keys){
        clearTable(table);
        int size = table.length;
        for(int i = 0; i < keys.length; i++){
            int numProbes = 0;
            int key = keys[i];
            // division method with table index starting at 0
            int hf = key % size;
            int newIndex = hf;
            int j = 0;
            // continue with quadratic probing until there is an empty space
            while(table[newIndex][0] != 0){
                numProbes++;
                j++;
                newIndex = (hf + j * j) % size;
            }
            table[newIndex][0] = key;
            table[newIndex][1] = numProbes;
        }
    }
    // division method with double hashing
    public static void HF3(int[][] table, int[] keys){
        clearTable(table);
        int size = table.length;
        for(int i = 0; i < keys.length; i++){
            int numProbes = 0;
            int key = keys[i];
            // divison method with table index starting at 0
            int hf = key % size;
            // double hashing function
            int hf2 = 30 - key % 25;
            int newIndex = hf;
            int j = 0;
            int tryCount = 0;
            // continue with double hashing until there is an empty space
            while(table[newIndex][0] != 0){
                numProbes++;
                j++;
                newIndex = (hf + j * hf2) % size;
                tryCount++;
                // if the number of tries is 50 or more, continue to the next key
                if(tryCount >= 50){
                    // this prints above the table when the output is displayed
                    System.out.println("Unable to hash key " + key + " to the table");
                    break;
                }
            }
            // if a space was found within 50 tries, add the key
            if(tryCount < 50){
                table[newIndex][0] = key;
                table[newIndex][1] = numProbes;
            }
        }
    }
    // custom hash function; 67 probes and 0 unhashed
    public static void HF4(int[][] table, int[] keys){
        clearTable(table);
        int size = table.length;
        for(int i = 0; i < keys.length; i++){
            int numProbes = 0;
            int key = keys[i];
            // square of the key with the last 2 digits truncated % size to keep it in bound
            // i tried a few hash functions with mid square and folding, but i had better outcomes with this
            int hf = (int)(key * key / 100) % size;
            int newIndex = hf;
            int j = 0;
            while(table[newIndex][0] != 0){
                numProbes++;
                // these were the best numbers I could find after some testing
                // i tested lots of numbers, found that primes worked the best, then tweaked them until i hit the lowest probe count
                newIndex = (hf * 13 + j * 3 + 11) % size;
                j++;
            }
            table[newIndex][0] = key;
            table[newIndex][1] = numProbes;
        }
    }
}