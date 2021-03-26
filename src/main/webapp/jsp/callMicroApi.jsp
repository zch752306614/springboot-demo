<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.alibaba.fastjson.*,java.net.URLDecoder"%>
<%@page import="java.util.*,java.io.*,java.text.SimpleDateFormat"%>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.URLConnection" %>
<%@ page import="java.net.HttpURLConnection" %>
<%--com.tl.web.entity.*,--%>
<%--<%@include file="../common/base.jsp"%>--%>
<%
	response.setCharacterEncoding("UTF-8");
    PrintWriter pw = response.getWriter();
    Map<String,Object> paramMap;
	String action = request.getParameter("action");
    String result ="";
	if (action.equals("createCallApiMsg")) {//生成占用单
		String url = request.getParameter("url");
		String requestKind = request.getParameter("requestKind");
		String dataKind = request.getParameter("dataKind");
		String param = request.getQueryString();
		String data = request.getParameter("data");
		data = URLDecoder.decode(data, "utf-8");
		try {
			if (requestKind.equals("get")) {
				String urlName = url + "?" + param;
				URL U = new URL(urlName);
				URLConnection connection = U.openConnection();
				connection.connect();
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line;
				while ((line = in.readLine()) != null) {
					result += line;
				}
				in.close();
			} else if (requestKind.equals("post")) {
				URL httpurl = new URL(url);
				HttpURLConnection httpConn = (HttpURLConnection)httpurl.openConnection();
				httpConn.setDoOutput(true);
				httpConn.setDoInput(true);
				//PrintWriter pout = new PrintWriter(httpConn.getOutputStream());
				if(dataKind.equals("data")) {
					out.print(data);
				}
				out.flush();
				out.close();
				BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
				String line;
				while ((line = in.readLine())!= null) {
					result += line;
				}
				in.close();
			}
		} catch (Exception e) {
			/*result = JSONObject.toJSONString(new Res(1, "请求失败", ex.getMessage()));*/
			result = "{\"errcode\"" + ":" + "\"1\",\"message\"" + ":" + "\"请求失败}\"";
		}

		/*try {
			data = URLDecoder.decode(data, "utf-8");
			//System.out.println("=======params ==================="+data);
			result = MyRequest.sendPostUTF8(DBUtil.GATEWALL + "svr-orderconsumer/createCallApiMsg/",
					data);
			//System.out.println("===========result ==="+result);
		} catch (Exception ex) {
			result = JSONObject.toJSONString(new Res(1, "请求失败", ex.getMessage()));
		}*/
	}
    pw.write(result);
%>