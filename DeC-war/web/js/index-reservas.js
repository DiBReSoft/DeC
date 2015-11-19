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
  /* Desabilita os campos inicialmente */

  $(".reservaCheckIn").datepicker({
    language: "pt-BR",
    format: "dd/mm/yyyy",
    startDate: new Date()
  });

  $(".reservaCheckIn").on('blur', function () {

    if ($(".reservaCheckIn").val()) {

      var dataCheckIn = $(".reservaCheckIn").val();
      var dataCheckInDia = "" + dataCheckIn.charAt(0) + dataCheckIn.charAt(1);
      var dataCheckInMes = "" + dataCheckIn.charAt(3) + dataCheckIn.charAt(4) - 1;
      var dataCheckInAno = "" + dataCheckIn.charAt(6) + dataCheckIn.charAt(7) + dataCheckIn.charAt(8) + dataCheckIn.charAt(9);
      dataCheckIn = new Date(dataCheckInAno, dataCheckInMes, dataCheckInDia);
      dataCheckIn.setDate(dataCheckIn.getDate() + 1);
      console.log(dataCheckIn);

      $(".reservaCheckOut").datepicker({
        language: "pt-BR",
        format: "dd/mm/yyyy",
        startDate: dataCheckIn
      });

      $(".reservaCheckOut").removeAttr("disabled");

    }

  });

  $(".reservaForm").on('submit', function () {

    $(".reservaCheckOut").removeAttr("disabled");

  });

});