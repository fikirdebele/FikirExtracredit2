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
<title>Movies</title>
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
			<h1>Movies</h1>
		</div>
	</div>
	</section>
	<section class="container"> <form:form
		modelAttribute="newMovie" class="form-horizontal"
		enctype="multipart/form-data">
		<fieldset>
			<legend>Add new movie</legend>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message
						code="addMovie.form.name.label" /></label>
				<div class="col-lg-10">
					<form:input id="name" path="title" type="text"
						class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="year"><spring:message
						code="addMovie.form.year.label" /></label>
				<div class="col-lg-10">
					<form:input id="year" path="year" type="text"
						class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="rating"><spring:message
						code="addMovie.form.rating.label" /></label>
				<div class="col-lg-10">
					<form:input id="rating" path="rating" type="text"
						class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="directors"><spring:message
						code="addMovie.form.directors.label" /></label>
				<div class="col-lg-10">
					<form:select id="directors" items="${directors}" path="directors" multiple="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="movieCharacters"><spring:message
						code="addMovie.form.movieCharacter.label" /></label>
				<div class="col-lg-10">
					<form:select id="movieCharacters" items="${movieCharacter}" path="movieCharacters" />
				</div>
			</div> 
			<div class="form-group">
					<label class="control-label col-lg-2" for="poster"> <spring:message
							code="addMovie.form.poster.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="poster" path="poster" type="file"
							class="form:input-large" />
					</div>
				</div>
			<%--				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitsInStock"><spring:message
							code="addProduct.form.unitsInStock.label" /></label>
					<div class="col-lg-10">
						<form:input id="unitsInStock" path="unitsInStock" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitsInOrder">UnitsInOrder</label>
					<div class="col-lg-10">
						<form:input id="unitsInOrder" path="unitsInOrder" type="text"
							class="form:input-large" />
					</div>
				</div>		

				<div class="form-group">
					<label class="control-label col-lg-2" for="description"><spring:message
							code="addProduct.form.description.label" /></label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows="2" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="discontinued">Discontinued</label>
					<div class="col-lg-10">
						<form:checkbox id="discontinued" path="discontinued" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="condition"><spring:message
							code="addProduct.form.condition.label" /></label>
					<div class="col-lg-10">
						<form:radiobutton path="condition" value="New" />
						New
						<form:radiobutton path="condition" value="Old" />
						Old
						<form:radiobutton path="condition" value="Refurbished" />
						Refubrished
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="productImage"> <spring:message
							code="addProdcut.form.productImage.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="productImage" path="productImage" type="file"
							class="form:input-large" />
					</div>
				</div> --%>
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