package calculator;

import java.util.ArrayDeque;

public class MemoryOperation implements Operation {
    private ArrayDeque<Integer> stack;

    public MemoryOperation() {
        this.stack = new ArrayDeque<>();
    }

    @Override
    public void addOperand(int operand) {
        this.stack.push(operand);
    }

    @Override
    public int getResult() {
        return this.stack.pop();
    }

    @Override
    public boolean isCompleted() {
        return this.stack.size() > 0;
    }
}
