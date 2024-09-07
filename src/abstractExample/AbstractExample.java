package abstractExample;

//Abstract base class
abstract class Trade {
 // Common method with implementation
 public void execute() {
     System.out.println("Executing trade.");
 }
 
 // Abstract method to be implemented by subclasses
 public abstract double calculateProfit();
 
 // Abstract method to be implemented by subclasses
 public abstract double calculateFee();
}

//Concrete class for stock trades
class StockTrade extends Trade {
 private double purchasePrice;
 private double sellingPrice;
 private double numberOfShares;
 
 public StockTrade(double purchasePrice, double sellingPrice, double numberOfShares) {
     this.purchasePrice = purchasePrice;
     this.sellingPrice = sellingPrice;
     this.numberOfShares = numberOfShares;
 }
 
 @Override
 public double calculateProfit() {
     return (sellingPrice - purchasePrice) * numberOfShares;
 }
 
 @Override
 public double calculateFee() {
     // Example fee calculation: 0.1% of the total transaction amount
     return (purchasePrice * numberOfShares + sellingPrice * numberOfShares) * 0.001;
 }
}

//Concrete class for bond trades
class BondTrade extends Trade {
 private double purchasePrice;
 private double sellingPrice;
 private double faceValue;
 
 public BondTrade(double purchasePrice, double sellingPrice, double faceValue) {
     this.purchasePrice = purchasePrice;
     this.sellingPrice = sellingPrice;
     this.faceValue = faceValue;
 }
 
 @Override
 public double calculateProfit() {
     return sellingPrice - purchasePrice;
 }
 
 @Override
 public double calculateFee() {
     // Example fee calculation: $5 flat fee
     return 5.0;
 }
}

//Main class to test the implementation
public class Main {
 public static void main(String[] args) {
     Trade stockTrade = new StockTrade(100, 150, 50);
     Trade bondTrade = new BondTrade(950, 980, 1000);
     
     stockTrade.execute();
     System.out.println("Stock Trade Profit: $" + stockTrade.calculateProfit());
     System.out.println("Stock Trade Fee: $" + stockTrade.calculateFee());
     
     bondTrade.execute();
     System.out.println("Bond Trade Profit: $" + bondTrade.calculateProfit());
     System.out.println("Bond Trade Fee: $" + bondTrade.calculateFee());
 }
}
