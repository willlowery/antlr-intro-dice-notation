package dice;

import generated.dice.DiceBaseVisitor;
import generated.dice.DiceLexer;
import generated.dice.DiceParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reader_Final {

    public List<Object> run(String toParse) throws IOException {
        ByteArrayInputStream input = new ByteArrayInputStream(toParse.getBytes());
        return new MyVisitor()
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


        public List<Object> visitDiceNotation(DiceParser.DiceNotationContext ctx) {
            ArrayList<Object> results = new ArrayList<>();
            Iterator<DiceParser.DieOrNumberContext> diceOrNumbers = ctx.dieOrNumber().iterator();
            Iterator<DiceParser.OperatorContext> ops = ctx.operator().iterator();
            results.add(visitDieOrNumber(diceOrNumbers.next()));

            while (diceOrNumbers.hasNext()) {
                results.add(visitOperator(ops.next()));
                results.add(visitDieOrNumber(diceOrNumbers.next()));
            }

            return results;
        }

        public Object visitOperator(DiceParser.OperatorContext ctx) {
            return BiFunctions.find(ctx.getText());
        }

        public Object visitDieOrNumber(DiceParser.DieOrNumberContext ctx) {
            if (ctx.dieRoll() != null) {
                return visitDieRoll(ctx.dieRoll());
            } else {
                return Integer.parseInt(ctx.INTEGER().getText());
            }
        }

        public DieRollRequest visitDieRoll(DiceParser.DieRollContext ctx) {
            return new DieRollRequest(
                    Integer.parseInt(ctx.INTEGER(0).getText()),
                    Integer.parseInt(ctx.INTEGER(1).getText())
            );
        }
    }
}
