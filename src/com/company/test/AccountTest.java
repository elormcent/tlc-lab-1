package com.company.test;

import com.company.exceptions.TradeIDException;
import com.company.exceptions.TradePriceException;
import com.company.one.Trade;
import com.company.one.Trader;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void accountPriceShouldAcceptPositiveNumber() throws TradePriceException {
        Trade trade = new Trade("T1", "APPL", 100, 15.25);
        assertTrue(trade.getPrice() > 0, "Price is positive");
    }

    @Test(expected = TradePriceException.class)
    public void accountPriceThrowsException() throws TradePriceException {
            Trade trade = new Trade("T1", "APPL", 100, -3);
    }

    @Test(expected = TradeIDException.class)
    public void duplicateIdCannotBeAdded() throws TradeIDException, TradePriceException {
        Trade trade = new Trade("T1", "APPL", 100, 15.25);
        Trade trade2 = new Trade("T1", "MML", 10, 10.25);
        Trader trader = new Trader("Juliet");
        trader.addTrade(trade);
        trader.addTrade(trade2);
    }
}
