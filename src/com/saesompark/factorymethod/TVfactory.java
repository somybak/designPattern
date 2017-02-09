package com.saesompark.factorymethod;

public class TVfactory extends FactoryMethod {

	@Override
	public Product make() {
		// TODO Auto-generated method stub
		return new TV();
	}

	@Override
	public Packed pack(Product product) {
		Packed packed = new TVPacked();
		packed.setProduct(product);
		return packed;
	}

}
