package logic;

import dal.IData;

public class Func implements IFunc {

	private IData data;

	public Func(IData data) {
		this.data = data;
	}

}