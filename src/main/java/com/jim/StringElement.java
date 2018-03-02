package com.jim;

public class StringElement extends Symbol implements SymbolTableEntry {

  public StringElement(String name) {
    super(name);
  }

  @Override
  public String getSymbolName() {
    return null;
  }
}
