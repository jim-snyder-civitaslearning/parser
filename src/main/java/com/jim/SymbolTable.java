package com.jim;

import java.util.Stack;

public class SymbolTable extends Stack<Scope> implements Scope {

  private final GlobalScope global = new GlobalScope();

  public SymbolTable() {
    push(global);
    initTypeSystem();
  }

  protected void initTypeSystem() {

  }

  @Override
  public String getScopeName() {
    return "SymbolTable";
  }

  @Override
  public Scope getParentScope() {
    return null;
  }

  @Override
  public void define(SymbolTableEntry s) {
    global.define(s);
  }
}
