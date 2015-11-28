package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.CategoriaEJBLocal;
import br.com.dibresoft.dec.entidade.Endereco;
import br.com.dibresoft.dec.entidade.Categoria;
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
public class CategoriaBean {

  private Categoria categoria;
  private Endereco endereco;

  private List<Categoria> categorias;
  private List<Categoria> categoriasAtivas;
  private List<Categoria> categoriasInativas;

  @EJB
  private CategoriaEJBLocal categoriaEJB;

  public CategoriaBean() {
  }

  @PostConstruct
  public void init() {
    categoria = new Categoria();
    categoria.setStatus(true);
    endereco = new Endereco();
    endereco.setPais("Brasil");
    categorias = categoriaEJB.listarTodos();
    categoriasAtivas = categoriaEJB.listarAtivas();
    categoriasInativas = categoriaEJB.listarInativas();
  }

  public void cadastrar() throws IOException {

    categoriaEJB.cadastrar(categoria);
    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/backoffice/sucesso-na-operacao");

  }

  public void alterar() throws IOException {

    categoriaEJB.alterar(categoria);
    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/backoffice/sucesso-na-operacao");

  }

  public void carregarInfos() {

    Map<String, String> params = FacesContext.getCurrentInstance().
            getExternalContext().getRequestParameterMap();

    Long paramCategoriaID = Long.parseLong(params.get("id"));

    Categoria categoriaAlterar = categoriaEJB.buscarCategoriaPorID(paramCategoriaID);

    categoria = categoriaAlterar;

  }

  public List<SelectItem> getComboCategorias() {

    List<SelectItem> lista = new ArrayList<>();

    for (Categoria categoria : categoriasAtivas) {
      lista.add(
              new SelectItem(
                      categoria.getId(),
                      categoria.getTitulo() + " (Diária: R$ " + categoria.getValor() + ")"
              )
      );
    }
    return lista;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;

  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public List<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }

  public List<Categoria> getCategoriasAtivas() {
    return categoriasAtivas;
  }

  public void setCategoriasAtivas(List<Categoria> categoriasAtivas) {
    this.categoriasAtivas = categoriasAtivas;
  }

  public List<Categoria> getCategoriasInativas() {
    return categoriasInativas;
  }

  public void setCategoriasInativas(List<Categoria> categoriasInativas) {
    this.categoriasInativas = categoriasInativas;
  }

}
