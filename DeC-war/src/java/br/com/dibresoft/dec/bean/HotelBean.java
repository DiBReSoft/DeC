package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.EnderecoEJBLocal;
import br.com.dibresoft.dec.ejb.HotelEJBLocal;
import br.com.dibresoft.dec.entidade.Endereco;
import br.com.dibresoft.dec.entidade.Hotel;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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

  @EJB
  private HotelEJBLocal hotelEJB;

  public HotelBean() {
  }

  @PostConstruct
  public void init() {
    hotel = new Hotel();
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

  public void inativar() throws IOException {

    endereco.setHotel(hotel);

    hotel.setEndereco(endereco);

    hotelEJB.inativar(hotel);
    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/backoffice/sucesso-na-operacao");

  }

  public void reativar() throws IOException {

    endereco.setHotel(hotel);

    hotel.setEndereco(endereco);

    hotelEJB.reativar(hotel);
    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/backoffice/sucesso-na-operacao");

  }

  public void carregarInfos() {

    Map<String, String> params = FacesContext.getCurrentInstance().
            getExternalContext().getRequestParameterMap();

    Long paramHotelID = Long.parseLong(params.get("id"));

    Hotel hotelAlterar = hotelEJB.buscarHotelPorID(paramHotelID);

    hotelAlterar.setEmail(
            hotelAlterar.getEmail().replace("@lebrehotel.com.br", "")
    );

    hotel = hotelAlterar;
    endereco = hotelAlterar.getEndereco();

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

}
