<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<tags:header secao="cadastroAnaisConferencia" />
<tags:menuCadastro />

<nav class="corpo">
	<form action="<c:url value="/cadastros/adicionaAnaisConferencia" />" method="POST">
		<tags:cadastroPublicacao />
		
		Artigos: <input type="text" name="artigos" size="50"><br>
		Editora: <input type="text" name="editora" size="50"><br>
		N�mero do Volume: <input type="text" name="numeroVolume" size="50"><br><br> 
		
		<input type="submit" value="Salvar" size="50">
	</form>
</nav>

<tags:footer />
