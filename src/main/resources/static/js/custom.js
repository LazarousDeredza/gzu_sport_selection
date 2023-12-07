function setLocal(id, name) {
    localStorage.removeItem("id");
    localStorage.setItem("id", JSON.stringify(id));

    localStorage.removeItem("nameProp");
    localStorage.setItem("nameProp", JSON.stringify(name));
}

function setLocalCompartment(id, name) {
    localStorage.removeItem("idComp");
    localStorage.setItem("idComp", JSON.stringify(id));

    localStorage.removeItem("nameComp");
    localStorage.setItem("nameComp", JSON.stringify(name));
}

function setDropDownLocal() {
    localStorage.removeItem("drop_id");
    localStorage.setItem("drop_id", JSON.stringify(id));
}

function searchFilter() {
    let items = JSON.parse(localStorage.getItem("properties"));

    let field = document.getElementById("propertySearch").value;

    let t_body = document.getElementById("t_body");

    while (t_body.hasChildNodes()) {
        t_body.removeChild(t_body.firstChild);
    }

    for (let i = 0; i < items.length; i++) {
        let string = JSON.stringify(items[i])

        if (string.toLowerCase().includes(field.toLowerCase())) {
            let new_html = `<td>
                            <div class="custom-control custom-checkbox">
                              <input type="checkbox" class="custom-control-input" id="2474">
                              <label class="custom-control-label" for="2474"></label>
                            </div>
                          </td>
                          <td>
                            <div class="avatar avatar-md">
                              <img src="assets/avatars/office-building.png" alt="..." class="avatar-img rounded-circle">
                            </div>
                          </td>
                          <td>
<!--                            <p class="mb-0 text-muted"><strong>Brown, Asher D.</strong></p>-->
                            <small class="mb-0 text-muted">${items[i].id}</small>
                          </td>
                          <td>
                            <p class="mb-0 text-muted">${items[i].name}</p>
                            <small class="mb-0 text-muted">${items[i].addressObject.address}</small>
                          </td>
                          <td>
                            <p class="mb-0 text-muted"><a href="#" class="text-muted">${items[i].propertyContactObject.phone} ${items[i].propertyContactObject.mobileNumber}</a></p>
                            <small class="mb-0 text-muted">${items[i].propertyContactObject.email}</small>
                          </td>
                          <td class="w-25">
                          <p class="mb-0 text-muted">${items[i].ownerObject.name} ${items[i].ownerObject.lastName}</p>
                          <small class="text-muted"> ${items[i].ownerObject.contactDetailsObject.mobileNumber} ${items[i].ownerObject.contactDetailsObject.email} </small>
                          </td>
                          <td class="text-muted">13/09/2020</td>
                          <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="text-muted sr-only">Action</span>
                          </button>
                            <div class="dropdown-menu dropdown-menu-right"  >
                              <a class="dropdown-item" href="editSport" onclick="setLocal('${items[i].id}')">Edit</a>
                              <a class="dropdown-item" href="viewSport" onclick="setLocal('${items[i].id}','${items[i].name}')">View</a>
<!--                              <a class="dropdown-item" href="#">Assign</a>-->
                            </div>
                          </td>`


            let tr = document.createElement("tr");

            tr.innerHTML = new_html;

            t_body.appendChild(tr);
        }
    }
}

/************************************ground section******************************************************/

function setAddPropertyDropDown() {
    $.ajax({
        url: '/api/sport/get-all-sports',
        type: 'GET',
        success: function (response) {
            console.log(response)
            let dropDown = document.getElementById("property");

            while (dropDown.hasChildNodes()) {
                dropDown.removeChild(dropDown.firstChild);
            }

            for (let i = 0; i < response.length; i++) {
                let option = document.createElement("option");

                option.text = response[i].name;
                option.setAttribute("value", `${response[i].id}`)

                dropDown.appendChild(option);
            }
        }
    })
}

function saveGround() {
    let property = document.getElementById("property").value;
    let floorNumber = document.getElementById("propertyFloor").value;
    let floorArea = document.getElementById("floorArea").value;
    let rentalRate = document.getElementById("rentalRate").value;
    let description = document.getElementById("description").value;
    let compartmentNumber = document.getElementById("compartmentNumber").value;

    let data = {
        property,
        floorNumber,
        floorArea,
        rentalRate,
        description,
        compartmentNumber
    }

    $.ajax({
        url: '/api/ground/save-ground',
        type: 'POST',
        dataType: "json",
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            let element = document.getElementById("toast");

            $('#successModal').modal('show')
            // Create toast instance
            // let myToast = new bootstrap.Toast(element);
            // myToast.show()

            document.getElementById("_form").reset();
            console.log(response)

        }
    })
}

function appendCompartments() {
    let id = JSON.parse(localStorage.getItem("id"));


    // -----------------
    var baseurl = '/api/ground/get-grounds-for-specific-sport/' + id;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", baseurl, true);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = JSON.parse(xmlhttp.responseText);
            console.log(data);
            $("#property-compartment").DataTable({
                data: data,
                columns: [
                    {"data": "id"},
                    {
                        "data": function (row) {
                            return "Space ID : " + row.compartmentNumber + "<br> Floor : " + row.floorNumber;

                        },
                        "sortable": false,
                        "searchable": false
                    },
                    {
                        "data": function (row) {
                            let businessName = "";
                            if (row.tenantObject === null) {
                                businessName = " ......"
                            } else {
                                businessName = row.tenantObject.business_name
                            }
                            return businessName;
                        }
                    },
                    {
                        "data": function (row) {
                            return "$" + row.floorArea * row.rentalRate;
                        }
                    },
                    {
                        "data": function (row) {
                            return row.floorArea + " &#13217";
                        }
                    },
                    {
                        "data": function (row) {
                            return `<button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                                </button>
                                <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">Edit</a>
                                <a class="dropdown-item" href="viewGround" onclick="setLocalCompartment('` + row.id + `')">View</a>
                                </div>`
                        },
                        "sortable": false,
                        "searchable": false
                    }


                ]
            });
        }
    };
    xmlhttp.send();

    // ---------------

    /*

        $.ajax({
            url: '/api/ground/get-compartments-for-specific-property/' + id,
            type: 'GET',
            success: function (response) {
                let t_body = document.getElementById("t_body");
                while (t_body.hasChildNodes()) {
                    t_body.removeChild(t_body.firstChild);
                }

                for (let i = 0; i < response.length; i++) {
                    let html = `<td>
    <!--                                                            <div class="custom-control custom-checkbox">-->
    <!--                                                                <input type="checkbox" class="custom-control-input" id="2474">-->
    <!--                                                                <label class="custom-control-label" for="2474"></label>-->
    <!--                                                            </div>-->
                                                            </td>
                                                            <td>
                                                                <div class="avatar avatar-sm">
                                                                    <img src="assets/avatars/data-random-squares.png" alt="..." class="avatar-img rounded-circle">
                                                                </div>
                                                            </td>
                                                            <td>
                                                                <p class="mb-0 text-muted"><strong>${response[i].compartmentNumber}, floor : ${response[i].compartmentNumber} </strong></p>
                                                                <small class="mb-0 text-muted">${response[i].id}</small>
                                                            </td>
                                                            <td>
                                                                <p class="mb-0 text-muted">Tenant Bussiness</p>
                                                                <small class="mb-0 text-muted">teneant email , tenant phone</small>
                                                            </td>
                                                            <td>
                                                                <p class="mb-0 text-muted"><a href="#" class="text-muted">status:<span class="badge badge-secondary">owing</span></a></p>
                                                                <small class="mb-0 text-muted">${response[i].floorArea * response[i].rentalRate}</small>
                                                            </td>
                                                            <td class="text-muted">${response[i].floorArea} &#13217;</td>
                                                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                <span class="text-muted sr-only">Action</span>
                                                            </button>
                                                                <div class="dropdown-menu dropdown-menu-right">
                                                                    <a class="dropdown-item" href="#">Edit</a>
                                                                    <a class="dropdown-item" href="view-ground.html" onclick="setLocalCompartment('${response[i].id}')">View</a>
                                                                </div>
                                                            </td>`
                    let tr = document.createElement("tr");
                    tr.innerHTML = html;

                    t_body.appendChild(tr);
                }
            }
        });*/
}

