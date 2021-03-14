package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import source.NodeStackMath;
import source.Stack;
import source.Util;

public class NodeStackMathTest {

	@Test
	public void test() {
		// necessario a classe Util para converter char[] em Charater[] para a pilha de nodes
		// Já que a programação generica não quer aceitar o tipo primitivo
		// char[]
		Character[] textoCorreto0 = Util.stringToCharaterlist("(1+2)(8(14+89)){2/7(7*3[5+9(8*9)])}+1");
		Character[] textoCorreto1 = Util.stringToCharaterlist("(1(2(3*1)(5+8(2))9{([(1)2]3)4}5)6)+7");
		Character[] textoCorreto2 = Util.stringToCharaterlist("[(5+x)/4–2*(y+z)]");
		Character[] textoCorreto3 = Util.stringToCharaterlist("[({})]");
		Character[] textoCorreto4 = Util.stringToCharaterlist("[]");
		
		Character[] textoIncorreto0 = Util.stringToCharaterlist("1)2(3(4))5{6(7[8(9+5)])}+10");
		Character[] textoIncorreto1 = Util.stringToCharaterlist("8+(7{6[5])}");
		Character[] textoIncorreto2 = Util.stringToCharaterlist("9+(2");
		Character[] textoIncorreto3 = Util.stringToCharaterlist("{})]");
		Character[] textoIncorreto4 = Util.stringToCharaterlist("[({}");
		
		Stack<Character> pilhaMath = new NodeStackMath<Character>();
		
		// 1° Teste com Correto 
		pilhaMath.addArray(textoCorreto0);
		assertTrue(" Texto correto! ", pilhaMath.verifyMath());
		pilhaMath.clear();
		// 2° Teste com Correto 
		pilhaMath.addArray(textoCorreto1);
		assertTrue(" Texto correto! ", pilhaMath.verifyMath());
		pilhaMath.clear();
		
		// 3° Teste com Correto 
		pilhaMath.addArray(textoCorreto2);
		assertTrue(" Texto correto! ", pilhaMath.verifyMath());
		pilhaMath.clear();
		
		// 4° Teste com Correto 
		pilhaMath.addArray(textoCorreto3);
		assertTrue(" Texto correto! ", pilhaMath.verifyMath());
		pilhaMath.clear();
		
		// 5° Teste com Correto 
		pilhaMath.addArray(textoCorreto4);
		assertTrue(" Texto correto! ", pilhaMath.verifyMath());
		pilhaMath.clear();
		
		
		
		// 1° Teste com Falso 
		pilhaMath.addArray(textoIncorreto0);
		assertFalse(" Texto correto! ", pilhaMath.verifyMath());
		pilhaMath.clear();
		
		// 2° Teste com Falso 
		pilhaMath.addArray(textoIncorreto1);
		assertFalse(" Texto correto! ", pilhaMath.verifyMath());
		pilhaMath.clear();
		
		// 3° Teste com Falso 
		pilhaMath.addArray(textoIncorreto2);
		assertFalse(" Texto correto! ", pilhaMath.verifyMath());
		pilhaMath.clear();
		
		// 4° Teste com Falso 
		pilhaMath.addArray(textoIncorreto3);
		assertFalse(" Texto correto! ", pilhaMath.verifyMath());
		pilhaMath.clear();
		
		// 5° Teste com Falso 
		pilhaMath.addArray(textoIncorreto4);
		assertFalse(" Texto correto! ", pilhaMath.verifyMath());
		pilhaMath.clear();
				
	}

}
