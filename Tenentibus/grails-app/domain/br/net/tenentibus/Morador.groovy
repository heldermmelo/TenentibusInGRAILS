package br.net.tenentibus



class Morador {

	
	
	String nome
	boolean condomino
	boolean sindico
	boolean secretario
	Apartamento apartamento
	Bloco bloco
	Condominio condominio
	String cpf
	
	String toString(){nome}
	
	
	
	
		
	
    static constraints = {
	 nome nullable:false, blank:false	
	 apartamento nullable:false
	 bloco nullable:false
	 condominio nullable:false
	 cpf blank:false, nullable:false,cpf:true, size:14..14
		      
	 
	
	 	
		
    }
	
	static mapping = {
		
		apartamento column:"id_apartamento"
		bloco column:"id_bloco"
		condominio column:"id_condominio"
	}
	
}
