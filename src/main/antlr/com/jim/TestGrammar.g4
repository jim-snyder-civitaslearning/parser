

grammar TestGrammar;

@parser::header {
package com.jim;
}

@lexer::header {
package com.jim;
import java.util.*;

}

@lexer::members {
    public static LexerUtils lexerUtils = new LexerUtils();
}

@parser::members {
    public boolean setLexerMode(boolean on) {
        TestGrammarLexer.lexerUtils.lexerMode.set(on);
        return true;
    }
}

tokens { A_KW, B_KW, C_KW }

start : items EOF;

items: item (',' item)*;

item :
    { setLexerMode(false) }? A_KW  ':'  { setLexerMode(true);} symbol
;

symbol :  QSTRING_ID;

// Things to skip over
WHITE_SPACE : [ \t\r\n]+ ->  skip;

KEY_WORD : '"' [a-zA-Z0-9]* '"' { lexerUtils.lexerMode.get() }? {
    String id = lexerUtils.getKeywordOrId(this);
    System.out.printf("found string of '%s' of kind %s %n", id, TestGrammarParser.VOCABULARY.getDisplayName(getType()));
};

QSTRING_ID : '"' [a-zA-Z0-9]* '"' { !lexerUtils.lexerMode.get() }? {
    String id = lexerUtils.getId(this);
    System.out.printf("found string of '%s' of kind %s %n", id, TestGrammarParser.VOCABULARY.getDisplayName(getType()));
}

;


