$(function () {

    var accountId =  $("#accountId").text();

    function show () {

        $.get("/trans/order/unConfirm/" + accountId ).done(function (data) {
            if(data.status == 'success') {
                if(data.data) {
                    var agencyOrderUnConfirmNum = data.data.agencyOrderUnConfirmNum;
                    var financeOrderUnConfirmNum = data.data.financeOrderUnConfirmNum;
                    if(agencyOrderUnConfirmNum) {
                          var agencyOrderMaxId = data.data.agencyOrderMaxId;
                          var localStorageAgencyNewOrderMaxId = localStorage.getItem("agencyNewOrderMaxId");
                          if(agencyOrderMaxId) {
                              if(agencyOrderMaxId > localStorageAgencyNewOrderMaxId) {
                                  /*var uri = window.location.pathname;
                                  if(uri == '/agency/order/new') {
                                      var audio = new Audio("/mp3/order.mp3");
                                      audio.play();
                                      window.history.go(0);
                                  }*/
                                  var audio = new Audio("/mp3/order.mp3");
                                  audio.play();
                                  localStorage.setItem("agencyNewOrderMaxId",agencyOrderMaxId);
                                  var msg = alertify.error('你有一条新的订单请及时处理', 0,function () {
                                      window.location.href="/agency/order/new";
                                  });
                                  $(msg).click(function () {
                                      msg.dismiss();
                                  });
                              }
                          }

                          /*if(agencyOrderMaxId != null && agencyOrderMaxId > localStorageAgencyNewOrderMaxId) {
                              var audio = new Audio("/mp3/order.mp3");
                              audio.play();
                              localStorage.setItem("agencyNewOrderMaxId",agencyOrderMaxId);
                          }*/
                          $("#agencyNewOrderNum").text(agencyOrderUnConfirmNum);
                    }
                    if(financeOrderUnConfirmNum) {
                        var financeOrderMaxId = data.data.financeOrderMaxId;
                        var localStorageFinanceNewOrderMaxId = localStorage.getItem("financeNewOrderMaxId");
                        if(financeOrderMaxId) {
                            if(financeOrderMaxId > localStorageFinanceNewOrderMaxId) {
                                var audio = new Audio("/mp3/order.mp3");
                                audio.play();
                                localStorage.setItem("financeNewOrderMaxId",financeOrderMaxId);
                                var msg = alertify.error('你有一条新的订单请及时处理', 0,function () {
                                    window.location.href="/finance/trans/order/new";
                                });
                                $(msg).click(function () {
                                    msg.dismiss();
                                });
                            }
                        }
                        /*if(financeOrderMaxId != null && financeOrderMaxId > localStorageFinanceNewOrderMaxId) {
                            var audio = new Audio("/mp3/order.mp3");
                            audio.play();
                            localStorage.setItem("financeNewOrderMaxId",financeOrderMaxId);



                        }*/


                    }
                    $("#financeNewOrderNum").text(financeOrderUnConfirmNum);

                }

            }else {
                layer.msg(data.message);

            }
        }).error(function () {

            layer.msg("系统忙!");

        })


    }

    show();



    setInterval(show,30000);

})