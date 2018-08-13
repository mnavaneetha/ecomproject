<%@ page language="java" contentType="text/html"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<form action="InsertCategory" method="post">
<table>
    <tr>
       <td>Category Name</td>
       <td><input type="text" name="cname"/></td>
    </tr>
    <tr>
       <td>Category Description</td>
       <td><input type="text" name="catDesc"/></td>
    </tr>
    <tr>
      <td colspan="2">
       
          <input type="submit" value="SUBMIT"/>
         
       </td>
     </tr>
   </table>
 </form>
 
 <table>
     <tr>
         <td>Category Id</td>
         <td>Category Name</td>
         <td>Category Desc</td>
      </tr>
   <c:forEach items="${categorylist}" var="category">
   <tr>
       <td> ${category.categoryId}</td>
       <td> ${category.categoryName}</td>
       <td> ${category.categoryDesc}</td>
       <td>
       <a href="<c:url value='/deleteCategory/${category.categoryId}'/>">delete</a>
       <a href="<c:url value='/editCategory/${category.categoryId}'/>">Edit</a>
     </tr>
     </c:forEach>
     </table>
   
       