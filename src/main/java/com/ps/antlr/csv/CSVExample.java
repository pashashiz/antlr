package com.ps.antlr.csv;

import com.ps.antlr.csv.parser.CSVLexer;
import com.ps.antlr.csv.parser.CSVParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CSVExample {

    public static void main(String[] args) throws IOException {
        String sample = "name,age\n" +
                        "pavlo,27\n" +
                        "randy,49\n" +
                        "bill,\"test\"\n" +
                        "mike,\n";
        CharStream charStream = new ANTLRInputStream(new ByteArrayInputStream(sample.getBytes()));
        CSVLexer lexer = new CSVLexer(charStream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        CSVParser parser = new CSVParser(tokenStream);
        ParseTree tree = parser.file();
        System.out.println(tree.toStringTree(parser));
    }

}
