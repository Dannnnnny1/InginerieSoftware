<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 12/10/2024
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="needs-validation" novalidate method="POST" action=${pageContext.request.contextPath}/AddCar">
    <div class="row">
        <div class="col-md-6 mb-3">
            <label for="licensePlate">License Plate</label>
            <input type="text" class="form-control" id="licensePlate" name="licensePlate" placeholder="License Plate" required>
            <div class="invalid-feedback">
                Please enter a valid license plate.
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 mb-3">
            <label for="parkingSpot">Parking Spot</label>
            <input type="text" class="form-control" id="parkingSpot" name="parkingSpot" placeholder="Parking Spot" required>
            <div class="invalid-feedback">
                Please enter a valid parking spot.
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 mb-3">
            <label for="ownerName">Owner Name</label>
            <input type="text" class="form-control" id="ownerName" name="ownerName" placeholder="Owner Name" required>
            <div class="invalid-feedback">
                Please enter a valid owner name.
            </div>
        </div>
    </div>
    <button class="btn btn-primary" type="submit">Add Car</button>
    

</form>

</body>
</html>
