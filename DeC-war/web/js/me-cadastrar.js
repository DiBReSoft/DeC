
var QueryString = function () {
  // This function is anonymous, is executed immediately and 
  // the return value is assigned to QueryString!
  var query_string = {};
  var query = window.location.search.substring(1);
  var vars = query.split("&");
  for (var i = 0; i < vars.length; i++) {
    var pair = vars[i].split("=");
    // If first entry with this name
    if (typeof query_string[pair[0]] === "undefined") {
      query_string[pair[0]] = decodeURIComponent(pair[1]);
      // If second entry with this name
    } else if (typeof query_string[pair[0]] === "string") {
      var arr = [query_string[pair[0]], decodeURIComponent(pair[1])];
      query_string[pair[0]] = arr;
      // If third or later entry with this name
    } else {
      query_string[pair[0]].push(decodeURIComponent(pair[1]));
    }
  }
  return query_string;
}();


$(document).ready(function () {

  $(".cadastroNewsletter").bootstrapToggle();

  $('.cadastroRG').mask('**.999.999-*');
  $('.cadastroCPF').mask('999.999.999-99');
  $('.cadastroNascimento').mask('**/**/****');

  if (QueryString.email || QueryString.cpf) {
    // Se tiver e-mail na URL, adiciona ele no campo de cadastro e trava
    $('#preCadastroContainer').addClass('text-muted');
    $('#preCadastroContainer #preCadastroMensagem').text('CPF ' + QueryString.cpf + ' liberado.');
    $('#preCadastroContainer #preCadastroMensagem').addClass('text-primary');

    $('#preCadastroClienteForm .cadastroCPF').val(QueryString.cpf);
    $('#preCadastroClienteForm .cadastroCPF').attr('disabled', 'disabled');

    $('#preCadastroClienteForm .cadastroEmail').val(QueryString.email);
    $('#preCadastroClienteForm .cadastroEmail').attr('disabled', 'disabled');

    $('#preCadastroClienteForm .btn').addClass('disabled');
    $('#preCadastroClienteForm input[type=submit]').removeAttr('action');
    $('#preCadastroClienteForm input[type=submit]').attr('type', 'button');

    $('#cadastroClienteForm .cadastroCPF').val(QueryString.cpf);
    $('#cadastroClienteForm .cadastroCPF').attr('disabled', 'disabled');

    $('#cadastroClienteForm .cadastroEmail').val(QueryString.email);
    $('#cadastroClienteForm .cadastroEmail').attr('disabled', 'disabled');
  } else {
    // Se não e-mail na URL, trava os campos do formulário de cadastro
    $('#cadastroContainer').addClass('text-muted');
    $('#cadastroClienteForm .form-control').attr('disabled', 'disabled');
    $('#cadastroClienteForm .checkbox').addClass('disabled');
    $('#cadastroClienteForm .checkbox input').attr('disabled', 'disabled');
    $('#cadastroClienteForm .btn').addClass('disabled');
    $('#cadastroClienteForm input[type=submit]').removeAttr('action');
    $('#cadastroClienteForm input[type=submit]').attr('type', 'button');
  }

  $('.cadastroClienteForm').on('submit', function () {
    $('#cadastroClienteForm .cadastroCPF').removeAttr('disabled');
    $('#cadastroClienteForm .cadastroEmail').removeAttr('disabled');
  });

});
