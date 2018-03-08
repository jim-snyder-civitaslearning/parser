package com.jim;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseScope implements Scope, SymbolTableEntry {

  private String scopeName;
  private Scope parentScope;
  private Map<String, SymbolTableEntry> symbols = new HashMap<>();

  public BaseScope(Scope parentScope, String scopeName) {
    if (scopeName == null) throw new UnsupportedOperationException("Scopes must have a name");
    this.scopeName = scopeName;
    this.parentScope = parentScope;
  }
  public String getScopeName() {
    return scopeName;
  }

  public String getSymbolName() {
    return getScopeName();
  }

  public Scope getParentScope() {
    return parentScope;
  }

  public void define(SymbolTableEntry s) {
    symbols.put(s.getSymbolName(), s);
  }

}
