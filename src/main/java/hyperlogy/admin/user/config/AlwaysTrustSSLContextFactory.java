//package hyperlogy.admin.user.config;
//
//import javax.net.ssl.KeyManager;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocketFactory;
//import javax.net.ssl.TrustManager;
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.net.UnknownHostException;
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//
///**
// * SSL socket factory accepting any certificate.
// *
// * @author l0co@wp.pl
// */
//public class AlwaysTrustSSLContextFactory extends SSLSocketFactory {
//    private static AlwaysTrustSSLContextFactory instance;
//
//    static {
//        try {
//            instance = new AlwaysTrustSSLContextFactory();
//        } catch (Exception e) {
//            throw new RuntimeException("Cannot instantiate default AlwaysTrustSSLContextFactory", e);
//        }
//    }
//
//    private SSLSocketFactory factory;
//
//    private AlwaysTrustSSLContextFactory() throws NoSuchAlgorithmException, KeyManagementException {
//        super();
//        SSLContext ctx = SSLContext.getInstance("TLS");
//        ctx.init(new KeyManager[0], new TrustManager[]{
//                new AlwaysTrustManager()}, new SecureRandom());
//        factory = ctx.getSocketFactory();
//    }
//
//    public static synchronized SSLSocketFactory getDefault() {
//        return instance;
//    }
//
//    public Socket createSocket() throws IOException {
//        return factory.createSocket();
//    }
//
//    public Socket createSocket(InetAddress address, int port,
//                               InetAddress localAddress, int localPort)
//            throws IOException {
//        return factory.createSocket(address, port, localAddress, localPort);
//    }
//
//    public Socket createSocket(InetAddress host, int port) throws IOException {
//        return factory.createSocket(host, port);
//    }
//
//    public Socket createSocket(Socket s, String host, int port,
//                               boolean autoClose) throws IOException {
//        return factory.createSocket(s, host, port, autoClose);
//    }
//
//    public Socket createSocket(String host, int port, InetAddress localHost,
//                               int localPort) throws IOException, UnknownHostException {
//        return factory.createSocket(host, port, localHost, localPort);
//    }
//
//    public Socket createSocket(String host, int port) throws IOException,
//            UnknownHostException {
//        return factory.createSocket(host, port);
//    }
//
//    public boolean equals(Object obj) {
//        return factory.equals(obj);
//    }
//
//    public String[] getDefaultCipherSuites() {
//        return factory.getDefaultCipherSuites();
//    }
//
//    public String[] getSupportedCipherSuites() {
//        return factory.getSupportedCipherSuites();
//    }
//
//}
