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
	<div class="jumbotron2">
		<div class="container">
			<h1>Movies</h1>
			<p>Movies in the Store</p>
		</div>
	</div>
	</section>
	<section class="container">
	<form class="form-inline" method="GET">
		<div class="form-group">
			<label for="name">Name of Movie</label> <input id="name" name="name"
				class="form-control" />
			<button type="submit" id="search" class="btn btn-default">Search</button>
		</div>
	</form>
	<div class="row">



		<table class="table">
			<c:forEach items="${movies}" var="movie">
				<tr>
					<td class="col-md-2"></td>
					<td>
						<p>Name: ${movie.title}</p>
						<p>Year: ${movie.year}</p>
						<p>Rating: ${movie.rating}</p>
						<p>
							<a href=" <spring:url value="/movies/${movie.id}" /> "
								class="btn"> <span
								class="glyphicon-info-sign glyphicon" /></span> Comment
							</a>
						</p>
					</td>
				</tr>

			</c:forEach>
		</table>
	</div>
	</section>
</body>
</html>