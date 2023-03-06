function operate(url, type, dataType, data, callback) {
    let config = {
        url: url,
        type: type,
        dataType: dataType,
        data: data,
        beforeSend: function () {
        },
        success: function(result) {
            callback(result);
        }
    };
    $.ajax(config)
}

function operatePost(url, data, callback) {
    operate(url, "post", "json", data, callback);
}

function operateGet(url, callback) {
    operate(url, "get", "json", "", callback);
}
