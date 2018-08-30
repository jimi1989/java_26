$(function () {

    var accountId = $("#accountId").text();

    function show () {

        $.get("/agency/trans/finance/unConfirmed/" + accountId).done(function (resp) {


            if(resp.status == "success") {
                if(resp.data) {
                    var nums = resp.data;
                    var totalUnConfirmed = nums[0];
                    if(totalUnConfirmed) {
                        var maxId = nums[1];
                        var localStorageMaxId = localStorage.getItem("agencyTransFinanceMaxId");
                        $("#agencyTransFinance").text(totalUnConfirmed);
                        if(localStorageMaxId) {
                            if(localStorageMaxId < maxId) {
                                localStorage.setItem("agencyTransFinanceMaxId",maxId);
                                var audio = new Audio("/mp3/order.mp3");
                                audio.play();
                                var msg = alertify.error('你有一笔转账请及时处理', 0,function () {
                                    window.location.href="/finance/agency/trans/records";
                                });
                                $(msg).click(function () {
                                    msg.dismiss();
                                });

                            }


                        }else {
                            localStorage.setItem("agencyTransFinanceMaxId", maxId);
                            var audio = new Audio("/mp3/order.mp3");
                            audio.play();
                            var msg = alertify.error('你有一笔转账请及时处理', 0, function () {
                                window.location.href = "/finance/agency/trans/records";
                            });
                            $(msg).click(function () {
                                msg.dismiss();
                            });
                        }

                    }

                }


            }else {

                layer.msg(resp.message);

            }


        }).error(function () {

            layer.msg("系统忙！");
        })



    }

    show();
    setInterval(show,30000);

})