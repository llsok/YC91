function doAjax(url, callback) {
	// 将xmlhttp放在函数内部是最安全的
	var xmlhttp;
	// 创建 XMLHttpRequest 对象
	// 浏览器兼容性问题
	if (xmlhttp == null) {
		try {
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				try {
					xmlhttp = new XMLHttpRequest();
				} catch (e) {
					alert("浏览器不支持 AJAX！");
				}
			}
		}
	}

	// 回调函数， 当收到服务器返回的数据时，执行的函数
	// xmlhttp.onreadystatechange = callback;
	xmlhttp.onreadystatechange = function() {
		// 通过匿名函数完成状态判断
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			// JS 特有的写法
			callback(xmlhttp.responseText);
		}
	};
	xmlhttp.open("post", url, true); // 第三个参数 表示异步执行
	xmlhttp.send(null);
}