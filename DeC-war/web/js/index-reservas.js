$(document).ready(function () {

  /* Preenche o Placeholder nos campos de data, com datas reais */
  var dataHoje = new Date();
  $(".reservaCheckIn").attr("placeholder", "Ex.: " + dataHoje.getDate() + "/" + (dataHoje.getMonth() + 1) + "/" + dataHoje.getFullYear());
  var dataFutura = new Date();
  dataFutura.setDate(dataHoje.getDate() + 5);
  $(".reservaCheckOut").attr("placeholder", "Ex.: " + dataFutura.getDate() + "/" + (dataFutura.getMonth() + 1) + "/" + dataFutura.getFullYear());
  /* Preenche o Placeholder nos campos de data, com datas reais */

  /* Desabilita os campos inicialmente */
  $(".reservaCheckOut").attr("disabled", "disabled");
  $(".reservaCategoria").attr("disabled", "disabled");
  $("input.btn[value='RESERVAR']").attr('disabled', 'disabled');
  /* Desabilita os campos inicialmente */
  
  //Configuração datepicker data checkin
  $(".reservaCheckIn").datepicker({
    language: "pt-BR",
    format: "dd/mm/yyyy"
  }).datepicker('setStartDate', 'today');
  
  //Comportamento data checkin
  $(".reservaCheckIn").datepicker().on('changeDate', function () {
    $(".reservaCheckIn").datepicker('hide');
    if ($(".reservaCheckIn").val()) {      
      //Comportamento data checkout e configuração datepicker
      $(".reservaCheckOut").focus().datepicker({
        language: "pt-BR",
        format: "dd/mm/yyyy"
      }).datepicker('setStartDate', ($(".reservaCheckIn").val() + 1)).show();
      $(".reservaCheckOut").removeAttr('disabled');
      $(".form-control.reservaCheckOut").focus();
      
      //Ao selecionar data checkout focus na categoria
      $(".reservaCheckOut").datepicker().on('changeDate', function(){
        $(".reservaCategoria").removeAttr('disabled', 'disabled');
        $(this).datepicker('hide');
        $(".reservaCategoria").focus();
      }); 
    }
  });
  $(".reservaCategoria").on('change', function(){
    if (this.selectedIndex !== 0)
      $("input.btn[value='RESERVAR']").removeAttr('disabled', 'disabled');
  });

  $(".reservaForm").on('submit', function () {
    //Setar informações de checkin no formato UTM
    var dataCheckIn = $(".reservaCheckIn").val();
    var dataCheckInDia = "" + dataCheckIn.charAt(0) + dataCheckIn.charAt(1);
    var dataCheckInMes = "" + dataCheckIn.charAt(3) + dataCheckIn.charAt(4) - 1;
    var dataCheckInAno = "" + dataCheckIn.charAt(6) + dataCheckIn.charAt(7) + dataCheckIn.charAt(8) + dataCheckIn.charAt(9);
    dataCheckIn = new Date(dataCheckInAno, dataCheckInMes, dataCheckInDia);
    dataCheckIn.setDate(dataCheckIn.getDate() + 1);
    
    //Setar informações de checkout no formato UTM
    var dataCheckOut = $(".reservaCheckIn").val();
    var dataCheckInDia = "" + dataCheckOut.charAt(0) + dataCheckOut.charAt(1);
    var dataCheckInMes = "" + dataCheckOut.charAt(3) + dataCheckOut.charAt(4) - 1;
    var dataCheckInAno = "" + dataCheckOut.charAt(6) + dataCheckOut.charAt(7) + dataCheckOut.charAt(8) + dataCheckOut.charAt(9);
    dataCheckOut = new Date(dataCheckInAno, dataCheckInMes, dataCheckInDia);
    dataCheckOut.setDate(dataCheckOut.getDate() + 1);

    console.log(dataCheckIn+" ate "+dataCheckOut.value);
    $(".reservaCheckOut").removeAttr('disabled');

  });
      /* teste de outra forma para coletar o valor da data UTM
      var dataCheckIn = new Date(Date.parse(($(".reservaCheckIn").val())));
      var dataCheckInDia = dataCheckIn.getDay();
      var dataCheckInMes = dataCheckIn.getMonth();
      var dataCheckInAno = dataCheckIn.getYear();
      dataCheckIn = new Date(dataCheckInAno, dataCheckInMes, dataCheckInDia);
      */

});