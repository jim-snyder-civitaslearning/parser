package com.jim;

public interface Scope {

  String getScopeName();
  Scope getParentScope();
  void define(SymbolTableEntry s);
}
