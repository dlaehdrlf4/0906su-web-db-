<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="org.json.*" %>
    <%
    	JSONObject obj = new JSONObject();
    	obj.put("name","kobebryant");
    	
    	JSONArray ar = new JSONArray();
    	ar.put("Losangles");
    	ar.put("james");
    	ar.put("gildong");
    	ar.put("curry");
    	
    %>
    <%=ar%>