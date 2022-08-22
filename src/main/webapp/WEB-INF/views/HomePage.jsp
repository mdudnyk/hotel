<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="css/home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>
    <script src="js/datepicker.js"></script>
</head>

<body>
    <div class="container px-1 px-sm-5 mx-auto">
        <form autocomplete="off" action="controller" >
            <div class="flex-sm-row flex-column d-flex">
                <div class="col-sm-9 col-12 px-0 mb-2">
                    <div class="input-group input-daterange" id="datepicker">
                        <input type="hidden" name="cmd" class="form-control" readonly value="CATEGORY_PAGE"
                               style="background-color: transparent;">
                        <input type="text" name="startDate" class="form-control" placeholder="Arriving Date" onkeydown="return false;"
                               style="caret-color: transparent !important;" required>
                        <input type="text" name="endDate" class="form-control" placeholder="Leaving Date" readonly>
                    </div>
                </div>
                <div class="col-sm-3 col-12 px-0" id="search-btn">
                    <button type="submit"
                            class="btn btn-black">Search
                    </button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
