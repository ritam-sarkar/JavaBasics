package com.design.creational.builder;

public class PizzaBuilder {
	
	private String bread;
	private String topping;
	private String type;
	
	static class Builder{
		private String bread;
		private String topping;
		private String type;
		
		public Builder bread(String bread) {
			this.bread = bread;
			return this;
		}
		public Builder topping(String topping) {
			this.topping = topping;
			return this;
		}
		public Builder type(String type) {
			this.type = type;
			return this;
		}
		public PizzaBuilder build() {
			PizzaBuilder pizzaBuilder = new PizzaBuilder();
			pizzaBuilder.bread = this.bread;
			pizzaBuilder.topping = this.topping;
			pizzaBuilder.type = this.type;
			return pizzaBuilder;
		}				
		
	}

	private PizzaBuilder() {}
	public String getBread() {
		return bread;
	}

	public String getTopping() {
		return topping;
	}

	public String getType() {
		return type;
	}
	
	

}
