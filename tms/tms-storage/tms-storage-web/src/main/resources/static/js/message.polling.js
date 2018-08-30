
$(function () {
    var accountId =  $("#accountId").text();
    function show() {

        $.get("/messages/unRead/" + accountId ).done(function (data) {
            if(data.status == 'success') {
                if(data.data) {
                    var nums = data.data;
                    var totalUnReadNum = nums[0];
                    //获取了页面传来的数组值
                    if(totalUnReadNum) {

                        var maxId = nums[1];
                        var loaclStorageMaxId = localStorage.getItem("maxId");

                        $("#countMessages").text(totalUnReadNum);
                        //判定localStorage里面有没有maxId这个值
                        if(loaclStorageMaxId) {
                            //如果有判断传入过来的maxId与localStorageMaxID是否相等
                            if(loaclStorageMaxId < maxId) {
                                localStorage.setItem("maxId",maxId);
                                var audio = new Audio('/mp3/message.mp3');
                                audio.play();
                            }

                        }else  {
                            localStorage.setItem("maxId",maxId);
                            var audio = new Audio('/mp3/message.mp3');
                            audio.play();
                        }



                    }


                }

            }else {
                layer.msg(data.message);

            }
        }).error(function () {

            layer.msg("系统忙!");

        })

    }

    show();
    setInterval(show,60000);



})
