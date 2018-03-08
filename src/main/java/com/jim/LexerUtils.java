package com.jim;

import org.antlr.v4.runtime.Lexer;

import java.util.HashMap;
import java.util.Map;

public class LexerUtils {
  // this is not thread safe
  public static boolean lexerMode = true;

  public Map<String, Integer> keywords = new HashMap<String, Integer>() {{
    put("A", TestGrammarParser.A_KW);
    put("B", TestGrammarParser.B_KW);
    put("C", TestGrammarParser.C_KW);
  }};

  protected String getUnquotedString(String original) {
    return original.substring(1, original.length() - 1);
  }

  public String getKeywordOrId(TestGrammarLexer lexer) {
    String id = getUnquotedString(lexer.getText());
    Integer type = keywords.get(id);
    if (type != null) {
      lexer.setType(type);
    } else {
      lexer.setType(lexer.QSTRING_ID);
    }
    return id;
  }

  public String getId(TestGrammarLexer lexer) {
    String id = getUnquotedString(lexer.getText());
    lexer.setType(lexer.QSTRING_ID);
    return id;
  }

}
