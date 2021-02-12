import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChainblockImpTests {
    private List<Transaction> transactions;
    private Chainblock chainblock;

    @Before
    public void setUp() {
        chainblock = new ChainblockImpl();
        transactions = new ArrayList<>();
        createNewTransactions();

    }

    @Test
    public void testGetCountShouldReturnCorrectCountOfTransactions() {
        Assert.assertEquals(0, chainblock.getCount());
        chainblock.add(transactions.get(0));
        Assert.assertEquals(1, chainblock.getCount());
        chainblock.add(transactions.get(0));
        Assert.assertEquals(1, chainblock.getCount());
        chainblock.add(new TransactionImpl(2, TransactionStatus.ABORTED, "User_1", "User_2", 5.0));
        Assert.assertEquals(2, chainblock.getCount());
    }

    @Test
    public void testContainsIdShouldReturnCorrectBooleanResult() {
        Assert.assertFalse(chainblock.contains(transactions.get(0).getId()));
        chainblock.add(transactions.get(0));
        Assert.assertTrue(chainblock.contains(transactions.get(0).getId()));
    }

    @Test
    public void testContainsTransactionShouldReturnCorrectBooleanResult() {
        Assert.assertFalse(chainblock.contains(transactions.get(0)));
        chainblock.add(transactions.get(0));
        Assert.assertTrue(chainblock.contains(transactions.get(0)));
    }

    @Test
    public void testAddWithValidTransaction() {
        chainblock.add(transactions.get(0));
        Assert.assertEquals(1, chainblock.getCount());
        chainblock.add(new TransactionImpl(2, TransactionStatus.ABORTED, "User_1", "User_2", 5.0));
        Assert.assertEquals(2, chainblock.getCount());
    }

    @Test
    public void testAddWithSameTransactionsShouldNotIncrementNumbersOfTransactions() {
        chainblock.add(transactions.get(0));
        Assert.assertEquals(1, chainblock.getCount());
        chainblock.add(transactions.get(0));
        Assert.assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testChangeTransactionStatusWithValidId() {
        chainblock.add(transactions.get(0));
        TransactionStatus expected = TransactionStatus.SUCCESSFUL;
        chainblock.changeTransactionStatus(transactions.get(0).getId(), expected);
        Transaction t = chainblock.getById(1);
        Assert.assertNotNull(t);
        Assert.assertEquals(expected, t.getTransactionStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusWithInvalidId(){
        chainblock.changeTransactionStatus(1, TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testGetByIdWithValidIdShouldReturnTransaction() {
        addTransactionsToChainblock();
        int id = transactions.get(0).getId();
        Transaction t = chainblock.getById(id);
        Assert.assertNotNull(t);
        Assert.assertEquals(id, t.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdWithInvalidIdShouldReturnTransaction() {
        Transaction t = chainblock.getById(1);
    }

    @Test
    public void testRemoveTransactionByIdWithValidId() {
        addTransactionsToChainblock();
        Assert.assertEquals(4, chainblock.getCount());
        chainblock.removeTransactionById(transactions.get(0).getId());
        Assert.assertEquals(3, chainblock.getCount());
        Assert.assertFalse(chainblock.contains(transactions.get(0).getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdWithInvalidId() {
        chainblock.removeTransactionById(transactions.get(0).getId());
    }

    @Test
    public void testGetByTransactionStatusWithValidStatusShouldReturnValidSize() {
        addTransactionsToChainblock();
        Iterable<Transaction> iterable = chainblock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertEquals(1, transactions.size());
    }

    @Test
    public void testGetByTransactionStatusWithValidStatusShouldReturnTransactionsOrderedByDescendingAmount() {
        addTransactionsToChainblock();
        Iterable<Transaction> iterable = chainblock.getByTransactionStatus(TransactionStatus.FAILED);
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertEquals(3, transactions.size());
        Assert.assertEquals(3, transactions.get(0).getId());
        Assert.assertEquals(2, transactions.get(1).getId());
        Assert.assertEquals(1, transactions.get(2).getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusWithInvalidStatus() {
        addTransactionsToChainblock();
        chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusWithValidStatus(){
        addTransactionsToChainblock();
        Iterable<String> iterable = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
        Assert.assertNotNull(iterable);
        List<String> senders = convertIterableToList(iterable);

        Assert.assertEquals(1, senders.size());
    }

    @Test
    public void testGetAllSendersWithTransactionStatusWithValidStatusShouldReturnTransactionsOrderedByDescendingAmount() {
        addTransactionsToChainblock();
        Iterable<String> iterable = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
        Assert.assertNotNull(iterable);
        List<String> senders = convertIterableToList(iterable);

        Assert.assertEquals(3, senders.size());
        Assert.assertEquals("From_3", senders.get(0));
        Assert.assertEquals("From_2", senders.get(1));
        Assert.assertEquals("From_1", senders.get(2));
    }

    @Test
    public void testGetAllSendersWithTransactionStatusWithValidStatusShouldReturnTransactionsOrderedByDescendingAmountWithMultipleTransactionsWithTheSameSender() {
        addTransactionsToChainblock();
        TransactionImpl transaction = new TransactionImpl(5, TransactionStatus.FAILED, "From_1", "To_1", 100.50);
        chainblock.add(transaction);
        Iterable<String> iterable = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
        Assert.assertNotNull(iterable);
        List<String> senders = convertIterableToList(iterable);

        Assert.assertEquals(4, senders.size());
        Assert.assertEquals("From_1", senders.get(0));
        Assert.assertEquals("From_3", senders.get(1));
        Assert.assertEquals("From_2", senders.get(2));
        Assert.assertEquals("From_1", senders.get(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusWithInvalidStatus() {
        addTransactionsToChainblock();
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusWithValidStatus(){
        addTransactionsToChainblock();
        Iterable<String> iterable = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
        Assert.assertNotNull(iterable);
        List<String> receivers = convertIterableToList(iterable);

        Assert.assertEquals(1, receivers.size());
    }
    @Test
    public void testGetAllReceiversWithTransactionStatusWithValidStatusShouldReturnTransactionsOrderedByDescendingAmount() {
        addTransactionsToChainblock();
        Iterable<String> iterable = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);
        Assert.assertNotNull(iterable);
        List<String> receivers = convertIterableToList(iterable);

        Assert.assertEquals(3, receivers.size());
        Assert.assertEquals("To_3", receivers.get(0));
        Assert.assertEquals("To_2", receivers.get(1));
        Assert.assertEquals("To_1", receivers.get(2));
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusWithValidStatusShouldReturnTransactionsOrderedByDescendingAmountWithMultipleTransactionsWithTheSameReceiver() {
        addTransactionsToChainblock();
        TransactionImpl transaction = new TransactionImpl(5, TransactionStatus.FAILED, "From_1", "To_1", 100.50);
        chainblock.add(transaction);
        Iterable<String> iterable = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);
        Assert.assertNotNull(iterable);
        List<String> receivers = convertIterableToList(iterable);

        Assert.assertEquals(4, receivers.size());
        Assert.assertEquals("To_1", receivers.get(0));
        Assert.assertEquals("To_3", receivers.get(1));
        Assert.assertEquals("To_2", receivers.get(2));
        Assert.assertEquals("To_1", receivers.get(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusWithInvalidStatus() {
        addTransactionsToChainblock();
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdShouldReturnAllTransactionsOrderedByDescendingAmount(){
        addTransactionsToChainblock();
        Iterable<Transaction> iterable = chainblock.getAllOrderedByAmountDescendingThenById();
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertEquals(4, transactions.size());
        Assert.assertEquals(4, transactions.get(0).getId());
        Assert.assertEquals(3, transactions.get(1).getId());
        Assert.assertEquals(2, transactions.get(2).getId());
        Assert.assertEquals(1, transactions.get(3).getId());
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdShouldReturnAllTransactionsOrderedByDescendingAmountThenById(){
        addTransactionsToChainblock();
        Transaction transaction = new TransactionImpl(5, TransactionStatus.FAILED, "From_2", "To_2", 6.60);
        chainblock.add(transaction);
        Iterable<Transaction> iterable = chainblock.getAllOrderedByAmountDescendingThenById();
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertEquals(5, transactions.size());
        Assert.assertEquals(4, transactions.get(0).getId());
        Assert.assertEquals(3, transactions.get(1).getId());
        Assert.assertEquals(2, transactions.get(2).getId());
        Assert.assertEquals(5, transactions.get(3).getId());
        Assert.assertEquals(1, transactions.get(4).getId());
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingShouldReturnCorrectTransactions(){
        addTransactionsToChainblock();
        Transaction transaction5 = new TransactionImpl(5, TransactionStatus.FAILED, "From_1", "To_1", 1.50);
        Transaction transaction6 = new TransactionImpl(6, TransactionStatus.FAILED, "From_1", "To_1", 2.50);
        Transaction transaction7 = new TransactionImpl(7, TransactionStatus.FAILED, "From_1", "To_1", 98.50);

        chainblock.add(transaction5);
        chainblock.add(transaction6);
        chainblock.add(transaction7);

        Iterable<Transaction> iterable = chainblock.getBySenderOrderedByAmountDescending("From_1");
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertEquals(4, transactions.size());
        Assert.assertEquals(7, transactions.get(0).getId());
        Assert.assertEquals(1, transactions.get(1).getId());
        Assert.assertEquals(6, transactions.get(2).getId());
        Assert.assertEquals(5, transactions.get(3).getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingWithNotSuchTransactions() {
        chainblock.getBySenderOrderedByAmountDescending("From_1");
    }


    @Test
    public void testGetByReceiverOrderedByAmountThenByIdWithValidReceivers() {
        addTransactionsToChainblock();
        Transaction transaction5 = new TransactionImpl(5, TransactionStatus.FAILED, "From_1", "To_1", 1.50);
        Transaction transaction6 = new TransactionImpl(6, TransactionStatus.FAILED, "From_1", "To_1", 4.50);
        Transaction transaction7 = new TransactionImpl(7, TransactionStatus.FAILED, "From_1", "To_1", 1.50);

        chainblock.add(transaction5);
        chainblock.add(transaction6);
        chainblock.add(transaction7);
        Iterable<Transaction> iterable = chainblock.getByReceiverOrderedByAmountThenById("To_1");
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertEquals(4, transactions.size());
        Assert.assertEquals(1, transactions.get(0).getId());
        Assert.assertEquals(6, transactions.get(1).getId());
        Assert.assertEquals(5, transactions.get(2).getId());
        Assert.assertEquals(7, transactions.get(3).getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdWithInvalidReceivers() {
        chainblock.getByReceiverOrderedByAmountThenById("To_1");
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountWithValidStatusAndValidAmount() {
        addTransactionsToChainblock();
        Iterable<Transaction> iterable = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.FAILED, 6.60);
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertEquals(2, transactions.size());
        Assert.assertEquals(2, transactions.get(0).getId());
        Assert.assertEquals(1, transactions.get(1).getId());
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountWithInvalidStatus() {
        addTransactionsToChainblock();
        Iterable<Transaction> iterable = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 6.60);
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertTrue(transactions.isEmpty());
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountWithInvalidAmount() {
        addTransactionsToChainblock();
        Iterable<Transaction> iterable = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 1);
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertTrue(transactions.isEmpty());
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescendingWithValidSenderAndValidAmount() {
        addTransactionsToChainblock();
        Transaction transaction5 = new TransactionImpl(5, TransactionStatus.FAILED, "From_1", "To_1", 1.50);
        Transaction transaction6 = new TransactionImpl(6, TransactionStatus.FAILED, "From_1", "To_1", 4.50);
        Transaction transaction7 = new TransactionImpl(7, TransactionStatus.FAILED, "From_1", "To_1", 1.50);

        chainblock.add(transaction5);
        chainblock.add(transaction6);
        chainblock.add(transaction7);
        Iterable<Transaction> iterable = chainblock.getBySenderAndMinimumAmountDescending("From_1", 1.5);
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertEquals(2, transactions.size());
        Assert.assertEquals(1, transactions.get(0).getId());
        Assert.assertEquals(6, transactions.get(1).getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingWithInvalidSender() {
        addTransactionsToChainblock();
        chainblock.getBySenderAndMinimumAmountDescending("Invalid_Sender", 1.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingWithInvalidAmount() {
        addTransactionsToChainblock();
        chainblock.getBySenderAndMinimumAmountDescending("From_1", 50.90);
    }

    @Test
    public void testGetByReceiverAndAmountRangeWithValidReceiverAndValidAmount() {
        addTransactionsToChainblock();
        Transaction transaction5 = new TransactionImpl(5, TransactionStatus.FAILED, "From_1", "To_1", 1.50);
        Transaction transaction6 = new TransactionImpl(6, TransactionStatus.FAILED, "From_1", "To_1", 4.50);
        Transaction transaction7 = new TransactionImpl(7, TransactionStatus.FAILED, "From_1", "To_1", 1.50);

        chainblock.add(transaction5);
        chainblock.add(transaction6);
        chainblock.add(transaction7);
        Iterable<Transaction> iterable = chainblock.getByReceiverAndAmountRange("To_1", 1.5, 5.5);
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertEquals(3, transactions.size());
        Assert.assertEquals(6, transactions.get(0).getId());
        Assert.assertEquals(5, transactions.get(1).getId());
        Assert.assertEquals(7, transactions.get(2).getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeWithInvalidReceiver() {
        addTransactionsToChainblock();
        chainblock.getByReceiverAndAmountRange("Invalid_Receiver", 1.5, 5.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeWithInvalidAmount() {
        addTransactionsToChainblock();
        chainblock.getByReceiverAndAmountRange("To_1", 40, 55);
    }

    @Test
    public void testGetAllInAmountRangeWithValidTransactions() {
        addTransactionsToChainblock();
        Iterable<Transaction> iterable = chainblock.getAllInAmountRange(5.51, 10.5);
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertEquals(3, transactions.size());

        for (int i = 0; i < transactions.size(); i++) {
            Assert.assertTrue(transactions.contains(transactions.get(i)));
        }
    }

    @Test
    public void testGetAllInAmountRangeWithInvalidTransactions() {
        addTransactionsToChainblock();
        Iterable<Transaction> iterable = chainblock.getAllInAmountRange(50.51, 100.5);
        Assert.assertNotNull(iterable);
        List<Transaction> transactions = convertIterableToList(iterable);
        Assert.assertTrue(transactions.isEmpty());
    }

    public <T>List<T> convertIterableToList(Iterable<T> iterable){
        List<T> list = new ArrayList<>();
        for (T t : iterable) {
            list.add(t);
        }
        return list;
    }

    private void addTransactionsToChainblock(){
        for (Transaction transaction : transactions) {
            chainblock.add(transaction);
        }
    }

    private void createNewTransactions() {
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.FAILED, "From_1", "To_1", 5.50);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.FAILED, "From_2", "To_2", 6.60);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.FAILED, "From_3", "To_3", 7.70);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.UNAUTHORIZED, "From_4", "To_4", 10.50);
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
    }
}
