package com.jim;

public class DiscoveryPack extends BaseScope implements SymbolTableEntry, Type {

  private static final String TYPE_NAME = "DiscoveryPack";

  public DiscoveryPack(Scope parentScope) {
    super(parentScope, TYPE_NAME);
  }

  public String getTypeName() {
    return TYPE_NAME;
  }

}
