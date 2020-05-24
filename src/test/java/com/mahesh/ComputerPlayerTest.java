package com.mahesh;

import org.junit.Assert;
import org.junit.Test;

public class ComputerPlayerTest {
    //Field box of type char[] - was not mocked since Mockito doesn't mock arrays
    //Field sc of type Scanner - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    ComputerPlayer computerPlayer = new ComputerPlayer();

    @Test
    public void testMain() throws Exception {
        ComputerPlayer.main(new String[]{"arg"});
    }


    @Test
    public void testGetComputerTurn() throws Exception {
        int result = computerPlayer.getComputerTurn();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testPrintCurrentState() throws Exception {
        computerPlayer.printCurrentState();
    }

    @Test
    public void testInitialise() throws Exception {
        computerPlayer.initialise();
    }

    @Test
    public void testFillBoxIndex() throws Exception {
        boolean result = computerPlayer.fillBoxIndex(0, PlayerEnum.X);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCheckWinner() throws Exception {
        boolean result = computerPlayer.checkWinner(PlayerEnum.X);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetPlayerYTurn() throws Exception {
        int result = computerPlayer.getPlayerYTurn();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetPlayerXTurn() throws Exception {
        int result = computerPlayer.getPlayerXTurn();
        Assert.assertEquals(0, result);
    }
}