package projeto.spring.data.aula;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSringDataUser;
import projeto.spring.data.aula.dao.InterfaceTelefone;
import projeto.spring.data.aula.model.Telefone;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTeste {
	
	
	@Autowired // dependency injection
	private InterfaceSringDataUser InterfaceSringDataUser;
	
	@Autowired // dependency injection
	private InterfaceTelefone interfaceTelefone;
	
	

	@Test
	public void testeInsert() {
		
		UsuarioSpringData usuarioSpringData =  new UsuarioSpringData();
		usuarioSpringData.setEmail("alex@gmail.com");
		usuarioSpringData.setIdade(31);
		usuarioSpringData.setLogin("teste123");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("alex");
		
		InterfaceSringDataUser.save(usuarioSpringData);
		
		System.out.println("Usuarios cadastrados -> "+InterfaceSringDataUser.count());
		
		
	}
	
	
	
	@Test
	public void testColsulta() {
		Optional<UsuarioSpringData> usuarioSpringData  =  InterfaceSringDataUser.findById(1L);
		
	System.out.println(usuarioSpringData.get().getIdade());
	System.out.println(usuarioSpringData.get().getEmail());
	System.out.println(usuarioSpringData.get().getLogin());
	System.out.println(usuarioSpringData.get().getLogin());
	System.out.println(usuarioSpringData.get().getNome());
	System.out.println(usuarioSpringData.get().getId());
	
	for (Telefone telefone: usuarioSpringData.get().getTelefones()) {
		System.out.println(telefone.getNumero());
		System.out.println(telefone.getTipo());
		System.out.println(telefone.getId());
		System.out.println(telefone.getUsuarioSpringData().getNome());
		System.out.println("__________________________________");
	}
	
	}
	
	@Test
	public void testeConsultaTodos() {
		
		Iterable<UsuarioSpringData> lista = InterfaceSringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("--------------------------------------------------");
			
		}
		
	}
	
	@Test
	public void testeUpdate() {
		
		Optional<UsuarioSpringData> usuarioSpringData = InterfaceSringDataUser.findById(4L);
		
		UsuarioSpringData data = usuarioSpringData.get();
		data.setNome("Cinthia Sanchez");
		data.setIdade(18);
		InterfaceSringDataUser.save(data);
	}
	
	@Test
	public void testeDelete() {
		
		//InterfaceSringDataUser.deleteById(11L);
		
		//----- otro metodo de hacerlo
		
		Optional<UsuarioSpringData> usuarioSpringData  =  InterfaceSringDataUser.findById(13L);// consultar
		InterfaceSringDataUser.delete(usuarioSpringData.get());
		
	}
	
	@Test
	public void consultaNome() {
		
		List<UsuarioSpringData> list = InterfaceSringDataUser.buscaPorNome("Cinthia Sanchez");
		
for (UsuarioSpringData usuarioSpringData : list) {
			
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("--------------------------------------------------");
			
		}
		
	}
	
	
	@Test
	public void testeConsultaParam() {
		
		UsuarioSpringData usuarioSpringData = InterfaceSringDataUser.buscaPorNomeParam("Sergio"); //nao retorna uma lista
		                                                                            // retorna um objeto
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("--------------------------------------------------");
			
		}
	
	@Test
	public void testeDeletePorNome() {
		InterfaceSringDataUser.deletePorNome("alex");
		
	}
	
	@Test
	public void testeUpdateEmaiPorNome() {
		
		InterfaceSringDataUser.updateEmaiPorNome("sandrabarbosa@yahoo.com.br", "Sandra");
		
	}
	
	@Test
	public void testInsertTelefone() {
		
		Optional<UsuarioSpringData> usuarioSpringData = InterfaceSringDataUser.findById(4L); // relaciona pessoa ao numero
		
		Telefone telefone = new Telefone();
		telefone.setTipo("celular");
		telefone.setNumero("9 11-45454545");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
		
		//para salvar
		
		interfaceTelefone.save(telefone);
		
	}
	
	
		
}
	
	


