package com.jim;

public class GlobalScope extends BaseScope implements SymbolTableEntry {

  public static final String SCOPE_NAME = "$__globals";

  private GlobalScope(Scope parentScope, String scopeName) {
    super(null, null);
  }

  public GlobalScope() {
    super(null, SCOPE_NAME);
  }

  @Override
  public String getSymbolName() {
    return SCOPE_NAME;
  }
}
