<%@ page import="br.net.tenentibus.Bloco" %>



<div class="fieldcontain ${hasErrors(bean: blocoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="bloco.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${blocoInstance?.nome}"/>

</div>

