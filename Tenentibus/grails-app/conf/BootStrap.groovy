import br.net.tenentibus.Permissao
import br.net.tenentibus.Usuarios;
import br.net.tenentibus.UsuariosPermissao;

class BootStrap {

    def init = { servletContext ->
		
		criaRoles()
		criaUser()
			
	  Permissao admin = Permissao.findByAuthority("ROLE_ADMIN")	
	  if (admin==null) {
		  
		  admin = new Permissao(authority:"ROLE_ADMIN").save(flush:true)
	  }
	  
	  Permissao sindico = Permissao.findByAuthority("ROLE_SINDICO")
	  if (sindico==null) {
		  
		  sindico = new Permissao(authority:"ROLE_SINDICO").save(flush:true)
	  }
	  
	  Permissao secretario = Permissao.findByAuthority("ROLE_SECRETARIO")
	  if (secretario==null) {
		  
		 secretario = new Permissao(authority:"ROLE_SECRETARIO").save(flush:true)
	  }
	  
	  Permissao morador = Permissao.findByAuthority("ROLE_MORADOR")
	  if (morador==null) {
		  
		  morador = new Permissao(authority:"ROLE_MORADOR").save(flush:true)
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
	  if (m==null){
		  
		  m = new Usuarios(username:"morador",password:"123",
									   enable:true,accountExpired:false,accountLocked:false,
									   passwordExpired:false).save(flush:true)
	  }
	  
    
	
	if (UsuariosPermissao.findByUsuariosAndPermissao(administrador,admin) == null){
		
		new UsuariosPermissao(Usuarios:administrador, Permissao: admin).save(flush:true)
	}
	

    }	
	
	def criaUser() {
		def adminRole = Permissao.findByAuthority('ROLE_ADMIN') ?: new Permissao(authority: 'ROLE_ADMIN').save(failOnError: true)

		def adminUser = Usuarios.findByUsername('admin') ?: new Usuarios(
				username: 'admin',
				password: 'admin',
				email: 'admin@lesteti.com.br',
				enabled: true).save(failOnError: true)

		if (!adminUser.authorities.contains(adminRole)) {
			UsuariosPermissao.create adminUser, adminRole
		}

	}
	def criaRoles() {
		def roles = ['ROLE_ADMIN','ROLE_SINDICO','ROLE_SECRETARIO','ROLE_MORADOR']

		def list = Permissao.list()

		list*.authority.each {
			if (!roles.contains(it)) new Permissao(authority: it).save()
		}
	}
	
	
	
    def destroy = {
    }
   
}