function viewGround() {
    let propertyName = JSON.parse(localStorage.getItem("nameProp"));
    let id = JSON.parse(localStorage.getItem("idComp"));
    $.ajax({
        url: '/api/ground/get-ground/' + id,
        type: 'GET',
        success: function (response) {
            let business_name;
            let business_type;
            let email;
            let phone;

            if (response.tenantObject != null) {
                business_name = response.tenantObject.business_name
                business_type = response.tenantObject.business_type
                email = response.tenantObject.email
                phone = response.tenantObject.phone
            } else {
                business_type = "N/A"
                business_name = "N/A"
                email = "N/A"
                phone = "N/A"
            }

            console.log(response)
            let html = `<div class="card-body">
                                        <dl class="row align-items-center mb-0">
                                            <dt class="col-sm-2 mb-3 text-muted"> Property Name</dt>
                                            <dd class="col-sm-4 mb-3">
                                                <strong>${propertyName}</strong>
                                            </dd>
                                            <dt class="col-sm-2 mb-3 text-muted"> Compartment Square Area</dt>
                                            <dd class="col-sm-4 mb-3">
                                                <strong>${response.floorArea}</strong>
                                            </dd>
                                        </dl>
                                        <dl class="row align-items-center mb-0">
                                            <dt class="col-sm-2 mb-3 text-muted">Lettable space ID</dt>
                                            <dd class="col-sm-4 mb-3">
                                                <strong>${response.compartmentNumber}</strong>
                                            </dd>
                                            <dt class="col-sm-2 mb-3 text-muted"> Lettable space Floor Number</dt>
                                            <dd class="col-sm-4 mb-3">
                                                <strong>${response.floorNumber}</strong>
                                            </dd>
                                        </dl>
                                        <dl class="row mb-0">
                                            <dt class="col-sm-2 mb-3 text-muted">Rental Rate per ㎡ </dt>
                                            <dd class="col-sm-4 mb-3">${response.rentalRate}</dd>
                                            <dt class="col-sm-2 mb-3 text-muted">Rent payable</dt>
                                            <dd class="col-sm-4 mb-3">${response.floorArea * response.rentalRate}</dd>
                                            <!--<dt class="col-sm-2 mb-3 text-muted">Phone</dt>
                                            <dd class="col-sm-4 mb-3"> +263 00 000</dd>
                                            <dt class="col-sm-2 mb-3 text-muted">Mobile</dt>
                                            <dd class="col-sm-4 mb-3">+263 00 000</dd>
                                            <dt class="col-sm-2 mb-3 text-muted">Created On</dt>
                                            <dd class="col-sm-4 mb-3">2020-04-21 00:38:38</dd>
                                            <dt class="col-sm-2 mb-3 text-muted">Last Update</dt>
                                            <dd class="col-sm-4 mb-3">2020-04-21 08:48:18</dd>-->
                                            <dt class="col-sm-2 text-muted">Description</dt>
                                            <dd class="col-sm-10"> ${response.description}.
                                            </dd>

                                        </dl>
                                        <hr class="my-4">
                                        <h5 class="mb-2 mt-4">Tenant Details</h5>
                                        <dl class="row align-items-center mb-0">
                                            <dt class="col-sm-2 mb-3 text-muted">Business Name</dt>
                                            <dd class="col-sm-4 mb-3">
                                                ${business_name}
                                            </dd>
                                            <dt class="col-sm-2 mb-3 text-muted">Business Type</dt>
                                            <dd class="col-sm-4 mb-3">
                                                ${business_type}
                                            </dd>
                                        </dl>
                                        <dl class="row align-items-center mb-0">
                                            <dt class="col-sm-2 mb-3 text-muted">Phone</dt>
                                            <dd class="col-sm-4 mb-3">
                                                ${phone}
                                            </dd>
                                            <dt class="col-sm-2 mb-3 text-muted">Email</dt>
                                            <dd class="col-sm-4 mb-3">
                                                ${email}
                                            </dd>
                                        </dl>
                                        <hr class="my-4">
                                        <h5 class="mb-2 mt-4">Payment History</h5>
                                        <dl class="row align-items-center mb-0">
                                            <div class="col-md-12 my-4">
                                                <div class="card shadow">
                                                    <div class="card-body">
                                                        <h5 class="card-title">Payment History</h5>
                                                        <p class="card-text">Below is a list of all payments for the tenant.</p>
                                                       <table class="table table-hover table-sm">
                                                            <thead>
                                                            <tr>
                                                                <th>Date</th>
                                                                <!--                              <th>ID #</th>-->
                                                                <th>Reference #</th>
                                                                <th>Company/Tenant</th>
                                                                <th>Payment Method</th>
                                                                <th>Invoice #</th>
                                                                <th>Amount</th>
            <!--                                                    <th>View</th>-->
                                                                <!--                              <th>Status</th>-->
                                                            </tr>
                                                            </thead>
                                                            <tbody id="t_body">
            
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </dl>
                                    </div> <!-- .card-body -->`

            let propertyDetails = document.getElementById("compartmentDetails");
            propertyDetails.innerHTML = html;

            let propNameOne = document.getElementById("propNameOne");
            let propNameTwo = document.getElementById("propNameTwo");

            propNameOne.innerText = "Lettable Space " + response.compartmentNumber;
            propNameTwo.innerText = "Lettable Space " + response.compartmentNumber;

            v_c_appendPayments()
        }
    })


}

