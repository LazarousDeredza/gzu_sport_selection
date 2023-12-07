function getStudents() {
    // -----
    var baseurl = "/api/students/get-all-students";
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
                            
                                <a class="dropdown-item" href="/assignSport">Assign Sport</a>
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

function getLecturers() {
    // -----
    var baseurl = "/api/lecturers/get-all-lecturers";
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
                                <a class="dropdown-item"  onclick="LocalTenantID('`+row.id+`')" href="lecturerDetail"">View</a>
                            
                                <a class="dropdown-item" href="/assignSportToLecture">Assign Sport to coach</a>
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


function saveStudent() {
    let name = document.getElementById("name").value
    let property = "null";
    let lease = " Active"
    let surname = document.getElementById("surname").value
    let email = document.getElementById("email").value
    let id_passport = document.getElementById("passport").value;


    let b_email = document.getElementById("b_email").value
    let b_phone = document.getElementById("b_phone").value
    let b_tel = document.getElementById("b_tel").value;
    let address = document.getElementById("address").value;
    //property contact details
    let phone = document.getElementById("phone").value;


    //owner Object properties
    let website = document.getElementById("website").value;
    let business_name = document.getElementById("business_name").value;

    let business_type = document.getElementById("business_type").value;
    let services = document.getElementById("services").value;


    let city = document.getElementById("city").value;
    let country = document.getElementById("country").value;

    //property address object properties
    let rent_status = "Paid";


    let data = {
        city,
        country,
        email,
        website,
        address,
        b_email,
        b_phone,
        b_tel,
        id_passport,
        lease,
        name,
        phone,
        property,
        rent_status,
        surname,
        business_name,
        business_type,
        services
    }

    $.ajax({
        url: '/api/students/addStudent',
        type: 'POST',
        dataType: "json",
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            $('#successModal').modal('show');
            console.log(response)

        },
        error: function (e) {
            console.log(e);
        }

    })

    $("#tenant_form")[0].reset();
}

function saveLecturer() {
    let name = document.getElementById("name").value
    let property = "null";
    let lease = " Active"
    let surname = document.getElementById("surname").value
    let email = document.getElementById("email").value
    let id_passport = document.getElementById("passport").value;


    let b_email = document.getElementById("b_email").value
    let b_phone = document.getElementById("b_phone").value
    let b_tel = document.getElementById("b_tel").value;
    let address = document.getElementById("address").value;
    //property contact details
    let phone = document.getElementById("phone").value;


    //owner Object properties
    let website = document.getElementById("website").value;
    let business_name = document.getElementById("business_name").value;

    let business_type = document.getElementById("business_type").value;
    let services = document.getElementById("services").value;


    let city = document.getElementById("city").value;
    let country = document.getElementById("country").value;

    //property address object properties
    let rent_status = "Paid";


    let data = {
        city,
        country,
        email,
        website,
        address,
        b_email,
        b_phone,
        b_tel,
        id_passport,
        lease,
        name,
        phone,
        property,
        rent_status,
        surname,
        business_name,
        business_type,
        services
    }

    $.ajax({
        url: '/api/lecturers/addLecturer',
        type: 'POST',
        dataType: "json",
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            $('#successModal').modal('show');
            console.log(response)

        },
        error: function (e) {
            console.log(e);
        }

    })

    $("#tenant_form")[0].reset();
}

function LocalTenantID(id) {
    localStorage.removeItem("t_id");
    localStorage.setItem("t_id", JSON.stringify(id));


}

function setLocalfile(id) {
    localStorage.removeItem("tenantId");
    localStorage.setItem("tenantId", JSON.stringify(id));
}

function setType(filetype) {
    localStorage.removeItem("filetype");
    localStorage.setItem("filetype", JSON.stringify(filetype));

}

function setLocalfiles(application_letter, article, bank_statement, cr6_form, cr14_form, director_id, tax_clearance, vat_reg, certificate_of_incorporation) {
    localStorage.removeItem("application_letter");
    localStorage.setItem("application_letter", JSON.stringify(application_letter));
    localStorage.removeItem("article");
    localStorage.setItem("article", JSON.stringify(article));
    localStorage.removeItem("bank_statement");
    localStorage.setItem("bank_statement", JSON.stringify(bank_statement));
    localStorage.removeItem("cr6_form");
    localStorage.setItem("cr6_form", JSON.stringify(cr6_form));
    localStorage.removeItem("cr14_form");
    localStorage.setItem("cr14_form", JSON.stringify(cr14_form));
    localStorage.removeItem("director_id");
    localStorage.setItem("director_id", JSON.stringify(director_id));
    localStorage.removeItem("tax_clearance");
    localStorage.setItem("tax_clearance", JSON.stringify(tax_clearance));
    localStorage.removeItem("vat_reg");
    localStorage.setItem("vat_reg", JSON.stringify(vat_reg));
    localStorage.removeItem("certificate_of_incorporation");
    localStorage.setItem("certificate_of_incorporation", JSON.stringify(certificate_of_incorporation));
}

