package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.CategoriaEJBLocal;
import br.com.dibresoft.dec.ejb.QuartoEJBLocal;
import br.com.dibresoft.dec.entidade.Categoria;
import br.com.dibresoft.dec.entidade.Hotel;
import br.com.dibresoft.dec.entidade.Quarto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author jSilverize
 */
@ManagedBean
@RequestScoped
public class QuartoBean {

  private Quarto quarto;
  private Categoria categoria;
  private Hotel hotel;

  private List<Quarto> quartos;
  private List<Quarto> quartosAtivos;
  private List<Quarto> quartosInativos;

  @EJB
  private QuartoEJBLocal quartoEJB;

  @EJB
  private CategoriaEJBLocal categoriaEJB;

  public QuartoBean() {
  }

  @PostConstruct
  public void init() {
    quarto = new Quarto();
    quarto.setStatus(true);
    quartos = quartoEJB.listarTodos();
    quartosAtivos = quartoEJB.listarAtivos();
    quartosInativos = quartoEJB.listarInativos();
    categoria = new Categoria();
    hotel = new Hotel();
  }

  public void cadastrar() throws IOException {
    
    quarto.setCategoria(categoria);
    
    quarto.setHotel(hotel);

    System.out.println("[INFO] QUARTO SUBMETIDO A CADASTRO");
    System.out.println("Título: " + quarto.getTitulo());
    System.out.println("Categoria: " + quarto.getCategoria().getTitulo());
    System.out.println("Hotel: " + quarto.getHotel().getTitulo());

    quartoEJB.cadastrar(quarto);
    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/backoffice/sucesso-na-operacao");

  }

  public void alterar() throws IOException {
    
    quarto.setCategoria(categoria);
    
    quarto.setHotel(hotel);

    System.out.println("[INFO] QUARTO SUBMETIDO A CADASTRO");
    System.out.println("Título: " + quarto.getTitulo());
    System.out.println("Categoria: " + quarto.getCategoria().getTitulo());
    System.out.println("Hotel: " + quarto.getHotel().getTitulo());

    quartoEJB.alterar(quarto);
    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/backoffice/sucesso-na-operacao");

  }

  public void carregarInfos() {

    Map<String, String> params = FacesContext.getCurrentInstance().
            getExternalContext().getRequestParameterMap();

    Long paramQuartoID = Long.parseLong(params.get("id"));

    Quarto quartoAlterar = quartoEJB.buscarQuartoPorID(paramQuartoID);
    
    quarto = quartoAlterar;
    
    categoria = quartoAlterar.getCategoria();
    hotel = quartoAlterar.getHotel();

  }

  public List<SelectItem> getComboQuartos() {

    List<SelectItem> lista = new ArrayList<>();

    for (Quarto quarto : quartosAtivos) {
      lista.add(
              new SelectItem(
                      quarto.getId(),
                      quarto.getTitulo()
              )
      );
    }
    return lista;
  }

  public Quarto getQuarto() {
    return quarto;
  }

  public void setQuarto(Quarto quarto) {
    this.quarto = quarto;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public List<Quarto> getQuartos() {
    return quartos;
  }

  public void setQuartos(List<Quarto> quartos) {
    this.quartos = quartos;
  }

  public List<Quarto> getQuartosAtivos() {
    return quartosAtivos;
  }

  public void setQuartosAtivos(List<Quarto> quartosAtivos) {
    this.quartosAtivos = quartosAtivos;
  }

  public List<Quarto> getQuartosInativos() {
    return quartosInativos;
  }

  public void setQuartosInativos(List<Quarto> quartosInativos) {
    this.quartosInativos = quartosInativos;
  }

  public Hotel getHotel() {
    return hotel;
  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }

}
