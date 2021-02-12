import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{

    private Map<Integer, Transaction> transactions;

    public ChainblockImpl(){
        this.transactions = new HashMap<>();
    }

    public int getCount() {
        return transactions.size();
    }

    public void add(Transaction transaction) {
        if(!contains(transaction.getId())) {
            transactions.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return this.contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        for (Transaction transaction : transactions.values()) {
            if(transaction.getId() == id){
                transaction.setTransactionStatus(newStatus);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public void removeTransactionById(int id) {
        for (Transaction transaction : transactions.values()) {
            if(transaction.getId() == id){
                transactions.remove(id);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public Transaction getById(int id) {
        for (Transaction transaction : transactions.values()) {
            if(transaction.getId() == id){
                return transaction;
            }
        }
        throw new IllegalArgumentException();
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : this.transactions.values()) {
            if(transaction.getTransactionStatus().equals(status)){
                transactions.add(transaction);
            }
        }
        if(transactions.isEmpty()){
            throw new IllegalArgumentException();
        }
        transactions = transactions.stream().sorted((l, r) -> Double.compare(r.getAmount(), l.getAmount())).collect(Collectors.toList());
        return transactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : this.transactions.values()) {
            if(transaction.getTransactionStatus().equals(status)){
                transactions.add(transaction);
            }
        }
        if(transactions.isEmpty()){
            throw new IllegalArgumentException();
        }
        transactions = transactions.stream().sorted((l, r) -> Double.compare(r.getAmount(), l.getAmount())).collect(Collectors.toList());
        List<String> senders = new ArrayList<>();
        for (Transaction transaction : transactions) {
            senders.add(transaction.getSender());
        }
        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : this.transactions.values()) {
            if(transaction.getTransactionStatus().equals(status)){
                transactions.add(transaction);
            }
        }
        if(transactions.isEmpty()){
            throw new IllegalArgumentException();
        }
        transactions = transactions.stream().sorted((l, r) -> Double.compare(r.getAmount(), l.getAmount())).collect(Collectors.toList());
        List<String> receivers = new ArrayList<>();
        for (Transaction transaction : transactions) {
            receivers.add(transaction.getReceiver());
        }
        return receivers;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        List<Transaction> sortedTransactions = transactions.values().stream().sorted((l, r) -> {
            int result = Double.compare(r.getAmount(), l.getAmount());
            if (result == 0) {
                result = Integer.compare(l.getId(), r.getId());
            }
            return result;
        }).collect(Collectors.toList());
        return sortedTransactions;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : this.transactions.values()) {
            if (transaction.getSender().equals(sender)){
                transactions.add(transaction);
            }
        }
        if(transactions.isEmpty()){
            throw new IllegalArgumentException();
        }
        transactions = transactions.stream().sorted((l, r) -> Double.compare(r.getAmount(), l.getAmount())).collect(Collectors.toList());

        return transactions;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : this.transactions.values()) {
            if(transaction.getReceiver().equals(receiver)){
                transactions.add(transaction);
            }
        }
        if(transactions.isEmpty()){
            throw new IllegalArgumentException();
        }
        transactions = transactions.stream().sorted((l, r) -> {
            int result = Double.compare(r.getAmount(), l.getAmount());
            if(result == 0){
                result = Integer.compare(l.getId(), r.getId());
            }
            return result;
        }).collect(Collectors.toList());
        return transactions;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : this.transactions.values()) {
            if(transaction.getTransactionStatus().equals(status) && transaction.getAmount() <= amount){
                transactions.add(transaction);
            }
        }
        return transactions.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : this.transactions.values()) {
            if(transaction.getSender().equals(sender) && transaction.getAmount() > amount){
                transactions.add(transaction);
            }
        }
        if(transactions.isEmpty()){
            throw new IllegalArgumentException();
        }
        return transactions.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : this.transactions.values()) {
            if(transaction.getReceiver().equals(receiver) && transaction.getAmount() >= lo && transaction.getAmount() < hi){
                transactions.add(transaction);
            }
        }
        if(transactions.isEmpty()){
            throw new IllegalArgumentException();
        }
        return transactions.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Comparator.comparing(Transaction::getId))).collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : this.transactions.values()) {
            if(transaction.getAmount() >= lo && transaction.getAmount() <= hi){
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
