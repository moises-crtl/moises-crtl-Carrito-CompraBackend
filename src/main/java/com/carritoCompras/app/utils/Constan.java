package com.carritoCompras.app.utils;

public interface Constan {

	/**
	 * END POINT LIST
	 */
	String  ENDPOINT_CREATE_PRODUCT = "/created";
	
	String  ENDPOINT_LIST_ALL_PRODUCT = "/list";
	
	String  ENDPOINT_LIST_FIND_ID_PRODUCT = "/view/id/{idProduct}";

	String  ENDPOINT_LIST_FIND_NAME_PRODUCT = "/view/name/{name}";
	
	String  ENDPOINT_UPDATE_BY_IDPRODUCT = "/update/{idProduct}";
	
	String  ENDPOINT_DELETE_FIND_ID_PRODUCT = "/delete/id/{idProduct}";
}
