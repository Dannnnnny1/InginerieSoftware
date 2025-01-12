<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/AddCarPhoto">
    <div class="row">
        <div class="col-md-6 mb-3">
            <label for="file">Photo</label>
            <input type="file" name="file" id="file" required>
            <div class="invalid-feedback">
                Photo is required.
            </div>
        </div>
    </div>
    <input type="hidden" name="car_id" value="${car.id}" />
    <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button>
</form>