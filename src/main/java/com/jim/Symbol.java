package com.jim;

public abstract class Symbol implements SymbolTableEntry {

  private Symbol() {

  }
  private String name;

  public Symbol(String name) {
    this.name = name;
  }

  @Override
  public String getSymbolName() {
    return name;
  }
}
