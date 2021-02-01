package calculator;

public class MemoryRecallOperation implements Operation {
    private MemoryOperation memoryOperation;

    public MemoryRecallOperation() {
        this.memoryOperation = new MemoryOperation();
    }

    @Override
    public void addOperand(int operand) {
        this.memoryOperation.addOperand(operand);
    }

    @Override
    public int getResult() {
        return this.memoryOperation.getResult();
    }

    @Override
    public boolean isCompleted() {
        return this.memoryOperation.isCompleted();
    }
}
