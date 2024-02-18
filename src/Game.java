import java.util.Scanner;

public class Game {
    private int month;
    private double money;
    private double retirementFunds;
    private final double goal;
    private String name;
    private double rent;
    private double rentInsurance;
    private double streamingService;
    private double internet;
    private double groceries;
    private double dataPlan;
    private double commute;
    private double extraFun;
    private double salary;
    public Game() {
        month = 0;
        money = 0.0;
        name = "";
        goal = 150000;
        retirementFunds = 0.0;
        rent = 1500;
        rentInsurance = 600;
        streamingService = 40;
        internet = 30;
        groceries = 120;
        dataPlan = 20;
        commute = 200;
        extraFun = 150;
        salary = 80000;
    }
    public void welcome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to The Game Of Life!");
        System.out.println("You're starting as a software engineer with a base salary of $80000");
        System.out.println("What's your name, buddy? ");
        name = scanner.nextLine();
        System.out.println("Welcome " + name + ", you'll be simulating your life monthly");
    }
    public void simulate() {
        while (money < goal) {
            choice();
            income();
            System.out.println(summary());
            month++;
        }
        int years = month / 12;
        int months = month & 12;
        System.out.println("------------------------------");
        System.out.println("\nCongrats! You've saved $150000 after " + years + " years and " + months + " months\n");
        System.out.println("Your Current Salary is $" + Math.round(salary * 100.0) / 100.0);
        System.out.println("Your Retirement Funds total to $" + Math.round(retirementFunds * 100.00) / 100.00);
        System.out.println("------------------------------");
        System.out.println("---------------");
        System.exit(130);
    }
    public boolean increasedSalary() {
        double random = Math.random();
        if (month != 0 && month % 12 == 0) {
            if (random < .25) {
                salary *= 1.06;
                return true;
            }
        }
        return false;
    }
    public boolean increasedExpenses() {
        double random = Math.random();
        if (month != 0 && month % 12 == 0) {
            if (random > .70) {
                rent *= 1.04;
                rentInsurance *= 1.04;
                streamingService *= 1.04;
                internet *= 1.04;
                groceries *= 1.04;
                dataPlan *= 1.04;
                commute *= 1.04;
                extraFun += 1.04;
                return true;
            }
        }
        return false;
    }
    public void income() {
        double monthlyIncome  = salary / 12;
        monthlyIncome /= 2;
        retirementFunds += (monthlyIncome * .05);
        monthlyIncome *= .95;
        money += Math.round(monthlyIncome * 100.0) / 100.0;
    }
    public String unwantedChange() {
        double chance = Math.random();
        if (chance < .20) {
            return "The lights exploded and destroyed all your clothes";
        } else if (chance > .20 && chance < .40) {
            return "The toilet broke";
        } else if (chance > .40 && chance < .60) {
            return "The sink and shower stopped producing hot water";
        } else if (chance > .60 && chance < .80) {
            return "A robber broke into your crib and destroyed all your windows";
        } else {
            return "You woke up one day and your bed-frame broke and your mattress was infested with bedbugs";
        }
    }
    public String summary() {
        double random = Math.random();
        String printMessage = "";
        printMessage += "---------------\n";
        printMessage += "Month " + month + ": \n";
        if (increasedSalary()) {
            printMessage += "How Lucky! You received a 6% increase on your salary!\n";
        }
        if (increasedExpenses()) {
            printMessage += "How Unfortunate! Due to inflation all your expenses has increased by 4%!\n";
        }
        rent();
        printMessage += "\n" + "After paying for rent, your balance is $" + money;
        rentInsurance();
        printMessage += "\n" + "After paying for rental insurance, your balance is $" + money;
        streamingService();
        printMessage += "\n" + "After paying for streaming services, your balance is $" + money;
        internet();
        printMessage += "\n" + "After paying for internet, your balance is $" + money;
        groceries();
        printMessage += "\n" + "After paying for groceries, your balance is $" + money;
        dataPlan();
        printMessage += "\n" + "After paying your cell phone plan, your balance is $" + money;
        commute();
        printMessage += "\n" + "After paying for commute, your balance is $" + money;
        extraFun();
        printMessage += "\n" + "After paying spending some money for yourself, your balance is $" + money + "\n";
        if (random < .20) {
            money -= 150;
            money = Math.round(money * 100.0) / 100.0;
            printMessage += unwantedChange() + " you paid $150 to fix the problem, your balance is $" + money + "\n";
        }
        printMessage += "\n---------------";
        return printMessage;
    }
    public void choice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type \"s\" + to (s)imulate");
        String choice = scanner.nextLine();
        while (!choice.equals("s")) {
            choice = scanner.nextLine();
        }
    }
    public void rent() {
        money -= rent;
        money = Math.round(money * 100.0) / 100.0;
    }
    public void rentInsurance() {
        money -= rentInsurance;
        money = Math.round(money * 100.0) / 100.0;
    }
    public void streamingService() {
        money -= streamingService;
        money = Math.round(money * 100.0) / 100.0;
    }
    public void internet() {
        money -= internet;
        money = Math.round(money * 100.0) / 100.0;
    }
    public void groceries() {
        money -= groceries;
        money = Math.round(money * 100.0) / 100.0;
    }
    public void dataPlan() {
        money -= dataPlan;
        money = Math.round(money * 100.0) / 100.0;
    }
    public void commute() {
        money -= commute;
        money = Math.round(money * 100.0) / 100.0;
    }
    public void extraFun() {
        money -= extraFun;
        money = Math.round(money * 100.0) / 100.0;
    }
}
