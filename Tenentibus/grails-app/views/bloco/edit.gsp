<%@ page import="br.net.tenentibus.Bloco" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bloco.label', default: 'Bloco')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<g:link class="btn btn-white btn-sm btn-info btn-bold" action="index">
			<i class="ace-icon fa fa-list"></i>
			<g:message code="default.list.label" args="[entityName]" />
		</g:link>
		<g:link class="btn btn-white btn-sm btn-info btn-bold" action="create">
			<i class="ace-icon fa fa-file-o"></i>
			<g:message code="default.new.label" args="[entityName]" />
		</g:link>

		<div class="page-header">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
		</div>
		<g:if test="${flash.message}">
		<div class="alert alert-success" role="status">
			<button class="close" data-dismiss="alert" type="button">
   				<i class="ace-icon fa fa-times"></i>
			</button>
			<p><strong><i class="ace-icon fa fa-check"></i></strong>${flash.message}</p>
		</div>
		</g:if>
		<g:hasErrors bean="${blocoInstance}">
		<div class="alert alert-danger">
			<button class="close" data-dismiss="alert" type="button">
   				<i class="ace-icon fa fa-times"></i>
			</button>
			<ul class="errors" role="alert">
				<g:eachError bean="${blocoInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
		</div>
		</g:hasErrors>
		<g:form url="[resource:blocoInstance, action:'update']" method="PUT" >
			<g:hiddenField name="version" value="${blocoInstance?.version}" />
			<fieldset class="form-horizontal">
				<g:render template="form"/>
			</fieldset>
			<div class="clearfix form-actions">
				<div class="col-md-offset-3 col-md-9">
					<button name="create" class="btn btn-info" id="save-button">
						<i class="ace-icon fa fa-check bigger-110" id="save-icon"></i>
						${message(code: 'default.button.update.label', default: 'Update')}
					</button>
				</div>
			</div>
		</g:form>
		<script type="text/javascript">
			$('form').submit( function () {
				$('#save-icon').removeClass('fa-check').addClass('fa-spin fa-spinner');
				$('#save-button').attr('disabled','disabled');
			});
		</script>
	</body>
</html>
