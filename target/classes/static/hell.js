$(document).ready(function() {

    var API = function() {
        var getAllUsers = function(callback) {
            $.ajax({
                url: "/getAllUsers",
                success: function(data) {
                    callback(data);
                }
            });
        };

        var addUser = function(info, callback) {
            $.ajax({
                url: "/user/add",
                data: info,
                dataType: 'json',
                success: function(data) {
                    callback(data);
                }
            });
        };

        var removeUser = function(id, callback) {
            $.ajax({
                url: "/user/remove/" + id,
                success: function(data) {
                    callback(data);
                }
            });
        };

        var editUser = function(id, info, callback) {
            $.ajax({
                url: "/user/edit/" + id,
                data: info,
                dataType: 'json',
                success: function(data) {
                    callback(data);
                }
            });
        };

		
		
		var getAllEquipment = function(callback) {
            $.ajax({
                url: "/getAllEquipment",
                success: function(data) {
                    callback(data);
                }
            });
        };

        var addEquipment = function(info, callback) {
            $.ajax({
                url: "/equipment/add",
                data: info,
                dataType: 'json',
                success: function(data) {
                    callback(data);
                }
            });
        };

        var removeEquipment = function(id, callback) {
            $.ajax({
                url: "/remove/equipment/" + id,
                success: function(data) {
                    callback(data);
                }
            });
        };

        var editEquipment = function(id, info, callback) {
            $.ajax({
                url: "/equipment/edit/" + id,
                data: info,
                dataType: 'json',
                success: function(data) {
                    callback(data);
                }
            });
        };
		
		
		
        return {
            getAllUsers: getAllUsers,
            addUser: addUser,
            removeUser: removeUser,
            editUser: editUser,
			
			getAllEquipment: getAllEquipment,
			addEquipment: addEquipment,
            removeEquipment: removeEquipment,
            editEquipment: editEquipment,
			
			getAllInventar: getAllInventar,
			addInventar: addInventar
            /* removeInventar: removeInventar,
            editInventar: editInventar,*/
        };
    };

    bindHandlers();
    run();

    function bindHandlers() {
        /*-------------ADD USER-------------*/
        $(document).on("click", "#addUser", function() {
            $("#addUserForm").show();
        });

        $(document).on("click", "#submitUserForm", function() {
            var info = {};
            info.firstName = $("#firstName").val();
            info.lastName = $("#lastName").val();

			console.log(info);
            API().addUser(info, function(data){
                renderListOfUsers();
            });
            $("#firstName").val("");
            $("#lastName").val("");

            $("#addUserForm").hide();
        });

        $(document).on("click", "#cancelUserForm", function() {
            $("#firstName").val("");
            $("#lastName").val("");

            $("#addUserForm").hide();
        });


        /*-------------EDIT USER-------------*/
        $(document).on("click", ".editUser", function() {
            $("#editUserForm").attr('data-id', $(this).parent("li").attr("data-id"));
            $("#editUserForm").show();
        });

        $(document).on("click", "#submitEditForm", function() {
            var id = $(this).parent("#editUserForm").attr("data-id");

            var info = {};
            info.firstName = $("#newFirstName").val();
            info.lastName = $("#newLastName").val();

             API().editUser(id, info, function(data){
                 renderListOfUsers();
             });

            $("#newFirstName").val("");
            $("#newLastName").val("");

            $("#editUserForm").hide();
        });

        $(document).on("click", "#cancelEditForm", function() {
            $("#newFirstName").val("");
            $("#newLastName").val("");

            $("#editUserForm").hide();
        });


        /*-------------REMOVE USER-------------*/
        $(document).on("click", ".removeUser", function() {
            var id = $(this).parent("li").attr("data-id");

            API().removeUser(id, function(data){
                renderListOfUsers();
            });
        });

		
		/*-------------ADD Equipment-------------*/
        $(document).on("click", "#addEquipment", function() {
            $("#addEquipmentForm").show();
        });

        $(document).on("click", "#submitEquipmentForm", function() {
            var info = {};
            info.nameEquipment = $("#equipmentName").val();
            info.networkName = $("#networkName").val();

            API().addEquipment(info, function(data){
                renderListOfEquipment();
            });
            $("#equipmentName").val("");
            $("#networkName").val("");

            $("#addEquipmentForm").hide();
        });

        $(document).on("click", "#cancelEquipmentForm", function() {
            $("#equipmentName").val("");
            $("#networkName").val("");

            $("#addEquipmentForm").hide();
        });


        /*-------------EDIT Equipment-------------*/
        $(document).on("click", ".editEquipment", function() {
            $("#editEquipmentForm").attr('data-id', $(this).parent("li").attr("data-id"));
            $("#editEquipmentForm").show();
        });

        $(document).on("click", "#submitEditEquipmentForm", function() {
            var id = $(this).parent("#editEquipmentForm").attr("data-id");

            var info = {};
            info.nameEquipment = $("#newEquipmentName").val();
            info.networkName = $("#newNetworkName").val();

             API().editEquipment(id, info, function(data){
                 renderListOfEquipment();
             });

            $("#newFirstName").val("");
            $("#newLastName").val("");

            $("#editEquipmentForm").hide();
        });

        $(document).on("click", "#cancelEditEquipmentForm", function() {
            $("#newEquipmentName").val("");
            $("#newNetworkName").val("");

            $("#editEquipmentForm").hide();
        });


        /*-------------REMOVE Equipment-------------*/
        $(document).on("click", ".removeEquipment", function() {
            var id = $(this).parent("li").attr("data-id");

            API().removeEquipment(id, function(data){
                renderListOfEquipment();
            });
        });

		/*-------------ADD Inventar-------------*/
        $(document).on("click", "#addInventar", function() {
            $("#addInventarForm").show();
        });

        $(document).on("click", "#submitInventarForm", function() {
            var info = {};
            info.nameInventar = $("#inventarName").val();

            API().addInventar(info, function(data){
                renderListOfInventar();
            });
            $("#inventarName").val("");

            $("#addInventarForm").hide();
        });

        $(document).on("click", "#cancelInventarForm", function() {
            $("#inventarName").val("");

            $("#addInventarForm").hide();
        });

        /*-------------EDIT removeInventar-------------*/
        /*$(document).on("click", ".editInventar", function() {
            $("#editInventarForm").attr('data-id', $(this).parent("li").attr("data-id"));
            $("#editInventarForm").show();
        });

        $(document).on("click", "#submitEditEquipmentForm", function() {
            var id = $(this).parent("#editInventarForm").attr("data-id");

            var info = {};
            info.nameInventar = $("#newInventarName").val();

             API().editInventar(id, info, function(data){
                 renderListOfInventar();
             });

            $("#newInventarName").val("");

            $("#editInventarForm").hide();
        });

        $(document).on("click", "#cancelEditInventarForm", function() {
            $("#newInventarName").val("");

            $("#editInventarForm").hide();
        });*/


        /*-------------REMOVE removeInventar-------------*/
        /*$(document).on("click", ".removeInventar", function() {
            var id = $(this).parent("li").attr("data-id");

            API().removeInventar(id, function(data){
                renderListOfInventar();
            });
        });*/

	
	
	
	
	
	
	
	
	
	};


    function run() {
        renderListOfUsers();
		renderListOfEquipment();
		//renderListOfInventar();
    };

    function renderListOfUsers() {
        API().getAllUsers(function(data){
            var tmpl = $.templates("#allUsers");
            var people = data;
            var data = {users: people};
            $("#usersList").html(tmpl.render(data));
        });
    }
	
	function renderListOfEquipment() {
        API().getAllEquipment(function(data){
            var tmpl = $.templates("#allEquipment");
            var equip = data;
            var data = {equipment: equip};
            $("#equipmentsList").html(tmpl.render(data));
        });
    }
	
	/*function renderListOfInventar() {
        API().getAllInventar(function(data){
            var tmpl = $.templates("#allInventar");
            var inventar = data;
            var data = {inventar: invent};
            $("#inventarList").html(tmpl.render(data));
        });
    }*/

});