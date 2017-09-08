function uploadFile(url,files,options) {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    var formData;
    // 用FormData来发送二进制文件.首先在HTML中要有一个包含了文件输入框的form元素
    formData = new FormData();
    formData.append('key', key);
    formData.append('token', token);
    formData.append('file', f);
    var taking;
    xhr.upload.addEventListener("progress", function(evt) {
        if(options.progress){
            options.progress(evt);
        }
    }, false);
    xhr.onreadystatechange = function(response) {
        if (xhr.readyState == 4 && xhr.status == 200 && xhr.responseText != "") {
            options.success(response,xhr);
        } else if (xhr.status != 200 && xhr.responseText) {
            if(options.error){
                options.error(response,xhr);
            }
        }
    };
    xhr.send(formData);
}