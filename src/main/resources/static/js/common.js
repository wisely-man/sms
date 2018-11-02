function save(url, _form, backUrl){

    $.ajax({
        url : url,
        type : "POST",
        dataType : "json",
        data : $(_form).serialize(),
        success : function (rdata) {
            alert(rdata.msg);
            if(rdata && rdata.code=='0'){
                window.location = backUrl;
                return;
            }
        }

    });

}


function del(url, id, backUrl){

    $.ajax({
        url : url,
        type : "POST",
        dataType : "json",
        data : {id : id},
        success : function (rdata) {
            alert(rdata.msg);
            if(rdata && rdata.code=='0'){
                window.location = backUrl;
                return;
            }
        }
    });

}