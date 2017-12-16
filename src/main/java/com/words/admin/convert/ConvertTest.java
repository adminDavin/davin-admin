package com.words.admin.convert;

import com.sun.star.comp.helper.BootstrapException;

public class ConvertTest {
	public static void main(String[] args) {
		try {
			com.sun.star.uno.XComponentContext xContext = com.sun.star.comp.helper.Bootstrap.bootstrap();
			com.sun.star.lang.XMultiComponentFactory xMCF = xContext.getServiceManager();
		} catch (BootstrapException e) {
			e.printStackTrace();
		}
	}
}
