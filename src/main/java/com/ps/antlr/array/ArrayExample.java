package com.ps.antlr.array;

import com.ps.antlr.array.parser.ArrayInitBaseListener;
import com.ps.antlr.array.parser.ArrayInitLexer;
import com.ps.antlr.array.parser.ArrayInitParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ArrayExample {

    public static void main(String[] args) throws IOException {
        CharStream charStream = new ANTLRInputStream(new ByteArrayInputStream("{1,2,3}".getBytes()));
        ArrayInitLexer lexer = new ArrayInitLexer(charStream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        ArrayInitParser parser = new ArrayInitParser(tokenStream);
        ParseTree tree = parser.init();
        //System.out.println(tree.toStringTree(parser));
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ShortToUnicodeStringListener(), tree);
    }

    public static class ShortToUnicodeStringListener extends ArrayInitBaseListener {

        @Override
        public void enterInit(ArrayInitParser.InitContext ctx) {
            System.out.print('"');
        }

        @Override
        public void exitInit(ArrayInitParser.InitContext ctx) {
            System.out.print('"');
        }

        @Override
        public void enterValue(ArrayInitParser.ValueContext ctx) {
            Integer value = Integer.valueOf(ctx.INT().getText());
            System.out.printf("\\u%04x", value);
        }
    }
}
