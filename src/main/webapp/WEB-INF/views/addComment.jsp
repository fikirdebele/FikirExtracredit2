<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
		<section>
	<div class="jumbotron">
		<a href="<c:url value="/j_spring_security_logout"/>"
			class="btn btn-danger btn-mini pull-right">logout</a>
		<div class="container">
			<div class="pull-right" style="padding-right: 50px">
				<a href="?language=en">English</a>|<a href="?language=nl">Dutch</a>
			</div>
			<h1>Review Movie</h1>
		</div>
	</div>
	</section>
	<section class="container"> <form:form
		modelAttribute="comment" class="form-horizontal">
		<fieldset>
			<legend>Add Review</legend>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="rating"><spring:message
						code="addComment.form.rating.label" /></label>
				<div class="col-lg-10">
					<form:input  id="rating" path="rating" type="text"
						class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="comment"><spring:message
						code="addComment.form.comment.label" /></label>
				<div class="col-lg-10">
					<form:textarea rows="3" cols="60" id="comment" path="comment" type="text"
						class="form:input-large" />
				</div>
			</div>

			
			
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Add" />
				</div>
			</div>
		</fieldset>
	</form:form> </section>
</body>
</html>