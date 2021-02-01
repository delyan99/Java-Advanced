package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculationEngine {
    private int result;
    private Operation currentOperation;
    private MemoryRecallOperation memoryRecallOperation;

    public CalculationEngine(){
        this.result = 0;
        this.currentOperation = null;
        memoryRecallOperation = new MemoryRecallOperation();
    }

   public void pushNumber(int number) {
        if (this.currentOperation != null) {
            currentOperation.addOperand(number);

            if (currentOperation.isCompleted()) {
                this.result = currentOperation.getResult();
                this.currentOperation = null;
            }
        } else {
            this.result = number;
        }
    }

    void pushOperation(Operation operation) {
        if(operation == null){
            return;
        }

        if(operation instanceof MemoryOperation){
            this.memoryRecallOperation.addOperand(this.result);
        }else if(operation instanceof MemoryRecallOperation){
            this.pushNumber(this.memoryRecallOperation.getResult());
        }

        if (operation.isCompleted()) {
            this.pushNumber(operation.getResult());
        } else {
            this.currentOperation = operation;
            this.pushNumber(this.result);
        }
    }

    int getCurrentResult() {
        return this.result;
    }
}
