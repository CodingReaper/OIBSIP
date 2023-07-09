import java.util.Scanner;

class BankAccount{
    String name;
    String username;
    String password;
    String accountno;
    float bal = 50000f;
    int transactions = 0;
    String transactionhistory = "";

    public void register(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your Name : - ");
        this.name = sc.nextLine();
        System.out.print("\nEnter your UserName : - ");
        this.username = sc.nextLine();
        System.out.print("\nEnter your Password : - ");
        this.password = sc.nextLine();
        System.out.print("\nEnter your AccountNo : - ");
        this.accountno = sc.nextLine();
        System.out.println("\n Registration Completed.You can Login Now...");
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while ( !isLogin ) {
            System.out.print("\nEnter Your Username - ");
            String Username = sc.nextLine();
            if ( Username.equals(username) ) {
                while ( !isLogin ) {
                    System.out.print("\nEnter Your Password - ");
                    String Password = sc.nextLine();
                    if ( Password.equals(password) ) {
                        System.out.print("\nLogin successful!!");
                        isLogin = true;
                    }
                    else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            }
            else {
                System.out.println("\nUsername not found");
            }
        }
        return isLogin;
    }

    public void withdraw(){
        System.out.println("\nEnter Your Amount to Withdraw : - ");
        Scanner sc = new Scanner(System.in);
        float amt = sc.nextFloat();
        try {
            if (bal >= amt){
                transactions++;
                bal -= amt;
                System.out.println("\nWithDraw SuccessFull ");
                String s = "Rs."+ amt + " WithDrawn\n";
                transactionhistory = transactionhistory.concat(s);
            }
            else {
                System.out.println("\nInsufficient Balance");
            }
        }
        catch (Exception e){
            System.out.println("Handled");
        }
    }

    public void deposit(){
        System.out.println("\nEnter amount to deposit : - ");
        Scanner sc = new Scanner(System.in);
        float amt  = sc.nextFloat();
        try {
            if (amt <= 10000f){
                transactions++;
                bal += amt;
                System.out.println("\nSuccessfully Deposited");
                String s = "Rs."+ amt + " Deposited\n";
                transactionhistory = transactionhistory.concat(s);
            }
            else {
                System.out.println("\nLimit is 10000");
            }
        }
        catch (Exception e){
            System.out.println("Handled");
        }
    }

    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter recipient name : -");
        String rec = sc.nextLine();
        System.out.print("\nEnter amount to transfer : -");
        float amt = sc.nextFloat();
        try {
            if (bal >= amt){
                if (amt <= 25000f){
                    transactions++;
                    bal -= amt;
                    System.out.println("Successfully transferred to " + rec);
                    String s = "Rs." + amt + " transferred to" + rec + "\n";
                    transactionhistory = transactionhistory.concat(s);
                }
                else{
                    System.out.println("\n Limit is 25000");
                }
            }
            else {
                System.out.println("\nInsufficient Balance");
            }
        }
        catch (Exception E){
            System.out.print("\nhHANDLED");
        }
    }

    public void checkBalance(){
        System.out.println("\n" + "Rs" + bal);
    }

    public void history(){
        if (transactions == 0){
            System.out.println("\nEmpty");
        }
        else {
            System.out.println("\n" + transactionhistory);
        }
    }
}

public class Main {
    public static int takeIntInput(int lim){
        int inp = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                inp = sc.nextInt();
                flag = true;

                if (flag && inp > lim || inp <1) {
                    System.out.println("Chose between 1 to" + lim);
                    flag = false;
                }
            }
            catch (Exception e){
                System.out.println("Enter only integer value.");
                flag = false;
            }
        }
        return inp;
    }

    public static void main(String[] args){
        System.out.println("\n**********WELCOME TO SBI ATM SYSTEM**********\n");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter Your Choice - ");
        int choice = takeIntInput(2);
        if (choice == 1) {
            BankAccount b = new BankAccount();
            b.register();
            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter Your Choice - ");
                int ch = takeIntInput(2);
                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("\n\n**********WELCOME BACK " + b.name + " **********\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.print("\nEnter Your Choice - ");
                            int c =takeIntInput(6);
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.history();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }
                else {
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }
    }
}