function v_c_appendPayments() {
    let id = JSON.parse(localStorage.getItem("idComp"));

    $.ajax({
        url: '/api/payment/get-payments-for-specific-tenant/' + id,
        type: 'GET',
        success: function (response) {
            console.log(response)

            if (response !== null) {
                let t_body = document.getElementById("t_body");

                while (t_body.hasChildNodes()) {
                    t_body.removeChild(t_body.firstChild);
                }
                // console.log(response[1].paymentDate)

                for (let i = response.length - 1; i >= 0; i--) {
                    let html = `<td>${response[i].paymentDate}</td>
                                                    <td>${response[i].reference}</td>
                                                    <td>${response[i].tenantObject.business_name}</td>
                                                    <td>${response[i].method}</td>
                                                    <td>${response[i].invoice}</td>
                                                    <td><span class="text-success">${response[i].amount}</span></td>`

                    let tr = document.createElement('tr');
                    tr.innerHTML = html;

                    t_body.appendChild(tr);
                }
            } else {
                let t_body = document.getElementById("t_body");

                while (t_body.hasChildNodes()) {
                    t_body.removeChild(t_body.firstChild);
                }
                // console.log(response[1].paymentDate)

                let html = `<td>"N/A"</td>
                                                    <td>"N/A"</td>
                                                    <td>"N/A"</td>
                                                    <td>"N/A"</td>
                                                    <td>"N/A"</td>
                                                    <td><span class="text-success">"N/A"</span></td>`

                let tr = document.createElement('tr');
                tr.innerHTML = html;

                t_body.appendChild(tr);

            }
        }
    })
}

/************************************Property section******************************************************/

function toggleView(id) {
    let active = document.getElementById(id);

    let local = localStorage.getItem("id")
    let deactivate = document.getElementById(local);
    deactivate.classList.add("hide-sections")

    active.classList.remove("hide-sections")

    localStorage.setItem("deactivate", id);
}

function getSports() {
    // -----------------
    var baseurl = "/api/sport/get-all-sports";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", baseurl, true);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = JSON.parse(xmlhttp.responseText);

            console.log(data);
            $("#property_list").DataTable({
                data: data,
                columns: [

                    {"data": "id"},
                    {
                        "data": function (row) {
                            return "<b> Name :</b> " + row.name + " <br> " + "<b>Address : </b>" + row.addressObject.address;

                        }
                    },
                    {
                        "data": function (row) {
                            return "<b>Line 1 : </b>" + row.propertyContactObject.mobileNumber + "<br> <b>Line 2 : </b>" + row.propertyContactObject.phone + "<br><a href='mailto:" + row.propertyContactObject.email + "'>" + row.propertyContactObject.email + "</a>";
                        }
                    },
                    {
                        "data": function (row) {
                            return "<b>Name : </b>" + row.ownerObject.name + " " + row.ownerObject.lastName + "<br>" + "<b>Phone : </b>" + row.ownerObject.contactDetailsObject.mobileNumber + " <br>" + "<a href='mailto:" + row.ownerObject.contactDetailsObject.email + "'>" + row.ownerObject.contactDetailsObject.email + "</a>";
                        }
                    },
                    {"data": "dateRegistered"},
                    {"data": "numberOfCompartments"},
                    {
                        "data": function (row) {
                            return `<button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="text-muted sr-only">Action</span>
                          </button>
                            <div class="dropdown-menu dropdown-menu-right">
                              <a class="dropdown-item" href="editSport" onclick="setLocal('` + row.id + `')">Edit</a>
                              <a class="dropdown-item" href="viewSport" onclick="setLocal('` + row.id + `','` + row.name + `')">View</a>
                              <a class="dropdown-item" href="#">Assign</a>
                            </div>`
                        },
                        "sortable": false,
                        "searchable": false
                    },

                ]
            });
        }
    };
    xmlhttp.send();

    // ---------------


    /*$.ajax({
        url: '/api/sport/get-all-sports',
        type: 'GET',
        success: function (response) {
            let items = response

            localStorage.setItem("properties", JSON.stringify(items));

            console.log(response)

           /!* var t_body = document.getElementById("t_body");

            while (t_body.hasChildNodes()) {
                t_body.removeChild(t_body.firstChild);
            }
*!/




            for (let i = 0; i < items.length; i++) {
                let new_html = `<td>
                            <div class="custom-control custom-checkbox">
                              <input type="checkbox" class="custom-control-input" id="2474">
                              <label class="custom-control-label" for="2474"></label>
                            </div>
                          </td>
                          <td>
                            <div class="avatar avatar-md">
                              <img src="assets/avatars/office-building.png" alt="..." class="avatar-img rounded-circle">
                            </div>
                          </td>
                          <td>
<!--                            <p class="mb-0 text-muted"><strong>Brown, Asher D.</strong></p>-->
                            <small class="mb-0 text-muted">${items[i].id}</small>
                          </td>
                          <td>
                            <p class="mb-0 text-muted">${items[i].name}</p>
                            <small class="mb-0 text-muted">${items[i].addressObject.address}</small>
                          </td>
                          <td>
                            <p class="mb-0 text-muted"><a href="#" class="text-muted">${items[i].propertyContactObject.phone} ${items[i].propertyContactObject.mobileNumber}</a></p>
                            <small class="mb-0 text-muted">${items[i].propertyContactObject.email}</small>
                          </td>
                          <td class="w-25">
                          <p class="mb-0 text-muted">${items[i].ownerObject.name} ${items[i].ownerObject.lastName}</p>
                          <small class="text-muted"> ${items[i].ownerObject.contactDetailsObject.mobileNumber} ${items[i].ownerObject.contactDetailsObject.email} </small>
                          </td>
                          <td class="text-muted">13/09/2020</td>
                          <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="text-muted sr-only">Action</span>
                          </button>
                            <div class="dropdown-menu dropdown-menu-right"  >
                              <a class="dropdown-item" href="edit_sport.html" onclick="setLocal('${items[i].id}')">Edit</a>
                              <a class="dropdown-item" href="view-sport.html" onclick="setLocal('${items[i].id}','${items[i].name}')">View</a>
<!--                              <a class="dropdown-item" href="#">Assign</a>-->
                            </div>
                          </td>`


                let tr = document.createElement("tr");

                tr.innerHTML = new_html;

                t_body.appendChild(tr);
            }
        }
    })*/
}




