package no.jascorp.powercalc.web.server;

import java.net.URL;
import java.net.URLClassLoader;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author Jørn Anders Svendsen
 *
 */
public class WebServer {

	public static void main(String[] args) throws Exception {

		// System.setProperty("org.apache.jasper.compiler.disablejsr199", "true");
		Server server = new Server(getHttpPort());
		WebAppContext context = createWebAppContext();
		server.setHandler(context);
		server.start();

		String baseUrl = "http://localhost:" + getHttpPort() + "/powercalc";
		System.out.println(baseUrl);
	}

	private static int getHttpPort() {
		return Integer.parseInt(System.getProperty("http.port", "8082"));
	}

	private static WebAppContext createWebAppContext() {
		return new WebAppContext(getSelfWebContext(), "/powercalc");
	}

	private static String getSelfWebContext() {
		URL[] urls = ((URLClassLoader) WebServer.class.getClassLoader()).getURLs();
		if (urls.length == 1 && urls[0].getFile().endsWith(".war")) {
			return urls[0].getFile();
		}
		return "src/main/webapp";
	}
}