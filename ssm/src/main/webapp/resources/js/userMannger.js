function getData(users) {
	var rows = [];
	for ( var i in users) {
		rows.push({
			id : users[i].id,
			userName : users[i].userName,
			password : users[i].password,
			gender : users[i].gender,
			age : users[i].age
		});
	}
	return rows;
}

function pagerFilter(data) {
	if (typeof data.length == 'number' && typeof data.splice == 'function') { // is array
		data = {
			total : data.length,
			rows : data
		}
	}
	var dg = $(this);
	var opts = dg.datagrid('options');
	var pager = dg.datagrid('getPager');
	pager.pagination({
		onSelectPage : function(pageNum, pageSize) {
			opts.pageNumber = pageNum;
			opts.pageSize = pageSize;
			pager.pagination('refresh', {
				pageNumber : pageNum,
				pageSize : pageSize
			});
			dg.datagrid('loadData', data);
		}
	});
	if (!data.originalRows) {
		data.originalRows = (data.rows);
	}
	var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
	var end = start + parseInt(opts.pageSize);
	data.rows = (data.originalRows.slice(start, end));
	return data;
}

$(function() {
	$.ajax({
		url:'getUsers',
		type:'get',
		success:function(users){
			console.log(users);
			$('#dg').datagrid({
				loadFilter : pagerFilter
			}).datagrid('loadData', getData(users));
		}
	})
});