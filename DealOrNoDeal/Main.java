import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        int[] cases = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        int[] caseValues = {1,2,5,10,25,50,75,100,200,300,400,500,750,1000,5000,10000,25000,
                50000,75000,100000,200000,300000,400000,500000,750000,1000000};

        int index, temp;
        Random random = new Random();
        for (int i = caseValues.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = caseValues[index];
            caseValues[index] = caseValues[i];
            caseValues[i] = temp;
        }

        System.out.println("Welcome To \"DEAL OR NO DEAL!\"");
        System.out.println("Select the case that you would like:");
        System.out.println(Arrays.toString(cases));

        int myCase = sc.nextInt();
        int myCaseValue = caseValues[findIndex(cases, myCase)];
        cases = removeCase(cases, myCase);
        caseValues = removeCase(caseValues, myCaseValue);
        System.out.println(Arrays.toString(cases));

        System.out.println("Select 6 cases to remove.");
        for (int i=0; i<6; i++) {
            System.out.println("Enter one at a time:");
            int caseTemp = sc.nextInt();
            int caseValueTemp = caseValues[findIndex(cases, caseTemp)];
            System.out.println("The value was $" + caseValueTemp);
            cases = removeCase(cases, caseTemp);
            caseValues = removeCase(caseValues, caseValueTemp);
            System.out.println(Arrays.toString(cases));
        }
        double bankerOffer = banker(myCaseValue, caseValues);
        System.out.println("The banker is offering you $" + bankerOffer);
        System.out.println("Deal or No Deal");
        String deal = sc2.nextLine();

        if (deal.equalsIgnoreCase("No Deal")) {
            System.out.println("Select 5 cases to remove.");
            for (int i=0; i<5; i++) {
                System.out.println("Enter one at a time:");
                int caseTemp = sc.nextInt();
                int caseValueTemp = caseValues[findIndex(cases, caseTemp)];
                System.out.println("The value was $" + caseValueTemp);
                cases = removeCase(cases, caseTemp);
                caseValues = removeCase(caseValues, caseValueTemp);
                System.out.println(Arrays.toString(cases));
            }

            bankerOffer = banker(myCaseValue, caseValues);
            System.out.println("The banker is offering you $" + bankerOffer);
            System.out.println("Deal or No Deal");
            deal = sc2.nextLine();

            if (deal.equalsIgnoreCase("No Deal")) {
                System.out.println("Select 4 cases to remove.");
                for (int i=0; i<4; i++) {
                    System.out.println("Enter one at a time:");
                    int caseTemp = sc.nextInt();
                    int caseValueTemp = caseValues[findIndex(cases, caseTemp)];
                    System.out.println("The value was $" + caseValueTemp);
                    cases = removeCase(cases, caseTemp);
                    caseValues = removeCase(caseValues, caseValueTemp);
                    System.out.println(Arrays.toString(cases));
                }

                bankerOffer = banker(myCaseValue, caseValues);
                System.out.println("The banker is offering you $" + bankerOffer);
                System.out.println("Deal or No Deal");
                deal = sc2.nextLine();

                if (deal.equalsIgnoreCase("No Deal")) {
                    System.out.println("Select 3 cases to remove.");
                    for (int i=0; i<3; i++) {
                        System.out.println("Enter one at a time:");
                        int caseTemp = sc.nextInt();
                        int caseValueTemp = caseValues[findIndex(cases, caseTemp)];
                        System.out.println("The value was $" + caseValueTemp);
                        cases = removeCase(cases, caseTemp);
                        caseValues = removeCase(caseValues, caseValueTemp);
                        System.out.println(Arrays.toString(cases));
                    }

                    bankerOffer = banker(myCaseValue, caseValues);
                    System.out.println("The banker is offering you $" + bankerOffer);
                    System.out.println("Deal or No Deal");
                    deal = sc2.nextLine();

                    if (deal.equalsIgnoreCase("No Deal")) {
                        System.out.println("Select 2 cases to remove.");
                        for (int i=0; i<2; i++) {
                            System.out.println("Enter one at a time:");
                            int caseTemp = sc.nextInt();
                            int caseValueTemp = caseValues[findIndex(cases, caseTemp)];
                            System.out.println("The value was $" + caseValueTemp);
                            cases = removeCase(cases, caseTemp);
                            caseValues = removeCase(caseValues, caseValueTemp);
                            System.out.println(Arrays.toString(cases));
                        }

                        bankerOffer = banker(myCaseValue, caseValues);
                        System.out.println("The banker is offering you $" + bankerOffer);
                        System.out.println("Deal or No Deal");
                        deal = sc2.nextLine();

                        for (int i=0; i<4; i++) {
                            if (deal.equalsIgnoreCase("No Deal")) {
                                System.out.println("Select 1 case to remove.");
                                System.out.println("Enter one at a time:");
                                int caseTemp = sc.nextInt();
                                int caseValueTemp = caseValues[findIndex(cases, caseTemp)];
                                System.out.println("The value was $" + caseValueTemp);
                                cases = removeCase(cases, caseTemp);
                                caseValues = removeCase(caseValues, caseValueTemp);
                                System.out.println(Arrays.toString(cases));

                                bankerOffer = banker(myCaseValue, caseValues);
                                System.out.println("The banker is offering you $" + bankerOffer);
                                System.out.println("Deal or No Deal");
                                deal = sc2.nextLine();
                            }
                            else if (deal.equalsIgnoreCase("Deal")) {
                                System.out.println("Congratulations! You won $" + bankerOffer);
                            }
                            else {
                                System.out.println("Error. Wrong input.");
                            }
                        }

                        if (deal.equalsIgnoreCase("No Deal")) {
                            System.out.println("Would you like to keep or swap?");
                            String swap = sc2.nextLine();
                            if (swap.equalsIgnoreCase("swap")) {
                                System.out.println("Congratulations! You won $" + caseValues[0]);
                            }
                            else if (swap.equalsIgnoreCase("keep")) {
                                System.out.println("Congratulations! You won $" + myCaseValue);
                            }
                            else {
                                System.out.println("Error. Wrong Input.");
                            }
                        }
                        else if (deal.equalsIgnoreCase("Deal")) {
                            System.out.println("Congratulations! You won $" + bankerOffer);
                        }
                        else {
                            System.out.println("Error. Wrong input.");
                        }
                    }
                    else if (deal.equalsIgnoreCase("Deal")) {
                        System.out.println("Congratulations! You won $" + bankerOffer);
                    }
                    else {
                        System.out.println("Error. Wrong input.");
                    }
                }
                else if (deal.equalsIgnoreCase("Deal")) {
                    System.out.println("Congratulations! You won $" + bankerOffer);
                }
                else {
                    System.out.println("Error. Wrong input.");
                }
            }
            else if (deal.equalsIgnoreCase("Deal")) {
                System.out.println("Congratulations! You won $" + bankerOffer);
            }
            else {
                System.out.println("Error. Wrong input.");
            }
        }
        else if (deal.equalsIgnoreCase("Deal")) {
            System.out.println("Congratulations! You won $" + bankerOffer);
        }
        else {
            System.out.println("Error. Wrong input.");
        }
    }

    public static int[] removeCase(int[] arr, int num) {
        int[] arr2 = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (arr[i] != num) {
                arr2[k] = arr[i];
                k++;
            }
        }
        return arr2;
    }

    public static double banker(int strayCaseValue, int[] arr) {
        double sumOfSquares = Math.pow(strayCaseValue, 2);
        for (int i=0; i < arr.length; i++) {
            sumOfSquares += Math.pow(arr[i], 2);
        }
        double RMS = Math.sqrt(sumOfSquares/(arr.length+1))/3;
        return Math.round(RMS * 100.0) / 100.0;
    }

    public static int findIndex(int[] arr, int t)
    {

        // if array is Null
        if (arr == null) {
            return -1;
        }

        // find length of array
        int len = arr.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
}