package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.QuartoEJBLocal;
import br.com.dibresoft.dec.ejb.ReservaEJBLocal;
import br.com.dibresoft.dec.entidade.Categoria;
import br.com.dibresoft.dec.entidade.Hotel;
import br.com.dibresoft.dec.entidade.Quarto;
import br.com.dibresoft.dec.entidade.Reserva;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Thi
 */
@ManagedBean
@SessionScoped
public class CarrinhoTesteBean {

  private Reserva reserva = new Reserva();
  private List<Reserva> lista = new ArrayList<>();

  private Categoria categoria;
  private Hotel hotel;

  @EJB
  private QuartoEJBLocal quartoEJB;
  @EJB
  private ReservaEJBLocal reservaEJB;

  public CarrinhoTesteBean() {
    reserva.setQuarto(new Quarto());
  }

  public CarrinhoTesteBean(List<Reserva> lista) {
    this.lista = lista;
  }

  @PostConstruct
  public void init() {
    categoria = new Categoria();
    hotel = new Hotel();
  }

  /**
   * Essa função primeiro verificaria se existem quartos da CATEGORIA
   * selecionada, disponíveis no HOTEL selecionado pelo usuário, na tela inicial
   * do e-commerce
   */
  public void preReserva() throws IOException {

    boolean checarQuartos = false;
     checarQuartos = reservaEJB.verificarDisponibilidadeQuartos(reserva,reserva.getQuarto().getCategoria().getId(),hotel.getId());

    if (checarQuartos) {
      /**
       * Se existirem quartos vagos, aí sim CRIA A RESERVA e então ADICIONA ELA
       * NO CARRINHO
       */
      adicionarReserva();

    } else {
      /**
       * Se não existirem quartos da Categoia selecionada no Hotel selecionado, 
       * aí encaminha o usuário para uma pagina informando que o periodo está
       * indisponível
       */
      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/reservas/periodo-indisponivel");

    }

  }

  public void adicionarReserva() throws IOException {

    try {
      
      reserva.setId(lista.size());
      
      long oi = reserva.getQuarto().getId();
      reserva.setQuarto(quartoEJB.buscarQuartoPorID(oi));

      double valorEstadia = reservaEJB.calcularValorReserva(reserva);
      reserva.setValorEstadia(valorEstadia);

      lista.add(reserva);
      System.out.println("[INFO SITE] Adicionada nova reserva à Mala de Reservas:");
      System.out.println("Data de CheckIn: " + reserva.getCheckIn());
      System.out.println("Data de CheckOut: " + reserva.getCheckOut());
      System.out.println("Quarto Selecionado: " + reserva.getQuarto());
      System.out.println("Itens na Mala: " + lista.size());

      reserva = new Reserva();
      reserva.setQuarto(new Quarto());

      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/reservas/mala");

    } catch (IOException ex) {

      Logger.getLogger(CarrinhoTesteBean.class.getName()).log(Level.SEVERE, null, ex);

      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/erro");

    }

  }

  public void removerReserva(int idReserva) throws IOException {

    try {
      lista.remove(idReserva);

      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/reservas/mala");

    } catch (IOException ex) {

      Logger.getLogger(CarrinhoTesteBean.class.getName()).log(Level.SEVERE, null, ex);

      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/erro");

    }

  }

  public void limparCarrinho() {

    lista.clear();

  }

  public double valorTotalCarrinho() {

    double valorTotalCarrinho = 0;

    for (Reserva reserva : lista) {
      valorTotalCarrinho = valorTotalCarrinho + reservaEJB.calcularValorReserva(reserva);
    }

    return valorTotalCarrinho;

  }

  public List<Reserva> getLista() {
    return lista;
  }

  public void setLista(List<Reserva> lista) {
    this.lista = lista;
  }

  public Reserva getReserva() {
    return reserva;
  }

  public void setReserva(Reserva reserva) {
    this.reserva = reserva;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public Hotel getHotel() {
    return hotel;
  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }

}
