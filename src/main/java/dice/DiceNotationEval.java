package dice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DiceNotationEval {

    private final DieRoller roller;

    public DiceNotationEval(DieRoller roller) {
        this.roller = roller;
    }

    public Integer eval(Object... objects) {
        return eval(Arrays.asList(objects));
    }

    private Integer eval(List<Object> list) {
        Integer result = 0;
        LinkedList<Object> stack = new LinkedList<>();
        stack.addAll(list);

        if (!stack.isEmpty()) {
            Object pop = stack.pop();
            if (pop instanceof Integer) {
                result = (Integer) pop;
            } else if (pop instanceof DieRollRequest) {
                result = roller.roll((DieRollRequest) pop);
            } else {
                throw new IllegalStateException("Bad Form");
            }
        }

        BiFunctions op = null;
        while (!stack.isEmpty()) {
            Object pop = stack.pop();
            if (pop instanceof Integer) {
                result = op.apply(result, (Integer) pop);
            } else if (pop instanceof DieRollRequest) {
                result = op.apply(result, roller.roll((DieRollRequest) pop));
            } else if (pop instanceof BiFunctions) {
                op = (BiFunctions) pop;
            }
        }

        return result;
    }

}