// view Tenant Details
function getStudentBYid() {
    let id = JSON.parse(localStorage.getItem("t_id"));
    $.ajax({
        url: '/api/students/getStudentByID/' + id,
        type: 'GET',
        success: function (response) {
            console.log(response);
            let businessName = document.getElementById("businessName");
            businessName.innerHTML = `${response.business_name}`;
            let businessType = document.getElementById("businessType");
            businessType.innerHTML = `${response.business_type}`;
            let businessEmail = document.getElementById("b_email");
            businessEmail.innerHTML = `${response.b_email}`;
            let businessPhone = document.getElementById("b_phone");
            businessPhone.innerHTML = `${response.b_phone}`;
            let businessTel = document.getElementById("b_tel");
            businessTel.innerHTML = `${response.b_tel}`;
            let businessCountry = document.getElementById("businessCountry");
            businessCountry.innerHTML = `${response.country}`;
            let businessCity = document.getElementById("businessCity");
            businessCity.innerHTML = `${response.city}`;

            if (response.website == null) {
                let website = document.getElementById("website");
                website.innerHTML = "N/A";
            } else {
                let website = document.getElementById("website");
                website.innerHTML = `${response.website}`;
            }

            if (response.website == null) {
                let businessService = document.getElementById("businessService");
                businessService.innerHTML = "N/A";
            } else {
                let businessService = document.getElementById("businessService");
                businessService.innerHTML = `${response.services}`;
            }

            let tenantname = document.getElementById("tenantname");
            tenantname.innerHTML = `${response.name}`;
            let tenantsurname = document.getElementById("tenantsurname");
            tenantsurname.innerHTML = `${response.surname}`;
            let tenantphone = document.getElementById("tenantphone");
            tenantphone.innerHTML = `${response.phone}`;

            let tenantemail = document.getElementById("tenantemail");
            tenantemail.innerHTML = `${response.email}`;

            let businessName2 = document.getElementById("businessName2");
            businessName2.innerHTML = `${response.business_name}`;

            let businessName3 = document.getElementById("businessName3");
            businessName3.innerHTML = `${response.business_name}`;


            $("#tenant-compartment").DataTable({
                data: response.compartmentObjectlist,
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
                            return "$" + row.rentalRate;
                        }
                    },

                    {
                        "data": function (row) {
                            return row.floorArea + " &#13217";
                        }
                    },
                    {
                        "data": function (row) {
                            return "$" + row.floorArea * row.rentalRate;
                        }
                    },
                    {
                        "data": function (row) {
                            return `<button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                                </button>
                                <div class="dropdown-menu dropdown-menu-right">
                               
                                <a class="dropdown-item" href="view-compartment.html" onclick="setLocalCompartment('` + row.id + `')">View</a>
                                </div>`
                        },
                        "sortable": false,
                        "searchable": false
                    }
                ]
            })


        }
    })
    $.ajax({
        url: '/api/tenant/fetchfile/' + id,
        type: 'GET',
        success: function (response) {
            console.log(response);
            if (response.length == 0) {
                let processing = document.getElementById("processing");
                processing.setAttribute("style", "display:none");

                let notAvailable = document.getElementById("notavailable");
                notAvailable.setAttribute("style", "display:all");

                let found = document.getElementById("documents");
                found.setAttribute("style", "display:none");
            } else {
                setLocalfile(id);
                setLocalfiles(response[0].application_letter, response[0].article, response[0].bank_statement, response[0].cr6_form, response[0].cr14_form, response[0].director_id, response[0].tax_clearance, response[0].vat_reg, response[0].certificate_of_incorporation);

                let processing = document.getElementById("processing");
                processing.setAttribute("style", "display:none");

                let notAvailable = document.getElementById("notavailable");
                notAvailable.setAttribute("style", "display:none");

                let found = document.getElementById("documents");
                found.setAttribute("style", "display:all");
            }

        }
    })

}

