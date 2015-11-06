<%@ page import="br.net.tenentibus.Bloco" %>



<div class="fieldcontain ${hasErrors(bean: blocoInstance, field: 'nome', 'error')} required form-group">
	<label for="nome" class="col-sm-3 control-label no-padding-right">
		<g:message code="bloco.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-9">
		<g:textField name="nome" required="" value="${blocoInstance?.nome}"/>

	</div>
</div>

