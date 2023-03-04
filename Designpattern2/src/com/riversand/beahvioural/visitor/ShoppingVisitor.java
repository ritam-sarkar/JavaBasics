package com.riversand.beahvioural.visitor;

public interface ShoppingVisitor {
	int visit(Book book);
	int visit(Fruit fruit);
}
