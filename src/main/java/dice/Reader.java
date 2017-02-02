package dice;

import generated.dice.DiceBaseVisitor;
import generated.dice.DiceLexer;
import generated.dice.DiceParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Reader {

    public void run(String toParse) throws IOException {

        ByteArrayInputStream input = new ByteArrayInputStream(toParse.getBytes());

        new MyVisitor().visitParse(
                new DiceParser(
                        new CommonTokenStream(
                                new DiceLexer(
                                        new ANTLRInputStream(input)
                                )
                        )
                ).parse()
        );
    }

    private static class MyVisitor extends DiceBaseVisitor {

    }
}
