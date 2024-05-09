package testing;

public class Test2 {
    private double[] sales;
    private int days;

    // Constructor
    public Test2(int days) {
        this.days = days;
        this.sales = new double[days];
    }

    // Method to add a daily sale
    public void addSale(double saleAmount, int day) {
        if (day >= 0 && day < days) {
            sales[day] = saleAmount;
        } else {
            throw new IllegalArgumentException("Invalid day");
        }
    }

    // Method to calculate total sales for the month
    public double calculateTotalSales() {
        double totalSales = 0;
        for (double sale : sales) {
            totalSales += sale;
        }
        return totalSales;
    }

    // Method to calculate average daily sales
    public double calculateAverageDailySales() {
        double totalSales = calculateTotalSales();
        return totalSales / days;
    }

    // Method to find the day with the highest sales
    public int findBestSalesDay() {
        int bestDay = 0;
        double highestSales = 0;
        for (int i = 0; i < days; i++) {
            if (sales[i] > highestSales) {
                highestSales = sales[i];
                bestDay = i;
            }
        }
        return bestDay;
    }

    // Method to find the day with the lowest sales
    public int findWorstSalesDay() {
        int worstDay = 0;
        double lowestSales = Double.MAX_VALUE;
        for (int i = 0; i < days; i++) {
            if (sales[i] < lowestSales) {
                lowestSales = sales[i];
                worstDay = i;
            }
        }
        return worstDay;
    }

    // Method to display sales report
    public void displaySalesReport() {
        System.out.println("Total Sales: $" + calculateTotalSales());
        System.out.println("Average Daily Sales: $" + calculateAverageDailySales());
        int bestDay = findBestSalesDay();
        System.out.println("Best Sales Day: Day " + (bestDay + 1) + " with $" + sales[bestDay]);
        int worstDay = findWorstSalesDay();
        System.out.println("Worst Sales Day: Day " + (worstDay + 1) + " with $" + sales[worstDay]);
    }

    public static void main(String[] args) {
        Test2 analyzer = new Test2(30); // Assuming 30 days in a month
        // Adding daily sales
        analyzer.addSale(100.50, 0);
        analyzer.addSale(200.75, 1);
        // Add more sales for other days as needed
        // Display sales report
        analyzer.displaySalesReport();
    }
}
