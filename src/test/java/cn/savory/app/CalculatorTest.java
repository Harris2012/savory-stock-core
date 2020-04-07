package cn.savory.app;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void calcServiceCharge() {
        Assert.assertEquals(11.55, Calculator.calcServiceCharge(4.62, 10000), 2);
        Assert.assertEquals(6.27, Calculator.calcServiceCharge(25.09, 1000), 2);
    }

    @Test
    public void calcTransferFee() {
        Assert.assertEquals(0.92, Calculator.calcTransferFee(4.62, 10000, false), 2);
        Assert.assertEquals(0.5, Calculator.calcTransferFee(4.62, 10000, false), 2);
    }

    @Test
    public void calcCalcStampTax() {
        Assert.assertEquals(46.2, Calculator.calcStampTax(4.62, 10000), 2);
        Assert.assertEquals(25.09, Calculator.calcStampTax(25.09, 1000), 2);
    }

    @Test
    public void buy() {

        buy(4.29, 5000, 5.79, false);
        buy(23.32, 1000, 6.3, false);
        buy(4.34, 5000, 5.86, false);
        buy(1.029, 10000, 5, true);
    }

    private void buy(double buyMoney, int buyCount, double expectedFee, boolean etf) {

        double serviceCharge = Calculator.calcServiceCharge(buyMoney, buyCount);
        double transferFee = Calculator.calcTransferFee(buyMoney, buyCount, etf);
        Assert.assertEquals(expectedFee, serviceCharge + transferFee, 0.02);
    }

    @Test
    public void sell() {
        sell(4.45, 19000, 107.39, false);
        sell(4.82, 8000, 48.97, false);
    }

    private void sell(double sellMoney, int sellCount, double expectedFee, boolean etf) {

        double serviceCharge = Calculator.calcServiceCharge(sellMoney, sellCount);
        double transferFee = Calculator.calcTransferFee(sellMoney, sellCount, etf);
        double stampTax = Calculator.calcStampTax(sellMoney, sellCount);
        double actualFee = serviceCharge + transferFee + stampTax;
        Assert.assertEquals(expectedFee, actualFee, 0.02);

        System.out.println(expectedFee + " = " + actualFee);
    }
}