function getLecturerBYid() {
    let id = JSON.parse(localStorage.getItem("t_id"));
    $.ajax({
        url: '/api/lecturers/getLecturerByID/' + id,
        type: 'GET',
        success: function (response) {
            console.log(response);
            let businessName = document.getElementById("businessName");
            businessName.innerHTML = `${response.business_name}`;
            let businessType = document.getElementById("businessType");
            businessType.innerHTML = `${response.business_type}`;
            let businessEmail = document.getElementById("b_email");
            businessEmail.innerHTML = `${response.b_email}`;
            let businessPhone = document.getElementById("b_phone");
            businessPhone.innerHTML = `${response.b_phone}`;
            let businessTel = document.getElementById("b_tel");
            businessTel.innerHTML = `${response.b_tel}`;
            let businessCountry = document.getElementById("businessCountry");
            businessCountry.innerHTML = `${response.country}`;
            let businessCity = document.getElementById("businessCity");
            businessCity.innerHTML = `${response.city}`;

            if (response.website == null) {
                let website = document.getElementById("website");
                website.innerHTML = "N/A";
            } else {
                let website = document.getElementById("website");
                website.innerHTML = `${response.website}`;
            }

            if (response.website == null) {
                let businessService = document.getElementById("businessService");
                businessService.innerHTML = "N/A";
            } else {
                let businessService = document.getElementById("businessService");
                businessService.innerHTML = `${response.services}`;
            }

            let tenantname = document.getElementById("tenantname");
            tenantname.innerHTML = `${response.name}`;
            let tenantsurname = document.getElementById("tenantsurname");
            tenantsurname.innerHTML = `${response.surname}`;
            let tenantphone = document.getElementById("tenantphone");
            tenantphone.innerHTML = `${response.phone}`;

            let tenantemail = document.getElementById("tenantemail");
            tenantemail.innerHTML = `${response.email}`;

            let businessName2 = document.getElementById("businessName2");
            businessName2.innerHTML = `${response.business_name}`;

            let businessName3 = document.getElementById("businessName3");
            businessName3.innerHTML = `${response.business_name}`;


            $("#tenant-compartment").DataTable({
                data: response.compartmentObjectlist,
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
                            return "$" + row.rentalRate;
                        }
                    },

                    {
                        "data": function (row) {
                            return row.floorArea + " &#13217";
                        }
                    },
                    {
                        "data": function (row) {
                            return "$" + row.floorArea * row.rentalRate;
                        }
                    },
                    {
                        "data": function (row) {
                            return `<button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                                </button>
                                <div class="dropdown-menu dropdown-menu-right">
                               
                                <a class="dropdown-item" href="view-compartment.html" onclick="setLocalCompartment('` + row.id + `')">View</a>
                                </div>`
                        },
                        "sortable": false,
                        "searchable": false
                    }
                ]
            })


        }
    })
    $.ajax({
        url: '/api/tenant/fetchfile/' + id,
        type: 'GET',
        success: function (response) {
            console.log(response);
            if (response.length == 0) {
                let processing = document.getElementById("processing");
                processing.setAttribute("style", "display:none");

                let notAvailable = document.getElementById("notavailable");
                notAvailable.setAttribute("style", "display:all");

                let found = document.getElementById("documents");
                found.setAttribute("style", "display:none");
            } else {
                setLocalfile(id);
                setLocalfiles(response[0].application_letter, response[0].article, response[0].bank_statement, response[0].cr6_form, response[0].cr14_form, response[0].director_id, response[0].tax_clearance, response[0].vat_reg, response[0].certificate_of_incorporation);

                let processing = document.getElementById("processing");
                processing.setAttribute("style", "display:none");

                let notAvailable = document.getElementById("notavailable");
                notAvailable.setAttribute("style", "display:none");

                let found = document.getElementById("documents");
                found.setAttribute("style", "display:all");
            }

        }
    })

}


function getStudentsAssign() {

    $.ajax({
        url: '/api/sport/get-all-sports',
        type: 'GET',
        success: function (response) {
            let items = response

            console.log(response)

            var buildings = document.getElementById("building_option");

            for (let i = 0; i < items.length; i++) {
                let html =
                    `<option value="${items[i].id}" >${items[i].name}</option>`

                let tr = document.createElement("option");


                tr.innerHTML = html;

                buildings.appendChild(tr);


            }


        }


    })
}


