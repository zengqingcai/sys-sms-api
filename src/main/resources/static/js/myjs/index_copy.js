$(function () {
    $('#menu').sidebarMenu({
        data: [{
            id: '1',
            text: '普通用户管理',
            icon: 'fa fa-user-circle-o fa-fw',
            url: '',
            menus: [{
                id: '11',
                text: '用户列表',
                icon: 'fa fa-group fa-fw',
                url: '/app/user/userList'
            }, {
                id: '12',
                text: '用户注册',
                icon: 'fa fa-user-o fa-fw',
                url: '/emp/empAdd'
            }]
        },{
            id: '2',
            text: '平台用户管理',
            icon: 'fa fa-user-circle-o fa-fw',
            url: '',
            menus: [{
                id: '21',
                text: '用户列表',
                icon: 'fa fa-group fa-fw',
                url: '/sys/user/userList'
            }, {
                id: '22',
                text: '用户注册',
                icon: 'fa fa-user-o fa-fw',
                url: '/emp/empAdd'
            }]
        },{
            id: '3',
            text: '系统设置',
            icon: 'fa fa-cog fa-fw',
            url: '',
            menus: [{
                id: '31',
                text: '角色管理',
                icon: 'fa fa-cog fa-fw',
                url: '',
                menus:[{
                    id: '311',
                    text: '角色列表',
                    icon: 'fa fa-pencil fa-fw',
                    url: '/role/roleList'
                },{
                    id: '312',
                    text: '角色权限列表',
                    icon: 'fa fa-pencil fa-fw',
                    url: '/role/roleList'
                }]
            },{
                    id: '32',
                    text: '权限管理',
                    icon: 'fa fa-pencil fa-fw',
                    url: '/permission/permissionList'
            },{
                id: '31',
                text: '系统参数',
                icon: 'fa fa-pencil fa-fw',
                url: '/params/paramsList'
            }]
        }, {
            id: '3',
            text: '系统日志',
            icon: 'fa fa-book fa-fw',
            url: '',
            menus: [{
                id: '31',
                text: '日志列表',
                icon: 'fa fa-bug fa-fw',
                url: '/syslog/logList'
            }]
        }]
    });
});



$(function () {
    $.ajax({
        url:"/index2",
        type:"post",
        dataType:"json",
        contentType :"application/json",
        success:function(data){
            $('#menu').sidebarMenu({
                data: data
            });

        },
        error:function () {
            alert("系统错误！")
        }
    });
});
//https://www.cnblogs.com/gjq1126-web/p/11367586.html 菜单树显示