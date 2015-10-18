import br.net.tenentibus.Permissao
import br.net.tenentibus.Usuarios;
import br.net.tenentibus.UsuariosPermissao;

class BootStrap {

    def init = { servletContext ->
	
			
	  Permissao admin = Permissao.findByAuthority("ADMIN")	
	  if (admin==null) {
		  
		  admin = new Permissao(authority:"ADMIN").save(flush:true)
	  }
	  
	  Permissao sindico = Permissao.findByAuthority("SINDICO")
	  if (admin==null) {
		  
		  admin = new Permissao(authority:"SINDICO").save(flush:true)
	  }
	  
	  Permissao secretario = Permissao.findByAuthority("SECRETARIO")
	  if (admin==null) {
		  
		  admin = new Permissao(authority:"SECRETARIO").save(flush:true)
	  }
	  
	  Permissao morador = Permissao.findByAuthority("MORADOR")
	  if (admin==null) {
		  
		  admin = new Permissao(authority:"MORADOR").save(flush:true)
	  }
	  
	  Usuarios administrador = Usuarios.findByUsername("administrador")
	  if (administrador==null){
		  
		  administrador = new Usuarios(username:"administrador",password:"admin",
			                           enable:true,accountExpired:false,accountLocked:false, 
									   passwordExpired:false).save(flush:true)
	  }
	  
	  Usuarios s = Usuarios.findByUsername("sindico")
	  if (s==null){
		  
		  s = new Usuarios(username:"sindico",password:"123",
									   enable:true,accountExpired:false,accountLocked:false,
									   passwordExpired:false).save(flush:true)
	  }
	  
	  Usuarios m = Usuarios.findByUsername("morador")
	  if (sindico==null){
		  
		  m = new Usuarios(username:"morador",password:"123",
									   enable:true,accountExpired:false,accountLocked:false,
									   passwordExpired:false).save(flush:true)
	  }
	  
    
	
	if (UsuariosPermissao.findByUsuariosAndPermissao(administrador,admin) == null){
		
		new UsuariosPermissao(Usuarios:administrador, Permissao: admin).save(flush:true)
	}
	

    }	
	
    def destroy = {
    }
   
}
