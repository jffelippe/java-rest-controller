//variables globales
let URL_BASE = "http://localhost:8080";
let User = null;

//Ejecutar cuando se carge la paguina
$(document).ready(function (){
    getAllUser();

    $("#modalUser").hide();
});
//Acciones con el modal
function openModal(idUser) {
    if(idUser==-1){                         //activar para agregar
        $("#btnAdd").show();
        $("#btnUpdate").hide();
        $("#txtId").val(-1);
        $("#user_name").val("");
        $("#user_lastname").val("");
        $("#user_email").val("");
        $("#user_phone").val("");
    }
    else{                               //activar para actualizar
        $("#btnAdd").hide();
        $("#btnUpdate").show();
        User = getUser(idUser);
        $("#txtId").val(User.idUser);
        $("#user_name").val(User.name);
        $("#user_lastname").val(User.lastname);
        $("#user_email").val(User.email);
        $("#user_phone").val(User.phone);
    }
    $("#modalUser").show();

}

function closeModal() {
    $("#modalUser").hide();

}
//Actualizar la tabla de datos
function updateDataGrid(items) {
    $("#tblUser").find("tr:gt(0)").remove();
    let data = "";
    for (let i = 0; i < items.length; i++) {
        data += "<tr>";
        data += "<td></td>";
        data += "<td>" + items[i].name + "</td>";
        data += "<td>" + items[i].lastname + "</td>";
        data += "<td>" + items[i].email + "</td>";
        data += "<td>" + items[i].phone + "</td>";
        data += "<td><span onclick=\"openModal(" + items[i].idUser + ")\">A</span></td>";
        data += "<td><span onclick=\"deleteUser(" + items[i].idUser + ")\">E</span></td>";
        data += "</tr>";
    }
    $("#tblUser> tbody:last-child").append(data);
}

//Llamado Backend para CRUD
function getAllUser() {
        $.ajax({
            url: URL_BASE + "/User/all",
            type: "GET",
            datatype: "JSON"
        })
            .done(function (response) {
                console.log(response);
                updateDataGrid(response);
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                alert("Error getting users");
            });
    }

    function getUser(idUser) {
        $.ajax({
            async: false,
            url: URL_BASE + "/User/" + idUser,
            type: "GET",
            datatype: "JSON"
        })
            .done(function (response) {
                console.log(response);
                User = response;
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                console.log("Error getting user" + idUser);
            });
        return User;

    }


    function insertUser() {
        User = {
            name: $("#user_name").val(),
            lastname: $("#user_lastname").val(),
            email: $("#user_email").val(),
            phone: $("#user_phone").val()
        }

        let body = JSON.stringify(User)
        $.ajax({
            url: URL_BASE + "/User/save",
            type: "POST",
            datatype: "JSON",
            data: body,
            contentType: "application/json;charset=UFT-8"
        })
            .done(function (response) {
                console.log(response);
                alert("User added")
                getAllUser();

            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                alert("Error creating user.");
            });
        closeModal();


    }

    function updateUser() {
        User = {
            idUser: $("#txtId").val(),
            name: $("#user_name").val(),
            name: $("#user_lastname").val(),
            email: $("#user_email").val(),
            phone: $("#user_phone").val()

        }
        let body = JSON.stringify(User)
        $.ajax({
            url: URL_BASE + "/User/update",
            type: "PUT",
            datatype: "JSON",
            data: body,
            contentType: "application/json;charset=UFT-8"
        })
            .done(function (response) {
                console.log(response);
                alert("User updated");
                getAllUser();

            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                alert("There's an error updating user")
            });
        closeModal();

    }

    function deleteUser(idUser) {
        $.ajax({
            url: URL_BASE + "/User/" + idUser,
            type: "DELETE",
            datatype: "JSON"
        })
            .done(function (response) {
                console.log(response);
                alert("User deleted");
                getAllUser();

            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                alert("Error deleting user" + idUser)

            });
    }
