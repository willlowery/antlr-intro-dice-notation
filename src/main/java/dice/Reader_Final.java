package dice;

import dice.sm.DieExpression;
import dice.sm.DieExpressionFactory;
import generated.dice.DiceBaseVisitor;
import generated.dice.DiceLexer;
import generated.dice.DiceParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Reader_Final {

    private DieExpressionFactory dieExpressionFactory;

    public Reader_Final(DieExpressionFactory dieExpressionFactory) {
        this.dieExpressionFactory = dieExpressionFactory;
    }

    public DieExpression run(String toParse) throws IOException {
        ByteArrayInputStream input = new ByteArrayInputStream(toParse.getBytes());
        return new MyVisitor(dieExpressionFactory)
                .visitDiceNotation(
                        new DiceParser(
                                new CommonTokenStream(
                                        new DiceLexer(
                                                new ANTLRInputStream(input)
                                        )
                                )
                        ).diceNotation()
                );
    }

    private static class MyVisitor extends DiceBaseVisitor {

        private DieExpressionFactory dieExpressionFactory;

        public MyVisitor(DieExpressionFactory dieExpressionFactory) {
            this.dieExpressionFactory = dieExpressionFactory;
        }

        public DieExpression visitDiceNotation(DiceParser.DiceNotationContext ctx) {
            Iterator<DiceParser.DieOrNumberContext> diceOrNumbers = ctx.dieOrNumber().iterator();
            Iterator<DiceParser.OperatorContext> ops = ctx.operator().iterator();

            DieExpression result = visitDieOrNumber(diceOrNumbers.next());

            while (diceOrNumbers.hasNext()) {
                String op = ops.next().getText();
                if(op.equals("+")){
                    result = dieExpressionFactory.add(result, visitDieOrNumber(diceOrNumbers.next()));
                }else if(op.equals("-")){
                    result = dieExpressionFactory.subtract(result, visitDieOrNumber(diceOrNumbers.next()));
                }
            }

            return result;
        }

        public Object visitOperator(DiceParser.OperatorContext ctx) {
            return BiFunctions.find(ctx.getText());
        }

        public DieExpression visitDieOrNumber(DiceParser.DieOrNumberContext ctx) {
            if (ctx.dieRoll() != null) {
                return visitDieRoll(ctx.dieRoll());
            } else {

                return dieExpressionFactory.constant(Integer.parseInt(ctx.INTEGER().getText()));
            }
        }

        public DieExpression visitDieRoll(DiceParser.DieRollContext ctx) {
            return dieExpressionFactory.roll(
                    Integer.parseInt(ctx.INTEGER(0).getText()),
                    Integer.parseInt(ctx.INTEGER(1).getText())
            );
        }
    }
}
