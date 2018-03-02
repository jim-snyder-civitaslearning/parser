import com.jim.*;
import org.junit.Test;

public class SymbolTableTest {

  @Test
  public void test1() {
    SymbolTable t  = new SymbolTable();
    Scope parentScope = t.peek();
    DiscoveryPack dp = new DiscoveryPack(parentScope);
    t.push(dp);
    dp.define(new StringElement("joes"));
  }
}
