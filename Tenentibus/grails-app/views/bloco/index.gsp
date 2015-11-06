
<%@ page import="br.net.tenentibus.Bloco" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bloco.label', default: 'Bloco')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<g:link class="btn btn-white btn-sm btn-info btn-bold" action="create">
			<i class="ace-icon fa fa-file-o"></i>
			<g:message code="default.new.label" args="[entityName]" />
		</g:link>

		<div class="page-header">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
		</div>
		<g:if test="${flash.message}">
		<div class="alert alert-success" role="status">
			<button class="close" data-dismiss="alert" type="button">
   				<i class="ace-icon fa fa-times"></i>
			</button>
			<p><strong><i class="ace-icon fa fa-check"></i></strong>${flash.message}</p>
		</div>
		</g:if>
		<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
			
				<g:sortableColumn property="nome" title="${message(code: 'bloco.nome.label', default: 'Nome')}"  params="${[q: params.q]}" />
			
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
		<g:each in="${blocoInstanceList}" status="i" var="blocoInstance">
			<tr>
			
				<td><g:link action="show" id="${blocoInstance.id}">${fieldValue(bean: blocoInstance, field: "nome")}</g:link></td>
			
				<td><g:link action="show" id="${blocoInstance.id}"><i class="ace fa fa-folder-open-o"></i></g:link></td>
			</tr>
		</g:each>
		</tbody>
		</table>
		<div class="pagination btn-group">
			<g:paginate total="${blocoInstanceCount ?: 0}" params="${[q: params.q]}" />
		</div>
		<script type="text/javascript">$('.pagination a').addClass('btn btn-sm btn-light');$('.pagination span').addClass('btn btn-sm btn-light active');</script>
	</body>
</html>
