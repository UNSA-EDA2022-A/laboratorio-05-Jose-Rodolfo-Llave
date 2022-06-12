package com.example.project;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

    public boolean esBalanceado(String s) {
       MyStack<Character> stack = new LinkedListStack<>();
        // Colocar codigo aqui
        //En primer lugar para que sea balanceado el numero de caracteres debe de ser par
        //Si el numero de caracteres es impar retorna fasle automaticamente
        	if(s.length() % 2 != 0) {
        		return false;
        	} 
        	
        	//Sin embargo, puede ocurrir que el numero de caracteres sea par
        	//Y no necesariamente debe de estar balanceado, para ello se verifica caracter por caracter
        	else {
        		//Se inicia en un ciclo for que ira iterando, hasta que llegue al caracter final
        		for(int i = 0; i < s.length(); i++) {
        			//Si se encuentra cualquiera de esos 2 caracteres, se entra a condiciones
        			if (s.charAt(i) == '(' || s.charAt(i) == ')') {
            			//Si es un caraceter abierto el caracter se inserta en la pila pero de forma contraria
        				//Esto con el fin de poder comparar el tope de la pila con los caracteres que posiblemente se inserten
        				if(s.charAt(i) == '('){
            				stack.push(')');
            			} 
        				//Si no es abierto, se verifica si la pila esta vacia o no
        				else if (s.charAt(i) == ')') {
        					//Si esta vacio, se inserta en la pila
            				if(stack.isEmpty()) {
            					stack.push(')');
            				} 
            				//Caso contrario se verifica si el caracter es igual al tope de la pila
            				else {
            					//Si es igual se eliminara de la pila
            					if(stack.top().compareTo(s.charAt(i)) == 0) {
            						stack.pop();
            					} 
            					//Si no es igual, se insertara en la pila
            					else {
            						stack.push(')');
            					}	
            				}	
            			}
        			} 
        			//Lo mismo aplica para corchetes
        			else if (s.charAt(i) == '[' || s.charAt(i) == ']') {
            			if(s.charAt(i) == '['){
            				stack.push(']');
            			} else if (s.charAt(i) == ']') {
            				if(stack.isEmpty()) {
            					stack.push(']');
            				} else {
            					if(stack.top().compareTo(s.charAt(i)) == 0) {
            						stack.pop();
            					} else {
            						stack.push(']');
            					}	
            				}
            			}
        			} 
        			//De igual manera para las llaves
        			else if (s.charAt(i) == '{' || s.charAt(i) == '}') {
            			if(s.charAt(i) == '{'){
            				stack.push('}');
            			} else if (s.charAt(i) == '}') {
            				if(stack.isEmpty()) {
            					stack.push('}');
            				} else {
            					if(stack.top().compareTo(s.charAt(i)) == 0) {
            						stack.pop();
            					} else {
            						stack.push('}');
            					}	
            				}	
            			}
        			} 		
        		}
        		//Al finalizar se verifica si la pila esta vacia
        		//Si esta vacia, es porque esta balanceado
        		if(stack.isEmpty() == true) {
        			return true;
        		}
        	}
        //Caso contrario no esta balanceado
        return false;
    }
}
