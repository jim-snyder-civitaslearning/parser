

grammar TestGrammar;

@parser::header {
package com.jim;
}

@lexer::header {
package com.jim;
import java.util.*;

}

@lexer::members {
    // this is not thread safe
    public static boolean lexerMode = true;

    Map<String,Integer> keywords = new HashMap<String,Integer>() {{
    	put("A", TestGrammarParser.A_KW);
    	put("B", TestGrammarParser.B_KW);
    	put("C", TestGrammarParser.C_KW);
    }};

    protected String getUnquotedString(String original) {
        return original.substring(1, original.length() - 1);
    }
}

@parser::members {

    public boolean setLexerMode(boolean on) {
        TestGrammarLexer.lexerMode = on;
        return true;
    }
}

tokens { A_KW, B_KW, C_KW }

start : items EOF;

items: item (',' item)*;

item :
    { setLexerMode(false) }? A_KW  ':'  symbol { setLexerMode(true);}
;

symbol :  QSTRING_ID;

// Things to skip over
WHITE_SPACE : [ \t\r\n]+ ->  skip;

KEY_WORD : '"' [a-zA-Z0-9]* '"' { lexerMode }? {
    String id = getUnquotedString(getText());
    setType(keywords.get(id));
    System.out.printf("found string of '%s' of kind %s %n", id, TestGrammarParser.VOCABULARY.getDisplayName(getType()));
};

QSTRING_ID : '"' [a-zA-Z0-9]* '"' { !lexerMode }? {
    String id = getUnquotedString(getText());
    setType(QSTRING_ID);
    System.out.printf("found string of '%s' of kind %s %n", id, TestGrammarParser.VOCABULARY.getDisplayName(getType()));
}

;


