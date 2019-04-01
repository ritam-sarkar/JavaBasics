package com.design.beahvioural.visitor;

public interface Item {
	int accept(ShoppingVisitor visitor);
}
