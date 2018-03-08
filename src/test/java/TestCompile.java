import com.jim.TestGrammarLexer;
import com.jim.TestGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestCompile {

  private InputStream getResourceAsStream(String name) throws IOException {
    InputStream is = getClass().getClassLoader().getResourceAsStream(name);
    if (is == null) {
      throw new FileNotFoundException(name);
    }
    return is;
  }
  @Test
  public void test1() throws IOException {
    InputStream is = getResourceAsStream("test.txt");
    TestGrammarLexer lexer = new TestGrammarLexer(CharStreams.fromStream(is));

    TokenStream tokens = new CommonTokenStream(lexer);

    // Pass the tokens to the parser
    TestGrammarParser parser = new TestGrammarParser(tokens);

    parser.start();
  }
}