function getSports2() {
    // -----------------
    var baseurl = "/api/sport/get-all-sports";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", baseurl, true);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = JSON.parse(xmlhttp.responseText);

            console.log(data);
            $("#property_list").DataTable({
                data: data,
                columns: [

                    {"data": "id"},
                    {"data": "name"},

                    {
                        "data": function (row) {


                            return  ` <a  href="view-sport-with-players"   onClick="setLocal('`+row.id+`','`+row.name+`')">View</a> `;



                        },
                        "sortable": false,
                        "searchable": false
                    },

                ]
            });


        }
    };
    xmlhttp.send();

    // ---------------


    /*$.ajax({
        url: '/api/sport/get-all-sports',
        type: 'GET',
        success: function (response) {
            let items = response

            localStorage.setItem("properties", JSON.stringify(items));

            console.log(response)

           /!* var t_body = document.getElementById("t_body");

            while (t_body.hasChildNodes()) {
                t_body.removeChild(t_body.firstChild);
            }
*!/




            for (let i = 0; i < items.length; i++) {
                let new_html = `<td>
                            <div class="custom-control custom-checkbox">
                              <input type="checkbox" class="custom-control-input" id="2474">
                              <label class="custom-control-label" for="2474"></label>
                            </div>
                          </td>
                          <td>
                            <div class="avatar avatar-md">
                              <img src="assets/avatars/office-building.png" alt="..." class="avatar-img rounded-circle">
                            </div>
                          </td>
                          <td>
<!--                            <p class="mb-0 text-muted"><strong>Brown, Asher D.</strong></p>-->
                            <small class="mb-0 text-muted">${items[i].id}</small>
                          </td>
                          <td>
                            <p class="mb-0 text-muted">${items[i].name}</p>
                            <small class="mb-0 text-muted">${items[i].addressObject.address}</small>
                          </td>
                          <td>
                            <p class="mb-0 text-muted"><a href="#" class="text-muted">${items[i].propertyContactObject.phone} ${items[i].propertyContactObject.mobileNumber}</a></p>
                            <small class="mb-0 text-muted">${items[i].propertyContactObject.email}</small>
                          </td>
                          <td class="w-25">
                          <p class="mb-0 text-muted">${items[i].ownerObject.name} ${items[i].ownerObject.lastName}</p>
                          <small class="text-muted"> ${items[i].ownerObject.contactDetailsObject.mobileNumber} ${items[i].ownerObject.contactDetailsObject.email} </small>
                          </td>
                          <td class="text-muted">13/09/2020</td>
                          <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="text-muted sr-only">Action</span>
                          </button>
                            <div class="dropdown-menu dropdown-menu-right"  >
                              <a class="dropdown-item" href="edit_sport.html" onclick="setLocal('${items[i].id}')">Edit</a>
                              <a class="dropdown-item" href="view-sport.html" onclick="setLocal('${items[i].id}','${items[i].name}')">View</a>
<!--                              <a class="dropdown-item" href="#">Assign</a>-->
                            </div>
                          </td>`


                let tr = document.createElement("tr");

                tr.innerHTML = new_html;

                t_body.appendChild(tr);
            }
        }
    })*/
}

function saveSport() {
    let name = document.getElementById("propertyName").value
    let address = "";
    let tenant = "";
    let insurance = ""
    let description = document.getElementById("description").value
    let propertyType = document.getElementById("propertyType").value
    let owner = ""
    let assetValue = document.getElementById("assetValue").value;
    let dateRegistered = document.getElementById("date-input").value;
    let numberOfFloors = document.getElementById("numberOfFloors").value;


    //property contact details
    let propertyEmail = document.getElementById("propertyEmail").value;
    let propertyPhone = document.getElementById("propertyPhone").value;
    let propertyMobileNumber = document.getElementById("propertyMobileNumber").value;


    //owner Object properties
    let ownerName = document.getElementById("ownerFirstName").value;
    let ownerLastname = document.getElementById("ownerLastName").value;

    let OwnerAddressAddress = document.getElementById("ownerAddress").value;
    let owerZipCode = document.getElementById("ownerZipCode").value;
    let ownerCity = document.getElementById("ownerCity").value;
    let ownerCountry = document.getElementById("ownerCountry").value;

    let ownerPhone = document.getElementById("ownerPhone").value;
    let ownerCell = document.getElementById("ownerCellNumber").value;
    let ownerEmail = document.getElementById("ownerEmailAddress").value;

    //property address object properties
    let propertyAddressAddress = document.getElementById("propertyAddress").value;
    let propertyZipCode = document.getElementById("propertyZipCode").value;
    let propertyCity = document.getElementById("propertyCity").value;
    let propertyCountry = document.getElementById("propertyCountry").value;

    let data = {
        name,
        addressObject: {
            address: propertyAddressAddress,
            zipCode: propertyZipCode,
            city: propertyCity,
            country: propertyCountry,
            property: 0
        },
        numberOfFloors,
        address,
        tenant,
        insurance,
        description,
        propertyType,
        ownerObject: {
            name: ownerName,
            lastName: ownerLastname,
            address: "",
            addressObject: {
                address: OwnerAddressAddress,
                zipCode: owerZipCode,
                city: ownerCity,
                country: ownerCountry,
                property: 0
            },
            contactDetailsObject: {
                phone: ownerPhone,
                mobileNumber: ownerCell,
                email: ownerEmail
            }
        },
        propertyContactObject: {
            phone: propertyPhone,
            mobileNumber: propertyMobileNumber,
            email: propertyEmail
        },
        owner,
        assetValue,
        dateAdded: new Date().toISOString().slice(0, 10),
        dateRegistered
    }

    $.ajax({
        url: '/api/sport/save-sport',
        type: 'POST',
        dataType: "json",
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            // alert("success" + response)
            console.log(response)
            // getProperties();
            let element = document.getElementById("successModal");

            $('#successModal').modal('show')
            // Create toast instance
            // let myToast = new bootstrap.Toast(element);
            // myToast.show()

            document.getElementById("_form").reset();
        }
    })
}

