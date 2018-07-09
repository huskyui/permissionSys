<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/2 0002
  Time: 下午 3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="roleModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">修改</h4>
            </div>
            <div class="modal-body">
                <form id="roleForm">
                    <div class="form-input">
                        <div class="form-group">
                            <label>rolename</label><input class="form-control" value=""
                                                          id="roleName" name="role.roleName">
                        </div>
                        <div class="form-group">
                            <label>remark</label>
                            <input class="form-control" value="" id="remark" name="role.remark">
                        </div>
                        <a class="btn btn-link" id="nextBtn">下一步</a>
                    </div>
                        <div class="form-check">
                            <div class="checks"></div>
                            <a class="btn btn-link" id="preBtn">上一步 </a>
                        </div>

                        <button class="btn btn-success" id="updateBtn" type="button">修改</button>
                        <button class="btn btn-warning" id="cancelBtn" type="button">取消</button>

                </form>
            </div>
        </div>
    </div>
</div>
