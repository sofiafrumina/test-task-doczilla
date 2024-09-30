import com.sun.net.httpserver.HttpExchange;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.security.Principal;
import java.util.*;

public class HttpExchangeWrapper implements HttpServletRequest {
    private final HttpExchange exchange;
    private final Map<String, String> parameters = new HashMap<>();

    public HttpExchangeWrapper(HttpExchange exchange) {
        this.exchange = exchange;
        parseParameters();
    }

    private void parseParameters() {
        // Разбор параметров из URI (если они есть)
        String query = exchange.getRequestURI().getQuery();
        if (query != null) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    parameters.put(keyValue[0], keyValue[1]);
                }
            }
        }
    }

    @Override
    public String getMethod() {
        return exchange.getRequestMethod();
    }

    @Override
    public Object getAttribute(String s) {
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public String getCharacterEncoding() {
        return "";
    }

    @Override
    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

    }

    @Override
    public int getContentLength() {
        return 0;
    }

    @Override
    public long getContentLengthLong() {
        return 0;
    }

    @Override
    public String getContentType() {
        return "";
    }

    @Override
    public InputStream getInputStream() {
        return exchange.getRequestBody();
    }

    @Override
    public String getRequestURI() {
        return exchange.getRequestURI().toString();
    }

    @Override
    public StringBuffer getRequestURL() {
        return null;
    }

    @Override
    public String getAuthType() {
        return "";
    }

    @Override
    public Cookie[] getCookies() {
        return new Cookie[0];
    }

    @Override
    public long getDateHeader(String s) {
        return 0;
    }

    @Override
    public String getHeader(String name) {
        return exchange.getRequestHeaders().getFirst(name);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        List<String> headers = exchange.getRequestHeaders().get(name);
        return headers != null ? Collections.enumeration(headers) : Collections.emptyEnumeration();
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return null;
    }

    @Override
    public int getIntHeader(String s) {
        return 0;
    }

    @Override
    public String getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> map = new HashMap<>();
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            map.put(entry.getKey(), new String[]{entry.getValue()});
        }
        return map;
    }

    @Override
    public String getProtocol() {
        return "";
    }

    @Override
    public String getScheme() {
        return "";
    }

    @Override
    public String getServerName() {
        return "";
    }

    @Override
    public int getServerPort() {
        return 0;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return null;
    }

    @Override
    public String getRemoteAddr() {
        return "";
    }

    @Override
    public String getRemoteHost() {
        return "";
    }

    @Override
    public void setAttribute(String s, Object o) {

    }

    @Override
    public void removeAttribute(String s) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public Enumeration<Locale> getLocales() {
        return null;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String s) {
        return null;
    }

    @Override
    public int getRemotePort() {
        return 0;
    }

    @Override
    public String getLocalName() {
        return "";
    }

    @Override
    public String getLocalAddr() {
        return "";
    }

    @Override
    public int getLocalPort() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        return null;
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        return null;
    }

    @Override
    public boolean isAsyncStarted() {
        return false;
    }

    @Override
    public boolean isAsyncSupported() {
        return false;
    }

    @Override
    public AsyncContext getAsyncContext() {
        return null;
    }

    @Override
    public DispatcherType getDispatcherType() {
        return null;
    }

    @Override
    public String getRequestId() {
        return "";
    }

    @Override
    public String getProtocolRequestId() {
        return "";
    }

    @Override
    public ServletConnection getServletConnection() {
        return null;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(parameters.keySet());
    }

    @Override
    public String[] getParameterValues(String s) {
        return new String[0];
    }

    // Реализуйте дополнительные методы по мере необходимости
    @Override
    public String getRequestURI() {
        return exchange.getRequestURI().toString();
    }

    @Override
    public String getContextPath() {
        return "";
    }

    // Необязательные методы (вернуть null или реализовать при необходимости)
    @Override
    public String getServletPath() {
        return "";
    }

    @Override
    public HttpSession getSession(boolean b) {
        return null;
    }

    @Override
    public HttpSession getSession() {
        return null;
    }

    @Override
    public String changeSessionId() {
        return "";
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return false;
    }

    @Override
    public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
        return false;
    }

    @Override
    public void login(String s, String s1) throws ServletException {

    }

    @Override
    public void logout() throws ServletException {

    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        return List.of();
    }

    @Override
    public Part getPart(String s) throws IOException, ServletException {
        return null;
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) throws IOException, ServletException {
        return null;
    }

    @Override
    public String getPathInfo() {
        return null;
    }

    @Override
    public String getPathTranslated() {
        return null;
    }

    @Override
    public String getQueryString() {
        return exchange.getRequestURI().getQuery();
    }

    @Override
    public String getRemoteUser() {
        return "";
    }

    @Override
    public boolean isUserInRole(String s) {
        return false;
    }

    @Override
    public Principal getUserPrincipal() {
        return null;
    }

    @Override
    public String getRequestedSessionId() {
        return "";
    }

    // Реализуйте другие методы по мере необходимости или верните null
}