function viewSport() {
    let id = JSON.parse(localStorage.getItem("id"));
    $.ajax({
        url: '/api/sport/get-sport/' + id,
        type: 'GET',
        success: function (response) {
            console.log(response)
            let html = `<div class="card-body">
                                        <dl class="row align-items-center mb-0">
                                            <dt class="col-sm-2 mb-3 text-muted"> Name</dt>
                                            <dd class="col-sm-4 mb-3">
                                                <strong>${response.name}</strong>
                                            </dd>
                                            <dt class="col-sm-2 mb-3 text-muted"> Type</dt>
                                            <dd class="col-sm-4 mb-3">
                                                <strong>${response.propertyType}</strong>
                                            </dd>
                                        </dl>
                                        <dl class="row align-items-center mb-0">
                                            <dt class="col-sm-2 mb-3 text-muted">Grounds Number</dt>
                                            <dd class="col-sm-4 mb-3">
                                                <strong>${response.numberOfCompartments}</strong>
                                            </dd>
                                            <dt class="col-sm-2 mb-3 text-muted"> </dt>
                                            <dd class="col-sm-4 mb-3">
                                                <strong></strong>
                                            </dd>
                                        </dl>
                                        <dl class="row mb-0">
                                           
                                            <dt class="col-sm-2 mb-3 text-muted">Email</dt>
                                            <dd class="col-sm-4 mb-3">${response.propertyContactObject.email}</dd>
                                            <dt class="col-sm-2 mb-3 text-muted">Phone</dt>
                                            <dd class="col-sm-4 mb-3"> ${response.propertyContactObject.phone}</dd>
                                            <dt class="col-sm-2 mb-3 text-muted">Mobile</dt>
                                            <dd class="col-sm-4 mb-3">${response.propertyContactObject.mobileNumber}</dd>
                                            <dt class="col-sm-2 mb-3 text-muted">Date registered</dt>
                                            <dd class="col-sm-4 mb-3">${response.dateRegistered}</dd>
                                            <dt class="col-sm-2 mb-3 text-muted">Date Captured</dt>
                                            <dd class="col-sm-4 mb-3">${response.dateAdded}</dd>
                                           
                                              </dl>
                                        
                                        <dl>
                                        <dt class="col-sm-2 text-muted">Address</dt>
                                            <dd class="col-sm-10"> ${response.addressObject.address} , ${response.addressObject.city} , ${response.addressObject.country}</dd>
                                      
</dl>
<dl>
 <dt class="col-sm-2 text-muted">Description</dt>
                                            <dd class="col-sm-10"> ${response.description}</dd>
</dl>
                                        
                                        
                                        <hr class="my-4">
                                        <h5 class="mb-2 mt-4">Sport Manager Contact Details</h5>
                                        <dl class="row align-items-center mb-0">
                                            <dt class="col-sm-2 mb-3 text-muted">Name</dt>
                                            <dd class="col-sm-4 mb-3">
                                                ${response.ownerObject.name}
                                            </dd>
                                            <dt class="col-sm-2 mb-3 text-muted">Surname</dt>
                                            <dd class="col-sm-4 mb-3">
                                                ${response.ownerObject.lastName}
                                            </dd>
                                        </dl>
                                        <dl class="row align-items-center mb-0">
                                            <dt class="col-sm-2 mb-3 text-muted">Phone</dt>
                                            <dd class="col-sm-4 mb-3">
                                                ${response.ownerObject.contactDetailsObject.phone}
                                            </dd>
                                            <dt class="col-sm-2 mb-3 text-muted">Mobile</dt>
                                            <dd class="col-sm-4 mb-3">
                                                ${response.ownerObject.contactDetailsObject.mobileNumber}
                                            </dd>
                                        </dl>
                                        <dl class="row align-items-center mb-0">
                                            <dt class="col-sm-2 mb-3 text-muted">Email</dt>
                                            <dd class="col-sm-4 mb-3">${response.ownerObject.contactDetailsObject.email}</dd>
                                            <!--<dt class="col-sm-2 mb-3 text-muted">Mobile</dt>
                                            <dd class="col-sm-4 mb-3">
                                                <strong>Kelley Sonya</strong>
                                            </dd>-->
                                        </dl>
                                    </div> <!-- .card-body -->`


            let propertyDetails = document.getElementById("propertyDetails");
            propertyDetails.innerHTML = html;

            let propNameOne = document.getElementById("propNameOne");
            let propNameTwo = document.getElementById("propNameTwo");
            let propNameThree = document.getElementById("propNameThree");
            propNameOne.innerText = response.name;
            propNameTwo.innerText = response.name;
            propNameThree.innerText = response.name;

        }
    })
}

function getPlayers() {
    let id = JSON.parse(localStorage.getItem("id"));
    let sportname= JSON.parse(localStorage.getItem("nameProp"));

}




function getSportsforHistory() {
    // -----------------
    var baseurl = "/api/sport/get-all-sports";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", baseurl, true);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = JSON.parse(xmlhttp.responseText);

            console.log(data);
            $("#property_list").DataTable({
                data: data,
                columns: [

                    {"data": "id"},
                    {"data": "name"},

                    {
                        "data": function (row) {


                            return  ` <a  href="historyDetail"   onClick="setLocal('`+row.id+`','`+row.name+`')">View</a> `;



                        },
                        "sortable": false,
                        "searchable": false
                    },

                ]
            });


        }
    };
    xmlhttp.send();

    // ---------------


    /*$.ajax({
        url: '/api/sport/get-all-sports',
        type: 'GET',
        success: function (response) {
            let items = response

            localStorage.setItem("properties", JSON.stringify(items));

            console.log(response)

           /!* var t_body = document.getElementById("t_body");

            while (t_body.hasChildNodes()) {
                t_body.removeChild(t_body.firstChild);
            }
*!/




            for (let i = 0; i < items.length; i++) {
                let new_html = `<td>
                            <div class="custom-control custom-checkbox">
                              <input type="checkbox" class="custom-control-input" id="2474">
                              <label class="custom-control-label" for="2474"></label>
                            </div>
                          </td>
                          <td>
                            <div class="avatar avatar-md">
                              <img src="assets/avatars/office-building.png" alt="..." class="avatar-img rounded-circle">
                            </div>
                          </td>
                          <td>
<!--                            <p class="mb-0 text-muted"><strong>Brown, Asher D.</strong></p>-->
                            <small class="mb-0 text-muted">${items[i].id}</small>
                          </td>
                          <td>
                            <p class="mb-0 text-muted">${items[i].name}</p>
                            <small class="mb-0 text-muted">${items[i].addressObject.address}</small>
                          </td>
                          <td>
                            <p class="mb-0 text-muted"><a href="#" class="text-muted">${items[i].propertyContactObject.phone} ${items[i].propertyContactObject.mobileNumber}</a></p>
                            <small class="mb-0 text-muted">${items[i].propertyContactObject.email}</small>
                          </td>
                          <td class="w-25">
                          <p class="mb-0 text-muted">${items[i].ownerObject.name} ${items[i].ownerObject.lastName}</p>
                          <small class="text-muted"> ${items[i].ownerObject.contactDetailsObject.mobileNumber} ${items[i].ownerObject.contactDetailsObject.email} </small>
                          </td>
                          <td class="text-muted">13/09/2020</td>
                          <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="text-muted sr-only">Action</span>
                          </button>
                            <div class="dropdown-menu dropdown-menu-right"  >
                              <a class="dropdown-item" href="edit_sport.html" onclick="setLocal('${items[i].id}')">Edit</a>
                              <a class="dropdown-item" href="view-sport.html" onclick="setLocal('${items[i].id}','${items[i].name}')">View</a>
<!--                              <a class="dropdown-item" href="#">Assign</a>-->
                            </div>
                          </td>`


                let tr = document.createElement("tr");

                tr.innerHTML = new_html;

                t_body.appendChild(tr);
            }
        }
    })*/
}


