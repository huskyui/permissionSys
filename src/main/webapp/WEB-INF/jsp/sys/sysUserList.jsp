<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/28 0028
  Time: 下午 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<button class="btn btn-success add" onclick="showAddModal('/addSysUser')">添加</button>
<table class="table table-striped">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>邮箱</th>
        <th>电话</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${sysUserList}" var="sysUser" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${sysUser.username}</td>
            <td>${sysUser.email}</td>
            <td>${sysUser.mobile}</td>
            <td>${sysUser.status eq 1? "可用":"不可用"}</td>
            <td>
                <a href="javascript:void(0)" class="btn btn-info" onclick="showUpdateData('/sysUserInfo','/updateSysUser',${sysUser.userId})">edit</a>
                <a href="javascript:void(0)" class="btn btn-danger" onclick="deleteData('/deleteSysUser',${sysUser.userId})">delete</a>
                <a href="javascript:void(0)" class="btn btn-warning" onclick="showSendModal(${sysUser.email})">email</a>
            </td>
        </tr>
    </c:forEach>
</table>

<ul class="pager">
    <c:if test="${page.currentPage != 1}">
        <li class="previous"><a href="javascript:void(0)" onclick="getData('/sysUserList',${page.currentPage-1})">上一页</a> </li>
    </c:if>
    <c:if test="${page.currentPage!=page.totalPage}">
        <li class="next"><a href="javascript:void(0)" onclick="getData('/sysUserList',${page.currentPage+1})">下一页</a> </li>
    </c:if>

</ul>


<%@ include file="userModal.jsp"%>