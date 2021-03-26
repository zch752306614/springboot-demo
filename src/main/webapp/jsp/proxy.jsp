<%@ page import="java.io.BufferedReader,java.io.InputStreamReader,java.io.OutputStream,java.io.PrintWriter"%>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/xml;charset=UTF-8"%>
<%
    response.setCharacterEncoding("UTF-8");
    PrintWriter  pw = response.getWriter();
    String typeString = request.getContentType();
    Enumeration<String> enu = request.getParameterNames();
    String result = "";
    String url = request.getParameter("url");
    String action = request.getParameter("action");

    //System.out.println(typeString);
    if (action.equals("createCallApiMsg")) {
        try {
            //获取json
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String dataLine;
            StringBuilder json = new StringBuilder();
            while ((dataLine = br.readLine()) != null) {
                json.append(dataLine);
            }
            String reqBody = json.toString();
            //System.out.println(json);

            url += "?";
            while (enu.hasMoreElements()) {
                //截取url中?后的参数
                String paramName = enu.nextElement();
                //System.out.println(paramName);
                switch (paramName) {
                    case "url":
                    case "action":
                        break;
                    case "data":
                        System.out.println(request.getParameter("data"));
                        url += "data=" + request.getParameter("data") + "&";
                        break;
                    default:
                        url += paramName + "=" + request.getParameter(paramName) + "&";
                        break;
                }
            }
            url = url.substring(0, url.length() - 1);
            System.out.println("url:" + url);

            URL connect;
            connect = new URL(url);
            OutputStream os;
            BufferedReader reader;
            String line;
            HttpURLConnection connection = (HttpURLConnection) connect.openConnection();

            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.setDoOutput(true);
            connection.setDoInput(true);

            //判断请求方法
            switch (request.getMethod()) {
                case "POST":
                    connection.setUseCaches(false);
                    connection.setRequestMethod("POST");
                    break;
                case "GET":
                    connection.setRequestMethod("GET");
            }

            connection.setRequestProperty("Content-type", typeString);
            //connection.setRequestProperty("token", token);
            connection.connect();
            os = connection.getOutputStream();
            //传入参数json
            os.write(URLDecoder.decode(reqBody,"utf-8").getBytes());
            os.flush();
            os.close();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
            reader.close();
        } catch (Exception ex) {
            result = "{\"errcode\"" + ":" + "\"1\",\"message\"" + ":" + "\"请求失败}\"";
            ex.printStackTrace();
        }
    }
    pw.write(result);
%>