function getSportsforTimeTables() {
    // -----------------
    var baseurl = "/api/sport/get-all-sports";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", baseurl, true);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = JSON.parse(xmlhttp.responseText);

            console.log(data);
            $("#property_list").DataTable({
                data: data,
                columns: [

                    {"data": "id"},
                    {"data": "name"},

                    {
                        "data": function (row) {


                            return  ` <a  href="timeTableDetail"   onClick="setLocal('`+row.id+`','`+row.name+`')">View</a> `;



                        },
                        "sortable": false,
                        "searchable": false
                    },

                ]
            });


        }
    };
    xmlhttp.send();

    // ---------------


    /*$.ajax({
        url: '/api/sport/get-all-sports',
        type: 'GET',
        success: function (response) {
            let items = response

            localStorage.setItem("properties", JSON.stringify(items));

            console.log(response)

           /!* var t_body = document.getElementById("t_body");

            while (t_body.hasChildNodes()) {
                t_body.removeChild(t_body.firstChild);
            }
*!/




            for (let i = 0; i < items.length; i++) {
                let new_html = `<td>
                            <div class="custom-control custom-checkbox">
                              <input type="checkbox" class="custom-control-input" id="2474">
                              <label class="custom-control-label" for="2474"></label>
                            </div>
                          </td>
                          <td>
                            <div class="avatar avatar-md">
                              <img src="assets/avatars/office-building.png" alt="..." class="avatar-img rounded-circle">
                            </div>
                          </td>
                          <td>
<!--                            <p class="mb-0 text-muted"><strong>Brown, Asher D.</strong></p>-->
                            <small class="mb-0 text-muted">${items[i].id}</small>
                          </td>
                          <td>
                            <p class="mb-0 text-muted">${items[i].name}</p>
                            <small class="mb-0 text-muted">${items[i].addressObject.address}</small>
                          </td>
                          <td>
                            <p class="mb-0 text-muted"><a href="#" class="text-muted">${items[i].propertyContactObject.phone} ${items[i].propertyContactObject.mobileNumber}</a></p>
                            <small class="mb-0 text-muted">${items[i].propertyContactObject.email}</small>
                          </td>
                          <td class="w-25">
                          <p class="mb-0 text-muted">${items[i].ownerObject.name} ${items[i].ownerObject.lastName}</p>
                          <small class="text-muted"> ${items[i].ownerObject.contactDetailsObject.mobileNumber} ${items[i].ownerObject.contactDetailsObject.email} </small>
                          </td>
                          <td class="text-muted">13/09/2020</td>
                          <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="text-muted sr-only">Action</span>
                          </button>
                            <div class="dropdown-menu dropdown-menu-right"  >
                              <a class="dropdown-item" href="edit_sport.html" onclick="setLocal('${items[i].id}')">Edit</a>
                              <a class="dropdown-item" href="view-sport.html" onclick="setLocal('${items[i].id}','${items[i].name}')">View</a>
<!--                              <a class="dropdown-item" href="#">Assign</a>-->
                            </div>
                          </td>`


                let tr = document.createElement("tr");

                tr.innerHTML = new_html;

                t_body.appendChild(tr);
            }
        }
    })*/
}

function getSportsforHistoryDetails() {

    let sportName= JSON.parse(localStorage.getItem("nameProp"));

    // -----------------
    var baseurl = "/api/history/get-all-histories/"+sportName;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", baseurl, true);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = JSON.parse(xmlhttp.responseText);

            console.log(data);
            // $("#property_list").DataTable({
            //     data: data,
            //     columns: [
            //
            //         {"data": "id"},
            //         {"data": "name"},
            //
            //         {
            //             "data": function (row) {
            //
            //
            //                 return  ` <a  href="historyDetail"   onClick="setLocal('`+row.id+`','`+row.name+`')">View</a> `;
            //
            //
            //
            //             },
            //             "sortable": false,
            //             "searchable": false
            //         },
            //
            //     ]
            // });

// Add the list to a container element with id "historyList"
            var container = document.getElementById("historyList");
            container.appendChild(generateHistoryList(data));


        }
    };
    xmlhttp.send();

}


function getSportsTimeTable() {

    let sportName= JSON.parse(localStorage.getItem("nameProp"));

    // -----------------
    var baseurl = "/api/timetable/get-all-timetable/"+sportName;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", baseurl, true);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = JSON.parse(xmlhttp.responseText);

            console.log(data);
            // $("#property_list").DataTable({
            //     data: data,
            //     columns: [
            //
            //         {"data": "id"},
            //         {"data": "name"},
            //
            //         {
            //             "data": function (row) {
            //
            //
            //                 return  ` <a  href="historyDetail"   onClick="setLocal('`+row.id+`','`+row.name+`')">View</a> `;
            //
            //
            //
            //             },
            //             "sortable": false,
            //             "searchable": false
            //         },
            //
            //     ]
            // });

// Add the list to a container element with id "historyList"
            var container = document.getElementById("timeTable");
            container.appendChild(generateTimeTable(data));


        }
    };
    xmlhttp.send();

}



function generateTimeTable(data) {
    var ul = document.createElement("ul");
    ul.style.fontSize = "20px";

    // Create list items

        var dt = data[data.length-1];
        var li = document.createElement("li");

        // Create content for each history
        var content =   "<center> <h3> <strong>Time Table for :</strong>   " + dt.sportName + " </h3> </center> <br><br>" +
            " <strong>Monday:</strong> " + dt.monday + "<br>" +
            "<strong>Tuesday:</strong> " + dt.tuesday + "<br>" +
            "<strong> Wednesday </strong>:</strong> " + dt.wednesday +"<br>" +
            " <strong>Thursday:</strong> " + dt.thursday + "<br>" +
            "<strong>Friday:</strong> " + dt.friday + "<br>" +
            "<strong> Saturday </strong>:</strong> " + dt.saturday +"<br>"+
            "<strong> Sunday </strong>:</strong> " + dt.sunday +

            "<br> <br>";

        li.innerHTML = content;
        ul.appendChild(li);


    return ul;
}


function generateHistoryList(histories) {
    var ul = document.createElement("ul");

    // Create list items
    for (var i = 0; i < histories.length; i++) {
        var history = histories[i];
        var li = document.createElement("li");

        // Create content for each history
        var content =   "<center> <strong>Title:</strong>   " + history.title + " </center> <br>" +
            " <strong>Description:</strong> " + history.desciption + "<br>" +
            "<strong>Sport Name:</strong> " + history.sportName + "<br>" +
            "<strong>Date Added:</strong> " + history.dateAdded + "<br> <br>";

        li.innerHTML = content;
        ul.appendChild(li);
    }

    return ul;
}

