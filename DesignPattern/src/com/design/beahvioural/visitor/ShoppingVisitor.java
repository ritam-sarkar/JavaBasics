package com.design.beahvioural.visitor;

public interface ShoppingVisitor {
	int visit(Book book);
	int visit(Fruit fruit);
}
