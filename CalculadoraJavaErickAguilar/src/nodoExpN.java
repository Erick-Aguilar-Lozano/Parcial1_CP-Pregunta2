/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erick
 */
public class nodoExpN {
	String num;
	nodoExpN sig;
	public nodoExpN() {
		sig=null;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String it) {
		num = it;
	}
	public nodoExpN getSig() {
		return sig;
	}
	public void setSig(nodoExpN it) {
		sig = it;
	}
	
}