function getStudentsBySport() {
    // -----

    let sportname= JSON.parse(localStorage.getItem("nameProp"));

    var baseurl = "/api/students/get-all-students-by-sport/"+sportname;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", baseurl, true);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

            var data = JSON.parse(xmlhttp.responseText);


            var url = "/api/v1/lease/getleases";
            var xxx = new XMLHttpRequest();
            xxx.open("GET", url, true);
            xxx.onreadystatechange = function () {

                if (xxx.readyState == 4 && xxx.status == 200) {


                    var leases = JSON.parse(xxx.responseText);

                    for (let i = 0; i < data.length; i++ ){
                        data[i].leases = [];
                        for (let j = 0; j < leases.length; j++){
                            if (data[i].id == leases[j].tenant_id){

                                data[i].leases.push(leases[j]);
                            }
                        }
                    }

                    console.log(data);
                    $("#students").DataTable({
                        data: data,
                        columns: [

                            {"data":"id"},
                            {"data":'business_name'},

                            {"data":"phone"},
                            {"data":"business_type"
                            },
                            {"data":function (row) {
                                    var sport="";
                                    if(row.property===null||row.property==="null") {
                                        sport="..."
                                    }else{
                                        sport=row.property ;
                                    }
                                    return sport;
                                }},
                            {"data":"services"

                            },
                            {"data":function(row){
                                    return`<button class="btn btn-sm " type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span style="font-size: 20px;color: blueviolet" class="fe fe-edit"></span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item"  onclick="LocalTenantID('`+row.id+`')" href="studentDetail"">View</a>
                            
                               
                              </div>`
                                },
                                "sortable":false,
                                "searchable":false
                            }

                        ]
                    });
                }
            }
            xxx.send();


        }
    };
    xmlhttp.send();


}



/*****************************************Edit Property section*************************************************/


//Property Details
function editSportDetails(id) {
    $.ajax({
        url: '/api/sport/get-sport/' + id,
        type: 'GET',
        success: function (response) {

            let html = `<div class="form-row">
                          <div class="form-group col-md-6">
                            <label for="propertyName">Sport Name</label>
                            <input type="text" class="form-control" id="propertyName" placeholder="${response.name}">
                          </div>
                            <div class="form-group col-md-6">
                                <label for="propertyType">Sport Category</label>
                              <select id="propertyType" class="form-control">
                                <option value="Athletics" selected>Athletics</option>
                                <option value="Ball Sports">Ball Sports</option>
                                <option value="Gymnastics"> Gymnastics</option>
                              </select>
                            </div>
                        </div>
                        <div class="form-group" style="display: none">
                          <label for="assetValue">Sport Value</label>
                          <input type="number" class="form-control" id="assetValue" placeholder="${response.assetValue}" value="0">
                        </div>
                        <div class="form-row">
                          <div class="col-md-12 mb-4">
                            <div class="card shadow">
                              <div class="card-body">
                                <div class="form-group mb-3">
                                  <label for="description">Description</label>
                                  <textarea class="form-control" id="description" rows="4" placeholder="${response.description}"></textarea>
                                </div>
                              </div> <!-- /.card-body -->
                              <hr class="my-4">
                              <button type="button" class="btn mb-2 btn-outline-success" onclick="updateSportDetails('${id}')"><span class="fe fe-upload-cloud fe-16"> Update Sport Details</span></button>
                            </div> <!-- /.card -->
                          </div> <!-- /.col -->
                        </div>`


            let container = document.getElementById("update_propertyDetails");

            container.innerHTML = html;

        }
    })
}

function updateSportDetails(id) {
    let name = document.getElementById("propertyName").value
    let description = document.getElementById("description").value
    let propertyType = document.getElementById("propertyType").value
    let propertyAssetValue = document.getElementById("assetValue").value;

    let data = {
        name: name,
        description: description,
        propertyType: propertyType,
        assetValue: propertyAssetValue
    }

    $.ajax({
        url: '/api/sport/update-sport/' + id,
        type: 'PUT',
        dataType: "json",
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {

            editSportDetails(id);
            alert("Update Completed Successfully");

            /*let html =  `<div class="form-row">
                          <div class="form-group col-md-6">
                            <label for="propertyName">Property Name</label>
                            <input type="text" class="form-control" id="propertyName" placeholder="${response.name}">
                          </div>
                            <div class="form-group col-md-6">
                                <label for="propertyType">Property Type</label>
                                <select id="propertyType" class="form-control">
                                    <option selected>Choose...</option>
                                    <option value="Multi Story"> Multi Story</option>
                                    <option value="Complex Building">Complex Building</option>
                                    <option value="Shopping Mall">Shopping Mall</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                          <label for="assetValue">Property Value</label>
                          <input type="number" class="form-control" id="assetValue" placeholder="${response.assetValue}">
                        </div>
                        <div class="form-row">
                          <div class="col-md-12 mb-4">
                            <div class="card shadow">
                              <div class="card-body">
                                <div class="form-group mb-3">
                                  <label for="description">Description</label>
                                  <textarea class="form-control" id="description" rows="4" placeholder="${response.description}"></textarea>
                                </div>
                              </div> <!-- /.card-body -->
                              <hr class="my-4">
                              <button type="button" class="btn mb-2 btn-outline-success" onclick="updatePropertyDetails('${id}')"><span class="fe fe-upload-cloud fe-16"> Update Property Details</span></button>
                            </div> <!-- /.card -->
                          </div> <!-- /.col -->
                        </div>`

            let container = document.getElementById("update_propertyDetails");

            container.innerHTML = html;*/
        }
    })
}

function editSportAddress(id) {
    $.ajax({
        url: '/api/address/get-address/' + id,
        type: 'GET',
        success: function (response) {

            let html = `<div class="form-group">
                            <label for="propertyAddress">Address</label>
                            <input type="text" class="form-control" id="propertyAddress" placeholder="${response.address}">
                          </div>
                          <!--<div class="form-group">
                            <label for="inputAddress2">Address 2</label>
                            <input type="text" class="form-control" id="inputAddress6" placeholder="Apartment, studio, or floor">
                          </div>-->
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="propertyCity">City</label>
                              <input type="text" class="form-control" id="propertyCity" placeholder="${response.city}">
                            </div>
                            <div class="form-group col-md-4">
                              <label for="propertyCountry">Country</label>
                              <select id="propertyCountry" class="form-control">
                                <option selected>${response.country}</option>
                                
                              </select>
                            </div>
                            <div class="form-group col-md-2">
                              <label for="propertyZipCode">Zip</label>
                              <input type="text" class="form-control" id="propertyZipCode" ${response.zipCode}>
                            </div>
                          </div>
                          <hr class="my-4">
                          <button type="button" class="btn mb-2 btn-outline-success" onclick="updateAddress('${id}')"><span class="fe fe-upload-cloud fe-16"> Update Address</span></button>
                       `

            let container = document.getElementById("update_PropertyAddress");
            container.innerHTML = html;

        }
    })
}

function updateAddress(id) {
    //property address object properties
    let name = document.getElementById("propertyAddress").value;
    let address = document.getElementById("propertyAddress").value;
    let zipCode = document.getElementById("propertyZipCode").value;
    let country = document.getElementById("propertyCountry").value;
    let city = document.getElementById("propertyCity").value;


    let data = {
        name,
        address,
        zipCode,
        city,
        country
    }

    $.ajax({
        url: ' /api/address/update-address/' + id,
        type: 'PUT',
        dataType: "json",
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            console.log(response);
            alert("Update Completed Successfully");


            editSportAddress(id);
        }
    })
}


