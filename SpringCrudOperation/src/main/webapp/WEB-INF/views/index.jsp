<html>
<head>
<%@include file="./base.jsp"%>
<%-- 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center">Welcome to Product App</h1>
				<table class="table table-success table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Product Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<c:forEach items="${Product}" var="p">
						<tbody>
							<tr>
								<th scope="row">${p.id }</th>
								<td>${p.name }</td>
								<td>${p.description }</td>
								<td class="font-weight-bold">&#x20B9; ${p.price }</td>
								<td>
								<a href="update/${p.id}"><i
										class="fa-solid fa-edit text-primary" data-bs-toggle="tooltip" data-bs-placement="right" title="edit"></i></a> &nbsp;
										<a href="delete/${p.id}"><i
										class="fa-solid fa-trash text-danger" data-bs-toggle="tooltip" data-bs-placement="right" title="delete"></i></a> 
							</tr>
						</tbody>
					</c:forEach>
				</table>
				<div class="container text-center">
					<a href="add-product" class="btn btn-outline-success">App
						Product</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
