package estudo;

public class E1 {

	public static void main(String[] args) {
		
		double soma = 0;
		int contador = 0;
		
		while(contador<35) {
			
			double valorDoLivro = 59.90;
			
			soma += valorDoLivro;
			contador ++;
			
		}
		
		System.out.println( "O total é de: " + (Math.round(soma)));
		
		if(soma<150) {
			System.out.println("Seu estoque está baixo");
			
		}else if (soma>2000) {
			System.out.println("Seu estoque está alto");
				
		}else {
			System.out.println("Seu estoque está normal");
			
		}
	}

}