function editSportContactDetails(id) {
    $.ajax({
        url: '/api/contact-details/get-contact-details/' + id,
        type: 'GET',
        success: function (response) {

            let html = `<div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="ownerEmailAddress">Email</label>
                                    <input type="email" class="form-control" id="propertyEmail" placeholder="${response.email}">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="ownerPhone">Phone 1</label>
                                    <input type="text" class="form-control" id="propertyPhone" placeholder="${response.phone}">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="ownerCellNumber">Phone 2</label>
                                    <input type="text" class="form-control" id="propertyMobileNumber" placeholder="${response.mobileNumber}">
                                </div>
                            </div>
                            <hr class="my-4">
                            <button type="button" class="btn mb-2 btn-outline-success" onclick="updateSportContactDetails('${id}')"><span class="fe fe-upload-cloud fe-16"> Update Contacts</span></button>
`


            let container = document.getElementById("propertyContactDetails");
            container.innerHTML = html;
        }
    })
}

function updateSportContactDetails(id) {
    let phone = document.getElementById("propertyPhone").value;
    let mobileNumber = document.getElementById("propertyMobileNumber").value;
    let email = document.getElementById("propertyEmail").value;

    let data = {
        phone,
        mobileNumber,
        email
    }

    $.ajax({
        url: ' /api/contact-details/update-contact-details/' + id,
        type: 'PUT',
        dataType: "json",
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            alert("Update Completed Successfully");
            editSportContactDetails(id);
        }
    })
}

//Property Owner Details
function editSportOwnerDetails(id) {
    $.ajax({
        url: '/api/owner/get-owner/' + id,
        type: 'GET',
        success: function (response) {
            let html = `<div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="ownerFirstName">Firstname</label>
                              <input type="text" id="ownerFirstName" class="form-control" placeholder="${response.name}">
                            </div>
                            <div class="form-group col-md-6">
                              <label for="ownerLastName">Lastname</label>
                              <input type="text" id="ownerLastName" class="form-control" placeholder="${response.lastName}">
                            </div>
                          </div>
                          <hr class="my-4">
                          <button type="button" class="btn mb-2 btn-outline-success" onclick="updateSportManagerDetails('${id}')"><span class="fe fe-upload-cloud fe-16"> Update Manager</span></button>
                        `

            let container = document.getElementById("update_PropertyOwnerDetails");
            container.innerHTML = html;
        }
    })
}

function updateSportManagerDetails(id) {
    let name = document.getElementById("ownerFirstName").value;
    let lastName = document.getElementById("ownerFirstName").value;

    let data = {
        name,
        lastName
    }

    $.ajax({
        url: '/api/owner/update-owner/' + id,
        type: 'PUT',
        dataType: "json",
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            alert("Update Completed Successfully");
            editSportOwnerDetails(id)
        }
    })
}

function editSportOwnerAddress(id) {
    $.ajax({
        url: '/api/address/get-address/' + id,
        type: 'GET',
        success: function (response) {
            let html = `                          <hr class="my-4">
                          <h5 class="mb-2 mt-4">Address</h5>
                          <p class="mb-4">Input Sport Address</p>
                          <div class="form-row">
                            <div class="form-group col-md-12">
                              <div class="form-group">
                                <label for="ownerAddress">Address</label>
                                <input type="text" class="form-control" id="ownerAddress" placeholder="${response.address}">
                              </div>
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group col-md-4">
                              <label for="ownerZipCode">Zip code</label>
                              <input class="form-control input-zip" id="ownerZipCode" ${response.country}>
                            </div>
                            <div class="form-group col-md-4">
                              <label for="ownerCountry">Country</label>
                              <select id="ownerCountry" class="form-control">
                                <option valye="">${response.country}</option>
                                <option>...</option>
                              </select>
                            </div>
                            <div class="form-group col-md-4">
                              <label for="ownerCity">City</label>
                             <input type="text" class="form-control" id="ownerCity" placeholder="${response.city}">
                        
                            </div>
                          </div>
                          <hr class="my-4">
                          <button type="button" class="btn mb-2 btn-outline-success" onclick="updateSportManagerAddress('${id}')"><span class="fe fe-upload-cloud fe-16"> Update Address</span></button>
                        `

            let container = document.getElementById("update_PropertyOwnerAddress");
            container.innerHTML = html;
        }
    })
}

function updateSportManagerAddress(id) {
    let address = document.getElementById("ownerAddress").value;
    let zipCode = document.getElementById("ownerZipCode").value;
    let city = document.getElementById("ownerCity").value;
    let country = document.getElementById("ownerCountry").value;

    let data = {
        address,
        zipCode,
        city,
        country
    }

    $.ajax({
        url: ' /api/address/update-address/' + id,
        type: 'PUT',
        dataType: "json",
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            alert("Update Completed Successfully");
            editSportOwnerAddress(id);
        }
    })
}

function editSportOwnerContactDetails(id) {
    $.ajax({
        url: '/api/contact-details/get-contact-details/' + id,
        type: 'GET',
        success: function (response) {

            let html = `<div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="ownerEmailAddress">Email</label>
                                    <input type="email" class="form-control" id="ownerEmailAddress" placeholder="${response.email}">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="ownerPhone">Phone</label>
                                    <input type="text" class="form-control" id="ownerPhone" placeholder="${response.phone}">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="ownerCellNumber">Mobile Number</label>
                                    <input type="text" class="form-control" id="ownerCellNumber" placeholder="${response.mobileNumber}">
                                </div>
                            </div>
                            <hr class="my-4">
                            <button type="button" class="btn mb-2 btn-outline-success" onclick="updateSportManagerContactDetails('${id}')"><span class="fe fe-upload-cloud fe-16"> Update Contacts</span></button>
`


            let container = document.getElementById("update_PropertyOwnerContactDetails");
            container.innerHTML = html;
        }
    })
}

function updateSportManagerContactDetails(id) {
    let phone = document.getElementById("ownerPhone").value;
    let mobileNumber = document.getElementById("ownerCellNumber").value;
    let email = document.getElementById("ownerEmailAddress").value;

    let data = {
        phone,
        mobileNumber,
        email
    }

    $.ajax({
        url: ' /api/contact-details/update-contact-details/' + id,
        type: 'PUT',
        dataType: "json",
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            alert("Update Completed Successfully");
            editSportOwnerContactDetails(id);
        }
    })
}

function setPropertyDetails() {
    let id = JSON.parse(localStorage.getItem("id"))

    let url = '/api/sport/get-sport/' + id;

    $.ajax({
        url: url,
        type: 'GET',
        success: function (response) {
            editSportDetails(id);
            editSportAddress(response.address);
            editSportOwnerDetails(response.owner);
            editSportContactDetails(response.propertyContactObject.id)
            editSportOwnerAddress(response.ownerObject.address);
            editSportOwnerContactDetails(response.ownerObject.contactDetailsObject.id);
        }
    })
}
