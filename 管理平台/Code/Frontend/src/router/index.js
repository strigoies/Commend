import Vue from 'vue'
import Router from 'vue-router'
import cookie from 'js-cookie'
// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'
import loginApi from '@/api/loginuser'
import VueRouter from 'vue-router'
/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirect in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
  }
**/
export const constantRoutes = [
    {
        path: '/login',
        component: () =>
            import ('@/views/login/index1'),
        hidden: true,
    },
    { path: '/login/register',
         meta: { title: '注册', noCache: true },
         component: () => import('@/views/login/register'),
         hidden: true
       },
    // {
    //     path: '/login',
    //     component: () =>
    //         import ('@/views/login/index'),
    //     hidden: true
    // },
    
//     { path: '/login',
//     meta: { title: '登录', noCache: true },
//     component: (resolve) => require(['@/views/login/login'], resolve),
//     hidden: true
//   }, 
    {
        path: '/404',
        component: () =>
            import ('@/views/404'),
        hidden: true
    },
    {
        path: '/',
        component: Layout,
        redirect: '/dashboard',
        name: 'Dashboard',
        hidden: true,
        children: [{
            path: 'dashboard',
            component: () =>
                import ('@/views/dashboard/index')
        }]
    },
    {
        path: '/sta',
        component: Layout,
        redirect: '/sta/show',
        name: '数据大屏',
        meta: { title: '数据大屏', icon: 'example' },
        children: [

            {
                path: 'show',
                name: '数据大屏',
                component: () =>
                    import ('@/views/sta/show'),
                meta: { title: '数据大屏', icon: 'tree' }
            },
            // {
            //   path: 'china1',
            //   name: '生成数据',
            //   component: () => import('@/views/sta/china1'),
            //   meta: { title: '生成数据', icon: 'table' }
            // }
        ]
    },
    {
        path: '/Seller',
        component: Layout,
        redirect: '/Seller/seller',
        name: '销售数据',
        meta: { title: '销售数据', icon: 'example' },
        children: [

            {
                path: 'seler',
                name: '销售数据',
                component: () =>
                    import ('@/views/Seller/seller'),
                meta: { title: '销售数据', icon: 'tree' }
            },
            // {
            //   path: 'china1',
            //   name: '生成数据',
            //   component: () => import('@/views/Seller/seller'),
            //   meta: { title: '生成数据', icon: 'table' }
            // }
        ]
    },
    {
        path: '/user',
        component: Layout,
        redirect: '/user/user',
        name: '客户数据',
        meta: { title: '客户数据', icon: 'example' },
        children: [

            {
                path: 'user',
                name: '客户数据示',
                component: () =>
                    import ('@/views/user/user'),
                meta: { title: '客户数据', icon: 'tree' }
            },
            // {
            //   path: 'user',
            //   name: '生成数据',
            //   component: () => import('@/views/user/user'),
            //   meta: { title: '生成数据', icon: 'table' }
            // }
        ]
    },
    {
        path: '/injury',
        component: Layout,
        redirect: '/injury/injury',
        name: '理赔数据',
        meta: { title: '理赔数据', icon: 'example' },
        children: [

            {
                path: 'seler',
                name: '理赔数据',
                component: () =>
                    import ('@/views/injury/injury'),
                meta: { title: '理赔数据', icon: 'tree' }
            },
        ]
    },
    {
        path: '/buy',
        component: Layout,
        redirect: '/buy/buy',
        name: '用户购买',
        meta: { title: '用户购买', icon: 'example' },
        children: [

            {
                path: 'buy',
                name: '用户购买',
                component: () =>
                    import ('@/views/buy/buy'),
                meta: { title: '用户购买', icon: 'tree' }
            },
        ]
    },
    {
        path: '/makecharts',
        component: Layout,
        redirect: '/makecharts/makecharts',
        name: '定制图表',
        meta: { title: '定制图表', icon: 'example' },
        children: [

            {
                path: 'makecharts',
                name: '定制图表',
                component: () =>
                    import ('@/views/makecharts/makecharts'),
                meta: { title: '定制图表', icon: 'tree' }
            },
        ]
    },
    {
        path: '/person',
        component: Layout,
        redirect: '/person/person',
        name: '个人中心',
        meta: { title: '个人中心', icon: 'example' },
        children: [

            {
                path: 'person',
                name: 'person',
                component: () =>
                    import ('@/views/person/person'),
                meta: { title: '个人中心', noCache: true },
                //hidden: true
            }
        ]
    },
   
    {
        path: 'external-link',
        component: Layout,
        children: [{
            path: 'http://www.qxbins.com/',
            meta: { title: '企小保', icon: 'link' }
        }]
    },
   
    

   { path: '*', redirect: '/404', hidden: true }
]
export const asyncRoutes = [
    {
        path: '/userManager',
        component: Layout,
        redirect: '/userManager/table',
        name: '用户管理',
        meta: { title: '用户管理', icon: 'example',roles: ['admin'] },
        children: [

            {
                path: 'table',
                name: '用户管理',
                component: () =>
                    import ('@/views/edu/teacher/userManager'),
                meta: { title: '用户管理', icon: 'tree',roles: ['admin'] }
            },
            {
                path: 'edituser/:id',
                name: 'EduTeacherEdit',
                component: () =>
                    import ('@/views/edu/teacher/saveUser1'),
                meta: { title: '编辑用户', noCache: true,roles: ['admin'] },
                hidden: true
            }
        ]
    },
    {
        path: '/teacher',
        component: Layout,
        redirect: '/teacher/table',
        name: '管理',
        meta: { title: '管理', icon: 'example',roles: ['admin'] },
        children: [{
                path: 'table',
                name: '数据管理',
                component: () =>
                    import ('@/views/edu/teacher/list'),
                meta: { title: '数据管理', icon: 'table',roles: ['admin'] },

            },
            
            {
                path: 'save',
                name: '添加用户',
                component: () =>
                    import ('@/views/edu/teacher/save'),
                meta: { title: '添加用户', icon: 'tree',roles: ['admin'] },
                hidden: true
            },
            {
                path: 'edit/:id',
                name: 'EduTeacherEdit',
                component: () =>
                    import ('@/views/edu/teacher/save'),
                meta: { title: '编辑讲师', noCache: true,roles: ['admin'] },
                hidden: true
            }
        ],
        hidden: true
    },
    // {
    //     path: '/form',
    //     component: Layout,
    //     children: [{
    //         path: 'index',
    //         name: '数据管理',
    //         component: () =>
    //             import ('@/views/dataManager/dataManager'),
    //         meta: { title: '数据管理', icon: 'form',roles: ['admin'] }
    //     }
        
    // ]
    // },
    { path: '*', redirect: '/404', hidden: true }
  ];
  const createRouter = () => new Router({
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRoutes
  })
  
  const router = createRouter()
  
  export function resetRouter() {
    const newRouter = createRouter()
    router.matcher = newRouter.matcher // reset router
  }
   
  export default router





