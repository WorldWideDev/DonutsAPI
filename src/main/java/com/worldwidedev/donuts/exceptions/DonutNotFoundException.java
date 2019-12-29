package com.worldwidedev.donuts.exceptions;

public class DonutNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DonutNotFoundException(Long id) {
		super("Could not find Donut " + id);
	}
}
