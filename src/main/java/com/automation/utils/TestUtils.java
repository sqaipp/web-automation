package com.automation.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;


public class TestUtils {
    public static final long WAIT = 20;

	public HashMap<String, String> parseStringXML(InputStream file) throws Exception {
		HashMap<String, String> stringMap = new HashMap<String, String>();
		//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		//Build Document
		Document document = builder.parse(file);

		//Normalize the XML Structure; It's just too important !!
		document.getDocumentElement()
			   .normalize();

		//Get all elements
		NodeList nList = document.getElementsByTagName("string");

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				// Store each element key value in map
				stringMap.put(eElement.getAttribute("name"), eElement.getTextContent());
			}
		}
		return stringMap;
	}

//	public Logger log() {
//		return LogManager.getLogger(Thread.currentThread()
//								    .getStackTrace()[2].getClassName());
//	}

    public static void cleanServer() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("pkill", "-9", "-f", "appium");
            processBuilder.inheritIO();
            processBuilder.start()
                    .waitFor();

            String[] packages = {
                    "io.appium.settings",
                    "io.appium.uiautomator2.server",
                    "io.appium.uiautomator2.server.test",
//                    "edts.klikidm.dev.android",
//                    "edts.co.id.klikindomaret"
			};
            for (String packageName : packages) {
                ProcessBuilder adbProcessBuilder = new ProcessBuilder("adb", "uninstall", packageName);
                adbProcessBuilder.inheritIO();
                adbProcessBuilder.start()
                        .waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
