package cn.savory.app;

public class App {
    public static void main(String[] args) {
        testBuy(4.62, 10000, false, 11.55, 0.92);

        System.out.println("ok");
    }

    private static void testBuy(double buyMoney, int buyCount, boolean etf, double expectedServiceCharge, double expectedTransferFee) {

        double actualServiceCharge = Calculator.calcServiceCharge(buyMoney, buyCount);
        double actualTransferFee = Calculator.calcTransferFee(buyMoney, buyCount, etf);

        if (actualServiceCharge != expectedServiceCharge) {
            System.out.println("[serviceCharge]" + buyMoney + "*" + buyCount + "=" + actualServiceCharge + "!=" + expectedServiceCharge);
        }
        if (actualTransferFee != expectedTransferFee) {
            System.out.println("[transferFee]" + buyMoney + "*" + buyCount + "=" + actualTransferFee + "!=" + expectedTransferFee);
        }
    }

    private static double buy(double buyMoney, int buyCount, boolean etf) {

        double serviceCharge = Calculator.calcServiceCharge(buyMoney, buyCount);
        double transferFee = Calculator.calcTransferFee(buyMoney, buyCount, etf);

        return serviceCharge + transferFee;
    }
}