function getCompartmentDetails() {

    $.ajax({
        url: '/api/sport/get-all-sports',
        type: 'GET',
        success: function (response) {
            let buildings = response

            console.log($("#building_option").val());

            let prop = document.getElementById("building_option").value;


            for (let i = 0; i < buildings.length; i++) {

                if (buildings[i].name === prop) {

                    console.log(buildings[i].id);
                    let id = buildings[i].id;

                    $.ajax({
                        url: '/api/ground/get-grounds-for-specific-sport/' + id,
                        type: 'GET',
                        data: {id},
                        success: function (response) {
                            let compartments = response

                            console.log(response)


                            let fl = document.getElementById("compartmentDropdown");
                            // while (tenant_list.hasChildNodes()) {
                            //     tenant_list.removeChild(tenant_list.firstChild);
                            // }

                            for (let i = 0; i < compartments.length; i++) {
                                // if (compartments[i].status){
                                let html =
                                    `<option value="${compartments[i].id}">${compartments[i].compartmentNumber}</option>`

                                let tr = document.createElement("option");


                                tr.innerHTML = html;

                                fl.appendChild(tr);
                            }

                        }

                    })


                }
            }


        }


    })

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
                              <a class="dropdown-item" href="edit_property.html" onclick="setLocal('${items[i].id}')">Edit</a>
                              <a class="dropdown-item" href="view-property.html" onclick="setLocal('${items[i].id}','${items[i].name}')">View</a>
<!--                              <a class="dropdown-item" href="#">Assign</a>-->
                            </div>
                          </td>`


            let tr = document.createElement("tr");

            tr.innerHTML = new_html;

            t_body.appendChild(tr);
        }
    }
}

/************************************compartment section******************************************************/

function setAddSportDropDown() {
    $.ajax({
        url: '/api/sport/get-all-sports',
        type: 'GET',
        success: function (response) {
            console.log(response)
            let dropDown = document.getElementById("sport-dropdown");

            /* while (dropDown.hasChildNodes()) {
                 dropDown.removeChild(dropDown.firstChild);
             }*/

            for (let i = 0; i < response.length; i++) {
                let option = document.createElement("option");

                option.text = response[i].name;
                option.setAttribute("value", `${response[i].id}`)

                dropDown.appendChild(option);
            }
        }
    })
}

function setAddStudentDropDown() {


    /*tenant dropdown*/
    var baseurl = "/api/students/get-all-students";
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



                 /*   Fillling*/

                    let dropDown = document.getElementById("tenant_list");

                    while (dropDown.hasChildNodes()) {
                        dropDown.removeChild(dropDown.firstChild);
                    }
                    let option = document.createElement("option");

                    option.text = "Available Students";
                    dropDown.appendChild(option);

                    for (let i =0;i<data.length;i++){
                        if (data[i].leases.length.toString()==="0"){
                            let option = document.createElement("option");

                            option.text = data[i].business_name;
                            option.setAttribute("value", `${data[i].id}`)

                            dropDown.appendChild(option);
                        }else{

                           var terminated = new Boolean(false);

                            for ( let j =0;j<data[i].leases.length;j++){

                                if(data[i].leases[j].status==="Expired"){

                                    terminated = false
                                }
                                else if(data[i].leases[j].status==="Active"){

                                    terminated = false
                                }
                                else if(data[i].leases[j].status==="Terminated"){
                                    terminated=true;
                                    break;
                                }
                            }
                            if(terminated===false){
                                let option = document.createElement("option");

                                option.text = data[i].business_name;
                                option.setAttribute("value", `${data[i].id}`);

                                dropDown.appendChild(option);
                            }
                        }

                    }



                }
            }
            xxx.send();


        }
    };
    xmlhttp.send();



}

function setAddLecturerDropDown() {


    /*tenant dropdown*/
    var baseurl = "/api/lecturers/get-all-lecturers";
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



                    /*   Fillling*/

                    let dropDown = document.getElementById("tenant_list");

                    while (dropDown.hasChildNodes()) {
                        dropDown.removeChild(dropDown.firstChild);
                    }
                    let option = document.createElement("option");

                    option.text = "Available Lecturers";
                    dropDown.appendChild(option);

                    for (let i =0;i<data.length;i++){
                        if (data[i].leases.length.toString()==="0"){
                            let option = document.createElement("option");

                            option.text = data[i].business_name;
                            option.setAttribute("value", `${data[i].id}`)

                            dropDown.appendChild(option);
                        }else{

                            var terminated = new Boolean(false);

                            for ( let j =0;j<data[i].leases.length;j++){

                                if(data[i].leases[j].status==="Expired"){

                                    terminated = false
                                }
                                else if(data[i].leases[j].status==="Active"){

                                    terminated = false
                                }
                                else if(data[i].leases[j].status==="Terminated"){
                                    terminated=true;
                                    break;
                                }
                            }
                            if(terminated===false){
                                let option = document.createElement("option");

                                option.text = data[i].business_name;
                                option.setAttribute("value", `${data[i].id}`);

                                dropDown.appendChild(option);
                            }
                        }

                    }



                }
            }
            xxx.send();


        }
    };
    xmlhttp.send();



}


function studentAssignLocalStudent(id) {
    localStorage.removeItem("tenant_id");
    localStorage.setItem("tenant_id", JSON.stringify(id));


}

function tenantAssignLocalCompartment(compartment_id) {
    localStorage.removeItem("compartment_id");
    localStorage.setItem("compartment_id", JSON.stringify(compartment_id));
}



function setlocalSelectedSport(selected) {
    localStorage.removeItem("sport_id");
    localStorage.setItem("sport_id", JSON.stringify(selected));
}
function setlocalSelectedSportName(selected) {
    localStorage.removeItem("sport_name");
    localStorage.setItem("sport_name", JSON.stringify(selected));
}
function onSetStudents() {

    // console.log("tenant_id");
    var select = document.getElementById("tenant_list");

    var selected = select.options[select.selectedIndex];


    // setDropDownLocal(id);
    var id = selected.value;
    console.log(id);

    studentAssignLocalStudent(id)


}

function onSetProperty() {
    var select = document.getElementById("sport-dropdown");

    var selected = select.options[select.selectedIndex];


    // setDropDownLocal(id);
    var compartment_id = selected.value;



    //setAddGroundDropDown(compartment_id);
    //tenantAssignLocalCompartment(compartment_id);
    setlocalSelectedSport(selected.value);
    setlocalSelectedSportName(selected.text);

    console.log(selected.value);
    console.log(selected.text);


}

function setAddGroundDropDown(compartment_id) {

    $.ajax({

        url: '/api/ground/get-grounds-for-specific-sport/' + compartment_id,
        type: 'GET',
        success: function (response) {
            console.log(response)
            let dropDown = document.getElementById("compartmentDropdown");

            while (dropDown.hasChildNodes()) {
                dropDown.removeChild(dropDown.firstChild);
            }
            let option = document.createElement("option");

            option.text = "Select Ground";
            dropDown.appendChild(option);


            for (let i = 0; i < response.length; i++) {
                // if (response[i].status != "1") {
                    let option = document.createElement("option");

                    option.text = response[i].compartmentNumber;
                    option.setAttribute("value", `${response[i].id}`);

                    dropDown.appendChild(option);
                // }
            }


        }
    })
}

function setStudentOnGround() {
    //let id = JSON.parse(localStorage.getItem("compartment_id"));

    var id = document.getElementById("compartmentDropdown").value

    let tenant_id = JSON.parse(localStorage.getItem("tenant_id"));
    console.log(id);
    console.log(tenant_id)
    var data = {
        "tenant": tenant_id,
        "status": "1"
    };
    $.ajax({

        url: '/api/ground/update-ground/' + id,
        type: 'PUT',
        dataType: "json",
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function () {
            $('#assignedModal').modal('show')


        }
    });

    $("#assign_form")[0].reset();

}


function setStudentOnGround2() {


    let sport_id = JSON.parse(localStorage.getItem("sport_id"));

    let student_id = JSON.parse(localStorage.getItem("tenant_id"));
    console.log(sport_id);
    console.log(student_id)

    $.ajax({

        url: '/api/students/updateStudentSport/' + student_id+"/"+sport_id,
        type: 'PUT',
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",

        success: function () {
            $('#assignedModal').modal('show')


        }
    });

    $("#assign_form")[0].reset();

}

function saveHistory() {

    let sportName = JSON.parse(localStorage.getItem("sport_name"));

    let title = document.getElementById("title").value
    let desciption = document.getElementById("description").value

    const date= new Date();


    let dateAdded=date.toLocaleDateString("en-GB");


    let data = {
        sportName,
        title,
        desciption,
        dateAdded,

    }



    $.ajax({
        url: '/api/history/save-history',
        type: 'POST',
        dataType: "json",
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            $('#assignedModal').modal('show');
            console.log(response)

        },
        error: function (e) {
            console.log(e);
        }

    })

}

function setLecturerOnGround2() {


    let sport_id = JSON.parse(localStorage.getItem("sport_id"));

    let lecturer_id = JSON.parse(localStorage.getItem("tenant_id"));
    console.log(sport_id);
    console.log(lecturer_id)

    $.ajax({

        url: '/api/lecturers/updateLecturerSport/' + lecturer_id+"/"+sport_id,
        type: 'PUT',
        crossDomain: "true",
        contentType: "application/json; charset=utf-8",

        success: function () {
            $('#assignedModal').modal('show')


        }
    });

    $("#assign_form")[0].reset();

}



