package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Cliente;
import br.com.dibresoft.dec.entidade.Email;
import br.com.dibresoft.dec.entidade.Quarto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author udimberto.sjunior
 */
@Stateless
public class ClienteEJB implements ClienteEJBLocal {

  @PersistenceContext
  private EntityManager em;

  /* AJUSTAR PARA VERIFICAR O RESULTADO DA OPERAÇÃO */
  @Override
  public boolean cadastrar(Cliente cliente) {
    em.persist(cliente);
    try {
      montaEmail(cliente);
    } catch (Exception e) {
      System.out.println("ALERTA!!! E-mail não enviado.");
      return true;
    }
    return true;
  }

  /* AJUSTAR PARA VERIFICAR O RESULTADO DA OPERAÇÃO */

  @Override
  public void inativar(Cliente cliente) {
    cliente.setStatus(false);
    em.merge(cliente);
  }

  @Override
  public void alterar(Cliente cliente) {
    em.merge(cliente);
  }

  @Override
  public boolean validar(String cpf, String email) {
    List<Cliente> clientes;

    Query q = em.createNamedQuery("Cliente.validar");
    q.setParameter("cpf", cpf);
    q.setParameter("email", email);

    clientes = q.getResultList();

    if (clientes.isEmpty()) {

      return true;
    }

    return false;
  }

  @Override
  public boolean buscarClientePorCpf(String cpf) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Cliente autenticar(String email, String senha) {
    
    Cliente c = new Cliente();
    List<Cliente> clientes;

    Query q = em.createNamedQuery("Cliente.autenticar");
    q.setParameter("email", email);
    q.setParameter("senha", senha);

    clientes = q.getResultList();

    if (clientes.size() > 0) {

      c = clientes.get(0);

      return c;

    } else {

      return c;

    }
    
  }

  @Override
  public Cliente buscarClientePorId(long id) {
    Query query = em.createQuery("Select c from Cliente c where c.id = " + id);
    return (Cliente) query.getSingleResult();
  }

  private void montaEmail(Cliente p) {
    System.out.println("[DADOS GRAVADOS COM SUCESSO] Novo cadastro: " + p.getNome());
    Email email = new Email();
    email.setDestinatario(p.getEmail());
    email.setAssunto("Cadastro Efetuado");
    email.setMensagem(p.getNome() + ", seja bem-vindo(a) e obrigado por efetuar o cadastro no Lebre Hotel!");
    EnviarEmail(email);
  }

  public void EnviarEmail(Email email) {

    Properties props = new Properties();
    /**
     * Parâmetros de conexão com servidor Gmail
     */
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("lebrehotel@gmail.com", "grupo123");
      }
    });

    /**
     * Ativa Debug para sessão
     */
    session.setDebug(true);

    try {

      Message message = new MimeMessage(session);

      // Remetente
      message.setFrom(new InternetAddress("lebrehotel@gmail.com"));

      // Destinatário(s)
      String destinos = "";
      for (String destinatario : email.getDestinatario()) {
        destinos += ", " + destinatario;
      }
      Address[] toUser = InternetAddress.parse("lebrehotel@gmail.com,fabioernanni@hotmail.com,elvitous@gmail.com,lucianolourencoti@gmail.com,renatolbrandao@gmail.com,larissa.deofranca@gmail.com" + destinos);
      message.setRecipients(Message.RecipientType.TO, toUser);

      // Assunto
      message.setSubject(email.getAssunto());

      // Montar corpo da mensagem
      message.setText(email.getMensagem());

      // Método para enviar a mensagem criada
      Transport.send(message);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

}
