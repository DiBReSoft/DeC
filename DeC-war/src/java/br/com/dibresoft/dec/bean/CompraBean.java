package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.CompraEJBLocal;
import br.com.dibresoft.dec.entidade.Cliente;
import br.com.dibresoft.dec.entidade.Compra;
import br.com.dibresoft.dec.entidade.Email;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
 * @author jSilverize
 */
@ManagedBean
@RequestScoped
public class CompraBean {

  private Compra compra;

  @EJB
  private CompraEJBLocal compraEJB;

  public CompraBean() {
    compra = new Compra();
  }

  public void gravar(Cliente cliente, double valorTotal) throws IOException {

    if (cliente.getId() != null) {

      compra.setStatus("aprovada");
      compra.setCliente(cliente);
      compra.setDataCompra(new Date());
      compra.setValorParcelas(valorTotal / compra.getCartaoParcelas());
      compra.setValorTotal(valorTotal);

      compraEJB.cadastrar(compra);
      montaEmail(compra);
      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/reservas/sucesso");

    } else {
      
      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/login");
      
    }

  }

  public Compra getCompra() {
    return compra;
  }

  public void setCompra(Compra compra) {
    this.compra = compra;
  }

  private void montaEmail(Compra c) {
    System.out.println("[DADOS GRAVADOS COM SUCESSO] Reserva: " + c.getCliente().getNome());
    Email email = new Email();
    email.setDestinatario(c.getCliente().getEmail());
    email.setAssunto("Reserva Efetuada");
    email.setMensagem(c.getCliente().getNome() + ", obrigado por reservar na Lebre Hotel! </br></br>"
            + "sua compra foi efetuada no dia:" + c.getDataCompra() + "</br></br>"
            + "parcelado em " + c.getCartaoParcelas() + "</br></br>"
            + "em um total de " + c.getValorTotal());
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
