"use strict";
layui.use(["okUtils", "table", "countUp", "okMock"], function () {
    var countUp = layui.countUp;
    var table = layui.table;
    var $ = layui.jquery;

    function statText() {
        var elem_nums = $(".stat-text");
        elem_nums.each(function (i, j) {
            var ran = parseInt(Math.random() * 99 + 1);
            !new countUp({
                target: j,
                endVal: 20 * ran
            }).start();
        });
    }

    table.render({
        elem: '#demo'
        ,cellMinWidth: 80
        ,url: '/pages/serverpage/serverdata' //数据接口
        ,page: true //开启分页
        ,cols: [
            [ //表头
                {field: 'server_id', title: '服务器编号', align: 'left', sort: true}
                ,{field: 'hostname', title: '主机名', align: 'center', sort: true}
                ,{field: 'device_type', title: '服务器型号', align: 'center'}
                ,{field: 'system_version', title: '系统版本', align: 'center'}
                ,{field: 'hard_disk', title: '硬盘容量', align: 'center'}
                ,{field: 'memory', title: '内存容量', align: 'center'}
                ,{field: 'physical_cpu_cores', title: 'CPU内核数',align: 'center'}
                ,{field: 'system_ip', title: 'Ip地址', align: 'center'}
            ]
        ]
    });

    statText();
});