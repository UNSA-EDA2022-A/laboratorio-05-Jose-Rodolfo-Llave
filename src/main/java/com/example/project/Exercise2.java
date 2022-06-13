package com.example.project;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }

    public boolean existenDuplicados(String str) {
        MyStack<Character> stack = new LinkedListStack<>();
        char x;
        //Si la cadena esta vacia retorna false
        if(str.equals("")) {
        	return false;
        } else {
        	//Procede a verificar los parentesis
        	for(int i = 0; i < str.length(); i++) {
        		//Si el caracter es parentesis abierto o algun signo se insertara el mismo en la pila
        		if ((str.charAt(i) == '(') || (str.charAt(i) == '+') || (str.charAt(i) == '-') || (str.charAt(i) == '*') || (str.charAt(i) == '/')) {
        			stack.push(str.charAt(i));
        		} 
        		//Si el caracter es parentesis cerrado se procede otra verificacion
        		else if (str.charAt(i) == ')') {
        			//Se encapsula el tope de la pila en una variable;
        			x = stack.top();
        			//Se verifica si la variable es igual a cualquiera de los signos
        			//Si es igual se procede a eliminar dos datos de la pila, se elminaria el signo
        			//Ademas se eliminaria el parentesis abierto obviamente se tiene la certeza que esta antes del signo
        			if(verificar(x)) {
        				for(int j = 0; j < 2; j++) {
        					stack.pop();
        				}
        			} 
        			//Si no se cumple la verificacion se inserta el dato en la pila;
        			else {
        				stack.push(str.charAt(i));
        			}
        		}
        	}
        	//Se bsuca en la pila si existe cualquiera de los 2 parentesis y si existe por lo menos uno retorna true
        	if (buscar(stack)) {
        		return true;
        	}
        }
        //Caso contrario retornara false
        return false;
    }
    
    //Se verifica si el caracter es igual a cualquiera de los signos
    public static boolean verificar(char x) {
    	if((x == '+') || (x == '-') || (x == '*') || (x == '/')) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    //Se busca si existe un parentesis cerrado o abierto en la pila
    public static boolean buscar(MyStack<Character> stack) {
    	char x;
    	for(int i = 0; i < stack.size(); i++) {
    		x = stack.top();
    		if(x == '(' || x == ')') {
    			return true;
    		} else {
    			stack.pop();
    		}
    	}
    	
    	return false;
    }
}
