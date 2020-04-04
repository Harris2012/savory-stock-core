package cn.savory.app;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void calcServiceCharge() {
        double buyMoney = 4.62;
        int buyCount = 10000;
        double expectedServiceCharge = 11.55;

        double actualServiceCharge = Calculator.calcServiceCharge(buyMoney, buyCount);
        Assert.assertEquals(expectedServiceCharge, actualServiceCharge, 2);
    }

    @Test
    public void calcTransferFee() {
        double buyMoney = 4.62;
        int buyCount = 10000;
        boolean etf = false;
        double expectedTransferFee = 0.92;

        double actualTransferFee = Calculator.calcTransferFee(buyMoney, buyCount, etf);
        Assert.assertEquals(expectedTransferFee, actualTransferFee, 2);
    }

    @Test
    public void calcCalcStampTax() {
        double sellMoney = 4.62;
        int sellCount = 10000;
        double expectedTransferFee = 46.2;

        double actualTransferFee = Calculator.calcStampTax(sellMoney, sellCount);
        Assert.assertEquals(expectedTransferFee, actualTransferFee, 2);
    }
}