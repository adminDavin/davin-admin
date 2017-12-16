package com.words.admin.convert;

import java.io.File;

import org.jodconverter.DocumentConverter;
import org.jodconverter.LocalConverter;
import org.jodconverter.office.OfficeManager;

import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.uno.XComponentContext;
import com.words.admin.config.Constant;

public class ConvertTest {
	private static String OPENOFFICE_PATH = "C:\\Program Files (x86)\\OpenOffice 4";

	public static void main(String[] args) {
		try {
			doGetConnect();
			//
			// XComponentContext xContext =
			// BootstrapSocketConnector.bootstrap(OPENOFFICE_PATH);
			// System.out.println("Connected to a running office ...");
			// com.sun.star.lang.XMultiComponentFactory xMCF = xContext.getServiceManager();
			// String available = (xMCF != null ? "available" : "not available");
			// System.out.println("remote ServiceManager is " + available);
			// XConnector connector = (XConnector)
			// UnoRuntime.queryInterface(XConnector.class,
			// xMCF.createInstanceWithContext("com.sun.star.connection.Connector",
			// xContext));
			// XConnection connection = connector.connect(connectionString);
			// doConvert(connection);
			// // XBridgeFactory bridgeFactory = (XBridgeFactory)
			// // UnoRuntime.queryInterface(XBridgeFactory.class,
			// xMCF.createInstanceWithContext("com.sun.star.bridge.BridgeFactory",
			// xContext));
			// XBridge bridge = bridgeFactory.createBridge("", "urp", connection, null);
			// XComponent bridgeComponent = (XComponent)
			// UnoRuntime.queryInterface(XComponent.class, bridge);
			// bridgeComponent.addEventListener(this);
			// serviceManager = (XMultiComponentFactory)
			// UnoRuntime.queryInterface(XMultiComponentFactory.class,
			// bridge.getInstance("StarOffice.ServiceManager"));
			// XPropertySet properties = (XPropertySet)
			// UnoRuntime.queryInterface(XPropertySet.class, serviceManager);
			// componentContext = (XComponentContext)
			// UnoRuntime.queryInterface(XComponentContext.class,
			// properties.getPropertyValue("DefaultContext"));
			// connected = true;
			// logger.info("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void doGetConnect() throws Exception {
		XComponentContext localContext = Bootstrap.createInitialComponentContext(null);
		XMultiComponentFactory localServiceManager = localContext.getServiceManager();
		// XConnector connector = OfficeUtils.cast(XConnector.class,
		// localServiceManager.createInstanceWithContext("com.sun.star.connection.Connector",
		// localContext));
		doConvert();
	}

	private static void doConvert() throws Exception {
		OfficeManager officeManager = OfficeBuilder.builder();
		officeManager.start();
		DocumentConverter documentConverter = LocalConverter.make(officeManager);
		documentConverter.convert(new File(Constant.OFFICEWORKER + "test.doc"))
				.to(new File(Constant.OFFICEWORKER + "test.pdf")).execute();
		officeManager.stop();
	}

}
