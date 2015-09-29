package br.net.tenentibus

class Condominio {
   
		
	private String nome
	
    static hasmany =[morador: Morador]
	static belongsTo = [Morador]
	
    static constraints = {
		
//  nome nullable:false , blank:false
	  
    }
}


