<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="no">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/slf/images/favicon.ico"/>" />
        <title>
           <spring:message code="system.navn"/>
        </title>
        
    <body>
        <div class="container content-wrapper">
            <div class="content">
				<tiles:insertAttribute name="body" defaultValue="" />
            </div>
        </div>
    </body>
</html>
