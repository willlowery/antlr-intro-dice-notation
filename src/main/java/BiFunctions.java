import java.util.function.BiFunction;

public enum BiFunctions {
    PLUS("+", (left, right) -> left + right);

    private final String match;
    private final BiFunction<Integer, Integer, Integer> op;

    BiFunctions(String match, BiFunction<Integer, Integer, Integer> op) {
        this.match = match;
        this.op = op;
    }

    public Integer apply(Integer left, Integer right) {
        return op.apply(left, right);
    }

    public static BiFunctions find(String str) {
        for (BiFunctions biFunctions : values()) {
            if (biFunctions.match.equals(str))
                return biFunctions;
        }

        return null;
    }
}
