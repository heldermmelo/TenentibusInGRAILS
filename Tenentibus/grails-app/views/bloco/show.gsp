
<%@ page import="br.net.tenentibus.Bloco" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bloco.label', default: 'Bloco')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>

        <g:if test="${flash.alert}">
            <div class="alert alert-warning" role="status">
                <button class="close" data-dismiss="alert" type="button">
                    <i class="ace-icon fa fa-times"></i>
                </button>
                <p><strong><i class="ace-icon fa fa-check"></i></strong>${flash.alert}</p>
            </div>
        </g:if>

		<g:link class="btn btn-white btn-sm btn-info btn-bold" action="index">
			<i class="ace-icon fa fa-list"></i>
			<g:message code="default.list.label" args="[entityName]" />
		</g:link>
		<g:link class="btn btn-white btn-sm btn-info btn-bold" action="create">
			<i class="ace-icon fa fa-file-o"></i>
			<g:message code="default.new.label" args="[entityName]" />
		</g:link>

		<div class="page-header">
			<h1>${blocoInstance} <small><i class="ace-icon fa fa-angle-double-right"></i> <g:message code="default.show.label" args="[entityName]" /></small></h1>
		</div>
		<g:if test="${flash.message}">
		<div class="alert alert-success" role="status">
			<button class="close" data-dismiss="alert" type="button">
   				<i class="ace-icon fa fa-times"></i>
			</button>
			<p><strong><i class="ace-icon fa fa-check"></i></strong>${flash.message}</p>
		</div>
		</g:if>
		<div class="form-horizontal">
		
			<g:if test="${blocoInstance?.nome}">
			<div class="form-group">
				<div><label class="control-label col-sm-3 no-padding-right" id="nome-label"><g:message code="bloco.nome.label" default="Nome" /></label></div>
				<div class="col-sm-9 form-control-static">
				
					<div><g:fieldValue bean="${blocoInstance}" field="nome"/></div>
				
				</div>
			</div>
			</g:if>
			
		
		</div>

        
		
		<g:form url="[resource:blocoInstance, action:'delete']" method="DELETE">
			<div class="clearfix form-actions">
				<div class="col-md-offset-3 col-md-9">
					<g:link class="btn" action="edit" resource="${blocoInstance}">
						<i class="ace-icon fa fa-pencil"></i>
						<g:message code="default.button.edit.label" default="Edit" />
					</g:link>

					<button class="btn btn-danger" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
						<i class="ace-icon fa fa-trash-o bigger-110"></i>
						${message(code: 'default.button.delete.label', default: 'Delete')}
					</button>						
				</div>
			</div>
		</g:form>
	</body>
</html>
