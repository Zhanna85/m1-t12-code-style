import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {

        new DepositCalculator().calculationOfDeposits();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) { //расчет вклада с капитализацией
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return performRounding(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) { //расчет вклада с обычным процентом
        return performRounding(amount + amount * yearRate * depositPeriod, 2);
    }

    double performRounding(double value, int powValue) {
        double scale = Math.pow(10, powValue);
        return Math.round(value * scale) / scale;
    }

    void calculationOfDeposits( ) {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double amountByTheEnd = 0;

        if (action == 1) {
            amountByTheEnd = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            amountByTheEnd = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + amountByTheEnd);
    }
}
