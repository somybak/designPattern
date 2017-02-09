package com.saesompark.factorymethod;

/*
 * Factory Method
 * ��ü�� �������ִ� ����
 * Ȯ���� ����Ŭ������ �޼��带 �������̵��ؼ� ��ȯ���ش�.
 */

public abstract class FactoryMethod {
	public abstract Product make();
	public abstract Packed pack(Product product);
//�⺻������ FactoryMethod Ŭ������ ������ �� �ΰ��� ��� �����ؾ�

}
