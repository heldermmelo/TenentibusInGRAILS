package br.net.tenentibus

class Bloco {
	
	
	String nome
	String toString(){nome}
	
	static hasmany = [morador:Morador]
	
	static belongsTo = [Morador]

    static constraints = {
		
	 	nome nullable:false , blank:false
		 
    }
}
