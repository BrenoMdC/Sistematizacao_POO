package com.MGS.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MGSDto (@NotBlank String nome,
       @NotBlank  String cargo,          
       @NotNull Integer idade,               
	   @NotBlank String nascimento,
	    Integer telefone,
	    String endereco,
		String alergia,   
		String probmedicos,
		String medicacoes ) {
	
}      
                    
                    
                     