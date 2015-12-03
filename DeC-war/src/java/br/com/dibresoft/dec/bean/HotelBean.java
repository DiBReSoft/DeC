package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.EnderecoEJBLocal;
import br.com.dibresoft.dec.ejb.HotelEJBLocal;
import br.com.dibresoft.dec.entidade.Endereco;
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
public class HotelBean {

  private Hotel hotel;
  private Endereco endereco;

  private List<Hotel> hoteis;
  private List<Hotel> hoteisAtivos;
  private List<Hotel> hoteisInativos;
  private List<Quarto> quartos;

  @EJB
  private HotelEJBLocal hotelEJB;

  public HotelBean() {
  }

  @PostConstruct
  public void init() {
    hotel = new Hotel();
    hotel.setStatus(true);
    endereco = new Endereco();
    endereco.setPais("Brasil");
    hoteis = hotelEJB.listarTodos();
    hoteisAtivos = hotelEJB.listarAtivos();
    hoteisInativos = hotelEJB.listarInativos();
  }

  public void cadastrar() throws IOException {

    endereco.setHotel(hotel);

    hotel.setEndereco(endereco);

    hotel.setEmail(hotel.getEmail() + "@lebrehotel.com.br");

    hotelEJB.cadastrar(hotel);
    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/backoffice/sucesso-na-operacao");

  }

  public void alterar() throws IOException {

    endereco.setHotel(hotel);

    hotel.setEndereco(endereco);

    hotel.setEmail(hotel.getEmail() + "@lebrehotel.com.br");

    hotelEJB.alterar(hotel);
    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/backoffice/sucesso-na-operacao");

  }

  public void carregarInfos() {

    Map<String, String> params = FacesContext.getCurrentInstance().
            getExternalContext().getRequestParameterMap();

    Long paramHotelID = Long.parseLong(params.get("id"));

    Hotel hotelCarregar = hotelEJB.buscarHotelPorID(paramHotelID);

    hotel = hotelCarregar;
    endereco = hotelCarregar.getEndereco();

  }

  public List<SelectItem> getComboHoteis() {

    List<SelectItem> lista = new ArrayList<>();

    for (Hotel hotel : hoteisAtivos) {
      lista.add(
              new SelectItem(
                      hotel.getId(),
                      hotel.getEndereco().getEstado() + " - " + hotel.getTitulo()
              )
      );
    }
    return lista;
  }

  public Hotel getHotel() {
    return hotel;
  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public List<Hotel> getHoteis() {
    return hoteis;
  }

  public void setHoteis(List<Hotel> hoteis) {
    this.hoteis = hoteis;
  }

  public List<Hotel> getHoteisAtivos() {
    return hoteisAtivos;
  }

  public void setHoteisAtivos(List<Hotel> hoteisAtivos) {
    this.hoteisAtivos = hoteisAtivos;
  }

  public List<Hotel> getHoteisInativos() {
    return hoteisInativos;
  }

  public void setHoteisInativos(List<Hotel> hoteisInativos) {
    this.hoteisInativos = hoteisInativos;
  }

  public List<Quarto> getQuartos() {
    return quartos;
  }

  public void setQuartos(List<Quarto> quartos) {
    this.quartos = quartos;
  }

}
