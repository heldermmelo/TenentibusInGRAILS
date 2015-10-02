package br.net.tenentibus



class Morador {

	
	
	String nome
	boolean condomino
	boolean sindico
	boolean secretario
	Apartamento apartamento
	Bloco bloco
	Condominio condominio
	
	
	
		
	
    static constraints = {
	 nome nullable:false, blank:false	
	 apartamento nullable:false
	 bloco nullable:false
	 condominio nullable:false
	
		      
	 
	
	 	
		
    }
	
	static mapping = {
		
		apartamento column:"id_apartamento"
		bloco column:"id_bloco"
		condominio column:"id_condominio"
	}
	
}
