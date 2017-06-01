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
                url: "/remove/user/" + id,
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

        return {
            getAllUsers: getAllUsers,
            addUser: addUser,
            removeUser: removeUser,
            editUser: editUser
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

    };


    function run() {
        renderListOfUsers();
    };

    function renderListOfUsers() {
        API().getAllUsers(function(data){
            var tmpl = $.templates("#allUsers");
            var people = data;
            var data = {users: people};
            $("#usersList").html(tmpl.render(data));
        });
    }

});