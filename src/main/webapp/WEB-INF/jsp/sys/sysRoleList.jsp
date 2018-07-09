<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/2 0002
  Time: 下午 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<button class="btn btn-success add" onclick="showAddRoleModal('/addSysRole')">添加</button>
<table class="table table-striped">
    <tr>
        <th>序号</th>
        <th>角色名</th>
        <th>描述</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${sysRoleList}" var="sysRole" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${sysRole.roleName}</td>
            <td>${sysRole.remark}</td>
            <td>${sysRole.createTime}</td>
            <td>
                <a href="javascript:void(0)" class="btn btn-info" onclick="showUpdateRoleData('')">edit</a>
                <a href="javascript:void(0)" class="btn btn-danger" onclick="s">delete</a>

            </td>
        </tr>
    </c:forEach>

</table>
<%@ include file="roleModal.jsp"%>
