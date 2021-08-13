package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import repositorio.PessoaRepository;

@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable, Runnable
{
	/* ATRIBUTOS */
	//private static final Pessoa p1 = new Pessoa("Mariah dos Santos","maria_santospg@yahoo.com.br", "Av. Brasil, 1262", 1430001l, "(99) 99999-9999", 2500.55, 1);
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected int idPessoa;
	
	@Column(name = "nome")//, nullable = false)
	protected String nomePessoa;
	
	@Column(name = "email")
	protected String emailPessoa;
	
	@Column(name = "endereco")
	protected String enderecoPessoa;
	
	@Column(name = "cep")
	protected long cepPessoa;
	
	@Column(name = "telefone")
	protected String telefonePessoa;
	
	@Column(name = "renda")
	protected double rendaPessoa;
	
	@Column(name = "situacao")
	protected int situacaoPessoa;
	
	// FetchType.LAZY -> Diz ao provedor de persistência para não buscar as entidades associadas no banco de dados até que elas sejam necessárias.
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "pessoas_contascomuns", joinColumns = { @JoinColumn(name = "idpessoa", referencedColumnName = "id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "numeroconta", referencedColumnName = "numeroconta") })
	protected Set<ContaComum> contas;
	
	/* CONSTRUTORES */
	
	
	public Pessoa()
	{
		this.situacaoPessoa = 1;
		this.contas = new HashSet<ContaComum>();		
	}
	public Pessoa(int idPessoa)
	{
		this.idPessoa = idPessoa;			
	}
	
	public Pessoa(String nomePessoa, String emailPessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa,
			double rendaPessoa, int situacaoPessoa)
	{
		this.nomePessoa = nomePessoa;
		this.emailPessoa = emailPessoa;
		this.enderecoPessoa = enderecoPessoa;
		this.cepPessoa = cepPessoa;
		this.telefonePessoa = telefonePessoa;
		this.rendaPessoa = rendaPessoa;
		this.situacaoPessoa = situacaoPessoa;
		this.contas = new HashSet<ContaComum>();
	}
	public Pessoa(int idPessoa,String nomePessoa, String emailPessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa,
			double rendaPessoa, int situacaoPessoa) {}
	
	/* GETTERS AND SETTERS */

	public int getIdPessoa()
	{
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa)
	{
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa()
	{
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa)
	{
		this.nomePessoa = nomePessoa;
	}

	public String getEmailPessoa() {
		return emailPessoa;
	}

	public void setEmailPessoa(String emailPessoa) {
		this.emailPessoa = emailPessoa;
	}

	public String getEnderecoPessoa()
	{
		return enderecoPessoa;
	}

	public void setEnderecoPessoa(String enderecoPessoa)
	{
		this.enderecoPessoa = enderecoPessoa;
	}

	public long getCepPessoa()
	{
		return cepPessoa;
	}

	public void setCepPessoa(long cepPessoa)
	{
		this.cepPessoa = cepPessoa;
	}

	public String getTelefonePessoa()
	{
		return telefonePessoa;
	}

	public void setTelefonePessoa(String telefonePessoa)
	{
		this.telefonePessoa = telefonePessoa;
	}

	public double getRendaPessoa()
	{
		return rendaPessoa;
	}

	public void setRendaPessoa(double rendaPessoa)
	{
		this.rendaPessoa = rendaPessoa;
	}

	public int getSituacaoPessoa()
	{
		return situacaoPessoa;
	}

	public void setSituacaoPessoa(int situacaoPessoa)
	{
		this.situacaoPessoa = situacaoPessoa;
	}
	
	public Set<ContaComum> getContas()
	{
		return contas;
	}

	public void setContas(Set<ContaComum> contas)
	{
		this.contas = contas;
	}	

	@Override
	public void run() {
	
		PessoaRepository pessoaRepository = new PessoaRepository();		
		
		pessoaRepository.criarPessoa(this);
		System.out.println("ID da Pessoa p1: " + this.getIdPessoa());
	
			
		}		
}