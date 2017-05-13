package com.ps.antlr.json;

import com.ps.antlr.json.parser.JSONLexer;
import com.ps.antlr.json.parser.JSONParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class JSONExample {

    public static void main(String[] args) throws IOException {
        String sample = "{\n" +
                "  \"antlr.org\": {\n" +
                "    \"owners\": [],\n" +
                "    \"live\": true,\n" +
                "    \"speed\": 1e100,\n" +
                "    \"menus\": [\n" +
                "      \"File\",\n" +
                "      \"Help\\nMenu\"\n" +
                "    ]\n" +
                "  }\n" +
                "}\n";
        CharStream charStream = new ANTLRInputStream(new ByteArrayInputStream(sample.getBytes()));
        JSONLexer lexer = new JSONLexer(charStream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokenStream);
        ParseTree tree = parser.json();
        System.out.println(tree.toStringTree(parser));
    }

}
