/**
 * ajax
 *
 * */
//------------------common-------------------
function getData(url,currentPage) {
    console.log("onclick");
    config={
        type:"get",
        url:url,
        data:{"currentPage":currentPage},
        success:function (data) {
            console.log(data);
            if(data.code==100){
                alert("暂无权限","",null,{type:'waring',confirmButtonText:'确定'})
            }else {
                $("#content").html(data);
            }
        }
    };
    $.ajax(config);
    
}


//更新数据
function updateData(form,url) {
    config={
        type:"post",
        url:url,
        data:$(form).serialize(),
        success:function (data) {
            if(data!=null &&data.code!=undefined&&data.code==102){
                //获取出错的modal id
                var modalId = "#"+(data.data[0].split("."))[0]+"Modal";
                changeModal(modalId,data.data);
            }else{
                $("#userModal").modal('hide');
                $(".modal-backdrop").remove();
                $("#content").html(data);
                console.log(data);
                alert("更新成功","",null,{type:'success',confirmButtonText:"确定"})
            }
        }
    }
    $.ajax(config);
    
}

//-----------------------------------sysUser----------------------
function showAddModal(url) {
    $("#userModal #myModalLabel").text("添加");
    $("#userModal #updateBtn").html("添加");
    $("#userForm #userId").remove();
    $("#userModal #userId").val("");
    $("#userForm #username").val("");
    $("#userForm #password").val("");
    $("#userForm #email").val("");
    $("#userForm #mobile").val("");
    $("#userForm #status").val("");

    $("#userModal .form-input").show();
    $("#userModal .form-check").hide();

    $("#userModal").modal();

    $("#userModal #nextBtn").click(function () {
        getModalData("/sysRoleJson",1);
        $("#userModal .form-input").hide();
        $("#userModal .form-check").show();
    });

    $("#userModal #preBtn").click(function () {
       $("#userModal .form-input").show();
       $("#userModal .form-check").hide();
    });

    $("#userModal #updateBtn").click(function () {
        resetModal("#userModal");
        updateData("#userForm",url);
    });

    $("#userModal #cancelBtn").click(function () {
        resetModal("#userModal");
        $("#userModal").modal("hide");
    })
}

function resetModal(modalId) {
    $(modalId+" .form-group").each(function () {
        $(this).removeClass("has-error");
        $(this).removeClass("has-success");
        $(this).children(".glyphicon").remove();
    })
    
}

//获取角色列表
//此处是hasroles是通过lazyload加载，但getSysUser时获取的roles的
//通过获取所有roles的id，和syuser的roles里面的roleid匹配，如果存在则checked=checked
function getModalData(url,currentPage,hasRoles){
    config = {
        type:"get",
        url:url,
        data:{"currentPage":currentPage},
        dataType:"json",
        success:function (data) {
            $("#userModal .form-check .checks").html("");
            data.forEach(function (role) {
                var checked = "";
                if(hasRoles!=null && hasRoles!=undefined) {
                    hasRoles.forEach(function (hasRole) {
                        if (hasRole.roleId == role.roleId) {
                            checked = "checked=checked";
                        }
                    })
                }
                $("#userModal .form-check .checks").append('<div class="checkbox">\
                <label>\
                <input type="checkbox"'+checked+'name="roleIds" value="'+role.roleId+'">'+role.roleName+'\
                </label>\
                </div>');
                });
        }
    };

    $.ajax(config);
}

function deleteData(url,id) {
    config={
        type:"get",
        url:url,
        data:{"id":id},
        success:function (data) {
            console.log(data);

            $("#content").html(data);
            alert("删除成功","",null,{type:"success",confirmButtonText:"确定"});
        },
        error:function (xhr) {
            if(xhr.status == 401){
                alert("暂无权限","",null,{type:"warning",confirmButtonText:"确定"})
            }
            console.log("fail")
        }
    };
    $.ajax(config);
}
//此处dataType是预计返回类型
function showUpdateData(getUserUrl,updateUrl,userid) {
    config = {
        type:"get",
        url:getUserUrl,
        data:{"id":userid},
        dataType:"json",
        success:function (data) {
            $("#userModal #myModalLabel").text("修改");
            $("#userModal #updateBtn").html("修改");
            $("#userForm").prepend('<input id="userId" name="user.userId" type="hidden">');
            $("#userModal #userId").val(data.userId);
            $("#userModal #username").val(data.username);
            $("#userModal #password").val(data.password);
            $("#userModal #email").val(data.email);
            $("#userModal #mobile").val(data.mobile);
            $("#userModal #status").val(data.status);

            $("#userModal .form-input").show();
            $("#userModal .form-check").hide();

            $("#userModal #nextBtn").click(function () {
                getModalData("/sysRoleJson",1,data.sysRoles);
                $("#userModal .form-input").hide();
                $("#userModal .form-check").show();
            });

            $("#userModal #preBtn").click(function () {
                $("#userModal .form-input").show();
                $("#userModal .form-check").hide();
            });

            $("#userModal #updateBtn").click(function () {
                resetModal("#userModal");
                updateData("#userForm",updateUrl);
            });

            $("#userModal #cancelBtn").click(function () {
                resetModal("#userModal");
                $("#userModal").modal("hide");
            });

            $("#userModal").modal();
        }
    };
    $.ajax(config);
}

//----------------sysRole-------------------
function showAddRoleModal(url) {
    $("#roleModal #myModalLabel").text("添加");
    $("#roleModal #updateBtn").html("添加");
    $("#roleModal #userId").remove();
    $("#roleModal #roleId").val("");
    $("#roleModal #roleName").val("");
    $("#roleModal #remark").val("");

    $("#roleModal .form-input").show();
    $("#roleModal .form-check").hide();

    $("#roleModal").modal('show');
//    上面这句话是实现模态框show

    $("#roleModal #nextBtn").click(function () {
        getModalPermData("/sysPermJson",1);
        $("#roleModal .form-input").hide();
        $("#roleModal .form-check").show();
    })

    $("#roleModal #preBtn").click(function () {
        $("#roleModal .form-input").show();
        $("#roleModal .form-check").hide();
    })

    $("#roleModal #updateBtn").click(function () {
        updateData("#roleForm",url);
        $("#roleModal").modal("hide")
        $(".modal-backdrop").remove()
    });

    $("#roleModal #cancelBtn").click(function () {
        $("#roleModal").modal("hide");
    });


    
}

//获取角色列表
function getModalPermData(url,currentPage,hasPerms) {
    config = {
        type:"get",
        url:url,
        data:{"currentPage":currentPage},
        dataType:"json",
        success:function (data) {
            console.log(data);
            $("#roleModal .form-check .checks").html("");
            data.forEach(function (perm) {
                var checked = "";
                if(hasPerms!=null&&hasPerms!=undefined){
                    hasPerms.forEach(function (hasPerm) {
                        if(hasPerm.permId == perm.permId){
                            checked = "checked=checked";
                        }
                    })
                }
                $("#roleModal .form-check .checks").append('<div class="checkbox">\
                <label>\
                <input type="checkbox" '+checked+'name="permIds" value="'+perm.permId+'"> '+perm.perms+'\
                </label>\
                </div>');

            });
            console.log($("#roleModal"));
        }
    };
    $.ajax(config);

    
}
