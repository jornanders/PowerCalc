package no.jascorp.powercalc.web.server;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.URLClassLoader;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ShutdownHandler;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author Jørn Anders Svendsen
 * 
 */
public class WebServer {

	public static void main(String[] args) throws Exception {
		new WebServer();
	}
	
	public WebServer() throws Exception {
		startJetty(getHttpPort(), createWebContexts());
	}

	protected int getHttpPort() {
		return Integer.parseInt(System.getProperty("powercalc.http.port", "8082"));
	}
	
	protected String getContextRoot() {
		return "/powercalc";
	}

	protected HandlerCollection createWebContexts() throws Exception {
		HandlerList handlerList = new HandlerList();
		handlerList.addHandler(createCurrentWebApp(getContextRoot()));
		return handlerList;
	}

	protected Handler createCurrentWebApp(String contextRoot) {
        URL[] urls = ((URLClassLoader) WebServer.class.getClassLoader()).getURLs();
        WebAppContext context;
        if (urls.length == 1 && urls[0].getFile().endsWith(".war")) {
            context = new WebAppContext(urls[0].getFile(), contextRoot);
        } else {
            context = new WebAppContext("src/main/webapp", contextRoot);
        }
        
        return context;
    }
	
	protected void startJetty(int port, HandlerCollection webContexts) throws Exception {
		attemptShutdown(port);

		Server server = new Server(port);
		webContexts.addHandler(createShutdownHandler(server));
		server.setHandler(webContexts);

		server.start();

		for (Connector connector : server.getConnectors()) {
			if (connector.isFailed()) {
				System.err.println(connector + " failed");
				server.stop();
			}
		}
		for (Handler handler : server.getHandlers()) {
			if (handler.isFailed()) {
				System.err.println(handler + " failed");
				server.stop();
			}
		}

		System.out.println("Started: http://" + server.getConnectors()[0].getHost() + ":"
				+ server.getConnectors()[0].getPort());
	}

	private void attemptShutdown(int port) {
		try {
			URL url = new URL("http://localhost:" + port + "/shutdown?token=" + getShutdownToken());
			System.out.println("Shutting down " + url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.getResponseCode();
		} catch (SocketException e) {
			// Okay - the server is not running
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String getShutdownToken() {
		return System.getProperty("server.shutdownToken", "sdgklnslhawoirnasiln");
	}

	protected ShutdownHandler createShutdownHandler(Server server) {
		return new ShutdownHandler(server, getShutdownToken());
	}

	// public static void main(String[] args) throws Exception {
	//
	// // System.setProperty("org.apache.jasper.compiler.disablejsr199",
	// "true");
	// Server server = new Server(getHttpPort());
	// WebAppContext context = createWebAppContext();
	// server.setHandler(context);
	// server.start();
	//
	// String baseUrl = "http://localhost:" + getHttpPort() + "/powercalc";
	// System.out.println(baseUrl);
	// }
	//
	// private static int getHttpPort() {
	// return Integer.parseInt(System.getProperty("http.port", "8082"));
	// }
	//
	// private static WebAppContext createWebAppContext() {
	// return new WebAppContext(getSelfWebContext(), "/powercalc");
	// }
	//
	// private static String getSelfWebContext() {
	// URL[] urls = ((URLClassLoader)
	// WebServer.class.getClassLoader()).getURLs();
	// if (urls.length == 1 && urls[0].getFile().endsWith(".war")) {
	// return urls[0].getFile();
	// }
	// return "src/main/webapp";
	// }
}