package com.itsmaxymoo.aliasshowtext;

public class ArgString {
	private String rawString;

	public ArgString(String s){
		rawString = s;
	}

	//TODO: Implement this
	public String getFormatted(String[] args){
		// Remember, args[0] will be the string name
		return rawString;
	}

	@Override
	public String toString(){
		return rawString;
	}
}
